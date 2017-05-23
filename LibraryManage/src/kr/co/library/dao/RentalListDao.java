package kr.co.library.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.library.vo.RentalList;

public interface RentalListDao {
	/**
	 * 매개변수로 받은RentalList객체를 insert
	 * @param session
	 * @param rentalList
	 * @return
	 */
	int insertRentalList(SqlSession session, RentalList rentalList);
	
	/**
	 * 매개변수로 받은 RentalList객체를 update
	 * @param session
	 * @param rentalList
	 * @return
	 */
	int updateRentalList(SqlSession session,  RentalList rentalList);
	/**
	 * 매개변수 로 받은 rentalNo를 delete
	 * @param session
	 * @param bookId
	 * @return
	 */
	int deleteRentalList(SqlSession session, int rentalNo);
	
	/**
	 * 모든 RentalList 정보를 조회
	 * @param session
	 * @return
	 */
	List<RentalList> selectRentalList(SqlSession session);
	/**
	 * UserId로 조회
	 * @param session
	 * @param userId
	 * @return
	 */
	RentalList selectRentalListByUserId(SqlSession session, String userId );
	/**
	 * BookId로 조회
	 * @param session
	 * @param bookId
	 * @return
	 */
	RentalList selectRentalListByBookId(SqlSession session, String bookId);
	
	/**
	 * UserId를 통해 book 테이블의 정보를 함꼐 조회한다.  (rental_start를 기준으로 내림 차순)
	 * @param session
	 * @param bookId
	 * @return
	 */
	List<RentalList> selectRentalListByUserIdToBook(SqlSession session, String bookId);
	

	/**
	 * rentalNo로 해당 대출목록을 조회
	 * @param session
	 * @param rentalNo
	 * @return
	 */
	RentalList selectRentalListByRentalNo(SqlSession session,int rentalNo);
	
	/**
	 * userId로 select한 대여 내역의 수를 반환
	 * @param session
	 * @param userId
	 * @return
	 */
	int selectRentalListByUserIdCount(SqlSession session, String userId);
	
	/**
	 * UserId를 통해 book 테이블의 정보를 함꼐 조회 후 일정 부분만 리턴한다. (rental_start를 기준으로 내림 차순)
	 * @param session
	 * @param bookId
	 * @return
	 */
	List<RentalList> selectRentalListPagingByUserIdToBook(SqlSession session, String userId, int startIndex, int endIndex);
	
	
	/**
	 * rental_end가 널인 지를 기준으로 book 테이블의 정보와 user_name을 조회 후 일정 부분만 리턴한다. (rental_start를 기준으로 내림 차순)
	 * @param session
	 * @param startIndex
	 * @param endIndex
	 * @return
	 */
	List<Object> selectRentalListPagingByEndIsNull(SqlSession session, int startIndex, int endIndex);
}
