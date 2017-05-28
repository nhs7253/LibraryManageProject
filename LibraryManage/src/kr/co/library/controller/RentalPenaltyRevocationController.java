package kr.co.library.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.library.exception.PenaltyNotException;
import kr.co.library.exception.PenaltyUnendedException;
import kr.co.library.service.RentalService;
import kr.co.library.service.impl.RentalServiceImpl;
import kr.co.library.vo.UserManagement;

public class RentalPenaltyRevocationController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserManagement user = new UserManagement(req.getParameter("userId"), 
												req.getParameter("password"), 
												req.getParameter("userName"), 
												req.getParameter("phoneNum"), 
												req.getParameter("email"), 
												req.getParameter("penaltyState").charAt(0));
		try {
			req.getSession().setAttribute("message", RentalServiceImpl.getInstance().RentalPenaltyRevocation(user));
		} catch (PenaltyUnendedException e) {
			req.getSession().setAttribute("message", e.getMessage());
		} catch (PenaltyNotException e) {
			req.getSession().setAttribute("message", e.getMessage());
		}

		resp.sendRedirect("/LibraryManage/allUser");
	}

}
