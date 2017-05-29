package kr.co.library.dao.test;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.co.library.dao.BookDao;
import kr.co.library.dao.RentalListDao;
import kr.co.library.dao.impl.BookDaoImpl;
import kr.co.library.dao.impl.RentalListDaoImpl;
import kr.co.library.util.SqlSessionFactoryManager;
import kr.co.library.vo.Book;
import kr.co.library.vo.RentalList;

public class TestRentalListDao {
	private SqlSessionFactory factory;

	public TestRentalListDao() throws IOException {
		SqlSessionFactoryManager manager = SqlSessionFactoryManager.getInstance();
		factory = manager.getSqlSessionFactory();
	}

	public void examRentalList() {
		RentalListDao dao = RentalListDaoImpl.getInstance();
		SqlSession session = null;
		try {
			

			session = factory.openSession();
			
					
			
			/*
			dao.insertRentalList(session, new RentalList(1, "1", "1", new Date(), new Date()));
			printBookList(dao.selectRentalList(session),"insertRentalList");
			
			dao.insertRentalList(session, new RentalList(1, "1", "2", new Date(), new Date()));
			dao.insertRentalList(session, new RentalList(1, "1", "3", new Date(), new Date()));
			dao.insertRentalList(session, new RentalList(1, "2", "1", new Date(), new Date()));
			dao.insertRentalList(session, new RentalList(1, "2", "2", new Date(), new Date()));
			dao.insertRentalList(session, new RentalList(1, "2", "3", new Date(), new Date()));
			dao.insertRentalList(session, new RentalList(1, "3", "1", new Date(), new Date()));
			dao.insertRentalList(session, new RentalList(1, "3", "2", new Date(), new Date()));
			dao.insertRentalList(session, new RentalList(1, "3", "3", new Date(), new Date()));
			*/
			
/*			dao.updateRentalList(session, new RentalList(1, "user02", "book01", new Date(), new Date()));
			printBookList(dao.selectRentalList(session),"updateRentalList");*/
			
/*			dao.deleteRentalList(session, 1);
			printBookList(dao.selectRentalList(session),"deleteRentalList");*/
			
/*			dao.selectRentalListByBookId(session, "book01");
			printBookList(dao.selectRentalList(session),"selectRentalListByBookId");*/
			
			/*			dao.deleteRentalList(session, 1);
			printBookList(dao.selectRentalList(session),"deleteRentalList");*/
			
/*			dao.selectRentalListByUserId(session, "user01");
			printBookList(dao.selectRentalList(session),"selectRentalListByUserId");*/
			
//			System.out.println(dao.selectRentalListByUserIdToBook(session, "1"));
			
			//System.out.println(dao.selectRentalListByUserIdCount(session, "1"));
			
			
			
//			printBookList(dao.selectRentalListPagingByUserIdToBook(session, "2", 1, 10),"selectRentalListPagingByUserIdToBook");
//			
//			
//			printBookList(dao.selectRentalListPagingByUserIdToBook(session, "", 1, 10),"selectRentalListPagingByUserIdToBook");
//			
//			System.out.println(dao.selectRentalListPagingByEndIsNull(session, null, 1, 10));
//			
//			System.out.println(dao.selectRentalListPagingByEndIsNull(session, "1", 1, 10));
//			
//			System.out.println(dao.selectRentalListByEndIsNullCount(session));
			
			
			printBookList(dao.selectRentalListPagingByUserIdToBook(session, "", 1, 10),"selectRentalListPagingByUserIdToBook");
			

			session.commit();
		} finally {
			session.close();
		}
	}
	
	public void printBookList(List<RentalList> list, String label){
		System.out.printf("-------------------%s-------------------%n", label);
		for(RentalList rl : list){
			System.out.println(rl);
		}
		System.out.println("------------------------------------------\n");
	}
	
	public static void main(String[] args) throws IOException {
		TestRentalListDao test = new TestRentalListDao();
		test.examRentalList();
	}
}