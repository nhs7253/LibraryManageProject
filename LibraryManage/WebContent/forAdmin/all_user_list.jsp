<%@page import="kr.co.library.service.impl.RentalServiceImpl"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 회원 목록</title>
<link rel="stylesheet" type="text/css" href ="/LibraryManage/css/view_table.css">
<style>
form{
float: middle;
}
</style>
</head>
<%@include file = "/forAdmin/admin_menu.jsp" %>
<body>

<c:if test="${sessionScope.addBookMessage != null}">
	<script>alert('${sessionScope.addBookMessage}')</script>
	<c:remove scope="session" var="addBookMessage"/>
</c:if>
<header>
		<h2>전체 회원 목록</h2>
</header>

<table class="w3-table-all">
	<thead>
		<tr class="w3-blue">
			<th>회원ID</th>
			<th>이름</th>
			<th>전화번호</th>
			<th>이메일</th>
			<th>연체상태</th>
			<th>연체해제</th>
			<th></th>

		</tr>
	</thead>
	<tbody>
		
		<%-- ######################################################
														조회된 item 출력 
			###################################################### --%>
		
		<c:forEach items="${requestScope.list}" var="user">
			<tr>
				<td>${user.userId}</td>
				<td>${user.userName}</td>
				<td>${user.phoneNum}</td>
				<td>${user.email}</td>
				<td>${user.penaltyState}</td>
				<td><c:choose>
						<c:when test="${user.penaltyState == 'N'.charAt(0)}">
								<input type="button" disabled="true" value="연체해제" />
						</c:when>
						<c:otherwise>
								<form action="/LibraryManage/RentalPenaltyRevocation" method="post" style="float: none;">
									<input type="hidden" name="userId" value="${user.userId }">
									<input type="hidden" name="password" value="${user.password }">
									<input type="hidden" name="userName" value="${user.userName }"> 
									<input type="hidden" name="phoneNum" value="${user.phoneNum }">
									<input type="hidden" name="email" value="${user.email }">
									<input type="hidden" name="penaltyState" value="${user.penaltyState }"> 
									<input type="submit" value="연체해제">
								</form>
						</c:otherwise>
					</c:choose>
				</td>
				<td><form action = "${initParam.rootPath }/DeleteUser?userId=${user.userId}" method = "post">
				<input type="submit" value = "탈퇴" onclick="alert('${user.userId}님이 탈퇴되었습니다.');" /></form></td>
		</c:forEach>

	</tbody>
</table>
<p>
	<%--######################################################
														페이징 처리
			###################################################### --%>
	<!-- 첫페이지로 이동 -->
	<a href="${initParam.rootPath }/allUser?page=1">첫페이지</a>

	<!--
		이전 페이지 그룹 처리.
		만약에 이전페이지 그룹이 있으면 링크처리하고 없으면 화살표만 나오도록 처리.
	 -->
	<c:choose>
		<c:when test="${requestScope.pageBean.previousPageGroup}">
			<!-- 이전페이지 그룹이 있다면 : isPreviousPageGroup() -->
			<a href="${initParam.rootPath }/allUser?page=${requestScope.pageBean.beginPage-1}">◀</a>
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
				<a href="${initParam.rootPath }/allUser?page=${page}">${page }&nbsp;&nbsp;</a>
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
			<a href="${initParam.rootPath }/allUser?page=${requestScope.pageBean.endPage+1}">▶</a>
		</c:when>
		<c:otherwise>
			▶
		</c:otherwise>
	</c:choose>
	
	
	
	
	<!-- 마지막 페이지로 이동 -->
	<a href="${initParam.rootPath }/allUser?page=${requestScope.pageBean.totalPage}">마지막 페이지</a>
	

</p>

</body>
</html>