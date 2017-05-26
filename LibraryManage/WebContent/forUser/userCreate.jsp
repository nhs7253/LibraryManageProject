<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<style>
h1 {text-align: center;} 
#c{text-align: center;}
<!-- c가운데로 정렬 -->
</style>
<link rel="stylesheet" type="text/css" href="./css/view_table.css">
</head>
<br>
<br>
<br>
<br>
<h1>회원 가입</h1>
<body>
<form id="c" action="/LibraryManage/userCreate" method="post">
<input type ="text" name="userId" placeholder="아이디"><br>
<input type="password" name="password" placeholder="비밀번호"><br>
<input type="text" name="userName" placeholder="이름"><br>
<input type="text" name="phoneNum" placeholder="휴대 전화 번호"><br>
<input type="text" name="email" placeholder="이메일"><br>
<p>
<script type="text/javascript">
      function alerttest(){
            alert("회원가입을 축하합니다. 메인화면으로 갑니다");
      }
 </script>
 <input type="submit" value="가입하기" onclick="alerttest();"> <br>
</form>
</body>
</html>