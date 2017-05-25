package kr.co.library.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.library.vo.UserManagement;

public interface UserManagementDao {
	/**
	 * 매개변수로 받은 Member객체를 insert
	 * @param session
	 * @param member
	 * @return
	 */
	int insertUserManagement(SqlSession session, UserManagement user);
	
	/**
	 * 매개변수로 받은 Member객체의 userId와 같은 Member의 나머지 정보를 수정
	 * @param session
	 * @param member
	 * @return
	 */
	int updateUserManagement(SqlSession session,UserManagement user);
	
	/**
	 * 매개변수로 받은 userId와 같은 user의 정보를 삭제
	 * @param session
	 * @param userId
	 * @return
	 */
	int deleteUserManagement(SqlSession session, String userId);
	
	/**
	 * 모든 회원의 정보를 반환(title - ASC)
	 * 페이징
	 * @param session
	 * @return
	 */
	List<Object> selectUserManagementPagingList(SqlSession session, int startIndex, int endIndex);
	
	/**
	 * 매개변수로 받은 userId와 일치하는 회원정보반환
	 * @param session
	 * @param userId
	 * @return
	 */
	UserManagement selectUserManagementListById(SqlSession session, String userId);
	
	/**
	 * 매개변수로 받은 userName과 일치하는 회원정보 반환
	 * @param session
	 * @param userName
	 * @return
	 */
	List<UserManagement> selectUserManagementListByUserName(SqlSession session, String userName);
	
	/**
	 * 모든 회원의 전체수를 반환
	 * @param session
	 * @return
	 */
	int selectUserManagementCount(SqlSession session);
	
}
