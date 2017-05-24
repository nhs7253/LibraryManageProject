package kr.co.library.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.library.exception.FailWaitException;
import kr.co.library.service.RentalService;
import kr.co.library.service.impl.RentalServiceImpl;

public class WaitListInsertController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*HttpSession session = req.getSession();
		session.setAttribute("userId", "userId");
		session.setAttribute("bookId", "bookId");
		
		RentalService service = RentalServiceImpl.getInstance();
		String message;
		
		try {
			message = service.waitBook((String)(session.getAttribute("userId")), (String)(session.getAttribute("bookId")));
		} catch (FailWaitException fwe) {
			message = fwe.getMessage();
		}
		session.setAttribute("message", message);
		
		resp.sendRedirect("/LibraryManage/rental/test.jsp");*/
		
		
		HttpSession session = req.getSession();
		
		RentalService service = RentalServiceImpl.getInstance();
		String message;
		
		try {
			message = service.waitBook(req.getParameter("userId"),req.getParameter("bookId"));
		} catch (FailWaitException e) {
			message = e.getMessage();
		}
		session.setAttribute("message", message);
		
		resp.sendRedirect("/LibraryManage/rental/test.jsp");
		
		
	}
}
