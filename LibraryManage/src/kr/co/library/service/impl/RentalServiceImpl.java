package kr.co.library.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
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
import kr.co.library.service.RentalService;
import kr.co.library.util.PagingBean;
import kr.co.library.util.SqlSessionFactoryManager;
import kr.co.library.vo.Book;
import kr.co.library.vo.RentalList;
import kr.co.library.vo.UserManagement;
import kr.co.library.vo.WaitList;

public class RentalServiceImpl implements RentalService{
	private SqlSessionFactory factory;
	private BookDao bookDao;
	private RentalListDao rentalDao;
	private WaitListDao waitDao;
	private UserManagementDao userDao;

	private static RentalService instance;
	public static RentalService getInstance() throws IOException{
		if(instance==null){
			instance = new RentalServiceImpl();
		}
		return instance;
	}
	private RentalServiceImpl() throws IOException{
		factory = SqlSessionFactoryManager.getInstance().getSqlSessionFactory();
		bookDao = BookDaoImpl.getInstance();
		rentalDao = RentalListDaoImpl.getInstance();
		waitDao = WaitListDaoImpl.getInstance();
		userDao = UserManagementDaoImpl.getInstance();
	}

	@Override
	public void rentBook(String userId, String bookId) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void returnBook(String userId, int rentalNo) {
		SqlSession session = factory.openSession();

		try {
			// 현재시간
			Date current = new Date();
			RentalList rentalList = rentalDao.selectRentalListByRentalNo(session, rentalNo);
			// 반납시간만 현재시간으로 재설정.
			RentalList updateRental = new RentalList(rentalList.getRentalNo(), rentalList.getUserId(),
					rentalList.getBookId(), rentalList.getRentalStart(), current);

			// 재설정한 대출목록으로 수정.
			rentalDao.updateRentalList(session, updateRental);

			// 반납시간-대출시간이 2주일보다 길면 연체상태를 Y로 수정.
			Date startTime = updateRental.getRentalStart();
			Date EndTime = updateRental.getRentalEnd();
			//2주 = 1209600000밀리초
			
			if (EndTime.getTime()-startTime.getTime() > 1209600000) {
				// 대출기간이 2주 이상이라면 ,연체Y설정
				UserManagement user = userDao.selectUserManagementListById(session, userId);
				userDao.updateUserManagement(session, new UserManagement(user.getUserId(), user.getPassword(), user.getUserName(), user.getPhoneNum(),
						user.getEmail(), 'Y'));
				
			}

			//======================================반납후 책 처리
			String bookId = rentalList.getBookId();
			// 대기목록에 이 책있는지 조회
			List<WaitList> waitLists = waitDao.selectWaitListByBookId(session, bookId);
			if (waitLists.isEmpty()) {
				// 해당 책이 대기목록에 없단것.그러면 책의 렌탈상태를 Y로 수정.
				Book book = bookDao.selectBookListById(session, bookId);  
				bookDao.updateBook(session, new Book(book.getBookId(),book.getTitle(),book.getAuthor(),book.getPublisher(),book.getPublishDate()
						,'Y'));
			} else {// 책이 대기목록에 있다는것.	
				
				//해당책 대기목록들을 넣고 대기1순위 객체를 찾아옴.
				WaitList firstWaitRankUser = MinWaitRanking(session,waitLists);
				
				String firstWaitRankUserId= firstWaitRankUser.getWaitUser();
				rentBook(firstWaitRankUserId,bookId);
				
				//1순위 대기자에게 대출했다고 이메일알림보내기
				noticeWaitUser(firstWaitRankUserId);
				
				//1순위 대기자를 대기목록에 삭제,
				waitDao.deleteWaitList(session, firstWaitRankUserId, bookId);
			}
			session.commit();
		} finally {
			session.close();
		}
	}

	@Override
	public void waitBook(String userId, String BookId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelWaitBook(String userId, String BookId) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void noticeWaitUser(String userId) {
		SqlSession session = factory.openSession();

		try {
			UserManagement user = userDao.selectUserManagementListById(session, userId);
			String email = user.getEmail();

			// 이메일보내기

			session.commit();
		} finally {
			session.close();
		}
	}

	
	
	@Override
	public Map<String, Object> PrintRentalList(int page, String userId) {
		HashMap<String, Object> map = new HashMap<>(); 
		List<String> overdue = new ArrayList<>();
		
		SqlSession session = factory.openSession();
		try {
			int tatalCount = rentalDao.selectRentalListByUserIdCount(session, userId);
			PagingBean pageBean = new PagingBean(tatalCount, page);
			List<RentalList> list = rentalDao.selectRentalListPagingByUserIdToBook(session, userId, pageBean.getBeginItemInPage(), pageBean.getEndItemInPage());
			
			
//			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			
			Calendar limit = Calendar.getInstance();
			
			for(int i=0;i<list.size();i++){
				if(list.get(i).getRentalEnd() != null){
					overdue.add("N");
				}else{
					limit.setTime(list.get(i).getRentalStart());
					limit.add(Calendar.DATE, 14);
					if(list.get(i).getRentalStart().getTime()>limit.getTimeInMillis()){
						overdue.add("Y");
					}else{
						overdue.add("N");
					}
				}
			}
		    
			map.put("pageBean", pageBean);
			map.put("list",list);
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
			List<Object> list = waitDao.selectWaitListPagingJoinBookJoinUserByUserId(session, userId, pageBean.getBeginItemInPage(), pageBean.getEndItemInPage());
			map.put("pageBean", pageBean);
			map.put("list", list);
		} finally {
			session.close();
		}
		
		return map;
	}

	//대기1순위 뽑아내는 메소드.
	private WaitList MinWaitRanking(SqlSession session,List<WaitList> waitLists){
		
		ArrayList<Integer> rankList = new ArrayList<>();
		
		//대기목록에서 랭킹리스트를 뽑음.
		for(int i=0; i<waitLists.size();i++){
			int rank = waitLists.get(i).getWaitRanking();
			rankList.add(rank);
		}
		
		//랭킹레스트에서 최소값뽑음.
		int minRanking = Collections.min(rankList);
		
		return waitDao.selectWaitListByWaitRanking(session, minRanking);
	}
}
