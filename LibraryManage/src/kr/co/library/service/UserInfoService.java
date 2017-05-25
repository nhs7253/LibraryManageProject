package kr.co.library.service;

import java.io.IOException;
import java.util.Map;

import kr.co.library.exception.LoginFailException;
import kr.co.library.exception.UserIDOverlapException;
import kr.co.library.exception.UserNotFoundException;
import kr.co.library.vo.UserManagement;

public interface UserInfoService {

	/**
	 * User객체를 받아서 새 회원을 가입처리
	 * @param user
	 * @return
	 * @throws UserIDOverlapException
	 * @throws IOException
	 */
	public void createUser(UserManagement user) throws UserIDOverlapException, IOException;
	
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
	public void dropUser(String userId) throws UserNotFoundException;

	/**
	 * 회원id를 받아서 해당 회원의 정보를 가져옴.
	 * @param id
	 * @return
	 * @throws IOException 
	 * @throws Exception 
	 */
	public UserManagement searchUser(String userId);
	
	/**
	 * 회원id의 연체상태를 변경함
	 * -일정시간이 지났을때 연체설정을 (Y->N)해제하는걸로 설정?
	 * @param userId
	 * @param penaltyState
	 */
	public void clearPenalty(String userId);
	
	/**
	 * 아이디 인증 메소드
	 * @param userId
	 * @param password
	 * @return
	 * @throws LoginFailException
	 */
	public UserManagement authenticate(String userId, String password);
	

	/**
	 * 전체회원목록보여주기
	 * 등록된 모든 회원의 정보를 보여주는 메소드(관리자)
	 * @param page
	 * @return
	 */
	Map<String,Object> allUserList(int page);

	
}
