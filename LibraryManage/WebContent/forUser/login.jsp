<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>

<style>
.center{text-align : center;}
#c{text-align : center;}
#b{ margin-left: 40px;}
</style>
<p>
<!-- C스타일 적용 (가운데로) -->
<h1 class="center">로그인</h1>
<p id="c"><%if(request.getAttribute("errorMessage")!=null){%>
=======

	<c:if test="${sessionScope.loginFailMessage != null}">
	<script>alert('${sessionScope.loginFailMessage}')</script>
	<c:remove scope="session" var="loginFaileMessage"/>
	</c:if>
	
<h1>로그인</h1>
<%if(request.getAttribute("errorMessage")!=null){%>
<span style ="color:red;"><%=request.getAttribute("errorMessage") %></span>
<%}%>
</p>

<form action="/LibraryManage/login" method="post">
<p id="c">
 ID : <input type="text" name="id"><br>
 PW : <input type="password" name="password"><br>
 </p>
 <p id="b"><button type="submit">로그인</button></p>
 </form>

<!--Exception 발생  -->
  <form action = "${initParam.rootPath }/forUser/userCreate.jsp" method = "post">
  <button type="submit">회원가입</button>
</form> 



</body>
</html>