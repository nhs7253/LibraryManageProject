<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/LibraryManage/css/testStyle.css">

</head>
<%@include file = "/forAdmin/admin_menu.jsp" %>
<body>
<header>
	<h1>도서정보관리</h1>
</header>
<nav>
	<ul>
    <li><a href="add_book.jsp">도서등록</a></li>
    <li><a href="update_book.jsp">도서수정</a></li>
    <li><a href="delete_book.jsp">도서삭제</a></li>
  </ul>
</nav>

<article>
	<h2>도서관리페이지 입니다.</h2>
</article>

<footer>Copyright &copy LibraryManage.co.kr</footer>

</body>
</html>