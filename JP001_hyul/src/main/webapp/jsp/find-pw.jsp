<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
</head>
<body>
	<jsp:include page="./header.jsp" />

    <main>
    	<div id="root">
    		<%
			String rstFindPw = (String) request.getAttribute("rstFindPw");
			if (rstFindPw != null) {
				out.println("회원님의 비밀번호는 " + rstFindPw + "입니다.");
			} else {
			%>
    		<form action="/JP001_hyul/member/find-pw" id="findPwForm" method="post">
	    		<div>
					<label for="mem_id">아이디</label>
					<input type="text" name="mem_id" id="mem_id">
				</div>
	   			<div>
					<label for="mem_email">이메일</label>
					<input type="text" name="mem_email" id="mem_email">
				</div>
				<div>
					<input type="submit" value="찾기">
					<input type="reset" value="초기화">
				</div>
    		</form>
    		<%
			}
			%>
    	</div>
    </main>

	<jsp:include page="./footer.jsp" />
</body>
</html>