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
		session.setAttribute("rentMessage", message);
		
		int page = 1; //기본페이지가 1
		
		String select = req.getParameter("select");
		String keyword = req.getParameter("keyword");

		try{
			page = Integer.parseInt(req.getParameter("page")); //보려는 페이지번호 조회.
		}catch (Exception e) {}
		
		session.setAttribute("check", "check");
		resp.sendRedirect(String.format("/LibraryManage/BookSearchByKeyword?select=%s&keyword=%s&page=%d", select, keyword, page));
		
	}
}
