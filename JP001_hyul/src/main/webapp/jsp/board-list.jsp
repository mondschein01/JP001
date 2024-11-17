<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hyul.model.BoardDAO"%>
<%@page import="com.hyul.model.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	// 게시판은 jsp
	// 키워드는 mvc2
	// 혈자리는 ajax
	// 회원관리 mvc2 + restful
	
	BoardDAO boardDAO = BoardDAO.getInstance();
	
	int cntTotalRecord = boardDAO.getBoardRecordCount();
	int cntRecordPerpage = 10;
	int cntPagePerBlock = 10;
	int cntTotalPage = (int) cntTotalRecord / cntRecordPerpage;
	int cntTotalBlock = (int) cntTotalPage / cntPagePerBlock;
	int curPage = 0;
	int curBlock = 0;

	int startRecordIdx = curPage * cntRecordPerpage;
	int endRecordIdx = 
		(curPage+1) * cntRecordPerpage > cntTotalBlock ? 
		(curPage+1) * cntRecordPerpage : cntTotalBlock;

	int startBlockIdx = curBlock * cntPagePerBlock;
	int endBlockIdx = 
		(curBlock+1) * cntPagePerBlock > cntTotalBlock ?
		(curBlock+1) * cntPagePerBlock : cntTotalBlock;
	
	List<BoardDTO> aryBoardDTO = 
		boardDAO.getBoardDTOList(startRecordIdx, endRecordIdx);
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="./../css/home.css">
	<script src="" type="text/javascript"></script>
	
	<script type="text/javascript">
	
	</script>
	
	<style>
		#boardRecordList table {
			width: 1340px;
			text-align: center;
		
		}
		
		#boardRecordList table, tr, td {
			border: 1px solid black;
		}

		#boardRecordList td {
			min-width:100px 
		}
		
		#boardRecordList tr:nth-child(1) {
			background-color: orange;
		}
	
		#boardPagination ul {
			width: 1340px;
			display: flex;
			list-style-type: none;
			justify-content: space-between;
			text-align: center;
		}
		
	</style>
	<title>게시판</title>
</head>
<body>
    <jsp:include page="./header.jsp" />

    <main>
    	<!--  -->
    	<div id="boardTopMenu">
    		<form action="">
    			Select
	    		<select name="cntRecordPerPage">
	    			<option value="10" selected>10</option>
	    			<option value="30">30</option>
	    			<option value="50">50</option>
	    			<option value="100">100</option>
	    		</select>
	    		<input type="button" value="글쓰기">
    		</form>
    	</div>

    	<!-- table -->
    	<div id="boardRecordList">
    		<table>
    			<tr>
    				<td>글번호</td>
    				<td>제목</td>
    				<td>작성자</td>
    				<td>작성일</td>
    				<td>조회수</td>
    			</tr>
    			
    		<%
    			for (int i = 0; i < aryBoardDTO.size(); i++) {
    		%>
    			<tr>
    			<td><%=aryBoardDTO.get(i).getIdx() %></td>
    			<td><a href="./board-read.jsp?num=<%= aryBoardDTO.get(i).getIdx() %>"><%=aryBoardDTO.get(i).getTitle() %></a></td>
    			<td><%=aryBoardDTO.get(i).getWriter() %></td>
    			<td><%=aryBoardDTO.get(i).getRegTime() %></td>
    			<td><%=aryBoardDTO.get(i).getHits() %></td>
    			</tr>
    		<%
    			}
    		%>
    		</table>
    	</div>
    	
    	<!-- pagination -->
    	<div id="boardPagination">
    		<ul>
    			<li>&laquo;</li>
    			<li>&lt;</li>
    		<%
    			for (int i = startBlockIdx; i < endBlockIdx; i++) {
    		%>
    			<li><%=i+1 %></li>
    		<%
    			}
    		%>
    			<li>&gt;</li>
    			<li>&raquo;</li>
    		</ul>
    	</div>
    	
    </main>

	<jsp:include page="./footer.jsp" />
</body>
</html>