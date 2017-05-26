package kr.co.library.service;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.co.library.exception.FailRentException;
import kr.co.library.exception.FailReturnException;
import kr.co.library.exception.FailWaitException;

public interface RentalService {

	/**
	 * rentBook Insert - 중복되는 명령어라 따로 분리.
	 * @param session
	 * @param userId
	 * @param bookId
	 */
	public void rentBookInsert(SqlSession session, String userId, String bookId);
	
	/**
	 * 대출처리
	 * 원하는 책을 검색 후 대출 신청 버튼을 누르면 Book의 대여 상태와 로그인한 사용자의 대여 패널티 상태를 비교하여 
	 * 대출, 대기자처리를 해준다. 
	 *
	 * @param userId
	 * @param bookId
	 * @return
	 * @throws FailWaitException 
	 */
	public String rentBook(String userId,String bookId) throws FailRentException, FailWaitException;
	
	/**
	 * 반납처리
	 * 회원이 로그인 후 자신의 대출목록에서 책의 반납버튼을 눌러서 진행되는 반납과정
	 * -RentalList에 종료시간설정
	 * -WaitList에 BookId가 있는지 조회, 
	 * 	있으면 WaitRanking이 제일작은애에게 대출처리 & 이메일 알림
	 * 	없으면 Book의 RentalState를 Y로 수정.
	 * -종료시간과 시작시간의 차이로 연체여부 결정-> user의 penaltyState를 설정
	 * @param userId
	 * @param rentalNo
	 */
	public String returnBook(String userId,int rentalNo) throws FailReturnException;
	
	/**
	 * 대기처리
	 * 
	 * @param userId
	 * @param BookId
	 * @return 
	 */
	public String waitBook(String userId,String BookId) throws FailWaitException;
	
	/**
	 * 대기취소처리
	 * 회원이 로그인 후 책의 대기를 취소하는 과정
	 * -WaitList에 해당 id들과 일치하는 컬럼을 삭제.
	 * -시퀀스 재조정? 
	 * @param userId
	 * @param BookId
	 */
	public void cancelWaitBook(String userId,String BookId);
	
	/**
	 * 대출목록 보여주기
	 * 회원의 대출목록들을 보여주기 (날짜순으로 정렬)
	 * 	대출번호,빌린날짜,반납날짜,책id,책제목,연체여부
	 * @param userId
	 * @return
	 */
	public Map<String, Object> PrintRentalList(int page, String userId);
	
	/**
	 * 대기목록보여주기
	 * 회원이 현재 대기중인 도서들의 목록을 보여주기
	 * 	도서제목,대기순위(시퀀스),대기취소버튼제공?
	 * @param userId
	 * @return
	 */
	public Map<String, Object> PrintWaitList(int page, String userId);
	

	/**
	 * 현재 대출 목록을 읽어오는 서비스 (관리자)
	 * @param page
	 * @return
	 */
	Map<String, Object> PrintCurrentRentalList(int page, String userId);
	
	
	/**
	 * 대기목록보여주기
	 * 회원이 현재 대기중인 도서들의 전체 목록을 보여주(관리자)
	 * @param page
	 * @return
	 */
	Map<String, Object> PrintAdminWaitList(int page);
	
	//public String rentWaitFirst(SqlSession session, String userId, String bookId) throws FailRentException, FailWaitException;
	
	
	
}
