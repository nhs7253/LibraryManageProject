package kr.co.library.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.library.exception.LoginFailException;
import kr.co.library.service.UserInfoService;
import kr.co.library.service.impl.UserInfoServiceImpl;
import kr.co.library.vo.UserManagement;

public class LoginUserController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		// id/password 조회
		String id = req.getParameter("id");
		String password = req.getParameter("password");

		try {
			UserInfoService service = UserInfoServiceImpl.getInstance();
			//id,password조회
			UserManagement user = service.authenticate(id, password);
			
			
			// 로그인성공 session 생성 ->
			HttpSession session = req.getSession();
			session.setAttribute("loginInfo", user);// 회원정보 관리
			req.getRequestDispatcher("/login/userInfo.jsp").forward(req, resp);// 전달 <-jsp아직 미생성

		} catch (LoginFailException e) {
			req.setAttribute("errorMessage", e.getMessage());// Exception오류 메세지
			req.getRequestDispatcher("/login/login_main.jsp").forward(req, resp);// 전달 경로
		}
	}

	

}
