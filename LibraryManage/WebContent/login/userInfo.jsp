<%@page import="kr.co.library.vo.UserManagement"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보</title>
</head>
<body>
<h1><%=((UserManagement)session.getAttribute("loginInfo")).getUserName() %>님의 정보입니다.</h1>
회원 ID : <%=((UserManagement)session.getAttribute("loginInfo")).getUserId() %><br>
회원 password : <%=((UserManagement)session.getAttribute("loginInfo")).getPassword() %><br>
회원 이름 : <%=((UserManagement)session.getAttribute("loginInfo")).getUserName() %><br>
핸드폰 번호 : <%=((UserManagement)session.getAttribute("loginInfo")).getPhoneNum() %><br>
이메일 : <%=((UserManagement)session.getAttribute("loginInfo")).getEmail() %><br>
패털티 확인 : <%=((UserManagement)session.getAttribute("loginInfo")).getPenaltyState() %><br>


<form action="/LibraryManage/logout" method="get">
<button type="submit">로그아웃</button>
<p>
<a href="/LibraryManage/login/login_main.jsp">메인페이지</a>
<a href="/LibraryManage/login/userInfoUpDate.jsp">정보 수정</a>
<a href="/LibraryManage/login/DeleteUser.jsp">회원 탈퇴</a>
</p>
</form>

</body>
</html>