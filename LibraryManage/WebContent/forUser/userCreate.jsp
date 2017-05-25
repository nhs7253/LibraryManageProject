<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="userCreate" method="post">

ID : <input type ="text" name="userId">	<br>
PW : <input type="password" name="password"> <br>
이름 : <input type="text" name="name"> <br>
폰 넘버 : <input type="text" name="phoneNum"> <br>
이메일 :	<input type="text" name="email"> <br>

<input type="submit" value="가입"> <br>

<a href="/LibraryManage/userInfoRefer">정보조회 테스트</a>
</form>
</body>
</html>