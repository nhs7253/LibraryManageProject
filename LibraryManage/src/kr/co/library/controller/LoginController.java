package kr.co.library.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.library.exception.AdminNotFoundException;
import kr.co.library.exception.LoginFailException;
import kr.co.library.service.AdministratorService;
import kr.co.library.service.UserInfoService;
import kr.co.library.service.impl.AdministratorServiceImpl;
import kr.co.library.service.impl.UserInfoServiceImpl;
import kr.co.library.vo.Administrator;
import kr.co.library.vo.UserManagement;

public class LoginController extends HttpServlet {


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// id/password 조회
		String mainId = req.getParameter("id");
		String mainPassword = req.getParameter("password");
		HttpSession session = req.getSession();// session 생성
		
		
		String returnURL = (String) session.getAttribute("returnURL");
		if(returnURL==null || returnURL.startsWith("null") || returnURL.contains("logout")){
			returnURL = "/forUser/main.jsp";
		}
		
		System.out.println("LoginController - " + returnURL);

		UserInfoService service = UserInfoServiceImpl.getInstance();// 유저 인스턴스
		AdministratorService adminService = AdministratorServiceImpl.getInstance();// 어드민
																					// 인스턴스

		UserManagement user = service.searchUser(mainId);
		Administrator admin = adminService.selectAdministratorById(mainId);

		// 유저,어드민 구별
		if (user != null)// user
		{
			try {
				
				UserManagement userInfo = service.longinUser(mainId, mainPassword); // user에
																					// 데이터를
																					// 집어넣음
				session.setAttribute("loginInfo", userInfo);// 회원정보를 담음
				
				session.removeAttribute("returnURL");
	
				req.getRequestDispatcher(returnURL.replace(getServletContext().getInitParameter("rootPath"),"")).forward(req, resp);
			} catch (LoginFailException e)// 에러메세지 전송
			{
				req.setAttribute("errorMessage", e.getMessage());// 응답하면 관리할
																	// 필요없는 속성값
				
				req.getRequestDispatcher("/forUser/login.jsp").forward(req, resp);// 전달
			}
		}  
		if (admin != null)// admin 조회
		{
			try {
				// 로그인성공 session 생성 ->

				Administrator adminInfo = adminService.adminLoging(mainId, mainPassword);
				session.setAttribute("adminInfo", adminInfo);// admin
				
				session.removeAttribute("returnURL");
				
				req.getRequestDispatcher("/forAdmin/admin_index.jsp").forward(req, resp);// 전달
			} catch (AdminNotFoundException e)// 에러메시지 전송
			{
				req.setAttribute("errorMessage", e.getMessage());// 응답하면 관리할
																	// 필요없는 속성값
				
				req.getRequestDispatcher("/forUser/login.jsp").forward(req, resp);// 전달
			}
		}
		if(user==null && admin == null){
			req.setAttribute("errorMessage", "아이디나 비밀번호를 다시 확인해주세요");// 응답하면 관리할
			req.getRequestDispatcher("/forUser/login.jsp").forward(req, resp);// 전달
		}
		
		
	}
}

