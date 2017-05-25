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


<h2>마이페이지</h2>

<table>
	<thead>
		<tr>
			<td>회원ID</td>
			<td>비밀번호</td>
			<td>이름</td>
			<td>전화번호</td>
			<td>이메일</td>
			<td>연체상태</td>
			<td></td>
			<td></td>
		</tr>
	</thead>
	<tbody>
		
		<%-- ######################################################
														조회된 item 출력 
			###################################################### --%>
		
			<tr>
				<td><%=((UserManagement)session.getAttribute("loginInfo")).getUserId() %></td>
				<td><%=((UserManagement)session.getAttribute("loginInfo")).getPassword() %></td>
				<td><%=((UserManagement)session.getAttribute("loginInfo")).getUserName() %></td>
				<td><%=((UserManagement)session.getAttribute("loginInfo")).getPhoneNum() %></td>
				<td><%=((UserManagement)session.getAttribute("loginInfo")).getEmail() %></td>
				<td><%=((UserManagement)session.getAttribute("loginInfo")).getPenaltyState() %></td>
				<td><a href = "${initParam.rootPath }/UserUpDate"/>수정</td>
				<td><a href = "${initParam.rootPath }/DeleteUser"/>탈퇴</td>
			</tr>
	</tbody>
</table>
<a href = "">회원탈퇴</a>
<a href = "${initParam.rootPath }/RentalList">나의 대출목록</a>
<a href ="${initParam.rootPath }/WaitList">나의 대기목록</a>




</body>
</html>