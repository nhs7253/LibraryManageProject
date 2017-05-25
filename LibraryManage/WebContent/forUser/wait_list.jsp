<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./css/view_table.css">
</head>
<%@include file = "/forUser/user_menu.jsp" %>
<body>
   <h2>대기 목록</h2>

   <table>
      <thead>
         <tr>
            <td>제목</td>
            <td>대기 순위</td>
            <td>대기상태</td>
         </tr>
      </thead>
      <tbody>

         <%-- ######################################################
                                          조회된 item 출력 
         ###################################################### --%>

         <c:forEach items="${requestScope.list }" var="wait">
            <tr>
               <td>${wait.title}</td>
               <td>${wait.rank}</td>
               <td>
               	  <form action="waitListCancel">

               	  <form action="waitListCancel" method="post" style="float: none;">

                     <input type="hidden" name="userId" value="${sessionScope.loginInfo.userId }">
                     <input type="hidden" name="bookId" value="${wait.bookId }">
                     <input type="submit" value="대기취소">
                  </form>
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
      <a
         href="${initParam.rootPath }/WaitList?page=1&userId=${requestScope.userId}">첫페이지</a>


      <!--
      이전 페이지 그룹 처리.
      만약에 이전페이지 그룹이 있으면 링크처리하고 없으면 화살표만 나오도록 처리.
    -->
      <c:choose>
         <c:when test="${requestScope.pageBean.previousPageGroup}">
            <!-- 이전페이지 그룹이 있다면 : isPreviousPageGroup() -->
            <a
               href="${initParam.rootPath }/WaitList?page=${requestScope.pageBean.beginPage-1}&userId=${sessionScope.loginInfo.userId}">◀</a>
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
<<<<<<< HEAD
               <a href="${initParam.rootPath }/WaitList?page=${page}&userId=${requestScope.userId}">${page }&nbsp;&nbsp;</a>
=======
               <a
                  href="${initParam.rootPath }/WaitList?page=${page}&userId=${sessionScope.loginInfo.userId}">${page }&nbsp;&nbsp;</a>
>>>>>>> branch 'master' of https://github.com/nhs7253/LibraryManageProject.git
            </c:when>
            <c:otherwise>
            ${page}]&nbsp;&nbsp;
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
               href="${initParam.rootPath }/WaitList?page=${requestScope.pageBean.endPage+1}&userId=${sessionScope.loginInfo.userId}">▶</a>
         </c:when>
         <c:otherwise>
         ▶
      </c:otherwise>
      </c:choose>




      <!-- 마지막 페이지로 이동 -->
      <a
         href="${initParam.rootPath }/WaitList?page=${requestScope.pageBean.totalPage}&userId=${sessionScope.loginInfo.userId}">마지막
         페이지</a>


   </p>


</body>
</html>



