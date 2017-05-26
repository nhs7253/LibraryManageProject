<%@page import="java.util.ArrayList"%>
<%@page import="kr.co.library.vo.UserManagement"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
h2 {text-align: center;} 
#c{text-align: center;}

<!-- c가운데로 정렬 -->
</style>
<link rel="stylesheet" type="text/css" href="./css/view_table.css">
</head>
<%@include file = "/forUser/user_menu.jsp" %>

<body >


<h2>회원 정보</h2>

<table id="c" border='1' width="500px" align="center" >
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
   <tbody id="c">
      
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


</body>
</html>