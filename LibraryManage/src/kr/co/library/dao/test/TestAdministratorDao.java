package kr.co.library.dao.test;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.co.library.dao.AdministratorDao;
import kr.co.library.dao.impl.AdministratorDaoImpl;
import kr.co.library.util.SqlSessionFactoryManager;
import kr.co.library.vo.Administrator;

public class TestAdministratorDao {
	private SqlSessionFactory factory;
	
	public TestAdministratorDao() throws IOException {
		SqlSessionFactoryManager manager = SqlSessionFactoryManager.getInstance();
		factory = manager.getSqlSessionFactory();
	}
	
	public void examAdminstrator(){
		AdministratorDao dao =  AdministratorDaoImpl.getInstance();
		
		SqlSession session = null;
		try{
		session = factory.openSession();
		//1.입력
//		int value = dao.insertAdministrator(session, new Administrator("manager3", "12345678" , 'Y'));
//		System.out.println(value);
		//2.삭제
		int de = dao.deleteAdministrator(session, "manager2");
		System.out.println(de);
		//3.id으로 조회
		System.out.println(dao.selectAdminstratorById(session, "manager3"));
		session.commit();
		}finally{
		session.close();	
		}
		
	}
	public static void main(String[] args) throws IOException {
		TestAdministratorDao client = new TestAdministratorDao();
		
		client.examAdminstrator();
		

		
	}
}
