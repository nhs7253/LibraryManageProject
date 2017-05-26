<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<%@ page contentType="text/html;charset=UTF-8"%>
<link rel="stylesheet" type="text/css" href="/LibraryManage/css/admin_menu_style.css">

<c:if test="${empty sessionScope.adminInfo}">
   <% response.sendRedirect("/LibraryManage/forUser/main.jsp"); %>
</c:if>
   <nav>
      <ul>
         <li><a class="menuLink" href="/LibraryManage/forAdmin/add_book.jsp">책정보관리</a></li>
         <li><a class="menuLink" href="/LibraryManage/BookSearchByKeyword?select=title">도서대출</a></li>
         <li><a class="menuLink" href="/LibraryManage/RentalListAdmin">도서반납</a></li>
         <li><a class="menuLink" href="/LibraryManage/allUser">전체회원목록</a></li>
         <li><a class="menuLink" href="/LibraryManage/WaitListAdmin">도서예약현황</a></li>
         <li><a class="menuLink" href="/LibraryManage/logout">로그아웃</a></li>
      </ul>
   </nav>