package kr.co.library.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.library.service.RentalService;
import kr.co.library.service.impl.RentalServiceImpl;

public class WaitListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		try{
		//1. 요청파라미터 조회 + 검증
		int page = 1; //기본페이지가 1
		String userId = "";
		
		userId = request.getParameter("userId");
		try{
			page = Integer.parseInt(request.getParameter("page")); //보려는 페이지번호 조회.
		}catch (Exception e) {}
		
		//2. 비지니스 로직 - Model 호출
		RentalService service = RentalServiceImpl.getInstance();
		Map<String, Object> map = service.PrintWaitList(page, userId);
		
		//3. 결과 응답 - View 호출
		request.setAttribute("list", map.get("list"));
		request.setAttribute("pageBean", map.get("pageBean"));
		request.setAttribute("userId", userId);
		

		

		request.getRequestDispatcher("/forUser/wait_list.jsp").forward(request, response);

		} catch(Exception e){
			//에러페이지로 이동
			e.printStackTrace();
		}
	}
}







