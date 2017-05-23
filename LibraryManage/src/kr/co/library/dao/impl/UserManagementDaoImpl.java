package kr.co.library.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.library.dao.UserManagementDao;
import kr.co.library.vo.UserManagement;

public class UserManagementDaoImpl implements UserManagementDao{

	//싱글톤
	private static UserManagementDao instance = new UserManagementDaoImpl();
	public static UserManagementDao getInstance(){
		return instance;
	}
	
	private UserManagementDaoImpl(){};
	private final String namespace = "kr.co.library.dao.config.mapper.UserManagementMapper.";
	
	@Override
	public int insertUserManagement(SqlSession session, UserManagement user) {
		return session.delete(namespace+"insertUserManagement",user);
	}

	@Override
	public int updateUserManagement(SqlSession session, UserManagement user) {
		return session.update(namespace+"updateUserManagement",user);
	}

	@Override
	public int deleteUserManagement(SqlSession session, String userId) {
		return session.delete(namespace+"deleteUserManagement",userId);
	}

	@Override
	public List<UserManagement> selectUserManagementList(SqlSession session) {
		return session.selectList(namespace+"selectUserManagementList");
	}

	@Override
	public UserManagement selectUserManagementListById(SqlSession session, String userId) {
		return session.selectOne(namespace+"selectUserManagementListById",userId);
	}

	
	@Override
	public List<UserManagement> selectUserManagementListByUserName(SqlSession session, String userName) {
		return session.selectList(namespace+"selectUserManagementListByUserName",userName);
	}

	@Override
	public int selectUserManagementCount(SqlSession session) {
		return session.selectOne(namespace+"selectUserManagementCount");
	}

	
}
