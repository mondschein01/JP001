<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
</head>
<body>
	<jsp:include page="./header.jsp" />

	<main>
		<div id="root">
			<%
			//http://localhost:8081/JP001_hyul/jsp/find-id.jsp
			//http://localhost:8081/JP001_hyul/member/find-id
			String rstFindId = (String) request.getAttribute("rstFindId");
			if (rstFindId != null) {
				out.println("회원님의 아이디는 " + rstFindId + "입니다.");
			} else {
			%>

			<form action="/JP001_hyul/member/find-id" id="findIdForm" method="post">
				<div>
					<label for="mem_name">이름</label>
					<input type="text" name="mem_name" id="mem_name">
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