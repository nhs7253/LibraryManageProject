<%@ page contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Library</title>

<style>
 
form {
   margin: auto;
   vertical-align: middle; 
}

.center {
    margin-top: 100px;
    margin-bottom :100px;
    width: 60%;
    top:400px;
    position:middle;

}

footer {
	position : bottom;
    padding: 1em;
    color: black;
    background-color: white;
    clear: left;
    text-align: center;
}
  
</style>
</head>
<%@include file = "/forUser/user_menu.jsp" %>
<body>
   <c:if test="${sessionScope.waitMessage != null}">
   <script>alert('${sessionScope.waitMessage}')</script>
   <c:remove scope="session" var="waitMessage"/>
	</c:if>
   <header></header>
 <article>
   <div class="center">
   <img src="/LibraryManage/img/main.jpg" width="330px" height="200px">
      <form action="${initParam.rootPath}/BookSearchByKeyword" method="post">
      <select name="select">
         <option value="title">제목</option>
         <option value="author">저자</option>
         <option value="publisher">출판사</option>
      </select>
         <input type="text" name="keyword"/>
         <input type="submit" value="검색"/>
   </div></article>
   
   <!-- <footer>Copyright &copy LibraryManage.co.kr</footer> -->
   
   </body>
</html>