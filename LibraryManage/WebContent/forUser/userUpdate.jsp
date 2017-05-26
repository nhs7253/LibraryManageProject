<%@page import="kr.co.library.vo.UserManagement"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<style type="text/css" >





</style>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./css/view_table.css">
</head>
<%@include file = "/forUser/user_menu.jsp" %>

<body>
<h2>회원정보수정 page</h2>
<hr>

<form action="${initParam.rootPath }/UserUpDate" method="post">

ID :  <input type ="text" name="userId" value="${sessionScope.loginInfo.userId}" readOnly >	<br>
PW : <input type="password" name="password" value="${sessionScope.loginInfo.password}"> <br>
Name : <input type="text" name="name" value="${sessionScope.loginInfo.userName}"> <br>
PhoneNum : <input type="text" name="phoneNum" value="${sessionScope.loginInfo.phoneNum}"> <br>
Email : 	<input type="text" name="email" value="${sessionScope.loginInfo.email}"> <br>
	<input type="submit" value="수정완료" onclick="alert(수정이 완료되었습니다.);">
</form>

</body>
</html>