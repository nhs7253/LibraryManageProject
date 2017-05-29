<%@page import="kr.co.library.vo.UserManagement"%>
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
	margin-left: auto;
	margin-right: auto;

}

table, th, td {
	border: 0.5px ridge;
	text-align: center;
	padding: 10px;
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
<title>회원정보수정</title>
<link rel="stylesheet" type="text/css" href="./css/view_table.css">
</head>


<body>

	<h1 class="center">INFO</h1>
	<hr>
	<form action="${initParam.rootPath }/UserUpDate" method="post">
		<br>
		<h3 class="center">회원기본정보</h3>
		<div align="center">
			<table>
				<tr>
					<td>ID</td>
					<td><input type="text" name="userId"
						value="${sessionScope.loginInfo.userId}" readOnly></td>
				</tr>
				<tr>
					<td>PW</td>
					<td><input type="password" name="password"
						value="${sessionScope.loginInfo.password}"></td>
				</tr>
				<tr>
					<td>Name</td>
					<td><input type="text" name="userName"
						value="${sessionScope.loginInfo.userName}"></td>
				</tr>
				<tr>
					<td>PhoneNum</td>
					<td><input type="text" name="phoneNum"
						value="${sessionScope.loginInfo.phoneNum}"></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="text" name="email"
						value="${sessionScope.loginInfo.email}"></td>
				</tr>
			</table>
			<br> <br>
			<%
				if (request.getAttribute("errorMessage") != null) {
			%>
			<span style="color: red;"><%=request.getAttribute("errorMessage")%></span>
			<%}%><br> <input type="submit" value="수정완료" onclick="alert(수정이 완료되었습니다.);">
		</div>
	</form><br><br><br><br>
	
	<footer>Copyright &copy LibraryManage.co.kr </footer>
	
</body>
</html>