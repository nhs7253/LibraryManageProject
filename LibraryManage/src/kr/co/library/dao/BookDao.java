package kr.co.library.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.library.vo.Book;

public interface BookDao {
	
	/**
	 * 매개변수로 받은 book객체를 insert
	 * @param session
	 * @param book 
	 * @return
	 */
	int insertBook(SqlSession session, Book book);
	
	/**
	 * 매개변수로 받은 book 객체의 bookId와 같은 book의 나머지 정보를 수정
	 * @param session
	 * @param book
	 * @return
	 */
	int updateBook(SqlSession session, Book book);
	
	/**
	 * 매개변수로 받은 bookId와 일치하는 컬럼의 rentalState를 수정
	 * @param session
	 * @param bookId
	 * @param rentalState
	 * @return
	 */
	int updateRentalState(SqlSession session, String bookId, String rentalState);
	
	/**
	 * 매개변수로 받은 bookId와 같은 책정보를 삭제
	 * @param session
	 * @param bookId
	 * @return
	 */
	int deleteBook(SqlSession session, String bookId);
	
	/**
	 * 책의 모든 정보를 반환 (title - ASC)
	 * @param session
	 * @return
	 */
	List<Book> selectBookList(SqlSession session);
	
	/**
	 * 매개변수로 받은 bookId와 일치하는 책정보 반환
	 * @param session
	 * @param bookId
	 * @return
	 */
	Book selectBookListById(SqlSession session, String bookId);
	
	/**
	 * 매개변수로 받은 title과 부분일치하는 책정보 반환 (LIKE), (title - ASC)
	 * @param session
	 * @param title
	 * @return
	 */
	List<Book> selectBookListByTitle(SqlSession session, String title);
	
	/**
	 * 페이징을 위해 해당 요소의 시작값과 끝 값을 받아 일정 크기만큼 책을 반환 (title - ASC)
	 * @param session
	 * @param startIndex 시작 데이터 인덱스
	 * @param endIndex 끝 데이터 인덱스
	 * @return (수정 가능성)
	 */
	List<Book> selectBookPaging(SqlSession session, int startIndex, int endIndex);
	
	/**
	 * 책의 전체 권수를 반환
	 * @param session
	 * @return
	 */
	int selectBookCount(SqlSession session);

	
	
	
	/**
	 * 매개변수로 받은 author와 부분일치하는 책정보 반환 (LIKE), (title - ASC)
	 * @param session
	 * @param author
	 * @return
	 */
	List<Book> selectBookListByAuthor(SqlSession session, String author);

	
	/**
	 * 매개변수로 받은 publisher와 부분일치하는 책정보 반환 (LIKE), (title - ASC)
	 * @param session
	 * @param publisher
	 * @return
	 */
	List<Book> selectBookListByPublisher(SqlSession session, String publisher);
	
	
	/////////////////////////////////////////////////////////////////////////////////
	
	
	/**
	 * keyword로 select한 책의 전체 권수를 반환 (LIKE)
	 * @param session
	 * @param select
	 * @param keyword
	 * @return
	 */
	int selectBookByKeywordCount(SqlSession session, String select, String keyword);
	
	
	/**
	 * keyword로 select 후 페이징을 위해 해당 요소의 시작값과 끝 값을 받아 일정 크기만큼 책을 반환 (LIKE) (title - ASC)
	 * @param session
	 * @param select
	 * @param keyword
	 * @param startIndex
	 * @param endIndex
	 * @return
	 */
	List<Book> selectBookPagingByKeyword(SqlSession session, String select, String keyword, int startIndex, int endIndex);
}
