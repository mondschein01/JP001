<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.hyul.model.BoardDTO"%>
<%@page import="com.hyul.model.BoardDAO"%>
<%

// default 쓰기 모드 
boolean chk_isWriteMode = true;
int idx = 0;

// idx가 넘어오면, 수정 모드
if (request.getParameter("idx") != null) {
	chk_isWriteMode = false;
	idx  = Integer.parseInt(request.getParameter("idx"));	
	BoardDAO boardDAO =BoardDAO.getInstance();
	BoardDTO boardDTO = boardDAO.getBoardDTO(idx);	
	request.setAttribute("boardDTO", boardDTO);
	
}

request.setAttribute("chk_isWriteMode", chk_isWriteMode);
request.setAttribute("idx", idx);

%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./../css/board-write.css">
    <script src="./../js/board-write.js"></script>
    <title>게시글 쓰기</title>
</head>
<body>
    <div id="wrapper">
	    <jsp:include page="./header.jsp" />

	    <main>
	        <div id="root">
	            <form action="return false" name="form_write">
	                <table id="table_board_list">
	                    <tr>
	                        <td>
	                            <label for="board_title">제목</label>
	                        </td>
	                        <td>
	                            <input type="text" name="board_title"
	                            id="board_title" class="userInput" value="${chk_isWriteMode ? '' : boardDTO.title}">
	                        </td>
	                        <td>
	                            <label for="board_writer">작성자</label>
	                        </td>
	                        <td>
	                            <input type="text" name="board_writer"
	                           		 id="board_writer" class="userInput" value="${chk_isWriteMode ? '' : boardDTO.writer}">
	                            <input type="hidden" name="title" id="hiddenTitle">
							    <input type="hidden" name="writer" id="hiddenWriter">
							    <input type="hidden" name="content" id="hiddenContent">
							    <input type="hidden" name="method" id="hiddenMethod">
	                        </td>
	                    </tr>
	                    <tr>
	                        <td><label for="board_content">내용</label></td>
	                        <td colspan="3">
	                            <textarea name="board_content" id="board_content"
	                            class="userInput">${chk_isWriteMode ? '' : boardDTO.content}</textarea>
	                        </td>
	                    </tr>
	                </table>
	                <div id="container_botton_btn">
	                    <input type="button" value="뒤로가기" onclick="history.back()">
	                    <input type="button" value="${chk_isWriteMode ? '등록' : '수정'}" onclick="${chk_isWriteMode ? 'clickWriteBtn()' : 'clickUpdateBtn(' += idx += ')'} ${sessionScope.curUserId.equals('hyulmaster') ? '': 'disabled'}">
	                </div>
	            </form>
	        </div>
	    </main>

        <jsp:include page="./footer.jsp" />
    </div>
</body>
</html>