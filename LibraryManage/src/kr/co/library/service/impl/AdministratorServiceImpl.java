package kr.co.library.service.impl;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.co.library.dao.AdministratorDao;
import kr.co.library.dao.impl.AdministratorDaoImpl;
import kr.co.library.exception.AdminNotFoundException;
import kr.co.library.exception.AdminOverlapException;
import kr.co.library.service.AdministratorService;
import kr.co.library.util.SqlSessionFactoryManager;
import kr.co.library.vo.Administrator;

public class AdministratorServiceImpl implements AdministratorService{
	private SqlSessionFactory factory;
	private AdministratorDao adminDao;
	
	private static AdministratorService instance;
	public static AdministratorService getInstance() throws IOException {
		if(instance==null){
			instance = new AdministratorServiceImpl();
		}
		return instance;
	}
	private AdministratorServiceImpl() throws IOException {
	factory = SqlSessionFactoryManager.getInstance().getSqlSessionFactory();
	adminDao = AdministratorDaoImpl.getInstance();
}
	@Override
	public void insertAdministrator(Administrator admin) throws AdminOverlapException{
		SqlSession session = null; 
		
		try{
		session = factory.openSession();
		if(adminDao.selectAdminstratorById(session, admin.getAdministratorId())!=null||admin.getAdministratorId().equals("")){
			throw new AdminOverlapException(String.format("ID가 중복 또는 잘못된 값을 입력하였습니다.", admin.getAdministratorId()));
		}
		adminDao.insertAdministrator(session, admin);
		session.commit();
		}finally{
			session.close();
		}
			
		
	}
	@Override
	public void deleteAdministrator(String adminId) throws AdminNotFoundException {
		SqlSession session = null;
		
		try{
			session = factory.openSession();
		
		if(adminDao.selectAdminstratorById(session, adminId)==null){
			throw new AdminNotFoundException(String.format("ID %s 인 회원이 없습니다.", adminId));
		
		}
		adminDao.deleteAdministrator(session, adminId);
		session.commit();
		}finally{
			session.close();
		}
	}
		
	@Override
	public Administrator selectAdministratorById(String adminId) {
		SqlSession session = factory.openSession();
		
		try {
			return adminDao.selectAdminstratorById(session, adminId);
		} finally {
			session.close();
		}
	}
	
	
}
