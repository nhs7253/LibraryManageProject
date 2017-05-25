package kr.co.library.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.co.library.dao.BookDao;
import kr.co.library.dao.RentalListDao;
import kr.co.library.dao.UserManagementDao;
import kr.co.library.dao.WaitListDao;
import kr.co.library.dao.impl.BookDaoImpl;
import kr.co.library.dao.impl.RentalListDaoImpl;
import kr.co.library.dao.impl.UserManagementDaoImpl;
import kr.co.library.dao.impl.WaitListDaoImpl;
import kr.co.library.exception.FailRentException;
import kr.co.library.exception.FailReturnException;
import kr.co.library.exception.FailWaitException;
import kr.co.library.service.RentalService;
import kr.co.library.util.PagingBean;
import kr.co.library.util.SqlSessionFactoryManager;
import kr.co.library.vo.Book;
import kr.co.library.vo.RentalList;
import kr.co.library.vo.UserManagement;
import kr.co.library.vo.WaitList;

public class RentalServiceImpl implements RentalService {
	private SqlSessionFactory factory;
	private BookDao bookDao;
	private RentalListDao rentalDao;
	private WaitListDao waitDao;
	private UserManagementDao userDao;

	private static RentalService instance;

	public static RentalService getInstance() throws IOException {
		if (instance == null) {
			instance = new RentalServiceImpl();
		}
		return instance;
	}

	private RentalServiceImpl() throws IOException {
		factory = SqlSessionFactoryManager.getInstance().getSqlSessionFactory();
		bookDao = BookDaoImpl.getInstance();
		rentalDao = RentalListDaoImpl.getInstance();
		waitDao = WaitListDaoImpl.getInstance();
		userDao = UserManagementDaoImpl.getInstance();
	}

	public void rentBookInsert(SqlSession session, String userId, String bookId) {
		Book book = bookDao.selectBookListById(session, bookId);

		RentalList rentalList = new RentalList(0, userId, bookId, new Date(), null);
		rentalDao.insertRentalList(session, rentalList);
		bookDao.updateBook(session, new Book(book.getBookId(), book.getTitle(), book.getAuthor(), book.getPublisher(),
				book.getPublishDate(), 'N'));
	}

	@Override
	public String rentBook(String userId, String bookId) throws FailRentException, FailWaitException {

		SqlSession session = factory.openSession();

		Book book = bookDao.selectBookListById(session, bookId);
		UserManagement user = userDao.selectUserManagementListById(session, userId);
		List<WaitList> waitList = waitDao.selectWaitListByBookId(session, bookId);
		try {
			// book과 user 값이 올바른 값인지 확인하는 조건문 -> 예외 발생되면 FailRentException 발생!
			if (book != null && user != null) {
				// Book의 대여상태와 로그인한 사용자의 ID의 패널티 상태를 비교하는 조건문.
				if (book.getRentalState() == 'Y' && user.getPenaltyState() == 'N') {
					// 대기자 우선순위 확인 & 대기자 없을시 신청 가능
					// 1. 원하는책의 대기자가 없는 조건.
					if (waitList.isEmpty()) {
						rentBookInsert(session, userId, bookId);
						session.commit();
						return userId + "님 대여완료";
						// 2. 원하는 책의 대기자 1순위일 경우 대여신청 (대여신청완료 동시에 대기순위에서
						// 삭제해줘야한다.)
					} else if (waitList.get(0).getWaitUser().equals(userId)) {
						rentBookInsert(session, userId, bookId);
						waitDao.deleteWaitList(session, userId, bookId);
						session.commit();
						return userId + "님 대여완료";
					} else {
						throw new FailRentException("대기 우선순위 확인부탁드립니다.");
					}
				} else if (book.getRentalState() == 'N') {
					throw new FailRentException("대여중인 도서입니다.!(대기자신청하세요)", userId, bookId);
				} else if (user.getPenaltyState() == 'Y') {
					throw new FailRentException("대여제한상태입니다.");
				} else if (book.getRentalState() == 'N') {
					throw new FailRentException("다른 사람이 대여중입니다. 대여를 원하시면 대기자 신청을 해주세요.");
				}
			}
			throw new FailRentException("대여실패(UserId 확인)", userId, bookId);
		} finally {
			session.close();
		}

	}

	@Override
	public String returnBook(String userId, int rentalNo) throws FailReturnException {
		SqlSession session = factory.openSession();

		try {

			RentalList rentalList = rentalDao.selectRentalListByRentalNo(session, rentalNo);
			String bookId = rentalList.getBookId();

			// 이미 반납된게 아니면
			if (rentalList.getRentalEnd() == null) {

				// 반납시간설정
				RentalList updateRental = new RentalList(rentalList.getRentalNo(), rentalList.getUserId(),
						rentalList.getBookId(), rentalList.getRentalStart(), new Date());
				rentalDao.updateRentalList(session, updateRental);

				// RentalState상태 변경 N->Y
				Book book = bookDao.selectBookListById(session, bookId);
				bookDao.updateBook(session, new Book(book.getBookId(), book.getTitle(), book.getAuthor(),
						book.getPublisher(), book.getPublishDate(), 'Y'));

				// 반납시간-대출시간이 2주일보다 길면 연체상태를 Y로 수정.1209600000밀리초
				Date startTime = updateRental.getRentalStart();
				Date EndTime = updateRental.getRentalEnd();
				if (EndTime.getTime() - startTime.getTime() > 1209600000) {
					UserManagement user = userDao.selectUserManagementListById(session, userId);
					userDao.updateUserManagement(session, new UserManagement(user.getUserId(), user.getPassword(),
							user.getUserName(), user.getPhoneNum(), user.getEmail(), 'Y'));
					return userId + "님 연체";
				}
				session.commit();
				return userId + "님 반납완료";
			} else {
				// 이미 반납된것.
				throw new FailReturnException("이미 반납된 책입니다", userId);
			}
		} finally {
			session.close();
		}
	}

	@Override
	public String waitBook(String userId, String bookId) throws FailWaitException {
		// TODO Auto-generated method stub
		SqlSession session = factory.openSession();

		if (waitDao.selectByWaitUserIdAndByBookId(session, userId, bookId) == null) {
			WaitList waitList = new WaitList(bookId, userId, 0);
			waitDao.insertWaitList(session, waitList);
			session.commit();
			return "대기자 신청완료";
		} else {
			throw new FailWaitException("이미 대기자 신청하셨습니다.", userId);
		}

	}

	@Override
	public void cancelWaitBook(String userId, String bookId) {
		// TODO Auto-generated method stub
		SqlSession session = factory.openSession();
		try {
			waitDao.deleteWaitList(session, userId, bookId);
			session.commit();
		} finally {
			session.close();
		}

	}

	@Override
	public Map<String, Object> PrintRentalList(int page, String userId) {
		HashMap<String, Object> map = new HashMap<>();
		List<String> overdue = null;

		SqlSession session = factory.openSession();
		try {
			int tatalCount = rentalDao.selectRentalListByUserIdCount(session, userId);
			PagingBean pageBean = new PagingBean(tatalCount, page);
			List<RentalList> list = rentalDao.selectRentalListPagingByUserIdToBook(session, userId,
					pageBean.getBeginItemInPage(), pageBean.getEndItemInPage());

			overdue = getOverdueInfo(list);

			map.put("pageBean", pageBean);
			map.put("list", list);
			map.put("overdue", overdue);
		} finally {
			session.close();
		}

		return map;
	}

	@Override
	public Map<String, Object> PrintWaitList(int page, String userId) {
		HashMap<String, Object> map = new HashMap<>();

		SqlSession session = factory.openSession();
		try {
			int tatalCount = waitDao.selectWaitListByUserCount(session, userId);
			PagingBean pageBean = new PagingBean(tatalCount, page);
			List<Object> list = waitDao.selectWaitListPagingJoinBookJoinUserByUserId(session, userId,
					pageBean.getBeginItemInPage(), pageBean.getEndItemInPage());
			map.put("pageBean", pageBean);
			map.put("list", list);
		} finally {
			session.close();
		}

		return map;
	}

	@Override
	public Map<String, Object> PrintCurrentRentalList(int page, String userId) {
		HashMap<String, Object> map = new HashMap<>();
		List<String> name = new ArrayList<>();
		List<String> overdue = null;

		SqlSession session = factory.openSession();
		try {
			int tatalCount = rentalDao.selectRentalListByEndIsNullCount(session);
			PagingBean pageBean = new PagingBean(tatalCount, page);
			List<Object> list = rentalDao.selectRentalListPagingByEndIsNull(session, userId,
					pageBean.getBeginItemInPage(), pageBean.getEndItemInPage());
			List<RentalList> temp = new ArrayList<>();

			for (int i = 0; i < list.size(); i++) {
				temp.add((RentalList) ((Map<String, Object>) list.get(i)).get("list"));
				name.add((String) ((Map<String, Object>) list.get(i)).get("user_name"));
			}

			overdue = getOverdueInfo(temp);

			map.put("pageBean", pageBean);
			map.put("list", temp);
			map.put("name", name);
			map.put("overdue", overdue);
		} finally {
			session.close();
		}
		return map;
	}

	/**
	 * List<RentalList>를 받아 연체 정보를 계산해 주는 메소드 List<String>를 리턴함
	 * 
	 * @param list
	 * @return
	 */
	public List<String> getOverdueInfo(List<RentalList> list) {
		List<String> overdue = new ArrayList<>();
		Calendar limit = Calendar.getInstance();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getRentalEnd() != null) {
				overdue.add("N");
			} else {
				limit.setTime(list.get(i).getRentalStart());
				limit.add(Calendar.DATE, 14);
				if (new Date().getTime() > limit.getTimeInMillis()) {
					overdue.add("Y");
				} else {
					overdue.add("N");
				}
			}
		}
		return overdue;
	}

	@Override
	public Map<String, Object> PrintAdminWaitList(int page) {
		HashMap<String, Object> map = new HashMap<>();

		SqlSession session = factory.openSession();
		try {
			int tatalCount = waitDao.selectWaitListCount(session);
			PagingBean pageBean = new PagingBean(tatalCount, page);
			List<Object> list = waitDao.selectWaitListPagingJoinBookJoinUser(session, pageBean.getBeginItemInPage(),
					pageBean.getEndItemInPage());
			map.put("pageBean", pageBean);
			map.put("list", list);
		} finally {
			session.close();
		}

		return map;
	}

}
