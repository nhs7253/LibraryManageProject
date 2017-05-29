package kr.co.library.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.library.exception.UserNotFoundException;
import kr.co.library.service.UserInfoService;
import kr.co.library.service.impl.UserInfoServiceImpl;
import kr.co.library.vo.UserManagement;

public class DeleteUserController extends HttpServlet 
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//session에서 데이터를 가져옴
		HttpSession session = req.getSession(); 
		UserInfoService service = UserInfoServiceImpl.getInstance();
		
		if(session.getAttribute("adminInfo")!=null){
			
			String userId= req.getParameter("userId");
			try {
				service.dropUser(userId);
			} catch (UserNotFoundException e) {
				e.printStackTrace();
			}			
			resp.sendRedirect("/LibraryManage/forAdmin/all_user_list.jsp");

		}else if(session.getAttribute("adminInfo")==null){
			
			try {
				service.dropUser(((UserManagement)session.getAttribute("loginInfo")).getUserId());
				session.invalidate();
			} catch (UserNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			resp.sendRedirect("/LibraryManage/forUser/main.jsp");
		}

		}
	}
