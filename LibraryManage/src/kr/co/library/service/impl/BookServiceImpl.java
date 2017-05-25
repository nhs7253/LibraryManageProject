package kr.co.library.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.co.library.dao.BookDao;
import kr.co.library.dao.impl.BookDaoImpl;
import kr.co.library.exception.BookIdException;
import kr.co.library.exception.BookNotFoundException;
import kr.co.library.exception.WrongBookException;
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
	public String addBook(Book book) throws BookIdException, WrongBookException {
		SqlSession session = factory.openSession();
		try {
			// id입력값이 공백이 아니라면.
			if (!book.getBookId().equals("") && !book.getTitle().equals("") && !book.getAuthor().equals("") &&
					!book.getPublisher().equals("") && !book.getPublishDate().equals("")) {
				// 처음 들어오는 값이라면.
				if (bookDao.selectBookListById(session, book.getBookId()) == null) {
					bookDao.insertBook(session, book);
					session.commit();
					return "추가완료";
				} else {
					// 이미 등록되어있는 책이라면.
					throw new BookIdException("이미 등록된 책입니다.");
				}
			}else{
				throw new WrongBookException("입력값이 올바르지 않습니다.");
			}
		} finally {
			session.close();
		}
	}

	@Override
	public String updateBook(Book book) throws BookNotFoundException, WrongBookException {
		SqlSession session = factory.openSession();
		try {
			// 값이 공백이 아니라면.
			if (!book.getBookId().equals("") && !book.getTitle().equals("") && !book.getAuthor().equals("")
					&& !book.getPublisher().equals("") && !book.getPublishDate().equals("")) {
				
				if (bookDao.selectBookListById(session, book.getBookId()) != null) {
					bookDao.updateBook(session, book);
					session.commit();
					return "수정완료";
				}else{
					throw new BookNotFoundException("없는 책입니다.");
				}
			}else{
				throw new WrongBookException("입력값이 올바르지 않습니다.");
			}
		} finally {
			session.close();
		}

	}

	@Override
	public String deleteBook(String id) throws BookNotFoundException {
		SqlSession session = factory.openSession();
		try{
			//값이 공백이 아니거나, 있을때.
			if(!id.equals("") && bookDao.selectBookListById(session, id)!=null){
				bookDao.deleteBook(session, id);
				session.commit();
				return "삭제완료";
			}else{
				throw new BookNotFoundException("입력값이 올바르지 않습니다.");
			}
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
