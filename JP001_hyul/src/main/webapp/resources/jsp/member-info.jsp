<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 현재 login 상태가 아닌데, 회원 정보 페이지에 들어왔다면,
	if (session.getAttribute("curUserId") == null) {
		// 잘못된 접근이므로 main.jsp로 이동
		response.sendRedirect("/JP001_hyul/main.jsp");
	}

	// reqeust에 memberDTO가 없다면,
	if (request.getAttribute("memberDTO") == null) {
		// MemberController 서블릿에 요청을 보내서 memberDTO 받아와야 됨
		request.getRequestDispatcher("/member/info").forward(request, response);	
	}
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원정보</title>
    <link rel="stylesheet" href="./../css/member-info.css">
    <script src="./../js/member-info.js"></script>
</head>
<body>
    <div id="wrapper">
	    <jsp:include page="./header.jsp" />

	    <main>
	        <div id="root">
	            <form action="return false" method="post" name="form_info">
	                <table>
	                    <tr>
	                        <td><label for="mem_id">아이디</label></td>
	                        <td><input type="text" id="mem_id" class="userInput"
	                            name="mem_id" value="${memberDTO.mem_id}" readonly>
	                        </td>
	                    </tr>
	                    <tr>
	                        <td><label for="mem_pw">비밀번호</label></td>
	                        <td><input type="password" id="mem_pw" class="userInput"
	                            name="mem_pw" value="${memberDTO.mem_pw}">
	                        </td>
	                    </tr>
	                    <tr>
	                        <td><label for="mem_name">이름</label></td>
	                        <td><input type="text" id="mem_name" class="userInput"
	                            name="mem_name" value="${memberDTO.mem_name}">
	                        </td>
	                    </tr>
	                    <tr>
	                        <td><label for="mem_birth">생년월일</label></td>
	                        <td><input type="text" id="mem_birth" class="userInput"
	                            name="mem_birth" value="${memberDTO.mem_birth}">
	                        </td>
	                    </tr>
	                    <tr>
	                        <td><label for="mem_gender">성별</label></td>
	                        <td>
	                            <label for="mem_gender">남자</label>
	                            <input type="radio" id="male" class="userInput"
	                            name="mem_gender" value="male" ${memberDTO.mem_gender == 'male' ? 'checked' : ''}>
	                            <label for="mem_gender">여자</label>
	                            <input type="radio" id="female" class="userInput"
	                            name="mem_gender" value="female" ${memberDTO.mem_gender == 'female' ? 'checked' : ''}>
	                        </td>
	                    </tr>
	                    <tr>
	                        <td><label for="mem_email">이메일</label></td>
	                        <td><input type="text" id="mem_email" class="userInput"
	                            name="mem_email" value="${memberDTO.mem_email}">
	                        </td>
	                    </tr>
	                </table>
	                <div>
	                    <input type="button" value="수정" onclick="clickSubmitBtn(this)">
	                    <input type="button" value="탈퇴" onclick="clickSubmitBtn(this)">
	                </div>
	            </form>
	        </div>
	    </main>

        <jsp:include page="./footer.jsp" />
    </div>
</body>
</html>