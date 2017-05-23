package kr.co.library.dao.test;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.co.library.dao.UserManagementDao;
import kr.co.library.dao.impl.UserManagementDaoImpl;
import kr.co.library.util.SqlSessionFactoryManager;
import kr.co.library.vo.Book;
import kr.co.library.vo.UserManagement;

public class TestUserManagementDao {

	private SqlSessionFactory factory;
	
	public TestUserManagementDao() throws IOException{
		SqlSessionFactoryManager manager = SqlSessionFactoryManager.getInstance();
		factory = manager.getSqlSessionFactory();
	}
	
	public void examUserManagement(){
		UserManagementDao dao = UserManagementDaoImpl.getInstance();
		SqlSession session = null;
		try {
			session = factory.openSession();
			//////////////////////////////////////
		
			//1.입력
			//dao.insertUserManagement(session, new UserManagement("kite","passw","박명수","0101212","park@na.com",'N'));
			
			//2.수정
			//dao.updateUserManagement(session, new UserManagement("park","pass","박영수","01012","park@na.com",'Y'));
			
			//3.삭제
			//dao.deleteUserManagement(session, "kite");
			
			//4.전체조회
			//printUserManagementList(dao.selectUserManagementList(session),"전체조회");
			
			//5.id로 조회
			//System.out.println(dao.selectUserManagementListById(session, "kite"));
			
			//6.이름으로 조회
			//printUserManagementList(dao.selectUserManagementListByUserName(session, "박"),"이름조회");
			
			//7.전체수 카운트
			//System.out.println(dao.selectUserManagementCount(session));
			session.commit();
		} finally {
			session.close();
		}
	}
	public void printUserManagementList(List<UserManagement> list, String label){
		System.out.printf("-------------------%s-------------------%n", label);
		for(UserManagement user : list){
			System.out.println(user);
		}
		System.out.println("------------------------------------------\n");
	}
	
	public static void main(String[] args) throws IOException{
		TestUserManagementDao client = new TestUserManagementDao();
		client.examUserManagement();
	}
}
