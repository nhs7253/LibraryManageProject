<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
header{
    padding: 1em;
    color: white;
    background-color: grey;
    clear: left;
    text-align: center;
}

footer {
    padding: 1em;
    color: black;
    background-color: white;
    clear: left;
    text-align: center;
}

aside {
    float: left;
    max-width: 160px;
    margin: 0;
    padding: 1em; 
}
article {
    margin-left: 170px;
    border-left: 1px solid gray;
    padding: 2em;
    overflow: hidden;
}

aside ul li{
	list-style-type: none;
    padding: 0;
   
}

 aside ul a{
 text-decoration: none;
 font-weight:bold;
 }
 
 a:link{
	/*방문하지 않은 링크 설정.*/
	text-decoration:none; /*밑줄 안나오도록 처리.*/
	color:black;
}
a:visited{
	/*방문한 링크 설정*/
	text-decoration: none;
	color:black;
}
a:hover{
	/*마우스 포인터가 올라간 시점의 설정.*/
	text-decoration: none;
	color:red;
}
a:active{
	/*마우스를 링크에 클릭하는 시점*/       
	color:grey;
}
</style>
<meta charset="UTF-8">
<title>도서삭제</title>
<link rel="stylesheet" type="text/css" href="/LibraryManage/css/bookmanage_style.css">
<link rel="stylesheet" type="text/css" href="/LibraryManage/css/table_clean.css">
</head>
<%@include file = "/forAdmin/admin_menu.jsp" %>
<body>
<c:if test="${sessionScope.deleteBookMessage != null}">
	<script>alert('${sessionScope.deleteBookMessage}')</script>
	<c:remove scope="session" var="deleteBookMessage"/>
	</c:if>
<header>
	<h1>도서정보관리</h1>
</header>
<aside>
	<ul>
    <li><a href="add_book.jsp"><h3>도서등록</h3></a></li>
    <li><a href="update_book.jsp"><h3>도서수정</h3></a></li>
    <li><a href="delete_book.jsp"><h2>도서삭제</h2></a></li>
  </ul>
</aside> 
<article>
	<form action="/LibraryManage/deleteBook" method = "post">
	<br>
      <h2 class="center">도서삭제</h2>
      <div align="center">
         <table>
            <tr>
               <td>책ID</td>
               <td><input type = "text" name = "bookId"></td>
            </tr>
			<tr>
				<td></td>
				<td><input type="submit" value="삭제">
				</td>
			</tr>
		</table>
	</div>
	</form>
</article>

<footer>Copyright &copy LibraryManage.co.kr</footer>

</body>
</html>