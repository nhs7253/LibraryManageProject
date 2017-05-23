package kr.co.library.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.co.library.dao.WaitListDao;
import kr.co.library.vo.WaitList;

public class WaitListDaoImpl implements WaitListDao
{
	private final String namespace="kr.co.library.dao.config.mapper.WaitListMapper.";
	private static WaitListDao instance = new WaitListDaoImpl();
	
	private WaitListDaoImpl(){}
	
	public static WaitListDao getInstance()
	{
		return instance;
	}
	
	@Override
	public int insertWaitList(SqlSession session, WaitList waitlist) {
		
		return session.insert(namespace+"insertWaitList",waitlist);
	}

	@Override
	public int updateWaitList(SqlSession session, WaitList waitlist) {
		// TODO Auto-generated method stub
		return session.update(namespace+"updateWaitList",waitlist);
	}

	@Override
	public int deleteWaitList(SqlSession session, String waitUser, String bookId) {
		// TODO Auto-generated method stub
		Map<String,String> input = new HashMap<String,String>();
		input.put("waitUser",waitUser);
		input.put("bookId",bookId);
		return session.delete(namespace+"deleteWaitList",input);
	}

	@Override
	public List<WaitList> selectWaitList(SqlSession session) {
		// TODO Auto-generated method stub
		return session.selectList(namespace+"selectWaitList");
	}

	@Override
	public List<WaitList> selectWaitListByBookId(SqlSession session, String bookId) {
		// TODO Auto-generated method stub
		return session.selectList(namespace+"selectWaitListByBookId",bookId);
	}

	@Override
	public List<WaitList> selectWaitListByWaitUser(SqlSession session, String waitUser) {
		// TODO Auto-generated method stub
		return session.selectList(namespace+"selectWaitListByWaitUser",waitUser);
	}

	@Override
	public WaitList selectByWaitUserIdAndByBookId(SqlSession session, String waitUser, String bookId) {
		// TODO Auto-generated method stub
		Map<String,String> input = new HashMap<String,String>();
		input.put("waitUser",waitUser);
		input.put("bookId",bookId);
		return session.selectOne(namespace+"selectByWaitUserIdAndByBookId",input);
	}

	@Override
	public int selectWaitListByBookCount(SqlSession session, String bookId) {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+"selectWaitListByBookCount",bookId);
	}

	@Override
	public WaitList selectWaitListByWaitRanking(SqlSession session, int ranking) {
		return session.selectOne(namespace + "selectWaitListByWaitRanking", ranking);
	}

	@Override
	public int selectWaitListByUserCount(SqlSession session, String waitUser) {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+"selectWaitListByUserCount",waitUser);
	}

	@Override
	public List<WaitList> selectWaitListJoinBookJoinUser(SqlSession session) {
		// TODO Auto-generated method stub
		return session.selectList(namespace+"selectWaitListJoinBookJoinUser");
	}

	@Override
	public List<WaitList> selectWaitListJoinBookJoinUserByBookId(SqlSession session, String bookId) {
		// TODO Auto-generated method stub
		return session.selectList(namespace+"selectWaitListJoinBookJoinUserByBookId", bookId);
	}

	@Override
	public List<WaitList> selectWaitListJoinBookJoinUserByUserId(SqlSession session, String userId) {
		// TODO Auto-generated method stub
		return session.selectList(namespace+"selectWaitListJoinBookJoinUserByUserId", userId);
	}

	@Override
	public List<Object> selectWaitListPagingJoinBookJoinUserByUserId(SqlSession session, String userId, int startIndex, int endIndex) {
		// TODO Auto-generated method stub
		Map<String, String> input = new HashMap<String, String>();
		input.put("userId", userId);
		input.put("startIndex",String.valueOf(startIndex));
		input.put("endIndex",String.valueOf(endIndex));
		return session.selectList(namespace+"selectWaitListPagingJoinBookJoinUserByUserId", input);
	}

	@Override
	public List<Object> selectWaitListPagingJoinBookJoinUser(SqlSession session, int startIndex, int endIndex) {
		// TODO Auto-generated method stub
		Map<String, String> input = new HashMap<String, String>();
		input.put("startIndex",String.valueOf(startIndex));
		input.put("endIndex",String.valueOf(endIndex));
		return session.selectList(namespace+"selectWaitListPagingJoinBookJoinUser", input);
	}
	
}
