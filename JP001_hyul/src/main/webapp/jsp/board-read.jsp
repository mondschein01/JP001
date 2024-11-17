<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.hyul.model.BoardDAO" %>
<%@ page import="com.hyul.model.BoardDTO" %>
<%@ page import="java.sql.*" %>
<%
	int num = Integer.parseInt(request.getParameter("num"));

	BoardDAO boardDAO = BoardDAO.getInstance();
	BoardDTO boardDTO = boardDAO.getBoardDTO(num);
	
	String title = boardDTO.getTitle();
	String writer = boardDTO.getTitle();
	Timestamp regTime = boardDTO.getRegTime();
	int hits = boardDTO.getHits();
	String content = boardDTO.getContent();
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="./../css/home.css">
	<script src="" type="text/javascript"></script>
	<title>게시판</title>
</head>
<script type="text/javascript">
	
</script>
<body>
    <jsp:include page="./header.jsp" />

    <main>
		<table>
			<tr>
				<td>글번호</td>
				<td><%=num %></td>
				<td>제목</td>
				<td><%=title %></td>
				<td>작성자</td>
				<td><%=writer %></td>
				<td>등록시간</td>
				<td><%=regTime %></td>
				<td>조회수</td>
				<td><%=hits %></td>
				<td>내용</td>
				<td><%=content %></td>
			</tr>
		</table>
		<div>
			<ul>
				<li><a href="./board-list.jsp">목록</a></li>
				<li><a href="./board-write.jsp">수정</a></li>
				<li><a href="./board-delete.jsp">삭제</a></li>
			</ul>
		</div>
    </main>

	<jsp:include page="./footer.jsp" />
</body>
</html>