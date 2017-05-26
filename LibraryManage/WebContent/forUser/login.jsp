<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<style>
.center{text-align : center;}
#c{text-align : center;}
#b{ margin-left: 40px;}
</style>
<p>
<!-- C스타일 적용 (가운데로) -->
<h1 class="center">로그인</h1>
<p id="c"><%if(request.getAttribute("errorMessage")!=null){%>
<span style ="color:red;"><%=request.getAttribute("errorMessage") %></span>
<%}%>
</p>

<form action="/LibraryManage/login" method="post">
<p id="c">
 ID : <input type="text" name="id"><br>
 PW : <input type="password" name="password"><br>

<br>
 <button type="submit">로그인</button>
 </form>


 <p id="b"><button type="submit">로그인</button></p>



<!--Exception 발생  -->
  <form action = "${initParam.rootPath }/forUser/userCreate.jsp" method = "post">


<input type="submit" value = "회원가입"/>
  </form> 


 
 




</body>
</html>