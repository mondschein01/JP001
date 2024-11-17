<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String tmp = request.getParameter("num");

	int num = (tmp != null && tmp.length() > 0) ? Integer.parseInt(tmp) : 0;

	String writer = "";
	String title = "";
	String content = "";
	String action = "";
	
	if (num > 0) {
		
	}

%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="./../css/home.css">
	<script src="" type="text/javascript"></script>
	<title>게시판</title>
</head>
<body>
    <jsp:include page="./header.jsp" />

    <main>
    	<table>
			<tr>
				<td>제목</td>
				<td>작성자</td>
				<td>내용</td>
			</tr>
		</table>
		<div>
			<ul>
				<li><a href="">등록</a></li>
				<li><a href="">취소</a></li>
			</ul>
		</div>
    </main>

	<jsp:include page="./footer.jsp" />
</body>
</html>