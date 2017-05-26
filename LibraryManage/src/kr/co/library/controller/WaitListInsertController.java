package kr.co.library.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.library.exception.FailWaitException;
import kr.co.library.exception.LoginFailException;
import kr.co.library.service.RentalService;
import kr.co.library.service.impl.RentalServiceImpl;

public class WaitListInsertController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		RentalService service = RentalServiceImpl.getInstance();
		String message;
		
		if (session.getAttribute("loginInfo") == null) {
			try {
				throw new LoginFailException("로그인이 필요합니다.");
			} catch (LoginFailException lfe) {
				message =lfe.getMessage();
				session.setAttribute("loginFailMessage", message);
				resp.sendRedirect("/LibraryManage/forUser/login.jsp");
			}
		} else {
			try {
				message = service.waitBook(req.getParameter("userId"), req.getParameter("bookId"));
			} catch (FailWaitException fwe) {
				message = fwe.getMessage();
			}
			
			session.setAttribute("waitMessage", message);
			
			int page = 1; //기본페이지가 1
			
			String select = req.getParameter("select");
			String keyword = req.getParameter("keyword");

			try{
				page = Integer.parseInt(req.getParameter("page")); //보려는 페이지번호 조회.
			}catch (Exception e) {}
			
			resp.sendRedirect(String.format("/LibraryManage/BookSearchByKeyword?select=%s&keyword=%s&page=%d", select, keyword, page));

		}
	}
}
