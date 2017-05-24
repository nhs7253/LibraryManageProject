package kr.co.library.dao;

import org.apache.ibatis.session.SqlSession;

import kr.co.library.vo.Administrator;

public interface AdministratorDao {
	/**
	 * 매개변수로 받은 admin insert
	 * @param session
	 * @param admin
	 * @return
	 */
	int insertAdministrator(SqlSession session, Administrator admin);
	/**
	 * 매개변수로 받은 adminId와 일치하는 관리자 정보 삭제
	 * @param session
	 * @param adminId
	 * @return
	 */
	int deleteAdministrator(SqlSession session, String adminId);
	/**
	 * 매개변수로 받은 adminId와 일치하는 관리자 정보 반환
	 * @param session
	 * @param adminId
	 * @return
	 */
	Administrator selectAdministratorById(SqlSession session, String adminId);
	
	
}
