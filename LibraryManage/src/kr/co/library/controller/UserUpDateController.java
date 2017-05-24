package kr.co.library.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import kr.co.library.dao.impl.UserManagementDaoImpl;
import kr.co.library.vo.UserManagement;


public class UserUpDateController extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		UserManagement user = new UserManagement();
		
		String id =req.getParameter("id");
		String password =req.getParameter("password");
		String name =req.getParameter("name");
		String phoneNum =req.getParameter("phoneNum");
		String email =req.getParameter("eamil");
		
		UserManagement userInfo = new UserManagement(id,password,name,phoneNum,email,user.getPenaltyState());
		
		try
		{
			UserManagementDaoImpl.getInstance().updateUserManagement((SqlSession) session, userInfo);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		resp.sendRedirect("//");
	}
	
	
	
}
