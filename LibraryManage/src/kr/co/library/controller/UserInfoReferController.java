package kr.co.library.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.library.exception.FailMemberRegistException;
import kr.co.library.service.UserInfoService;
import kr.co.library.service.impl.UserInfoServiceImpl;
import kr.co.library.vo.UserManagement;

public class UserInfoReferController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
																														throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		//session.userId를 조회
		String userId = (String) session.getAttribute("userId");

		// 비지니스 로직 - Model 호출
		UserInfoService service = UserInfoServiceImpl.getInstance();

		UserManagement user = service.searchUser(userId);
		//user 객체안에 userId 조회를 넣어준다.
		
		request.setAttribute("info", user);
		//request에 info라는 이름으로 user를 넣어준다.
		
		
		//요청디스패치
		request.getRequestDispatcher("/test.jsp").forward(request, response);

	}

}
