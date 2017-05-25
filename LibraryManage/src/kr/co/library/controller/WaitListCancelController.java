package kr.co.library.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.library.service.RentalService;
import kr.co.library.service.impl.RentalServiceImpl;

public class WaitListCancelController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();

		session.setAttribute("userId", req.getParameter("userId"));
		session.setAttribute("bookId", req.getParameter("bookId"));

		RentalService service = RentalServiceImpl.getInstance();
		service.cancelWaitBook((String) (session.getAttribute("userId")), (String) (session.getAttribute("bookId")));

		resp.sendRedirect("/LibraryManage/WaitList?userId=userId");
	}

}