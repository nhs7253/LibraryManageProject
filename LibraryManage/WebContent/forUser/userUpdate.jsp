<%@page import="kr.co.library.vo.UserManagement"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./css/view_table.css">
</head>
<%@include file = "/forUser/user_menu.jsp" %>

<body>
<h2>회원정보수정 page</h2>
<hr>

<form action="${initParam.rootPath }/UserUpDateController" method="post">
ID : ${user.userId} <input type ="hidden" name="userId" value="${user.userId}">	<br>
PW : <input type="password" name="password" placeholder="숫자만 입력해주세요"> <br>
이름 : ${user.userName} <input type="hidden" name="name" value="${user.userName}" > <br>
폰 넘버 : ${user.phoneNum }<input type="text" name="phoneNum" value="${user.phoneNum}"> <br>
이메일 : ${user.email}	<input type="text" name="email" value="${user.email}"> <br>
	<input type="submit" value="수정완료" onclick="alert(수정이 완료되었습니다.);">
</form>

</body>
</html>