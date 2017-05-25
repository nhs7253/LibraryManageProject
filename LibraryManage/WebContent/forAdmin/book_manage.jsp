<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%@include file = "/forAdmin/admin_menu.jsp" %>
<body>

<h1>책등록</h1>
<form action="/LibraryManage/addBook" method = "post">
	책id: <input type = "text" name = "bookId"><br>
	제목 : <input type = "text" name = "title"><br>
	저자 : <input type = "text" name = "author"><br>
	출판사 : <input type = "text" name = "publisher"><br>
	출판일 : <input type = "text" name = "publishDate"><br>
	<input type="submit" value="등록" onclick="alert('${sessionScope.addBookMessage}');">
</form>

<h1>책수정</h1>
<form action="/LibraryManage/updateBook" method = "post">
	책id : <input type = "text" name = "bookId"><br><hr>
	제목 : <input type = "text" name = "title"><br>
	저자 : <input type = "text" name = "author"><br>
	출판사 : <input type = "text" name = "publisher"><br>
	출판일 : <input type = "text" name = "publishDate"><br>
	대출가능상태 : <input type ="text"  name = "rentalState"><br>
	<input type="submit" value="수정" onclick="alert('${sessionScope.updateBookMessage}');">
</form>

<h1>책삭제</h1>
<form action="/LibraryManage/deleteBook" method = "post">
	책ID: <input type = "text" name = "bookId"><br>
	<input type="submit" value="삭제" onclick="alert('${sessionScope.deleteBookMessage}');">
</form>


</body>
</html>