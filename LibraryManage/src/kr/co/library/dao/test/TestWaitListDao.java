package kr.co.library.dao.test;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.co.library.dao.WaitListDao;
import kr.co.library.dao.impl.WaitListDaoImpl;
import kr.co.library.util.SqlSessionFactoryManager;
import kr.co.library.vo.WaitList;

public class TestWaitListDao {
	private SqlSessionFactory factory;
	
	public TestWaitListDao() throws IOException{
		SqlSessionFactoryManager manager = SqlSessionFactoryManager.getInstance();
		factory = manager.getSqlSessionFactory();
	}
	public void examWaitList()
	{
		WaitListDao dao = WaitListDaoImpl.getInstance();
		SqlSession session = null;
		
		try
		{
			session = factory.openSession();
			////////////////////////////////////
//			dao.insertWaitList(session, new WaitList("2","2",111));
			/*
			dao.insertWaitList(session, new WaitList("3","2",111));
			dao.insertWaitList(session, new WaitList("3","3",111));
			dao.insertWaitList(session, new WaitList("3","1",111));
			
			printWaitList(dao.selectWaitList(session),"insetWaitList");
			
			dao.updateWaitList(session, new WaitList("2","2",123123));
			
			printWaitList(dao.selectWaitList(session),"updateWaitList");
			
			dao.deleteWaitList(session, "2","2");
			
			printWaitList(dao.selectWaitList(session),"deleteWaitList");
		///////////////////////////////////////////////
			
			printWaitList(dao.selectWaitListByBookId(session, "1"),"selectWaitListByBookId");
			
			printWaitList(dao.selectWaitListByWaitUser(session, "1"),"selectWaitListByWaitUser");
			
			System.out.println(dao.selectByWaitUserIdAndByBookId(session, "1", "1"));
			
			System.out.println("selectWaitListByBookCount = " + dao.selectWaitListByBookCount(session, "1"));
			
			System.out.println("selectWaitListByUserCount = " + dao.selectWaitListByUserCount(session, "1"));
			
			printWaitList(dao.selectWaitListJoinBookJoinUser(session),"selectWaitListJoinBookJoinUser");
			
			printWaitList(dao.selectWaitListJoinBookJoinUserByBookId(session, "1"),"selectWaitListJoinBookJoinUserByBookId");
			
			printWaitList(dao.selectWaitListJoinBookJoinUserByUserId(session, "1"),"selectWaitListJoinBookJoinUserByUserId");
			*/
			System.out.println(dao.selectWaitListPagingJoinBookJoinUserByUserId(session, "2", 1, 3));
			
			System.out.println("이상없음");
			//////////////////////////
			session.commit();
		}
		finally 
		
		{
			session.close();
		}
	}
	public void printWaitList(List<WaitList> list, String label)
	{
		System.out.printf("-------------------%s-------------------%n", label);
		for(WaitList WaitList : list){
			System.out.println(WaitList);
		}
		System.out.println("------------------------------------------\n");
	}
	
	public static void main(String[] args) throws IOException{
		TestWaitListDao client = new TestWaitListDao();
		client.examWaitList();
	}
}
