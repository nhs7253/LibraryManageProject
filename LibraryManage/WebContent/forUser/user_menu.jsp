<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 

<c:choose>
	<c:when test = "${empty sessionScope.loginInfo}">
		<a href = "/LibraryManage/forUser/login.jsp">로그인</a>
		<a href = "/LibraryManage/forUser/userCreate.jsp">회원가입</a>
	</c:when>
	<c:otherwise>
		<a href = "/LibraryManage/logout">로그아웃</a>
		<a href = "/LibraryManage/forUser/MyPage.jsp">마이페이지</a>
		<a href = "/LibraryManage/forUser/rental_list.jsp">대출목록</a>
	</c:otherwise>
</c:choose>


<hr>