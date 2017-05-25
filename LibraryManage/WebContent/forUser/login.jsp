<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>

<h1>로그인</h1>
<%if(request.getAttribute("errorMessage")!=null){%>
<span style ="color:red;"><%=request.getAttribute("errorMessage") %></span>
<%}%>
<form action="/LibraryManage/login" method="post">

 ID : <input type="text" name="id"><br>
 PW : <input type="password" name="password"><br>
 <p>
 <button type="submit">로그인</button>
</form>

<!--Exception 발생  -->
  <form action = "${initParam.rootPath }/forUser/userCreate" method = "post">
	<input type="submit" value = "회원가입" />
</form> 


</body>
</html>