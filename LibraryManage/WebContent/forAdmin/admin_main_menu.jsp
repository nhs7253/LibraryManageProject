<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,inital-scale=1.0"/>
<title>Insert title here</title>
<style>
   nav {
       height: 30px;
       width: 1000px;
       margin: 0 auto;
   }
   
   nav ul li {
      list-style: none;
      color: white;
      background-color: #464646;
      line-height: 30px;
      float: left;
      vertical-align: middle;
      text-align: center;
   }
   
   nav .menuLink {
      text-decoration:none;
      color: white;
      display: block;
      width: 150px;
      font-size: 12px;
      font-weight: bold;
      font-family: "Trebuchet MS", Dotum, Arial;
   }
   
   nav .menuLink:hover {
      color : red;
      background-color: #4d4d4d;
   }
   img{
   	display: block;
   	margin-left: auto;
   	margin-right: auto;
   	position:relative;
   	top: 100px;
   }
</style>
</head>
<body>
   <nav>
      <ul>
         <li><a class="menuLink" href="/LibraryManage/forAdmin/book_manage.jsp">책정보관리</a></li>
         <li><a class="menuLink" href="/LibraryManage/BookSearchByKeyword?select=title">도서대출</a></li>
         <li><a class="menuLink" href="/LibraryManage/RentalListAdmin">도서반납</a></li>
         <li><a class="menuLink" href="/LibraryManage/allUser">전체회원목록</a></li>
         <li><a class="menuLink" href="/LibraryManage/WaitListAdmin">도서예약현황</a></li>
         <li><a class="menuLink" href="/LibraryManage/logout">로그아웃</a></li>
      </ul>
   </nav>
   <img src="/LibraryManage/img/admin2.png" width="400px" height="400px" align="middle">
</body>
</html>