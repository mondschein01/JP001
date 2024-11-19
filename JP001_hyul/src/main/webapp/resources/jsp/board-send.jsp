<%@page import="com.hyul.model.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("utf-8");
	
	String method = request.getParameter("method");
	
	BoardDAO boardDAO = BoardDAO.getInstance();
	String queryString;
	
	if (method.equals("insert")) {
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		queryString = "INSERT INTO board VALUES ("
				+ "bd_idx_seq.NEXTVAL, "
				+ "?, ?, ?, 0, sysdate)";
		
		boardDAO.insDelUpdBoard(queryString, title, writer, content);
		
		response.sendRedirect("/JP001_hyul/resources/jsp/board-list.jsp");
	}
	else 	if (method.equals("delete")) {
		queryString = "DELETE FROM board "
							+ "WHERE bd_idx = ?";
		
		int idx = Integer.parseInt(request.getParameter("idx"));

		boardDAO.insDelUpdBoard(queryString, idx);
		
		response.sendRedirect("/JP001_hyul/resources/jsp/board-list.jsp");
	}
	
	else 	if (method.equals("update")) {
		int idx = Integer.parseInt(request.getParameter("idx"));

		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		queryString = "UPDATE board SET "
							+ "bd_title = ?, "
							+ "bd_writer = ?, "
							+ "bd_content = ?, "
							+ "bd_regTime = sysdate "
							+ "WHERE bd_idx = ?";
		
		boardDAO.insDelUpdBoard(queryString, title, writer, content, idx);
		response.sendRedirect("/JP001_hyul/resources/jsp/board-list.jsp");
	}
	else {
		return;
	}
	
%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>