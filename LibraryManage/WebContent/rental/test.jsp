<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
	<c:when test='${message==null}'>
		null이에요
	</c:when>
	<c:otherwise>
		${message } 
	</c:otherwise>
	</c:choose>
</body>
</html>