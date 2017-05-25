<%@page import="java.util.ArrayList"%>
<%@page import="kr.co.library.vo.UserManagement"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%@include file = "/forUser/user_menu.jsp" %>

<body>



<h3>현재 개인정보 확인</h3>


ID : ${sessionScope.loginInfo.userId}<br>
PW : ${sessionScope.loginInfo.userPassword }<br>
NAME : ${sessionScope.loginInfo.userName }<br>
PhoneNum : ${sessionScope.loginInfo.phoneNum }<br>
Email : ${sessionScope.loginInfo.email}<br>

	 

<a href="${initParam.rootPath}/forUser/userUpdate.jsp">회원정보 수정</a>
<a href = "${initParam.rootPath}/RentalList">나의 대출목록</a>
<a href ="${initParam.rootPath}/WaitList">나의 대기목록</a>

</body>
</html>