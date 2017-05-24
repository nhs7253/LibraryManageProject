<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="">로그인</a> <a href="">회원가입</a> <br />
<h2>도서검색</h2>

<form action="${initParam.rootPath }/BookSearchByKeyword" method="post">
<select name="select">
    <option value="title">제목</option>
    <option value="author">저자</option>
    <option value="publisher">출판사</option>
</select>
	<input type="text" name="keyword"/>
	<input type="submit" value="검색"/>
</form> <br />




</body>
</html>