<%@page import="com.hyul.model.BoardDTO"%>
<%@page import="com.hyul.model.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	int idx_record = 0;
	boolean chk_isAdmin = false;	

	// 번호 없이 읽기 진입 시 리스트로 이동
	if (request.getParameter("idx") == null) {
		response.sendRedirect("/JP001_hyul/resources/jsp/board-list.jsp");
		return;
	}
	else if (session.getAttribute("curUserId") == null) {
%>
	<script type="text/javascript">
		alert("비회원은 읽을 수 없습니다.");
		history.back();
	</script>
<%
		return;
	}
	else {
	// 게시글 읽기
	idx_record = Integer.parseInt(request.getParameter("idx"));	

	BoardDAO boardDAO =BoardDAO.getInstance();
	BoardDTO boardDTO = boardDAO.getBoardDTO(idx_record);	
	int preHit = boardDTO.getHits();
	int newHit = preHit + 1;
	boardDAO.insDelUpdBoard("UPDATE board SET bd_hits = ? WHERE bd_idx = ?", newHit, idx_record);
	
	boardDTO = boardDAO.getBoardDTO(idx_record);
	request.setAttribute("idx_record", idx_record);
	request.setAttribute("boardDTO", boardDTO);
	}
%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./../css/board-view.css">
    <script src="./../js/board-view.js"></script>
    <title>게시글 보기</title>
</head>
<body>
    <div id="wrapper">
	    <jsp:include page="./header.jsp" />

	    <main>
	        <div id="root">
	            <form name="board_view">
	                <table id="table_board_list">
	                    <tr>
	                        <td>
	                            <label for="board_title">제목</label>
	                        </td>
	                        <td>
	                            <input type="text" name="board_title"
	                            id="board_title" class="board_title" value="${boardDTO.title}" readonly>
	                        </td>
	                        <td>
	                            <label for="board_writer">작성자</label>
	                        </td>
	                        <td>
	                            <input type="text" name="board_writer"
	                            id="board_writer" class="board_writer" value="${boardDTO.writer}" readonly>
	                        </td>
	                    </tr>
	                    <tr>
	                        <td><label for="board_regTime">등록시간</label></td>
	                        <td>
	                            <input type="text" name="board_regTime"
	                            id="board_regTime" class="board_regTime" value="${boardDTO.regTime}" readonly>
	                        </td>
	                        <td><label for="board_hits">조회수</label></td>
	                        <td>
	                            <input type="text" name="board_hits"
	                            id="board_hits" class="board_hits" value="${boardDTO.hits}" readonly>
	                        </td>
	                    </tr>
	                    <tr>
	                        <td><label for="board_content">내용</label></td>
	                        <td colspan="3">
	                            <textarea name="board_content" id="board_content"
	                            class="board_content" readonly>${boardDTO.content}</textarea>
	                        </td>
	                    </tr>
	                </table>
	                <div id="container_botton_btn">
	                    <input type="button" value="목록보기" onclick="clickListBtn()">
	                    <input type="button" value="수정" onclick="clickUpdateBtn(${idx_record})" ${sessionScope.curUserId.equals('hyulmaster') ? '': 'disabled'}>
	                    <input type="button" value="삭제" onclick="clickDeleteBtn(${idx_record})" ${sessionScope.curUserId.equals('hyulmaster') ? '': 'disabled'}>
	                </div>
	            </form>
	        </div>
	    </main>

        <jsp:include page="./footer.jsp" />
    </div>
</body>
</html>