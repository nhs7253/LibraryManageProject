<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style>
h1 {
	text-align: center;
}

#c {
	text-align: center;
}
footer {
    padding: 1em;
    color: black;
    background-color: white;
    clear: left;
    text-align: center;
}
</style>
<meta charset="UTF-8">

<title>로그인</title>
</head>
<body>
	<c:if test="${sessionScope.loginFailMessage != null}">
		<script>
			alert('${sessionScope.loginFailMessage}')
		</script>
		<c:remove scope="session" var="loginFailMessage" />
	</c:if>
		<h1 class="center">LOGIN</h1>
	<hr>
	<br>
	<br>
	<br>
	<br>


	<form id="c" action="/LibraryManage/login" method="post">

		<input type="text" name="id" placeholder="아이디"><br> <input
			type="password" name="password" placeholder="비밀번호"><br>
		<%
			if (request.getAttribute("errorMessage") != null) {
		%>
		<span style="color: red;"><%=request.getAttribute("errorMessage")%></span>
		<%
			}
		%>
		<p>
			<button id="c" type="submit">로그인</button>
			<input id="c" type="button" value="회원가입"
				onClick="location.href='/LibraryManage/forUser/userCreate.jsp';">
	</form>	<br><br><br><br><br><br><br><br>

<footer>Copyright &copy LibraryManage.co.kr</footer>
</body>
</html>