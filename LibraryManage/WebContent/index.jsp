<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<form action="${initParam.rootPath }/BookSearchByKeyword" method="post">
<select name="select">
    <option value="title">제목</option>
    <option value="author">저자</option>
    <option value="publisher">출판사</option>
</select>
	<input type="text" name="keyword"/>
	<input type="submit" value="검색"/>
</form> <br />


<a href="${initParam.rootPath }/RentalList?userId=1">유저의 대여 목록 (1)</a> <br />

<a href="${initParam.rootPath }/WaitList?userId=1">유저의 대기 목록 (2)</a>
</body>
</html>