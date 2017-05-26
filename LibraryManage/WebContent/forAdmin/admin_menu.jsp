<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<%@ page contentType="text/html;charset=UTF-8"%>
<link rel="stylesheet" type="text/css" href="/LibraryManage/css/menu_style.css">
<c:if test="${empty sessionScope.adminInfo}">
	<% response.sendRedirect("/LibraryManage/forUser/main.jsp"); %>
</c:if>

${sessionScope.adminInfo.administratorId }관리자님 환영합니다.

<div>
	<a href = "/LibraryManage/forAdmin/add_book.jsp" >책정보관리</a>
	<a href = "/LibraryManage/BookSearchByKeyword?select=title" >도서대출</a>
	<a href = "/LibraryManage/RentalListAdmin" >도서반납</a>
	<a href = "/LibraryManage/allUser" >전체회원목록</a>
	<a href = "/LibraryManage/WaitListAdmin" >도서예약현황</a>
	<a href = "/LibraryManage/logout" >로그아웃</a>
</div>
<br />

<hr>