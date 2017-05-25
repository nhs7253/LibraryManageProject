package kr.co.library.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.library.service.UserInfoService;
import kr.co.library.service.impl.UserInfoServiceImpl;

public class AllUserListController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		try{
		//1. 요청파라미터 조회 + 검증
		int page = 1; //기본페이지가 1
		
		try{
			page = Integer.parseInt(req.getParameter("page")); //보려는 페이지번호 조회.
		}catch (Exception e) {}
		
		//2. 비지니스 로직 - Model 호출
		UserInfoService service = UserInfoServiceImpl.getInstance();
		Map<String, Object> map = service.allUserList(page);
		
		//3. 결과 응답 - View 호출
		req.setAttribute("list", map.get("list"));
		req.setAttribute("pageBean", map.get("pageBean"));
			
		req.getRequestDispatcher("/forAdmin/all_user_list.jsp").forward(req, resp);

		} catch(Exception e){
			//에러페이지로 이동
			e.printStackTrace();
		}
	}
}
