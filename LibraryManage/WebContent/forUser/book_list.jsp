<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="/LibraryManage/css/view_table.css">
<!-- 
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
 -->



</head>
<body>
	<%@include file="/forUser/user_menu.jsp"%>
	<c:if test="${sessionScope.waitMessage != null}">
	<script>alert('${sessionScope.waitMessage}')</script>
	<c:remove scope="session" var="waitMessage"/>
	</c:if>

	<h2>도서 목록</h2>



	<form action="${initParam.rootPath }/BookSearchByKeyword" method="post">
		<select name="select">
			<option value="title">제목</option>
			<option value="author">저자</option>
			<option value="publisher">출판사</option>
		</select> <input type="text" name="keyword" /> <input type="submit" value="검색" />
	</form>
	<br>

	<table class="w3-table-all">
		<thead>
			<tr class="w3-blue">
				<th width = "36%"> 제목</th>
				<th width = "27%">저자</th>
				<th width = "14%">출판사</th>
				<th width = "5%">발간일</th>
				<th width = "10%">대여가능여부</th>
				<th width = "8%">대여신청</th>
			</tr>
		</thead>
		<tbody>

			<%-- ######################################################
															조회된 item 출력 
				###################################################### --%>
			<c:forEach items="${requestScope.list }" var="book">

				<tr>
					<td title='${book.title}'>${book.title}</td>
					<td title='${book.author}'>${book.author}</td>
					<td>${book.publisher}</td>
					<td>${book.publishDate}</td>
					<td>${book.rentalState}</td>
					<c:choose>
						<c:when test="${book.rentalState eq 'Y'.charAt(0)}">
							<td><input type="button" onclick="rentAlert();" value="대여신청" />
							</td>
						</c:when>
						<c:otherwise>
							<td>

								<form action="/LibraryManage/waitListInsert" method="post"
									style="float: none;">
									<input type="hidden" name="userId"
										value="${sessionScope.loginInfo.userId }">
										<input type="hidden" name="bookId" value="${book.bookId }"> <input
										type="hidden" name="keyword" value="${param.keyword }"><input
										type="hidden" name="select" value="${param.select }"><input
										type="hidden" name="page" value="${param.page }"> <input
										type="submit" value="대기신청">
								</form>

							</td>
						</c:otherwise>
					</c:choose>
				</tr>
			</c:forEach>

		</tbody>
	</table>

	<script>
		function rentAlert() {
			alert("관리자에게 대여하세요!!");
		}
	</script>




	<p>
		<%--######################################################
															페이징 처리
				###################################################### --%>
		<!-- 첫페이지로 이동 -->
		<a
			href="${initParam.rootPath }/BookSearchByKeyword?page=1&select=${requestScope.select}&keyword=${requestScope.keyword}">첫페이지</a>


		<!--
			이전 페이지 그룹 처리.
			만약에 이전페이지 그룹이 있으면 링크처리하고 없으면 화살표만 나오도록 처리.
		 -->
		<c:choose>
			<c:when test="${requestScope.pageBean.previousPageGroup}">
				<!-- 이전페이지 그룹이 있다면 : isPreviousPageGroup() -->
				<a
					href="${initParam.rootPath }/BookSearchByKeyword?page=${requestScope.pageBean.beginPage-1}&select=${requestScope.select}&keyword=${requestScope.keyword}">◀</a>
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

		<c:forEach begin="${requestScope.pageBean.beginPage }"
			end="${requestScope.pageBean.endPage }" var="page">
			<c:choose>
				<c:when test="${page != requestScope.pageBean.page}">
					<!-- 현재페이지가 아니라면 -->
					<a
						href="${initParam.rootPath }/BookSearchByKeyword?page=${page}&select=${requestScope.select}&keyword=${requestScope.keyword}">${page }&nbsp;&nbsp;</a>
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
				<a
					href="${initParam.rootPath }/BookSearchByKeyword?page=${requestScope.pageBean.endPage+1}&select=${requestScope.select}&keyword=${requestScope.keyword}">▶</a>
			</c:when>
			<c:otherwise>
			▶
		</c:otherwise>
		</c:choose>




		<!-- 마지막 페이지로 이동 -->
		<a
			href="${initParam.rootPath }/BookSearchByKeyword?page=${requestScope.pageBean.totalPage}&select=${requestScope.select}&keyword=${requestScope.keyword}">마지막
			페이지</a>


	</p>


</body>
</html>




