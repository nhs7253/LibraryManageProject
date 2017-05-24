<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원정보조회</h1>


	${requestScope.info.userId }
	${requestScope.info.userName }
	${requestScope.info.password }
</body>
</html>