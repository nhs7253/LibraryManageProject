<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나의 대여목록</title>
<link rel="stylesheet" type="text/css" href ="./css/view_table.css">
</head>
<%@include file = "/forUser/user_menu.jsp" %>
<body>
<h2>나의 도서 대여 목록</h2>
<br><br>
<table class="w3-table-all">
	<thead>
		<tr class="w3-blue">
			<th>책ID</th>
			<th>제목</th>
			<th>저자</th>
			<th>출판사</th>
			<th>발간일</th>
			<th>빌린날짜</th>
			<th>반납날짜</th>
			<th>연체여부</th>
		</tr>
	</thead>
	<tbody>
		
		<%-- ######################################################
														조회된 item 출력 
			###################################################### --%>
		
		<c:forEach items="${requestScope.list }" var="rent" varStatus="Status">
			<tr>
				<td>${rent.bookId}</td>
				<td>${rent.book.title}</td>
				<td>${rent.book.author}</td>
				<td>${rent.book.publisher}</td>
				<td>${rent.book.publishDate}</td>
				<td><fmt:formatDate value="${rent.rentalStart}" pattern="yyyy-MM-dd"/></td>
				<td><fmt:formatDate value="${rent.rentalEnd}" pattern="yyyy-MM-dd"/></td>
				<td>${requestScope.overdue[Status.index]}</td>
			</tr>
		</c:forEach>
		
		
		
	</tbody>
</table>

<p>
	<%--######################################################
														페이징 처리
			###################################################### --%>
	<!-- 첫페이지로 이동 -->
	<a href="${initParam.rootPath }/RentalList?page=1&userId=${sessionScope.loginInfo.userId}">첫페이지</a>
	

	<!--
		이전 페이지 그룹 처리.
		만약에 이전페이지 그룹이 있으면 링크처리하고 없으면 화살표만 나오도록 처리.
	 -->
	<c:choose>
		<c:when test="${requestScope.pageBean.previousPageGroup}">
			<!-- 이전페이지 그룹이 있다면 : isPreviousPageGroup() -->
			<a href="${initParam.rootPath }/RentalList?page=${requestScope.pageBean.beginPage-1}&userId=${sessionScope.loginInfo.userId}">◀</a>
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
				<a href="${initParam.rootPath }/RentalList?page=${page}&userId=${sessionScope.loginInfo.userId}">${page }&nbsp;&nbsp;</a>
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
			<a href="${initParam.rootPath }/RentalList?page=${requestScope.pageBean.endPage+1}&userId=${sessionScope.loginInfo.userId}">▶</a>
		</c:when>
		<c:otherwise>
			▶
		</c:otherwise>
	</c:choose>
	
	
	
	
	<!-- 마지막 페이지로 이동 -->
	<a href="${initParam.rootPath }/RentalList?page=${requestScope.pageBean.totalPage}&userId=${sessionScope.loginInfo.userId}">마지막 페이지</a>
	

</p>


</body>
</html>




