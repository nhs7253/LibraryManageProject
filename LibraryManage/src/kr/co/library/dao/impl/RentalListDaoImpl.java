package kr.co.library.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.co.library.dao.RentalListDao;
import kr.co.library.vo.RentalList;

public class RentalListDaoImpl implements RentalListDao {
	private final String namespace = "kr.co.library.dao.config.mapper.RentalListMapper.";
	private static RentalListDao instance = new RentalListDaoImpl();

	private RentalListDaoImpl() {
	}

	public static RentalListDao getInstance() {
		return instance;
	}

	@Override
	public int insertRentalList(SqlSession session, RentalList rentalList) {
		// TODO Auto-generated method stub
		return session.insert(namespace + "insertRentalList", rentalList);
	}

	@Override
	public int updateRentalList(SqlSession session, RentalList rentalList) {
		// TODO Auto-generated method stub
		return session.update(namespace + "updateRentalList", rentalList);
	}

	@Override
	public int deleteRentalList(SqlSession session, int rentalNo) {
		// TODO Auto-generated method stub
		return session.delete(namespace + "deleteRentalList", rentalNo);
	}

	@Override
	public List<RentalList> selectRentalList(SqlSession session) {
		// TODO Auto-generated method stub
		return session.selectList(namespace + "selectRentalList", session);
	}

	@Override
	public RentalList selectRentalListByRentalNo(SqlSession session, int rentalNo) {
		return session.selectOne(namespace + "selectRentalListByRentalNo",rentalNo);
	}
	
	@Override
	public RentalList selectRentalListByUserId(SqlSession session, String userId) {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + "selectRentalListByUserId", userId);
	}

	@Override
	public RentalList selectRentalListByBookId(SqlSession session, String bookId) {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + "selectRentalListByBookId", bookId);
	}

	@Override
	public List<RentalList> selectRentalListByUserIdToBook(SqlSession session, String bookId) {
		// TODO Auto-generated method stub
		return session.selectList(namespace + "selectRentalListByUserIdToBook", bookId);
	}

	@Override
	public int selectRentalListByUserIdCount(SqlSession session, String userId) {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+"selectRentalListByUserIdCount", userId);
	}
	
	@Override
	public List<RentalList> selectRentalListPagingByUserIdToBook(SqlSession session, String userId, int startIndex, int endIndex) {
		// TODO Auto-generated method stub
		Map<String, String> input = new HashMap<String, String>();
		input.put("userId", userId);
		input.put("startIndex",String.valueOf(startIndex));
		input.put("endIndex",String.valueOf(endIndex));
		return session.selectList(namespace + "selectRentalListPagingByUserIdToBook", input);
	}

	@Override
	public List<Object> selectRentalListPagingByEndIsNull(SqlSession session, int startIndex, int endIndex) {
		// TODO Auto-generated method stub
		Map<String, String> input = new HashMap<String, String>();
		input.put("startIndex",String.valueOf(startIndex));
		input.put("endIndex",String.valueOf(endIndex));
		return session.selectList(namespace + "selectRentalListPagingByEndIsNull", input);
	}

	@Override
	public int selectRentalListByEndIsNullCount(SqlSession session) {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+"selectRentalListByEndIsNullCount");
	}

}