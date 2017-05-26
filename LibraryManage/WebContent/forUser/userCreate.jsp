<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.center {
	text-align: center;
}

table {
	border-collapse: collapse;
	margin: 20px;
}

table, th, td {
	border: 0.5px ridge;
	text-align: center;
	padding: 10px;
}
</style>
<meta charset="UTF-8">
<title>회원가입</title>

<link rel="stylesheet" type="text/css" href="./css/view_table.css">
</head>
<body>
   <c:if test="${sessionScope.failMessage != null}">
   <script>alert('${sessionScope.failMessage}')</script>
   <c:remove scope="session" var="failMessage"/>
   </c:if>
   
	<h1 class="center">JOIN US</h1>
	<hr>
	<form action="/LibraryManage/userCreate" method="post">
		<br>
		<h3 class="center">기본정보입력</h3>
		<div align="center">
			<table>
				<tr>
					<td>ID</td>
					<td><input type="text" name="userId"></td>
				</tr>
				<tr>
					<td>PW</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td>NAME</td>
					<td><input type="text" name="userName"></td>
				</tr>
				<tr>
					<td>PHONE NUM</td>
					<td><input type="text" name="phoneNum"></td>
				</tr>
				<tr>
					<td>EMAIL</td>
					<td><input type="text" name="email"></td>
				</tr>
			</table>

			<input type="submit" value="가입">
		</div>
	</form>
	
	<%-- <form action="${initParam.rootPath}/userCreate" method="post">
	<%if (request.getAttribute("loginInfo") == null || request.getAttribute("loginInfo").equals("")){%>
		<input type="button" value="가입" onclick="alert('회원가입정보를 입력해주세요.')">
	<%} %>
	</form> --%>
</body>
</html>