<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!--  <link rel="stylesheet" type="text/css" href ="./css/view_table.css"> -->
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<style type="text/css">
table {
    width: 100%;
    border-collapse: collapse;
	text-align: center;
	border: 1px solid gray;
	
	table-layout:fixed
}
 th {
    border-top: 3px solid #000000;
    border-bottom: 3px solid #000000;
	padding: 5px 10px;
}

td {
    border-bottom: 1px solid #c8c8c8;
	padding: 5px 10px;
	
	overflow:hidden;
	white-space:nowrap;
	text-overflow:ellipsis;
}

form {
	padding: 10px 5px;
	float: right;
}

p, h2{
	text-align:center;
	vertical-align:middle;
	.align-center { text-align: center; }
}

tr:hover{background-color:#f5f5f5}




thead:hover{
	/*마우스 포인터가 올라간 시점의 설정.*/
	background-color:green;
}



}
</style>

</head>
<%@include file = "/forAdmin/admin_menu.jsp" %>
<body>
	<c:if test="${sessionScope.rentMessage != null}">
	<script>alert('${sessionScope.rentMessage}')</script>
	<c:remove scope="session" var="rentMessage"/>
	</c:if>
	<h2>도서 목록</h2>
	<form action="${initParam.rootPath }/BookSearchByKeyword" method="post">
	<select name="select">
	    <option value="title">제목</option>
	    <option value="author">저자</option>
	    <option value="publisher">출판사</option>
	</select>
		<input type="text" name="keyword"/>
		<input type="submit" value="검색"/>
	</form> <br>
	
	<table>
		<thead>
			<tr>
				<td width = "10%">책ID</td>
				<td width = "30%">제목</td>
				<td width = "20%">저자</td>
				<td width = "10%">출판사</td>
				<td width = "5%">발간일</td>
				<td width = "5%">대출여부</td>
				<td width = "20%">버튼</td>
			</tr>
		</thead>
		<tbody>
			
			<%-- ######################################################
															조회된 item 출력 
				###################################################### --%>
			
			<c:forEach items="${requestScope.list }" var="book">
				<tr>
					<td>${book.bookId}</td>
					<td title='${book.title}'>${book.title}</td>
					<td title='${book.author}'>${book.author}</td>
					<td>${book.publisher}</td>
					<td>${book.publishDate}</td>
					<td>${book.rentalState}</td>
					<td>
					<c:choose>
						<c:when test = "${book.rentalState eq 'Y'.charAt(0)}">
							<form action ="rentBook"  method = "post" style="float: none;">
							<input type="text" name="userId" placeholder="ID을 입력하세요.">
							<input type="hidden" name="bookId" value="${book.bookId }">
							 <input	type="hidden" name="keyword" value="${param.keyword }">
							 <input type="hidden" name="select" value="${param.select }">
							 <input type="hidden" name="page" value="${param.page }">
							<input type="submit" value ="대출"/></form>
						</c:when>
						<c:otherwise>
							
							<input type="submit" value = "대출중" onclick="alert('대출불가능');" style="float: none;"/>
							
						</c:otherwise>
					</c:choose>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<p>
		<%--######################################################
															페이징 처리
				###################################################### --%>
		<!-- 첫페이지로 이동 -->
		<a href="${initParam.rootPath }/BookSearchByKeyword?page=1&select=${requestScope.select}&keyword=${requestScope.keyword}">첫페이지</a>
		
	
		<!--
			이전 페이지 그룹 처리.
			만약에 이전페이지 그룹이 있으면 링크처리하고 없으면 화살표만 나오도록 처리.
		 -->
		<c:choose>
			<c:when test="${requestScope.pageBean.previousPageGroup}">
				<!-- 이전페이지 그룹이 있다면 : isPreviousPageGroup() -->
				<a href="${initParam.rootPath }/BookSearchByKeyword?page=${requestScope.pageBean.beginPage-1}&select=${requestScope.select}&keyword=${requestScope.keyword}">◀</a>
			</c:when>
			<c:otherwise>
				◀
			</c:otherwise>
		</c:choose>
		
		
		
	
	
	<!-- 
		현재 page가 속한 page 그룹내의 페이지들 링크.
		현재 pageGroup의 시작page ~ 끝 page
	 -->
	 <!-- 만약에 page가 현재페이지면 링크처리를 하지 않고 page가 현재페이지가 아니라면 링크처리. -->
	
	<c:forEach begin="${requestScope.pageBean.beginPage }" end="${requestScope.pageBean.endPage }" var="page">
		<c:choose>
			<c:when test="${page != requestScope.pageBean.page}">
				<!-- 현재페이지가 아니라면 -->
				<a href="${initParam.rootPath }/BookSearchByKeyword?page=${page}&select=${requestScope.select}&keyword=${requestScope.keyword}" class="w3-button w3-hover-green">${page }&nbsp;&nbsp;</a>
			</c:when>
			<c:otherwise>
				[${page}]&nbsp;&nbsp;
			</c:otherwise>
		</c:choose>
		
	</c:forEach>
	
	
	
	<!-- 
		다음페이지 그룹으로 이동
		만약에 다음페이지 그룹이 있으면 링크 처리 없으면 화살표만 나오도록 처리
	 -->
	<c:choose>
		<c:when test="${requestScope.pageBean.nextPageGroup}">
			<a href="${initParam.rootPath }/BookSearchByKeyword?page=${requestScope.pageBean.endPage+1}&select=${requestScope.select}&keyword=${requestScope.keyword}">▶</a>
		</c:when>
		<c:otherwise>
			▶
		</c:otherwise>
	</c:choose>
	
	
	
	
	<!-- 마지막 페이지로 이동 -->
	<a href="${initParam.rootPath }/BookSearchByKeyword?page=${requestScope.pageBean.totalPage}&select=${requestScope.select}&keyword=${requestScope.keyword}">마지막 페이지</a>
	

	</p>


</body>
</html>




