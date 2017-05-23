package kr.co.library.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.co.library.dao.BookDao;
import kr.co.library.vo.Book;

public class BookDaoImpl implements BookDao{
	private final String namespace="kr.co.library.dao.config.mapper.bookMapper.";
	private static BookDao instance = new BookDaoImpl();
	
	private BookDaoImpl(){}
	
	public static BookDao getInstance(){
		return instance;
	}

	@Override
	public int insertBook(SqlSession session, Book book) {
		// TODO Auto-generated method stub
		return session.insert(namespace+"insertBook", book);
	}

	@Override
	public int updateBook(SqlSession session, Book book) {
		// TODO Auto-generated method stub
		return session.update(namespace+"updateBook", book);
	}
	
	@Override
	public int updateRentalState(SqlSession session, String bookId, String rentalState) {
		// TODO Auto-generated method stub
		Map<String, String> input = new HashMap<String, String>();
		input.put("bookId",bookId);
		input.put("rentalState",rentalState);
		return 0;
	}

	@Override
	public int deleteBook(SqlSession session, String bookId) {
		// TODO Auto-generated method stub
		return session.delete(namespace+"deleteBook", bookId);
	}

	@Override
	public List<Book> selectBookList(SqlSession session) {
		// TODO Auto-generated method stub
		return session.selectList(namespace+"selectBookList", session);
	}

	@Override
	public Book selectBookListById(SqlSession session, String bookId) {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+"selectBookListById", bookId);
	}

	@Override
	public List<Book> selectBookListByTitle(SqlSession session, String title) {
		// TODO Auto-generated method stub
		return session.selectList(namespace+"selectBookListByTitle", title);
	}

	@Override
	public List<Book> selectBookPaging(SqlSession session, int startIndex, int endIndex) {
		// TODO Auto-generated method stub
		Map<String, Integer> input = new HashMap<String, Integer>();
		input.put("startIndex",startIndex);
		input.put("endIndex",endIndex);
		return session.selectList(namespace+"selectBookPaging",input);
	}

	@Override
	public int selectBookCount(SqlSession session) {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+"selectBookCount");
	}

	

	@Override
	public List<Book> selectBookListByAuthor(SqlSession session, String author) {
		// TODO Auto-generated method stub
		return session.selectList(namespace+"selectBookListByAuthor", author);
	}

	

	@Override
	public List<Book> selectBookListByPublisher(SqlSession session, String publisher) {
		// TODO Auto-generated method stub
		return session.selectList(namespace+"selectBookListByPublisher", publisher);
	}



	
	
	@Override
	public int selectBookByKeywordCount(SqlSession session, String select, String keyword) {
		// TODO Auto-generated method stub
		Map<String, String> input = new HashMap<String, String>();
		input.put("select", select);
		input.put("keyword", keyword);
		return session.selectOne(namespace+"selectBookByKeywordCount",input);
	}

	@Override
	public List<Book> selectBookPagingByKeyword(SqlSession session, String select, String keyword, int startIndex, int endIndex) {
		// TODO Auto-generated method stub
		Map<String, String> input = new HashMap<String, String>();
		input.put("select", select);
		input.put("keyword", keyword);
		input.put("startIndex",String.valueOf(startIndex));
		input.put("endIndex",String.valueOf(endIndex));
		return session.selectList(namespace+"selectBookPagingByKeyword",input);
	}




}
