<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<%@ page contentType="text/html;charset=UTF-8"%>


<style type="text/css">
div {
	float: right;
}

a:link {
	/*방문하지 않은 링크 설정.*/
	text-decoration: none; /*밑줄 안나오도록 처리.*/
	color: green;
}

a:visited {
	/*방문한 링크 설정*/
	text-decoration: none;
	color: green;
}

a:hover {
	/*마우스 포인터가 올라간 시점의 설정.*/
	text-decoration: none;
	color: red;
}

a:active {
	/*마우스를 링크에 클릭하는 시점*/
	color: blue;
}
</style>
<c:if test="${empty sessionScope.adminInfo}">
	<% response.sendRedirect("/LibraryManage/forUser/main.jsp"); %>
</c:if>
<div>
	<a href = "/LibraryManage/forAdmin/book_manage.jsp" >책정보관리</a>
	<a href = "/LibraryManage/BookSearchByKeyword?select=title" >도서대출</a>
	<a href = "/LibraryManage/RentalListAdmin" >도서반납</a>
	<a href = "/LibraryManage/allUser" >전체회원목록</a>
	<a href = "/LibraryManage/WaitListAdmin" >도서예약현황</a>
</div>
<br />

<hr>