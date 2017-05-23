<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>책등록</h1>
<form action="LibraryManage/kr/co/library/controller/addBook" method = "post">
	책id: <input type = "text" name = "bookId"><br>
	제목 : <input type = "text" name = "title"><br>
	저자 : <input type = "text" name = "author"><br>
	출판사 : <input type = "text" name = "publisher"><br>
	출판일 : <input type = "text" name = "publishDate"><br>
	<input type="submit" value="등록">
</form>

<h1>책수정</h1>
<form action="LibraryManage/kr/co/library/controller/updateBook" method = "post">
	책id: <input type = "text" name = "bookId"><br>
	제목 : <input type = "text" name = "title"><br>
	저자 : <input type = "text" name = "author"><br>
	출판사 : <input type = "text" name = "publisher"><br>
	출판일 : <input type = "text" name = "publishDate"><br>
	<input type="submit" value="수정">
</form>

<h1>책삭제</h1>
<form action="LibraryManage/kr/co/library/controller/deleteBook" method = "post">
	책ID: <input type = "text" name = "bookId"><br>
	<input type="submit" value="삭제">
</form>

</body>
</html>