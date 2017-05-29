package kr.co.library.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.library.exception.UserNotFoundException;
import kr.co.library.service.impl.UserInfoServiceImpl;
import kr.co.library.vo.UserManagement;

public class UserUpDateController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		HttpSession session = req.getSession(); 		
		
		//jsp에서 수정한 데이터를 받음.
		String password =req.getParameter("password");
		String userName =req.getParameter("userName");
		String phoneNum =req.getParameter("phoneNum");
		String email =req.getParameter("email");
		
	     if (password.equals("") || userName.equals("") ||email.equals("")) {
	          req.setAttribute("errorMessage", "이름,패스워드,이메일 중 빈칸이 빈곳이 있으면 안됩니다.");// 빈칸확인
	          req.getRequestDispatcher("/forUser/userUpdate.jsp").forward(req, resp);// 전달
	       } 
	      else{
	          UserManagement user = new UserManagement(((UserManagement) session.getAttribute("loginInfo")).getUserId(),
	                password, userName, phoneNum, email,
	                ((UserManagement) session.getAttribute("loginInfo")).getPenaltyState());
		
		try
		{
			UserInfoServiceImpl.getInstance().updateUser(user);
			req.getSession().setAttribute("loginInfo", user);
		}
		catch(UserNotFoundException e)
		{
			e.printStackTrace();
		}
		resp.sendRedirect("/LibraryManage/forUser/MyPage.jsp");
	}
	
	}
}
