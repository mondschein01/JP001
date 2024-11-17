<%@page import="com.hyul.model.MemberDTO"%>
<%@page import="com.hyul.model.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보</title>
<link rel="stylesheet" type="text/css" href="./../css/info.css">
<script type="text/javascript" src="./../js/info.js"></script>
</head>
<body>
	<%
	String curUserId = (String) session.getAttribute("curUserId");

	// 현재 로그인 상태가 아니면 메인 페이지로 이동
	if (curUserId == null) {
		response.sendRedirect("/JP001_hyul/jsp/home.jsp");
	}

	MemberDTO memberDTO = (MemberDTO) request.getAttribute("memberDTO");
	%>
	<jsp:include page="./header.jsp" />

	<main>
		<div id="root">
			<form action="">
				<table>
				<tr>
					<td><label for="mem_id">아이디</label></td>
					<td><input type="text" id="mem_id" value="<%=memberDTO.getMem_id()%>" readonly></td>
				</tr>
				<tr>
					<td><label for="mem_pw">비밀번호</label></td>
					<td><input type="password" id="mem_pw" value="<%=memberDTO.getMem_pw()%>"></td>
				</tr>
				<tr>
					<td><label for="mem_name">이름</label></td>
					<td><input type="text" id="mem_name" value="<%=memberDTO.getMem_name()%>"></td>
				</tr>
				<tr>
					<td><label for="mem_email">이메일</label></td>
					<td><input type="text" id="mem_email" value="<%=memberDTO.getMem_email()%>"></td>
				</tr>
				<tr>
					<td>성별</td>
		    			<td id="box_radioBtn_gender" class="radio_toggleType">
			    			<input type="radio" id="male" name="mem_gender" value="male" checked>
		                    <label for="male">남자</label>
		                    <input type="radio" id="female" name="mem_gender" value="female">
		                    <label for="female">여자</label>
	                    </td>
				</tr>
				<tr>
					<td><label for="mem_birth">생년월일</label></td>
					<td><input type="text" id="mem_birth" value="<%=memberDTO.getMem_birth()%>"></td>
				</tr>
				<tr>
					<td colspan="2" id="td_btns">
						<input type="button" value="정보 수정" onclick="">
						<input type="button" value="회원 탈퇴" onclick="">
					</td>
				</tr>
				</table>
			</form>
		</div>
	</main>

	<jsp:include page="./footer.jsp" />
</body>
</html>