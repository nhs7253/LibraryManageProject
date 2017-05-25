package kr.co.library.service;

import java.util.Map;

import kr.co.library.exception.BookIdException;
import kr.co.library.exception.BookNotFoundException;
import kr.co.library.vo.Book;

public interface BookService {

	/**    
	 * Book객체를 입력받아서 새로운 책정보를 추가.
	 * - null이 들어왔을때 체크
	 * - 이미 있는 책인지 중복체크
	 * @param book
	 */
	public void addBook(Book book)throws BookIdException;
		
	/**
	 * 수정된 Book 객체의 정보를 받아서 같은 id를 제외한 정보를 수정.
	 * -null체크
	 * -없는 책인지 체크
	 * @param book
	 */
	public void updateBook(Book book) throws BookNotFoundException;
	
	/**
	 * Book의 id를 받아서 해당 책의 정보를 삭제.
	 * -null체크
	 * -없는id인지 체크
	 * @param id
	 */
	public void deleteBook(String id) throws BookNotFoundException;
	
	
	//public List<Book> searchByAuthor(String author);
	//public List<Book> searchByPublisher(String publisher);
	
	/**
	 * bookId를 받아서 해당 id에 해당하는 책 정보를 반환.
	 * 단 찾는 ID의 책 정보가 없으면 null을 리턴한다.
	 * @param bookId
	 * @return
	 */
	public Book searchByBookId(String bookId);
	
	
	/**
	 * 해당 select 항목에 대해 keyword 검색한 검색 결과를 반환
	 * @param page
	 * @param select
	 * @param keyword
	 * @return
	 */
	public Map<String, Object> searchByKeyword(int page, String select, String keyword);
}
