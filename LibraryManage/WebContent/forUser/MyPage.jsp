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

<table border='1' width="500px" >
	<thead>
		<tr>
			<td>회원ID</td>
			<td>비밀번호</td>
			<td>이름</td>
			<td>전화번호</td>
			<td>이메일</td>
			<td>연체상태</td>
		
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
			</tr>
	</tbody>
</table>
<a href = /LibraryManage/forUser/userUpdate.jsp>수정</a>

<!-- 회원 탈퇴 버튼 -> Y/N 확인 알람 -->
<script type="text/javascript">
function button_event(){
	if(confirm("회원을 탈퇴하시 겠습니까?")){//확인
		location.href="/LibraryManage/DeleteUser";
	}
}
</script>
<input type="button" value="삭제하기" onclick="button_event();">

<a href = "${initParam.rootPath }/RentalList">나의 대출목록</a>
<a href ="${initParam.rootPath }/WaitList">나의 대기목록</a>




</body>
</html>