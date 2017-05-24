<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>책등록</h1>
<form action="/LibraryManage/addBook" method = "post">
	책id: <input type = "text" name = "bookId"><br>
	제목 : <input type = "text" name = "title"><br>
	저자 : <input type = "text" name = "author"><br>
	출판사 : <input type = "text" name = "publisher"><br>
	출판일 : <input type = "text" name = "publishDate"><br>
	<input type="submit" value="등록">
</form>

<h1>책수정</h1>
<form action="/LibraryManage/updateBook" method = "post">
	책id: <input type = "text" name = "bookId"><br>
	제목 : <input type = "text" name = "title"><br>
	저자 : <input type = "text" name = "author"><br>
	출판사 : <input type = "text" name = "publisher"><br>
	출판일 : <input type = "text" name = "publishDate"><br>
	<input type="submit" value="수정">
</form>

<h1>책삭제</h1>
<form action="/LibraryManage/deleteBook" method = "post">
	책ID: <input type = "text" name = "bookId"><br>
	<input type="submit" value="삭제">
</form>

<h1>회원가입</h1>
<form action = "/LibraryManage/userCreate" method = "post">
	userId : <input type = "text" name = "userId"><br>
	password : <input type = "password" name = "password"><br>
	userName : <input type = "text" name = "userName"><br>
	phonNum : <input type = "text" name = "phoneNum"><br>
	email : <input type = "text" name = "email"><br>
	<input type = "submit" value = "회원가입">
</form>

<h1>대기</h1>
<form action = "/LibraryManage/waitListInsert" method = "post">
	userId : <input type = "text" name = "userId"><br>
	책id : <input type = "text" name = "bookId"><br>
	<input type = "submit" value = "대기">
</form>

<h1>대출</h1>
<form action = "/LibraryManage/rentBook" method = "post">
	userId : <input type = "text" name = "userId"><br>
	책id : <input type = "text" name = "bookId"><br>
	<input type = "submit" value = "대출">
</form>

<h1>반납</h1>
<form action = "/LibraryManage/returnBook" method = "post">
	userId : <input type = "text" name = "userId"><br>
	rentalNo : <input type = "number" name = "rentalNo"><br>
	<input type="submit" value = "반납">
</form>

</body>
</html>