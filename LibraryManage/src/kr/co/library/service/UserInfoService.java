package kr.co.library.service;

import exception.UserNotFoundException;
import kr.co.library.vo.UserManagement;

public interface UserInfoService {

	/**
	 * User객체를 받아서 새 회원을 가입처리
	 * @param user
	 */
	public void createUser(UserManagement user);
	
	/**
	 * 수정된 User객체를 받아서 회원정보를 수정. 
	 * @param user
	 * @throws UserNotFoundException 
	 */
	public void updateUser(UserManagement user) throws UserNotFoundException;
	
	/**
	 * 회원 id를 받아서 해당회원을 탈퇴처리
	 * @param userId
	 * @throws UserNotFoundException 
	 */
	public void dropUSer(String userId) throws UserNotFoundException;

	/**
	 * 회원id를 받아서 해당 회원의 정보를 가져옴.
	 * @param id
	 * @return
	 */
	public UserManagement searchById(String id);
	
	/**
	 * 회원id의 연체상태를 변경함
	 * -일정시간이 지났을때 연체설정을 (Y->N)해제하는걸로 설정?
	 * @param userId
	 * @param penaltyState
	 */
	public void clearPenalty(String userId);
	
}
