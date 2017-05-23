package kr.co.library.util;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryManager {

	private static SqlSessionFactoryManager instance;
	private SqlSessionFactory factory;
	
	private SqlSessionFactoryManager() throws IOException{

		factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("kr/co/library/dao/config/mybatis-config.xml"));
	}
	
	public static SqlSessionFactoryManager getInstance() throws IOException{
		if(instance == null){
			instance = new SqlSessionFactoryManager();
		}
		return instance;
	}
	
	public SqlSessionFactory getSqlSessionFactory(){
		return factory;
	}

}
