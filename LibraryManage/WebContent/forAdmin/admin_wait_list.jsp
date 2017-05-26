<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href ="/LibraryManage/css/view_table.css">
</head>
<%@include file = "/forAdmin/admin_menu.jsp" %>
<body>
<h2>도서 대출 예약 목록(관리자)</h2>

<table class="w3-table-all">
	<thead>
		<tr class="w3-blue">
			<th>예약자ID</th>
			<th>이름</th>
			<th>예약도서ID</th>
			<th>도서제목</th>
			<th>대기순위</th>
		</tr>
	</thead>
	<tbody>
		
		<%-- ######################################################
														조회된 item 출력 
			###################################################### --%>
		
		<c:forEach items="${requestScope.list }" var="wait">
			<tr>
				<td>${wait.userId}</td>
				<td>${wait.name}</td>
				<td>${wait.bookId}</td>
				<td>${wait.title}</td>
				<td>${wait.rank}</td>
			</tr>
		</c:forEach>
		
		
		
	</tbody>
</table>

<p>
	<%--######################################################
														페이징 처리
			###################################################### --%>
	<!-- 첫페이지로 이동 -->
	<a href="${initParam.rootPath }/WaitListAdmin?page=1">첫페이지</a>
	

	<!--
		이전 페이지 그룹 처리.
		만약에 이전페이지 그룹이 있으면 링크처리하고 없으면 화살표만 나오도록 처리.
	 -->
	<c:choose>
		<c:when test="${requestScope.pageBean.previousPageGroup}">
			<!-- 이전페이지 그룹이 있다면 : isPreviousPageGroup() -->
			<a href="${initParam.rootPath }/WaitListAdmin?page=${requestScope.pageBean.beginPage-1}">◀</a>
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
				<a href="${initParam.rootPath }/WaitListAdmin?page=${page}">${page }&nbsp;&nbsp;</a>
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
			<a href="${initParam.rootPath }/WaitListAdmin?page=${requestScope.pageBean.endPage+1}">▶</a>
		</c:when>
		<c:otherwise>
			▶
		</c:otherwise>
	</c:choose>
	
	
	
	
	<!-- 마지막 페이지로 이동 -->
	<a href="${initParam.rootPath }/WaitListAdmin?page=${requestScope.pageBean.totalPage}">마지막 페이지</a>
	

</p>


</body>
</html>




