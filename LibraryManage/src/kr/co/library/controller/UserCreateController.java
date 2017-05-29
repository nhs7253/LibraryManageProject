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
		// 연체상태는 회원가입에서 필요없으므로 제외.
		
		//회원가입이 성공했을 시 보여주는 message
		String message = "회원가입이 완료되었습니다.";
	
		// 비지니스 로직
		UserInfoService service = UserInfoServiceImpl.getInstance();
	
		try {
			//UserManagement객체를 넣어주고
			service.createUser(new UserManagement(userId, password, name, phoneNum, email, 'N'));
			session.setAttribute("successMessage", message);//성공시 message를 session.successMessage에 넣어준다.
			response.sendRedirect("/LibraryManage/forUser/main.jsp");
			//F5 눌렀을 때 회원가입이 중복으로 발생하지않게하기위해 리다이렉트로 전송함.
			
		} catch (FailMemberRegistException e) {
			message = e.getMessage();
			session.setAttribute("failMessage", message);
			response.sendRedirect("/LibraryManage/forUser/userCreate.jsp");
		}
	}
}
