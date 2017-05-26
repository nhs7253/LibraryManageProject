package kr.co.library.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.library.exception.FailRentException;
import kr.co.library.exception.FailReturnException;
import kr.co.library.exception.FailWaitException;
import kr.co.library.exception.NoWaitException;
import kr.co.library.service.RentalService;
import kr.co.library.service.impl.RentalServiceImpl;

public class ReturnBookController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		String message;

		String userId = (String) req.getParameter("userId");
		int rentalNo = Integer.parseInt((String) req.getParameter("rentalNo"));

		RentalService service = RentalServiceImpl.getInstance();

		try {
			message = service.returnBook(userId, rentalNo);
		} catch (FailReturnException e) {
			message = e.getMessage();
		}

		session.setAttribute("returnBookMessage", message);
		
		resp.sendRedirect("/LibraryManage/RentalListAdmin");

	}
}
