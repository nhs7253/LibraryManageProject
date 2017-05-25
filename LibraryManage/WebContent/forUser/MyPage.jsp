<%@page import="java.util.ArrayList"%>
<%@page import="kr.co.library.vo.UserManagement"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%

UserManagement user = new UserManagement();



session.setAttribute("userList", user);


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%@include file = "/forUser/user_menu.jsp" %>

<body>

<h2>마이페이지</h2>
<a href="${initParam.rootPath}/userUpdate">회원정보 수정</a>
<a href = "${initParam.rootPath}/RentalList">나의 대출목록</a>
<a href ="${initParam.rootPath}/WaitList">나의 대기목록</a>

</body>
</html>