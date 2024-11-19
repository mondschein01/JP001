<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	// 현재 login 상태인데, 로그인 페이지에 들어왔다면,
	if (session.getAttribute("curUserId") != null) {
		// 잘못된 접근이므로 main.jsp로 이동
		response.sendRedirect("/JP001_hyul/main.jsp");
	}
%>
	
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인</title>
    <link rel="stylesheet" href="./../css/member-login.css">
    <script src="./../js/member-login.js"></script>
</head>
<body>
	<%
		// loginFail 속성이 있으면,
		if (session.getAttribute("loginFail") != null) {
	%>
		<script type="text/javascript">
			alert("로그인에 실패하였습니다.");
		</script>
	<%
			session.removeAttribute("loginFail");
		}
	%>
    <div id="wrapper">
	    <jsp:include page="./header.jsp" />

	    <main>
	        <div id="root">
	            <form action="/JP001_hyul/member/login" method="post" name="form_login">
	                <table>
	                    <tr>
	                        <td><label for="mem_id">아이디</label></td>
	                        <td><input type="text" id="mem_id" class="userInput" name="mem_id"></td>
	                    </tr>
	                    <tr>
	                        <td><label for="mem_pw">비밀번호</label></td>
	                        <td><input type="password" id="mem_pw" class="userInput" name="mem_pw"></td>
	                    </tr>
	                </table>
	                <div>
	                    <input type="button" value="아이디 찾기" onclick="clickSubmitBtn(this)">
	                    <input type="button" value="비밀번호 찾기" onclick="clickSubmitBtn(this)">
	                    <input type="button" value="로그인" onclick="clickSubmitBtn(this)">
	                </div>
	            </form>
	        </div>
	    </main>

        <jsp:include page="./footer.jsp" />
    </div>
</body>
</html>