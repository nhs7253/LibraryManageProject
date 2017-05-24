package kr.co.library.dao.test;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.co.library.dao.BookDao;
import kr.co.library.dao.impl.BookDaoImpl;
import kr.co.library.service.impl.RentalServiceImpl;
import kr.co.library.util.SqlSessionFactoryManager;
import kr.co.library.vo.Book;


public class TestBookDao {
	private SqlSessionFactory factory;
	
	
	public TestBookDao() throws IOException{
		SqlSessionFactoryManager manager = SqlSessionFactoryManager.getInstance();
		factory = manager.getSqlSessionFactory();
	}
	
	public void examBook(){
		BookDao dao = BookDaoImpl.getInstance();
		SqlSession session = null;
		try {
			session = factory.openSession();
			//////////////////////////////////////
		
			
			dao.insertBook(session, new Book("44512","제목1","저자1","출판1","1111",'N'));
			
			printBookList(dao.selectBookList(session),"insetBook");
			
			dao.updateBook(session, new Book("44512","제목2","저자2","출판2","2",'N'));
			
			printBookList(dao.selectBookList(session),"updateBook");
			
			dao.updateRentalState(session, "44512", "Y");
			
			printBookList(dao.selectBookList(session),"updateBook");
			
			dao.deleteBook(session, "44512");
			
			printBookList(dao.selectBookList(session),"deleteBook");
			
			////////////////////////////////////////////////////////////////////
			
			System.out.println(dao.selectBookListById(session, "P003E0003122"));
			
			printBookList(dao.selectBookListByTitle(session, "사진"),"selectBookListByTitle");
			
			System.out.println(dao.selectBookCount(session));
			
			printBookList(dao.selectBookPaging(session, 101, 200),"selectBookPaging");
			
			
			
			printBookList(dao.selectBookListByAuthor(session, "바다"),"selectBookListByPublisher");
			

			
			
			printBookList(dao.selectBookListByPublisher(session, "바다"),"selectBookListByPublisher");
			

			
			
			/*
			System.out.println(dao.selectBookByKeywordCount(session,"title","바다"));
			
			System.out.println(dao.selectBookByKeywordCount(session,"author","바다"));
			
			System.out.println(dao.selectBookByKeywordCount(session,"publisher","바다"));
			
			printBookList(dao.selectBookPagingByKeyword(session, "title", "바다",101, 200),"title");
			
			printBookList(dao.selectBookPagingByKeyword(session, "author", "바다",101, 200),"author");
			
			printBookList(dao.selectBookPagingByKeyword(session, "publisher", "바다",101, 200),"publisher");
			*/
			
		
			System.out.println("이상없음");
			//////////////////////////////////////
			session.commit();
		} finally {
//			session.close();
		}
	}
	public void printBookList(List<Book> list, String label){
		System.out.printf("-------------------%s-------------------%n", label);
		for(Book book : list){
			System.out.println(book);
		}
		System.out.println("------------------------------------------\n");
	}
	
	public static void main(String[] args) throws IOException{
		TestBookDao client = new TestBookDao();
		client.examBook();
	}
}
