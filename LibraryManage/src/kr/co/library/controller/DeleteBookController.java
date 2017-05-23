package kr.co.library.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.library.exception.BookNotFoundException;
import kr.co.library.service.impl.BookServiceImpl;

public class DeleteBookController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//HttpSession session = req.getSession();
		
		String bookId = req.getParameter("bookId");
		
		try {
			BookServiceImpl.getInstance().deleteBook(bookId);
		} catch (BookNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//session.setAttribute("", "");
		resp.sendRedirect("/LibraryManage/testBook.jsp");
		
	}
	
}
