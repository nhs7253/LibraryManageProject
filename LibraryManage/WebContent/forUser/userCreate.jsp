<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/LibraryManage/userCreate" method="post">

ID : <input type ="text" name="userId">	<br>
PW : <input type="password" name="password"> <br>
이름 : <input type="text" name="userName"> <br>
폰 넘버 : <input type="text" name="phoneNum"> <br>
이메일 :	<input type="text" name="email"> <br>

<input type="submit" value="가입"> 


</form>
</body>
</html>