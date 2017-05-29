package kr.co.library.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.library.service.BookService;
import kr.co.library.service.impl.BookServiceImpl;
import kr.co.library.util.MailSender;

public class BookSearchByKeywordController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		try{
		//1. 요청파라미터 조회 + 검증
		int page = 1; //기본페이지가 1
		
		
		String select = request.getParameter("select");
		String keyword = request.getParameter("keyword");
		HttpSession session = request.getSession();
		try{
			page = Integer.parseInt(request.getParameter("page")); //보려는 페이지번호 조회.
		}catch (Exception e) {}
		
		//2. 비지니스 로직 - Model 호출
		BookService service = BookServiceImpl.getInstance();
		Map<String, Object> map = service.searchByKeyword(page, select, keyword);
		
		//3. 결과 응답 - View 호출
		request.setAttribute("list", map.get("list"));
		request.setAttribute("pageBean", map.get("pageBean"));
		request.setAttribute("select", select);
		request.setAttribute("keyword", keyword);
		
		if(session.getAttribute("adminInfo")!=null){
			request.getRequestDispatcher("/forAdmin/admin_book_list.jsp").forward(request, response);
			//request.getRequestDispatcher("/forUser/book_list.jsp").forward(request, response);
		}else if(session.getAttribute("adminInfo")==null){
			request.getRequestDispatcher("/forUser/book_list.jsp").forward(request, response);
		}
		} catch(Exception e){
			//에러페이지로 이동
			e.printStackTrace();
		}
		
		
	}
}







