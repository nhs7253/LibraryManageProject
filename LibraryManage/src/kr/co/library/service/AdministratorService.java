package kr.co.library.service;

import kr.co.library.exception.AdminNotFoundException;
import kr.co.library.exception.AdminOverlapException;
import kr.co.library.vo.Administrator;

public interface AdministratorService {
/**
 * 관리자 정보를 생성해서 관리자 객체에 반환한다.
 * @param admin
 * @return
 * @throws AdminOverlapException 
 */
	public void insertAdministrator(Administrator admin) throws AdminOverlapException;
	/**
	 * 매개변수 adminId를 받아 삭제
	 * @param adminId
	 */
	public void deleteAdministrator(String adminId) throws AdminNotFoundException;
	/**
	 * 매개변수 adminId를 받아 조회
	 * 관리자 객체로 반환
	 * @param adminId
	 * @return
	 */
	public Administrator selectAdministratorById(String adminId);
	
	
}
