<%@ page contentType="text/html;charset=UTF-8"%>

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
.center {
    margin: auto;
    width: 60%;
    top:400px;
    position:absoulte;

}
  
</style>
</head>
<%@include file = "/forUser/user_menu.jsp" %>
   <body>
   <c:if test="${sessionScope.waitMessage != null}">
   <script>alert('${sessionScope.waitMessage}')</script>
   <c:remove scope="session" var="waitMessage"/>
</c:if>
   
   <div class="center" style="position: relative; top: 50px;">
   <img src="/LibraryManage/img/main.jpg" width="290px" height="100px">
      <form action="${initParam.rootPath }/BookSearchByKeyword" method="post">
      <select name="select">
         <option value="title">제목</option>
         <option value="author">저자</option>
         <option value="publisher">출판사</option>
      </select>
         <input type="text" name="keyword"/>
         <input type="submit" value="검색"/>
      </form> 

      <br>
      </div>
   </body>
</html>