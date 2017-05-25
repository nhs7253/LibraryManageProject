<%@ page contentType="text/html;charset=UTF-8"%>


<style type="text/css">
 
 div{
 	float: right;
 }
 
 a:link{
	/*방문하지 않은 링크 설정.*/
	text-decoration:none; /*밑줄 안나오도록 처리.*/
	color:green;
}
a:visited{
	/*방문한 링크 설정*/
	text-decoration: none;
	color:green;
}
a:hover{
	/*마우스 포인터가 올라간 시점의 설정.*/
	text-decoration: none;
	color:red;
}
a:active{
	/*마우스를 링크에 클릭하는 시점*/       
	color:blue;
}
 
</style>

<div>
	<a href = "/LibraryManage/forAdmin/book_manage.jsp" >책정보관리</a>
	<a href = "/LibraryManage/forAdmin/admin_book_list.jsp" >도서대출</a>
	<a href = "/LibraryManage/forAdmin/admin_rental_list.jsp" >도서반납</a>
	<a href = "/LibraryManage/forAdmin/all_user_list.jsp" >전체회원목록</a>
	<a href = "/LibraryManage/forAdmin/admin_wait_list.jsp" >도서예약현황</a>
</div>
<br />

<hr>