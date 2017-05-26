<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/LibraryManage/css/bookmanage_style.css">
</head>
<%@include file = "/forAdmin/admin_menu.jsp" %>
<body>
<header>
	<h1>도서정보관리</h1>
</header>
<aside>
	<ul>
    <li><a href="add_book.jsp">도서등록</a></li>
    <li><a href="update_book.jsp">도서수정</a></li>
    <li><a href="delete_book.jsp">도서삭제</a></li>
  </ul>
</aside> 
<article>
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
</article>

<footer>Copyright &copy LibraryManage.co.kr</footer>

</body>
</html>