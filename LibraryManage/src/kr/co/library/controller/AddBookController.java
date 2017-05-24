package kr.co.library.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.library.exception.BookIdException;
import kr.co.library.service.impl.BookServiceImpl;
import kr.co.library.vo.Book;

public class AddBookController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		//HttpSession session = req.getSession();
		/*String id = (String) session.getAttribute("userId");
		if(id == 관리자인지)
		*/		
		
		String bookId = req.getParameter("bookId");
		String title = req.getParameter("title");
		String author = req.getParameter("author");
		String publisher = req.getParameter("publisher");
		String publishDate = req.getParameter("publishDate");
	//	String rentalState = req.getParameter("rentalState");
		
		System.out.println(bookId);
		try{
			BookServiceImpl.getInstance().addBook(new Book(bookId,title,author,publisher,publishDate,'Y'));
		}catch(BookIdException e){
			e.printStackTrace();
		}
		
		//session.setAttribute("", "");
		
		resp.sendRedirect("/LibraryManage/testBook.jsp");
	}
}
