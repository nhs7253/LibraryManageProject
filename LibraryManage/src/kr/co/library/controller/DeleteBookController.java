package kr.co.library.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.library.exception.BookNotFoundException;
import kr.co.library.service.impl.BookServiceImpl;

public class DeleteBookController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		String message="";

		// 관리자아이디로 로그인 되었을때
		if (session.getAttribute("adminInfo") != null) {
			String bookId = req.getParameter("bookId");
			try {
				message = BookServiceImpl.getInstance().deleteBook(bookId);
			} catch (BookNotFoundException e) {
				message = e.getMessage();
			}
			session.setAttribute("deleteBookMessage", message);
			resp.sendRedirect("/LibraryManage/forAdmin/delete_book.jsp");
		} else {
			// 관리자 아이디로 로그인되지 않았을때
			session.setAttribute("NoAdminMessage", "관리자가 아닙니다.");
			resp.sendRedirect("/LibraryManage/forAdmin/delete_book.jsp");
		}

	}

}
