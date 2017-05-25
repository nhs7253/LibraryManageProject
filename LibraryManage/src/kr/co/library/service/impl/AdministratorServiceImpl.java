package kr.co.library.service.impl;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.co.library.dao.AdministratorDao;
import kr.co.library.dao.impl.AdministratorDaoImpl;
import kr.co.library.exception.AdminNotFoundException;
import kr.co.library.exception.AdminOverlapException;
import kr.co.library.service.AdministratorService;
import kr.co.library.util.SqlSessionFactoryManager;
import kr.co.library.vo.Administrator;

public class AdministratorServiceImpl implements AdministratorService {
   private SqlSessionFactory factory;
   private AdministratorDao adminDao;

   private static AdministratorService instance;

   public static AdministratorService getInstance() throws IOException {
      if (instance == null) {
         instance = new AdministratorServiceImpl();
      }
      return instance;
   }

   private AdministratorServiceImpl() throws IOException {
      factory = SqlSessionFactoryManager.getInstance().getSqlSessionFactory();
      adminDao = AdministratorDaoImpl.getInstance();
   }

   @Override
   public void insertAdministrator(Administrator admin) throws AdminOverlapException {
      SqlSession session = null;

      try {
         session = factory.openSession();
         if (adminDao.selectAdministratorById(session, admin.getAdministratorId()) != null
               || admin.getAdministratorId().equals("")) {
            throw new AdminOverlapException(String.format("ID가 중복 또는 잘못된 값을 입력하였습니다.", admin.getAdministratorId()));
         }
         adminDao.insertAdministrator(session, admin);
         session.commit();
      } finally {
         session.close();
      }

   }

   @Override
   public void deleteAdministrator(String adminId) throws AdminNotFoundException {
      SqlSession session = null;

      try {
         session = factory.openSession();

         if (adminDao.selectAdministratorById(session, adminId) == null) {
            throw new AdminNotFoundException(String.format("ID %s 인 회원이 없습니다.", adminId));

         }
         adminDao.deleteAdministrator(session, adminId);
         session.commit();
      } finally {
         session.close();
      }
   }

   @Override
   public Administrator selectAdministratorById(String adminId) {
      SqlSession session = factory.openSession();

      try {
         return adminDao.selectAdministratorById(session, adminId);
      } finally {
         session.close();
      }
   }

   @Override
   public Administrator adminLoging(String adminId, String adminpassword) throws AdminNotFoundException {
      SqlSession session = factory.openSession();
      // 가져옴
      try {
         // 집어넣어서 조회
         Administrator admin = adminDao.selectAdministratorById(session, adminId);
         if (adminId.equals(admin.getAdministratorId()))// 아이디 비교
         {
            if (adminpassword.equals(admin.getAdministratorPw()))// 비밀번호 비교
            {
               return admin;// 비밀번호 아이디 일치 admin 리턴
            } else {
               throw new AdminNotFoundException("아이디나 비밀번호 오류 입니다");// 비밀번호 오류시
                                                // 오류메세지던짐
            }
         }
         session.commit();
      } finally {
         session.close();
      }
      return null;
   }

}