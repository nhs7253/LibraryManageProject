<%@page import="java.util.ArrayList"%>
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


<h2>마이페이지</h2>

<table>
	<thead>
		<tr>
			<td>회원ID : <%=((UserManagement)session.getAttribute("loginInfo")).getUserId() %></td>
			<td>비밀번호 : <%=((UserManagement)session.getAttribute("loginInfo")).getPassword() %></td>
			<td>이름 : <%=((UserManagement)session.getAttribute("loginInfo")).getUserName() %></td>
			<td>전화번호 : <%=((UserManagement)session.getAttribute("loginInfo")).getPhoneNum() %></td>
			<td>이메일 : <%=((UserManagement)session.getAttribute("loginInfo")).getEmail() %></td>
			<td>연체상태 : <%=((UserManagement)session.getAttribute("loginInfo")).getPenaltyState() %></td>
			<td></td>
			<td></td>
		</tr>
	</thead>
	<tbody>
		
		<%-- ######################################################
														조회된 item 출력 
			###################################################### --%>
		
		<c:forEach items="${sessionScope.userInfo }" var="user" varStatus="Status">
			<tr>
				<td>${user.userId}</td>
				<td>${user.password}</td>
				<td>${user.userName}</td>
				<td>${user.phoneNum}</td>
				<td>${user.email}</td>
				<td>${user.penaltyState}</td>
				<td><a href = "${initParam.rootPath }/UserUpDate"/>수정</td>
				<td><a href = "${initParam.rootPath }/DeleteUser"/>탈퇴</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<a href = "">회원탈퇴</a>
<a href = "${initParam.rootPath }/RentalList">나의 대출목록</a>
<a href ="${initParam.rootPath }/WaitList">나의 대기목록</a>




</body>
</html>