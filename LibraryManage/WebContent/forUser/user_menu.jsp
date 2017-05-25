<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<c:set scope="session" var="returnURL" value='<%=  request.getAttribute( "javax.servlet.forward.request_uri" )+"?page="+request.getParameter("page")+"&select="+request.getAttribute("select")+"&keyword="+request.getAttribute("keyword")%>'/>

<style type="text/css">
 
 div{
 	float: right;
 }
 
 a:link{
	/*방문하지 않은 링크 설정.*/
	text-decoration:none; /*밑줄 안나오도록 처리.*/
	color:green;
}
a:visited{
	/*방문한 링크 설정*/
	text-decoration: none;
	color:green;
}
a:hover{
	/*마우스 포인터가 올라간 시점의 설정.*/
	text-decoration: none;
	color:red;
}
a:active{
	/*마우스를 링크에 클릭하는 시점*/       
	color:blue;
}
 
</style>

<div>
	<c:choose>
		<c:when test = "${empty sessionScope.loginInfo}">
			<a href = "/LibraryManage/forUser/login.jsp">로그인</a>
			<a href = "/LibraryManage/forUser/userCreate.jsp">회원가입</a>
		</c:when>
		<c:otherwise>
			<a href = "/LibraryManage/logout">로그아웃</a>
			<a href = "/LibraryManage/forUser/MyPage.jsp">마이페이지</a>
			<a href = "/LibraryManage/RentalList">대출목록</a>
			<a href = "/LibraryManage/forUser/main.jsp">도서검색</a>
			
		</c:otherwise>
	</c:choose>
</div>
<br /> <hr />


