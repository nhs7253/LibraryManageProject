<%@page import="kr.co.library.vo.UserManagement"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%UserManagement user = (UserManagement)request.getAttribute("result"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원가입</h1>
<%=request.getAttribute("message") %>
<form action = "/LibraryManage/userCreate" method = "post">

	userId : <input type = "text" name = "userId"><br>
	password : <input type = "password" name = "password"><br>
	userName : <input type = "text" name = "userName"><br>
	phonNum : <input type = "text" name = "phoneNum">
			  <!-- -<input type ="text" name = "phoneNum">
			  -<input type ="text" name = "phoneNum"><br> -->
	email : <input type = "text" name = "email"><br>
	<input type = "submit" value = "회원가입"><br>
</form>
<a href="/LibraryManage/userInfoRefer">정보조회 테스트</a>


</body>
</html>