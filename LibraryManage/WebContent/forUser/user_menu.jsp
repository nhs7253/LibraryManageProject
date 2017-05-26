<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<link rel="stylesheet" type="text/css" href="/LibraryManage/css/menu_style.css">

<c:if test="${empty sessionScope.loginInfo}">
	<c:set scope="session" var="returnURL" value='<%=  request.getAttribute( "javax.servlet.forward.request_uri" )+"?page="+request.getParameter("page")+"&select="+request.getAttribute("select")+"&keyword="+request.getAttribute("keyword")%>'/>
</c:if>


<div>
	<c:choose>
		<c:when test = "${empty sessionScope.loginInfo}">
			<a href = "/LibraryManage/forUser/login.jsp">로그인</a>
			<a href = "/LibraryManage/forUser/userCreate.jsp">회원가입</a>
		</c:when>
		<c:otherwise>
			${sessionScope.loginInfo.userId}님 환영합니다.
			<a href = "/LibraryManage/logout">로그아웃</a>
			<a href = "/LibraryManage/forUser/MyPage.jsp">마이페이지</a>
			<a href = "/LibraryManage/RentalList">대출목록</a>
			<a href = "/LibraryManage/BookSearchByKeyword?select=title">도서검색</a>
		</c:otherwise>
	</c:choose>
</div>
<br /> <hr />


