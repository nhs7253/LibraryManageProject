<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<h1>로그인</h1>
<c:if test="${sessionScope.loginFailMessage != null}">
	<script>alert('${sessionScope.loginFailMessage}')</script>
	<c:remove scope="session" var="loginFailMessage"/>
</c:if>
<%if(request.getAttribute("errorMessage")!=null){%>
<span style ="color:red;"><%=request.getAttribute("errorMessage") %></span>
<%}%>
<form action="/LibraryManage/login" method="post">

 ID : <input type="text" name="id"><br>
 PW : <input type="password" name="password"><br>
 <p>
 <button type="submit">로그인</button>
</form>
</body>
</html>