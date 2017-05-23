package kr.co.library.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import kr.co.library.dao.impl.UserManagementDaoImpl;
import kr.co.library.exception.LoginFailException;
import kr.co.library.vo.UserManagement;

public class LoginUser extends HttpServlet {
	private SqlSession session;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// id/password 조회
		String id = req.getParameter("id");
		String password = req.getParameter("password");

		try {

			UserManagement user = authenticate(id, password);
			// 로그인성공 session 생성 ->
			HttpSession session = req.getSession();
			session.setAttribute("longinInfo", user);// 회원정보 관리
			req.getRequestDispatcher("").forward(req, resp);// 전달

		} catch (LoginFailException e) {
			req.setAttribute("errorMessage", e.getMessage());// Exception오류 메세지
			req.getRequestDispatcher("").forward(req, resp);// 전달 경로
		}
	}

	// 인증 처리 메소드
	public UserManagement authenticate(String userId, String password) throws LoginFailException {
		// id,password 비교
		UserManagement user = UserManagementDaoImpl.getInstance().selectUserManagementListById(session, userId);
		if (user != null)// 비밀번호 조회
		{
			if (password.equals(user.getPassword())) {
				return user;
			} else// PW가 틀린경우
			{
				throw new LoginFailException("비밀번호가 틀렸습니다.");
			}
		} else// ID 인증 실패
		{
			throw new LoginFailException("ID가 틀렸습니다.");
		}
	}

}
