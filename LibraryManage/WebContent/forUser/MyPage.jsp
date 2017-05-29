<%@page import="java.util.ArrayList"%>
<%@page import="kr.co.library.vo.UserManagement"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<style>

#c{text-align: center;}
.center {
	text-align: center;
}

table {
	border-collapse: collapse;
	margin-left: auto;
	margin-right: auto;

}

table, th, td {
	border: 0.5px ridge;
	text-align: center;
	padding: 10px;
}
footer {
    padding: 1em;
    color: black;
    background-color: white;
    clear: left;
    text-align: center;
}
</style>

<link rel="stylesheet" type="text/css" href="./css/view_table.css">
</head>
<%@include file = "/forUser/user_menu.jsp" %>

<body>
<h1 class="center">회원정보</h1><hr><br><br><br><br>


<table id="c" border='1' width="500px" align="center" >
   <thead>
      <tr>
         <td>회원ID</td>
         <td><%=((UserManagement)session.getAttribute("loginInfo")).getUserId() %></td>
      </tr>
      <tr>
         <td>비밀번호</td>
         <td><%=((UserManagement)session.getAttribute("loginInfo")).getPassword() %></td>
      </tr>
      <tr>
         <td>이름</td>
         <td><%=((UserManagement)session.getAttribute("loginInfo")).getUserName() %></td>
      </tr>
      <tr>
         <td>전화번호</td>
         <td><%=((UserManagement)session.getAttribute("loginInfo")).getPhoneNum() %></td>
      </tr>
      <tr>
         <td>이메일</td>  
         <td><%=((UserManagement)session.getAttribute("loginInfo")).getEmail() %></td>
      </tr>
      <tr>
         <td>연체상태</td>
     	 <td><%=((UserManagement)session.getAttribute("loginInfo")).getPenaltyState() %></td>
      </tr>
   </thead>
</table><br>

<p id="c">
<input id="c" type="button" value="수정" onClick="location.href='/LibraryManage/forUser/userUpdate.jsp';">
<input id="c" type="button" value="나의 대출목록" onClick="location.href='${initParam.rootPath }/RentalList';">
<input id="c" type="button" value="나의 대기목록" onClick="location.href='${initParam.rootPath }/WaitList';">
<!-- 회원 탈퇴 버튼 -> Y/N 확인 알람 -->
<script type="text/javascript">
function button_event(){
   if(confirm("회원을 탈퇴하시 겠습니까?")){//확인
      location.href="/LibraryManage/DeleteUser";}
}
</script>
<input id="c" type="button" value="회원탈퇴" onclick="button_event();">
</p><br><br><br>

<footer>Copyright &copy LibraryManage.co.kr</footer>
</body>
</html>