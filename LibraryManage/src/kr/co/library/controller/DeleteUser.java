package kr.co.library.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.library.exception.UserNotFoundException;
import kr.co.library.service.impl.UserInfoServiceImpl;


public class DeleteUser extends HttpServlet 
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId = req.getParameter("userid");
		
		try
		{
			UserInfoServiceImpl.getInstance().dropUser(userId);
		}
		catch(UserNotFoundException e)
		{
			e.printStackTrace();
		}
		resp.sendRedirect("//");
	}
}
