package kr.co.library.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.library.exception.BookNotFoundException;
import kr.co.library.exception.WrongBookException;
import kr.co.library.service.impl.BookServiceImpl;
import kr.co.library.vo.Book;

public class UpdateBookController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		String message="?";

		// 관리자일때
		if (session.getAttribute("adminInfo") != null) {
			
			String bookId = req.getParameter("bookId");
			String title = req.getParameter("title");
			String author = req.getParameter("author");
			String publisher = req.getParameter("publisher");
			String publishDate = req.getParameter("publishDate");
			//String rentalState = req.getParameter("rentalState");

			Book book = new Book(bookId, title, author, publisher, publishDate,'Y');
					//rentalState.charAt(0));
			try {
				message = BookServiceImpl.getInstance().updateBook(book);
			} catch (BookNotFoundException e) {
				message = e.getMessage();
			} catch (WrongBookException e) {
				message = e.getMessage();
			}
			
			session.setAttribute("updateBookMessage", message);
			resp.sendRedirect("/LibraryManage/forAdmin/update_book.jsp");
		} else {
			// 관리자 아닐때
			session.setAttribute("NoAdminMessage", "관리자가 아닙니다.");
			resp.sendRedirect("/LibraryManage/forAdmin/update_book.jsp");
		}

	}
}
