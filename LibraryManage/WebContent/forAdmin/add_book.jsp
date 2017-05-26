<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/LibraryManage/css/bookmanage_style.css">
<link rel="stylesheet" type="text/css" href="/LibraryManage/css/table_clean.css">
</head>
<%@include file = "/forAdmin/admin_menu.jsp" %>
<body>
<header>
	<h1>도서정보관리</h1>
</header>
<aside>
	<ul>
    <li><a class="bookmenu" href="add_book.jsp">도서등록</a></li>
    <li><a class="bookmenu" href="update_book.jsp">도서수정</a></li>
    <li><a class="bookmenu" href="delete_book.jsp">도서삭제</a></li>
  </ul>
</aside>
<article>
	<form action="/LibraryManage/addBook" method = "post">
      <br>
      <h2 class="center">도서등록</h2>
      <div align="center">
         <table>
            <tr>
               <td>책ID</td>
               <td><input type = "text" name = "bookId"></td>
            </tr>
            <tr>
               <td>제목</td>
               <td><input type = "text" name = "title"></td>
            </tr>
            <tr>
               <td>저자</td>
               <td><input type = "text" name = "author"></td>
            </tr>
            <tr>
               <td>출판사</td>
               <td><input type = "text" name = "publisher"></td>
            </tr>
            <tr>
               <td>출판일</td>
               <td><input type = "text" name = "publishDate"></td>
            </tr>
            <tr>
            	<td>
				 <input type="submit" value="등록" onclick="alert('${sessionScope.addBookMessage}');">
				 </td>
            </tr>
         </table>
      </div>
   </form>
</article>

<footer>Copyright &copy LibraryManage.co.kr</footer>

</body>
</html>