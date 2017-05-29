<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,inital-scale=1.0"/>
<title>관리자 메인페이지</title>

</head>
<body>
<%@include file="/forAdmin/admin_menu.jsp"%>

<p class="adminWelcome">
${sessionScope.adminInfo.administratorId }관리자님 환영합니다.
</p>
   <img src="/LibraryManage/img/admin2.png" width="400px" height="400px" align="middle">
</body>
</html>