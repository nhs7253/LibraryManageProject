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
	<h1>책삭제</h1>
	<form action="/LibraryManage/deleteBook" method = "post">
	책ID: <input type = "text" name = "bookId"><br><br>
	<input type="submit" value="삭제" onclick="alert('${sessionScope.deleteBookMessage}');">
	</form>
</article>

<footer>Copyright &copy LibraryManage.co.kr</footer>

</body>
</html>