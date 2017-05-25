package kr.co.library.dao.impl;

import org.apache.ibatis.session.SqlSession;

import kr.co.library.dao.AdministratorDao;
import kr.co.library.vo.Administrator;

public class AdministratorDaoImpl implements AdministratorDao {
	//싱글톤
	private static AdministratorDao instance = new AdministratorDaoImpl();
	public static AdministratorDao getInstance(){
		return instance;
	}
	
	private AdministratorDaoImpl(){}
	private final String namespace = "kr.co.library.dao.config.mapper.AdministratorMapper.";
	@Override
	public int insertAdministrator(SqlSession session, Administrator admin) {
		
		return session.insert(namespace+"insertAdministrator", admin);
	}

	@Override
	public int deleteAdministrator(SqlSession session, String adminId) {
		
		return session.delete(namespace+"deleteAdministrator", adminId);
	}

	@Override
	public Administrator selectAdministratorById(SqlSession session, String adminId) {

		return session.selectOne(namespace+"selectAdministratorById", adminId);
	}

	
	
	
}
