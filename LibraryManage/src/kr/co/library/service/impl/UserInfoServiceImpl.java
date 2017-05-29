package kr.co.library.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.co.library.dao.UserManagementDao;
import kr.co.library.dao.impl.UserManagementDaoImpl;
import kr.co.library.exception.LoginFailException;
import kr.co.library.exception.FailMemberRegistException;
import kr.co.library.exception.UserNotFoundException;
import kr.co.library.service.UserInfoService;
import kr.co.library.util.PagingBean;
import kr.co.library.util.SqlSessionFactoryManager;
import kr.co.library.vo.UserManagement;

public class UserInfoServiceImpl implements UserInfoService {

	private SqlSessionFactory factory;
	private UserManagementDao userDao;

	private static UserInfoService instance;

	public static UserInfoService getInstance() throws IOException {
		if (instance == null) {
			instance = new UserInfoServiceImpl();
		}
		return instance;
	}

	private UserInfoServiceImpl() throws IOException {
		factory = SqlSessionFactoryManager.getInstance().getSqlSessionFactory();
		userDao = UserManagementDaoImpl.getInstance();
	}

	@Override
	public void createUser(UserManagement user) throws FailMemberRegistException {
		SqlSession session = null;
		try {
			session = factory.openSession();
			// 아이디중복검사 또는 잘못된값 일경우
			if (userDao.selectUserManagementListById(session, user.getUserId()) != null) {
				throw new FailMemberRegistException(String.format("ID 중복!!."));
				
			//UserId의 값이 없을 경우
			}else if(user.getUserId().isEmpty()){
				throw new FailMemberRegistException(String.format("ID 입력하세요."));
			} 
			//UserPassword의 값이 없을 경우
			else if (user.getPassword().isEmpty()) {
				throw new FailMemberRegistException(String.format("비밀번호 입력하세요"));
			} 
			//UserName의 값이 없을 경우
			else if (user.getUserName().isEmpty()) {
				throw new FailMemberRegistException(String.format("이름를 입력하세요"));
			} 
			//PhoneNum의 값이 없을경우
			else if (user.getPhoneNum().isEmpty()) {
				throw new FailMemberRegistException(String.format("번호를 입력하세요"));
			} 
			//Email의 값이 없을경우
			else if (user.getEmail().isEmpty()) {
				throw new FailMemberRegistException(String.format("이메일 입력하세요"));
			}
			
			userDao.insertUserManagement(session, user);
			
			session.commit();
		} finally {
			session.close();
		}

	}

	@Override
	public void updateUser(UserManagement user) throws UserNotFoundException {
		SqlSession session = factory.openSession();
		
		try {
			if (userDao.selectUserManagementListById(session, user.getUserId()) == null) {
				throw new UserNotFoundException(String.format("ID %s 인 회원이 없습니다.", user.getUserId()));
			}
			userDao.updateUserManagement(session, user);
			session.commit();
		} finally {
			session.close();
		}

	}

	@Override
	public void dropUser(String userId) throws UserNotFoundException {
		SqlSession session = factory.openSession();
		try {
			if (userDao.selectUserManagementListById(session, userId) == null) {
				throw new UserNotFoundException(String.format("ID %s 인 회원이 없습니다.", userId));
			}
			userDao.deleteUserManagement(session, userId);
			session.commit();
		} finally {
			session.close();
		}

	}

	@Override
	public UserManagement searchUser(String userId) {
		// 회원의 ID조회
		SqlSession session = factory.openSession();
		try {
			return userDao.selectUserManagementListById(session, userId);
		} finally {
			session.close();
		}
	}

	@Override
	public void clearPenalty(String userId) {
		SqlSession session = factory.openSession();
		try {
			// id로 유저객체 가져옴
			UserManagement user = userDao.selectUserManagementListById(session, userId);
			// 새 유저객체로 수정,패널티상태빼고 다시 도로 넣고, 패널티만 바꿈
			userDao.updateUserManagement(session, new UserManagement(user.getUserId(), user.getPassword(),
					user.getUserName(), user.getPhoneNum(), user.getEmail(), 'N'));
			session.commit();
		} finally {
			session.close();
		}
	}

	@Override
	public UserManagement longinUser(String id, String password) throws LoginFailException {
		SqlSession session = factory.openSession();
		try {
			UserManagement user = userDao.selectUserManagementListById(session, id);
			if (id.equals(user.getUserId())) {
				if (password.equals(user.getPassword())) {
					return user;// 비밀번호 아이디 일치 user 리턴
				} else {
					throw new LoginFailException("패스워드 오류");
				}
			}

			session.commit();
		} finally {
			session.close();
		}
		throw new LoginFailException("아이디가 없습니다.");
	}

	@Override
	public Map<String, Object> allUserList(int page) {
		HashMap<String, Object> map = new HashMap<>();
		SqlSession session = factory.openSession();
		try {

			int totalCount = userDao.selectUserManagementCount(session);
			PagingBean pageBean = new PagingBean(totalCount, page);

			List<Object> list = userDao.selectUserManagementPagingList(session, pageBean.getBeginItemInPage(),
					pageBean.getEndItemInPage());

			map.put("pageBean", pageBean);
			map.put("list", list);
		} finally {
			session.close();
		}
		return map;
	}

}
