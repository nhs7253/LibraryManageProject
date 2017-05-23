package kr.co.library.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import exception.BookIdException;
import exception.BookNotFoundException;
import kr.co.library.dao.BookDao;
import kr.co.library.dao.impl.BookDaoImpl;
import kr.co.library.service.BookService;
import kr.co.library.util.PagingBean;
import kr.co.library.util.SqlSessionFactoryManager;
import kr.co.library.vo.Book;



public class BookServiceImpl implements BookService {
	private SqlSessionFactory factory;
	private BookDao bookDao;
	private static BookService instance;
	
	private BookServiceImpl() throws IOException{
		factory = SqlSessionFactoryManager.getInstance().getSqlSessionFactory();
		bookDao = BookDaoImpl.getInstance();
	}
	
	public static BookService getInstance() throws IOException{
		if(instance == null){
			instance = new BookServiceImpl();
		}
		return instance;
	}

	@Override
	public void addBook(Book book) throws BookIdException {
		SqlSession session = factory.openSession();
		try{
			if(bookDao.selectBookListById(session, book.getBookId())!=null || book.getBookId().equals("")){
				throw new BookIdException("책의 id입력이 잘못 되었습니다.");
			}
			bookDao.insertBook(session, book);
			session.commit();
		}finally{
			session.close();
		}
	}
	
	@Override
	public void updateBook(Book book) throws BookNotFoundException{
		SqlSession session = factory.openSession();
		try{
			if(bookDao.selectBookListById(session, book.getBookId())==null){
				throw new BookNotFoundException(String.format("입력하신 id인 %s의 책의 정보가 없습니다.", book.getBookId()));
			}
			bookDao.updateBook(session, book);
			session.commit();
		}finally{
			session.close();
		}
		
	}

	@Override
	public void deleteBook(String id) throws BookNotFoundException {
	
		SqlSession session = factory.openSession();
		try{
			if(bookDao.selectBookListById(session, id)==null){
				throw new BookNotFoundException(String.format("입력하신 id인 %s의 책의 정보가 없습니다.", id));
			}
			bookDao.deleteBook(session, id);
			session.commit();
		}finally{
			session.close();
		}
		
	}

	@Override
	public Book searchByBookId(String bookId) {
		SqlSession session = factory.openSession();
		
		try {
			return bookDao.selectBookListById(session, bookId);
		} finally {
			session.close();
		}
	}


	@Override
	public Map<String, Object> searchByKeyword(int page, String select, String keyword) {
		HashMap<String, Object> map = new HashMap<>(); 
		SqlSession session = factory.openSession();
		try {
			int tatalCount = bookDao.selectBookByKeywordCount(session, select, keyword);
			PagingBean pageBean = new PagingBean(tatalCount, page);
			List<Book> list = bookDao.selectBookPagingByKeyword(session, select, keyword, pageBean.getBeginItemInPage(), pageBean.getEndItemInPage());
			map.put("pageBean", pageBean);
			map.put("list", list);
		} finally {
			session.close();
		}
		return map;
	}

}
