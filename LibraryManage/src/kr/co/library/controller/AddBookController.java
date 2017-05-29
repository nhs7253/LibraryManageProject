package kr.co.library.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.library.exception.BookIdException;
import kr.co.library.exception.WrongBookException;
import kr.co.library.service.impl.BookServiceImpl;
import kr.co.library.vo.Book;

public class AddBookController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		String message="";
		
		//관리자아이디로 로그인 되었을때 
		if(session.getAttribute("adminInfo")!=null){
					
			String bookId = req.getParameter("bookId");
			String title = req.getParameter("title");
			String author = req.getParameter("author");
			String publisher = req.getParameter("publisher");
			String publishDate = req.getParameter("publishDate");
		
			try{
				message = BookServiceImpl.getInstance().addBook(new Book(bookId,title,author,publisher,publishDate,'Y'));
			}catch(BookIdException e){
				message = e.getMessage();
			} catch (WrongBookException e) {
				message = e.getMessage();
			}
			session.setAttribute("addBookMessage", message);
			resp.sendRedirect("/LibraryManage/forAdmin/add_book.jsp");		
		}else{
			//관리자 아이디로 로그인되지 않았을때 
			session.setAttribute("NoAdminMessage", "관리자가 아닙니다.");
			resp.sendRedirect("/LibraryManage/forAdmin/add_book.jsp");
		}
	
	}
}
