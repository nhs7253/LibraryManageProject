package kr.co.library.service.impl;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.co.library.dao.BookDao;
import kr.co.library.dao.RentalListDao;
import kr.co.library.dao.WaitListDao;
import kr.co.library.dao.impl.BookDaoImpl;
import kr.co.library.dao.impl.RentalListDaoImpl;
import kr.co.library.dao.impl.WaitListDaoImpl;
import kr.co.library.service.BookService;
import kr.co.library.service.RentalService;
import kr.co.library.util.PagingBean;
import kr.co.library.util.SqlSessionFactoryManager;
import kr.co.library.vo.Book;
import kr.co.library.vo.RentalList;
import kr.co.library.vo.WaitList;

public class RentalServiceImpl implements RentalService{
	private SqlSessionFactory factory;
	private WaitListDao waitListDao;
	private RentalListDao rentalListDao;
	private static RentalService instance;
	
	private RentalServiceImpl() throws IOException{
		factory = SqlSessionFactoryManager.getInstance().getSqlSessionFactory();
		waitListDao = WaitListDaoImpl.getInstance();
		rentalListDao = RentalListDaoImpl.getInstance();
	}
	
	public static RentalService getInstance() throws IOException{
		if(instance == null){
			instance = new RentalServiceImpl();
		}
		return instance;
	}

	@Override
	public void rentBook(String userId, String bookId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void returnBook(String userId, int rentalNo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void waitBook(String userId, String BookId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelWaitBook(String userId, String BookId) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void noticeWaitUser(String userId, String email) {
		// TODO Auto-generated method stub
		
	}

	
	
	@Override
	public Map<String, Object> PrintRentalList(int page, String userId) {
		HashMap<String, Object> map = new HashMap<>(); 
		List<String> overdue = new ArrayList<>();
		
		SqlSession session = factory.openSession();
		try {
			int tatalCount = rentalListDao.selectRentalListByUserIdCount(session, userId);
			PagingBean pageBean = new PagingBean(tatalCount, page);
			List<RentalList> list = rentalListDao.selectRentalListPagingByUserIdToBook(session, userId, pageBean.getBeginItemInPage(), pageBean.getEndItemInPage());
			
			
//			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			
			Calendar limit = Calendar.getInstance();
			
			for(int i=0;i<list.size();i++){
				if(list.get(i).getRentalEnd() != null){
					overdue.add("N");
				}else{
					limit.setTime(list.get(i).getRentalStart());
					limit.add(Calendar.DATE, 14);
					if(list.get(i).getRentalStart().getTime()>limit.getTimeInMillis()){
						overdue.add("Y");
					}else{
						overdue.add("N");
					}
				}
			}
		    
			map.put("pageBean", pageBean);
			map.put("list",list);
			map.put("overdue", overdue);
		} finally {
			session.close();
		}
		
		return map;
	}

	@Override
	public Map<String, Object> PrintWaitList(int page, String userId) {
		HashMap<String, Object> map = new HashMap<>(); 
		
		SqlSession session = factory.openSession();
		try {
			int tatalCount = waitListDao.selectWaitListByUserCount(session, userId);
			PagingBean pageBean = new PagingBean(tatalCount, page);
			List<Object> list = waitListDao.selectWaitListPagingJoinBookJoinUserByUserId(session, userId, pageBean.getBeginItemInPage(), pageBean.getEndItemInPage());
			map.put("pageBean", pageBean);
			map.put("list", list);
		} finally {
			session.close();
		}
		
		return map;
	}

}
