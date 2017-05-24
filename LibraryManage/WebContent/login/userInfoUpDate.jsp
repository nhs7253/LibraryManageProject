<%@page import="kr.co.library.vo.UserManagement"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>정보</title>
</head>
<body>
<form action="/LibraryManage/UserUpDate" method="post"><br>
회원 ID : <%=((UserManagement)session.getAttribute("loginInfo")).getUserId() %><br>
회원 password : <input type="password" name="password"><br>
회원 이름 : <input type="text" name="name"><br>
핸드폰 번호 : <input type="text" name="phoneNum"><br>
이메일 : <input type="text" name="eamil"><br>
패털티 확인 : <%=((UserManagement)session.getAttribute("loginInfo")).getPenaltyState() %><br>
<p>
 <button type="submit">정보 수정</button>
 <button type="reset">다시 작성</button>
</form>

</body>
</html>