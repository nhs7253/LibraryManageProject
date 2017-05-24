package kr.co.library.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.library.exception.FailRentException;
import kr.co.library.exception.FailWaitException;
import kr.co.library.service.RentalService;
import kr.co.library.service.impl.RentalServiceImpl;
//Test 완료 - 김진광 170523
public class RentBookController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String message;

		String userId = req.getParameter("userId");
		String bookId = req.getParameter("bookId");
		
		
		RentalService service = RentalServiceImpl.getInstance();
		try {
			message = service.rentBook(userId,bookId);
		} catch (FailRentException e) {
			message = e.getMessage();
		} catch (FailWaitException e) {
			message = e.getMessage();
		}
		session.setAttribute("message", message);

		resp.sendRedirect("/LibraryManage/rental/test.jsp");
		
		
		/*		HttpSession session = req.getSession();
		String message;
		session.setAttribute("userId", "userId");
		session.setAttribute("bookId", "bookId");

		RentalService service = RentalServiceImpl.getInstance();

		try {
			message = service.rentBook((String) (session.getAttribute("userId")),
					(String) (session.getAttribute("bookId")));
		} catch (FailRentException fre) {
			message = fre.getMessage();
		} catch (FailWaitException fwe) {
			message = fwe.getMessage();
		}
		session.setAttribute("message", message);

		resp.sendRedirect("/LibraryManage/rental/test.jsp");*/
	}
}
