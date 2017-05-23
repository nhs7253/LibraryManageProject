package kr.co.library.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.co.library.vo.WaitList;

public interface WaitListDao 
{
	/**
	 * 책한권에 회원이 빌려서 생성되는 객체를 insert
	 * @param session
	 * @param waitlist
	 * @return
	 */
	int insertWaitList(SqlSession session, WaitList waitlist );
	
	/**
	 * 매개변수로 받은 waitlist 정보를 수정
	 * @param session
	 * @param waitlist
	 * @return
	 */
	int updateWaitList(SqlSession session, WaitList waitlist );
	
	/**
	 * waitUser와 bookId 두 정보 모두가 일치하는 대기정보 삭제
	 * @param session
	 * @param waitUser
	 * @param bookId
	 * @return
	 */
	int deleteWaitList(SqlSession session, String waitUser, String bookId);
	
	/**
	 * 대기자 모든정보 반환
	 * @param session
	 * @return
	 */
	List<WaitList>selectWaitList(SqlSession session);
	
	/**
	 * 매개변수로 받은 bookId와 일치하는 대기자 명단 반환
	 * @param session
	 * @param bookId
	 * @param waitUser
	 * @return
	 */
	List<WaitList>selectWaitListByBookId(SqlSession session, String bookId);
	
	/**
	 * 매개변수로 받은 랭킹으로 일치하는 대기목록을 반환
	 * 랭킹은 시퀀스.
	 * @param session
	 * @param ranking
	 * @return
	 */
	WaitList selectWaitListByWaitRanking(SqlSession session, int ranking);
	
	/**
	 * 매개변수로 받은 waitUser와 일치하는 책 목록 반환
	 * @param session
	 * @param waitUser
	 * @param bookId
	 * @return
	 */
	List<WaitList> selectWaitListByWaitUser(SqlSession session,String waitUser);

	/**
	 * 매개변수로 받은 bookId와 waitUserId 일치하는 책정보 반환
	 * @param session
	 * @param bookId
	 * @return
	 */
	WaitList selectByWaitUserIdAndByBookId(SqlSession session, String waitUser, String bookId);

	/**
	 * 특정 bookId의 숫자를 반환
	 * @param session
	 * @param bookId
	 * @return
	 */
	int selectWaitListByBookCount(SqlSession session, String bookId);
	
	/**
	 * 특정 waitUser의 숫자를 반환
	 * @param session
	 * @param waitUser
	 * @return
	 */
	int selectWaitListByUserCount(SqlSession session, String waitUser);
	
	/**
	 * WaitList, Book, User의 세 테이블의 전체 조인 결과를 반환
	 * @param session
	 * @return
	 */
	List<WaitList> selectWaitListJoinBookJoinUser(SqlSession session);
	
	/**
	 * bookId를 기준으로 WaitList, Book, User의 세 테이블의 전체 조인 결과를 반환
	 * @param session
	 * @param bookId
	 * @return
	 */
	List<WaitList> selectWaitListJoinBookJoinUserByBookId(SqlSession session, String bookId);

	/**
	 * userId를 기준으로 WaitList, Book, User의 세 테이블의 전체 조인 결과를 반환
	 * @param session
	 * @param userId
	 * @return
	 */
	List<WaitList> selectWaitListJoinBookJoinUserByUserId(SqlSession session, String userId);
	
	/**
	 * userId를 기준으로 WaitList, Book 테이블의 조인 후 책 제목과 대기 순위를 반환
	 * @param session
	 * @param userId
	 * @param startIndex
	 * @param endIndex
	 * @return
	 */
	List<Object> selectWaitListPagingJoinBookJoinUserByUserId(SqlSession session, String userId, int startIndex, int endIndex);
	
	/**
	 * WaitList, Book 테이블의 조인 후 책 제목과 대기 순위를 반환(userId, name, bookId, title, rank)
	 * @param session
	 * @param startIndex
	 * @param endIndex
	 * @return
	 */
	List<Object> selectWaitListPagingJoinBookJoinUser(SqlSession session, int startIndex, int endIndex);
}
