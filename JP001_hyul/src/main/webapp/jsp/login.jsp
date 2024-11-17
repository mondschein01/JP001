<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./../css/login.css">
<script type="text/javascript" src="./../js/login.js"></script>
</head>
<body>
    <jsp:include page="./header.jsp" />

    <main>
    	<div id="root">
    		<form id="loginForm" method="post" action="/JP001_hyul/member/login">
    			<table>
	    			<tr>
		    			<td><label for="mem_id">아이디</label></td>
		    			<td colspan="2"><input type="text" name="mem_id" id="mem_id" class="userInput"></td>
	    			</tr>
	    			<tr>
		    			<td><label for="mem_pw">비밀번호</label></td>
		    			<td colspan="2"><input type="password" name="mem_pw" id="mem_pw" class="userInput"></td>
	    			</tr>
    				<tr>
    					<td colspan="3"><input type="button" value="로그인" onclick="clickSubmit()"></td>
    				</tr>
    				<tr>
		    			<td><a href="/JP001_hyul/jsp/join.jsp">회원가입 |</a></td>
		    			<td><a href="/JP001_hyul/jsp/find-id.jsp">아이디 찾기 |</a></td>
		    			<td><a href="/JP001_hyul/jsp/find-pw.jsp">비밀번호 찾기</a></td>
	    			</tr>
	    		</table>
    		</form>
    	</div>
    </main>

	<jsp:include page="./footer.jsp" />
</body>
</html>