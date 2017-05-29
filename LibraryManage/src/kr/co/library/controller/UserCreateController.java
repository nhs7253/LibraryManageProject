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

public class UserCreateController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		// 요청파라미터 조회
		String userId = request.getParameter("userId");
		// pw
		String password = request.getParameter("password");
		// 이름
		String name = request.getParameter("userName");
		// 폰번호
		String phoneNum = request.getParameter("phoneNum");
		// 이메일
		String email = request.getParameter("email");
		// 연체상태는 입력받으면 안되지.
		

		String message = "회원가입이 완료되었습니다.";
		// 비지니스 로직
		UserInfoService service = UserInfoServiceImpl.getInstance();
		try {

			service.createUser(new UserManagement(userId, password, name, phoneNum, email, 'N'));
			session.setAttribute("successMessage", message);
			response.sendRedirect("/LibraryManage/forUser/main.jsp");
			
		} catch (FailMemberRegistException e) {
			message = e.getMessage();
			session.setAttribute("failMessage", message);
			response.sendRedirect("/LibraryManage/forUser/userCreate.jsp");
		}
	}
}
