package kr.co.library.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.library.exception.UserIDOverlapException;
import kr.co.library.service.UserInfoService;
import kr.co.library.service.impl.UserInfoServiceImpl;
import kr.co.library.vo.UserManagement;

public class UserCreateServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//요청파라미터 조회
		String userId = request.getParameter("userId");
		//pw
		String password = request.getParameter("password");
		//이름
		String name = request.getParameter("userName");
		//폰번호
		String phoneNum = request.getParameter("phoneNum");
		//이메일
		String email = request.getParameter("email");
		//연체상태는 입력받으면 안되지.
		String message = "회원가입이 완료되었습니다.";
		//비지니스 로직
		
		System.out.println(new UserManagement(userId, password, name, phoneNum, email, 'N'));
		
		UserInfoService service = UserInfoServiceImpl.getInstance();
		 try {
			service.createUser(new UserManagement(userId, password, name, phoneNum, email, 'N'));
		} catch (UserIDOverlapException e) {
			message = "중복된 ID 또는 잘못된값입니다.";
		}

		
		//결과응답
		//request.setAttribute("result", message);
	
		//리다이렉트
		//response.sendRedirect("/userCreate.jsp");
		
		
		
		
/*		//요청파라미터 조회
		String userId = request.getParameter("userId");
		//pw
		String password = request.getParameter("password");
		//이름
		String name = request.getParameter("userName");
		//폰번호
		String phoneNum = request.getParameter("phoneNum");
		//이메일
		String email = request.getParameter("email");
		//연체상태는 입력받으면 안되지.
		String message = "회원가입이 완료되었습니다.";
		//비지니스 로직
		UserInfoService service = UserInfoServiceImpl.getInstance();
		 try {
			service.createUser(new UserManagement(userId, password, name, phoneNum, email, 'N'));
		} catch (UserIDOverlapException e) {
			message = "중복된 ID 또는 잘못된값입니다.";
		}

		
		//결과응답
		//request.setAttribute("result", message);
	
		//리다이렉트
		//response.sendRedirect("/userCreate.jsp");
*/	
	}
}
