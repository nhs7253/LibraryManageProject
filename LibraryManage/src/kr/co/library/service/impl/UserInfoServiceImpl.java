package kr.co.library.service.impl;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.co.library.dao.UserManagementDao;
import kr.co.library.dao.impl.UserManagementDaoImpl;
import kr.co.library.service.UserInfoService;
import kr.co.library.util.SqlSessionFactoryManager;
import kr.co.library.vo.UserManagement;

public class UserInfoServiceImpl implements UserInfoService{

	private SqlSessionFactory factory;
	private UserManagementDao userDao;

	private static UserInfoService instance;
	public static UserInfoService getInstance() throws IOException{
		if(instance==null){
			instance = new UserInfoServiceImpl();
		}
		return instance;
	}
	private UserInfoServiceImpl() throws IOException{
		factory = SqlSessionFactoryManager.getInstance().getSqlSessionFactory();
		userDao = UserManagementDaoImpl.getInstance();
	}
	
	@Override
	public void createUser(UserManagement user) {
		SqlSession session = factory.openSession();
		userDao.insertUserManagement(session, user);
		session.close();
		
	}
	@Override
	public void updateUser(UserManagement user) {
		
	}
	@Override
	public void dropUSer(String id) {
	
		
	}
	@Override
	public UserManagement searchById(String id) {
	
		SqlSession session = factory.openSession();
		try{
			
		}finally{
			session.close();
		}
		return null;
	}
	
	/**
	 * 회원id의 연체상태를 변경함
	 * -연체설정을 (Y->N)해제
	 * @param userId
	 * @param penaltyState
	 */
	@Override
	public void clearPenalty(String userId) {
		SqlSession session = factory.openSession();
		try {
			// id로 유저객체 가져옴
			UserManagement user = userDao.selectUserManagementListById(session, userId);
			//새 유저객체로 수정,패널티상태빼고 다시 도로 넣고, 패널티만 바꿈
			userDao.updateUserManagement(session, new UserManagement(user.getUserId(), user.getPassword(), user.getUserName(), user.getPhoneNum(),
					user.getEmail(), 'N'));
			session.commit();
		} finally {
			session.close();
		}
	}
	
}
