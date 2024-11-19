<%@page import="java.util.List"%>
<%@page import="com.hyul.model.BoardDAO"%>
<%@page import="com.hyul.model.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./../css/board-list.css">
    <script src="./../js/board-list.js"></script>
    <title>게시판</title>
</head>
<script>


</script>
<body>

<%
	// boardDAO
	BoardDAO boardDAO = BoardDAO.getInstance();

	// 동적 게시판을 위한 멤버 변수 선언
	// 총 레코드 수
	int totalRecordCnt = boardDAO.getBoardRecordCount();
	// out.println("총 레코드 수 " + totalRecordCnt + "<br>");
	
	// 페이지당 레코드 수
	int recordCntPerPage;
	if (request.getParameter("recordCntPerPage") != null){
		recordCntPerPage = Integer.parseInt(request.getParameter("recordCntPerPage"));
	}
	else {
		recordCntPerPage = 10;
	}

	// 블럭당 페이지 수
	int pageCntPerBlock = 5;

	// 총 페이지 수
	int totalPageCnt = (int) Math.ceil((double) totalRecordCnt / recordCntPerPage);
	
	// out.println("총 페이지 수" + totalPageCnt + "<br>");
	
	// 총 블럭 수
	int totalBlockCnt = (int) Math.ceil((double) totalPageCnt / pageCntPerBlock);
	
	// out.println("총 블럭 수" + totalBlockCnt + "<br>");
	
	// 현재 페이지 인덱스
	int curPageIdx;
	if (request.getParameter("curPageIdx") != null){
		curPageIdx = Integer.parseInt(request.getParameter("curPageIdx"));
	}
	else {
		curPageIdx = 0;
	}

	// 현재 블럭 인덱스
	int curBlockIdx;
	if (request.getParameter("curBlockIdx") != null){
		curBlockIdx = Integer.parseInt(request.getParameter("curBlockIdx"));
	}
	else {
		curBlockIdx = 0;
	}

	// 시작 레코드 숫자
	int startRecordNum = curPageIdx * recordCntPerPage; // 현재 페이지 idx * 페이지당 레코드 수 => 0 * 10 = 0
	
	// out.println("시작 레코드 숫자 " + startRecordNum + "<br>");
	
	// 끝 레코드 숫자
	int endRecordNum = ((curPageIdx + 1) * recordCntPerPage) - 1; // (현재 페이지 idx + 1) * 페이지당 레코드 수 - 1 = 1 * 10 - 1 = 9
	// out.println("끝 레코드 숫자0 " + endRecordNum + "<br>");
	
	// 끝 레코드 숫자가 총 레코드 숫자를 초과하면, 총 레코드 숫자로
	endRecordNum = endRecordNum > totalRecordCnt ? totalRecordCnt - 1 : endRecordNum;
	
	// out.println("끝 레코드 숫자1 " + endRecordNum + "<br>");
	
	// 블럭에서 시작 페이지 숫자
	int startPageNum = curBlockIdx * pageCntPerBlock; // 현재 블럭 idx * 블럭당 페이지 수 => 0 * 10 = 0
	
	// out.println("블럭 시작 숫자" + startPageNum + "<br>");
	
	// 블럭에서 끝 페이지 숫자
	int endPageNum = ((curBlockIdx + 1) * pageCntPerBlock) - 1; // (현재 블럭 idx + 1) * 블럭당 페이지 수  - 1=> 1 * 10 - 1= 9
	
	// 블럭에서 끝 페이지 숫자가 총 페이지 숫자를 초과하면, 총 페이지 숫자로
	endPageNum = endPageNum >= totalPageCnt ? totalPageCnt - 1 : endPageNum;
	
	// out.println("블럭 끝 숫자" + endPageNum  + "<br>");
	
	// 레코드 리스트 // 이거 rownum으로 바꿔야 됨
	List<BoardDTO> list_boardDTO = boardDAO.getBoardDTOList(startRecordNum+1, endRecordNum+1);

	// set
	request.setAttribute("list_boardDTO", list_boardDTO); // 레코드 리스트

	request.setAttribute("recordCntPerPage", recordCntPerPage); // 페이지당 레코드 숫자
	request.setAttribute("totalBlockCnt", totalBlockCnt); // 총 블럭 숫자
	request.setAttribute("totalPageCnt", totalPageCnt); // 총 페이지 숫자
	request.setAttribute("pageCntPerBlock", pageCntPerBlock); // 블럭 당 페이지 숫자

	request.setAttribute("curPageIdx", curPageIdx); // 현재 페이지 인덱스
	request.setAttribute("curBlockIdx", curBlockIdx); // 현재 블럭 인덱스

	request.setAttribute("startRecordNum", startRecordNum); // 시작 레코드 숫자
	request.setAttribute("endRecordNum", endRecordNum); // 끝 레코드 숫자

	request.setAttribute("startPageNum", startPageNum); // 블럭에서 시작 페이지 숫자
	request.setAttribute("endPageNum", endPageNum); // 블럭에서 끝 페이지 숫자

%>
    <div id="wrapper">
	    <jsp:include page="./header.jsp" />

        <main>
            <div id="root">
            	<div id="container_top_select">
            		<span>게시글 수</span>
                    <select id="recordCntPerPage" onchange="changeSelectValue()">
					    <option value="10" ${recordCntPerPage == 10 ? 'selected' : ''}>10</option>
					    <option value="30" ${recordCntPerPage == 30 ? 'selected' : ''}>30</option>
					    <option value="50" ${recordCntPerPage == 50 ? 'selected' : ''}>50</option>
					    <option value="100" ${recordCntPerPage == 100 ? 'selected' : ''}>100</option>
					</select>
                </div>
                <table id="table_board_list">
                    <thead>
                        <tr>
                            <td>번호</td>
                            <td>제목</td>
                            <td>작성자</td>
                            <td>작성일시</td>
                            <td>조회수</td>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="boardDTO" items="${list_boardDTO}">
	                        <tr>
	                            <td>${boardDTO.idx}</td>
	                            <td onclick="clickBoardTitle(${boardDTO.idx})">${boardDTO.title}</td>
	                            <td>${boardDTO.writer}</td>
	                            <td>${boardDTO.regTime}</td>
	                            <td>${boardDTO.hits}</td>
	                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <div id="container_bot_btn">
                    <button type="button" onclick="clickWriteBtn()" ${sessionScope.curUserId.equals('hyulmaster') ? '': 'disabled'}>글쓰기</button>
                </div>
                <div id="container_pagination">
                    <ul>
						<li onclick="clickPagination(this, ${curBlockIdx}, ${totalBlockCnt}, ${recordCntPerPage}, ${pageCntPerBlock})">&lt;</li>
						
                   		<c:forEach var="i" begin="${startPageNum}" end="${endPageNum}">
	                        <li onclick="clickPagination(this, ${curBlockIdx}, ${totalBlockCnt}, ${recordCntPerPage}, ${pageCntPerBlock})">${i+1}</li>
                        </c:forEach>
                        
						<li onclick="clickPagination(this, ${curBlockIdx}, ${totalBlockCnt}, ${recordCntPerPage}, ${pageCntPerBlock})">&gt;</li>
                    </ul>
                </div>
            </div>
        </main>

        <jsp:include page="./footer.jsp" />
    </div>
</body>
</html>