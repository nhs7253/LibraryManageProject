package kr.co.library.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.library.service.RentalService;
import kr.co.library.service.impl.RentalServiceImpl;
import kr.co.library.vo.RentalList;

public class CurrentRentalListController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		String userId = req.getParameter("userId");
		
		RentalService service = RentalServiceImpl.getInstance();
		List<RentalList> list = service.CountCurrentRentalList(userId);
		
		req.setAttribute("currentList", list);
	
		req.getRequestDispatcher("/forAdmin/all_user_list.jsp").forward(req, resp);
	}
}
