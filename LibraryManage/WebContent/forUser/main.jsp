<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
 
h2{
	text-align:center;
}

form {
	margin: auto;
	vertical-align: middle; 
}
 
</style>

</head>
<%@include file = "/forUser/user_menu.jsp" %>
	<body>
 		<c:if test="${sessionScope.successMessage != null}">
   <script>alert('${sessionScope.successMessage}')</script>
   <c:remove scope="session" var="successMessage"/>
   </c:if>
		<h2>도서검색</h2>

		<h2>메인 </h2>

		<form action="${initParam.rootPath }/BookSearchByKeyword" method="post">
		<select name="select">
			<option value="title">제목</option>
			<option value="author">저자</option>
			<option value="publisher">출판사</option>
		</select>
			<input type="text" name="keyword"/>
			<input type="submit" value="검색"/>
		</form> 

		<br/>
	</body>
</html>