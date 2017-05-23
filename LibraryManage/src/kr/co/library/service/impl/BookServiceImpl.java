package kr.co.library.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.co.library.dao.BookDao;
import kr.co.library.dao.impl.BookDaoImpl;
import kr.co.library.service.BookService;
import kr.co.library.util.PagingBean;
import kr.co.library.util.SqlSessionFactoryManager;
import kr.co.library.vo.Book;



public class BookServiceImpl implements BookService {
	private SqlSessionFactory factory;
	private BookDao dao;
	private static BookService instance;
	
	private BookServiceImpl() throws IOException{
		factory = SqlSessionFactoryManager.getInstance().getSqlSessionFactory();
		dao = BookDaoImpl.getInstance();
	}
	
	public static BookService getInstance() throws IOException{
		if(instance == null){
			instance = new BookServiceImpl();
		}
		return instance;
	}

	@Override
	public void addBook(Book book) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBook(Book book) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBook(String id) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Book searchByBookId(String bookId) {
		SqlSession session = factory.openSession();
		
		try {
			return dao.selectBookListById(session, bookId);
		} finally {
			session.close();
		}
	}


	@Override
	public Map<String, Object> searchByKeyword(int page, String select, String keyword) {
		HashMap<String, Object> map = new HashMap<>(); 
		SqlSession session = factory.openSession();
		try {
			int tatalCount = dao.selectBookByKeywordCount(session, select, keyword);
			PagingBean pageBean = new PagingBean(tatalCount, page);
			List<Book> list = dao.selectBookPagingByKeyword(session, select, keyword, pageBean.getBeginItemInPage(), pageBean.getEndItemInPage());
			map.put("pageBean", pageBean);
			map.put("list", list);
		} finally {
			session.close();
		}
		return map;
	}

}
