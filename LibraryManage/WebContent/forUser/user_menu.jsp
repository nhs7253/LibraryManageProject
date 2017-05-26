<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<<<<<<< HEAD
<link rel="stylesheet" type="text/css" href="/LibraryManage/css/menu_style.css">
=======

<style type="text/css">
 
 div{
 	float: right;
 }
 
a:link{
	/*방문하지 않은 링크 설정.*/
	text-decoration:none; /*밑줄 안나오도록 처리.*/
	color:blue;
}
a:visited{
	/*방문한 링크 설정*/
	text-decoration: none;
	color:blue;
}
a:hover{
	/*마우스 포인터가 올라간 시점의 설정.*/
	text-decoration: none;
	color:red;
}
a:active{
	/*마우스를 링크에 클릭하는 시점*/       
	color:green;
}
 
</style>
>>>>>>> branch 'master' of https://github.com/nhs7253/LibraryManageProject.git

<c:if test="${empty sessionScope.loginInfo}">
	<c:set scope="session" var="returnURL" value='<%=  request.getAttribute( "javax.servlet.forward.request_uri" )+"?page="+request.getParameter("page")+"&select="+request.getAttribute("select")+"&keyword="+request.getAttribute("keyword")%>'/>
</c:if>


	<c:choose>
		<c:when test = "${empty sessionScope.loginInfo}">
			<div>
			<a href = "/LibraryManage/forUser/login.jsp">로그인</a>
			<a href = "/LibraryManage/forUser/userCreate.jsp">회원가입</a>
			</div>
		</c:when>
		<c:otherwise>
			${sessionScope.loginInfo.userId }님 환영합니다.
			<div>
			<a href = "/LibraryManage/logout">로그아웃</a>
			<a href = "/LibraryManage/forUser/MyPage.jsp">마이페이지</a>
			<a href = "/LibraryManage/RentalList">대출목록</a>
			<a href = "/LibraryManage/BookSearchByKeyword?select=title">도서검색</a>
			</div>		
		
		</c:otherwise>
	</c:choose>

 <br> <hr>

