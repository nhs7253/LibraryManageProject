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



public class DeleteUserController extends HttpServlet 
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//session에서 데이터를 가져옴
		HttpSession session = req.getSession(); 
		System.out.println(((UserManagement)session.getAttribute("loginInfo")).getUserId());
		try
		{
			UserInfoServiceImpl.getInstance().dropUser(((UserManagement)session.getAttribute("loginInfo")).getUserId());
			//session 제거
			session.invalidate();
		}
		catch(UserNotFoundException e)
		{
			e.printStackTrace();
		}
		
		resp.sendRedirect("/LibraryManage/login/DeleteUser.jsp");
	}
}
