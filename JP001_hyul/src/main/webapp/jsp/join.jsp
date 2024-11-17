<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./../css/join.css">
<script type="text/javascript" src="./../js/join.js"></script>
</head>
<body>
    <jsp:include page="./header.jsp" />
        
    <main>
    	<div id="root">
    		<form action="./../member/join" method="post" id="joinForm">
    			<table>
	    			<tr>
		    			<td><label for="mem_id">아이디</label></td>
		    			<td><input type="text" name="mem_id" id="mem_id" class="userInput"></td>
	    			</tr>
	    			<tr>
		    			<td><label for="mem_pw">비밀번호</label></td>
		    			<td><input type="password" name="mem_pw" id="mem_pw" class="userInput"></td>
	    			</tr>
	    			<tr>
		    			<td><label for="mem_name">이름</label></td>
		    			<td><input type="text" name="mem_name" id="mem_name" class="userInput"></td>
	    			</tr>
	    			<tr>
		    			<td><label for="mem_email">이메일</label></td>
		    			<td><input type="text" name="mem_email" id="mem_email" class="userInput"></td>
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
		    			<td><input type="text" name="mem_birth" id="mem_birth" class="userInput"></td>
	    			</tr>
	    			<tr>
		    			<td id="td_btns" colspan="2">
		    				<input type="button" value="가입" onclick="clickSubmit()">
		    				<input type="reset" value="초기화">
		    			</td>
	    			</tr>
				</table>
    		</form>
    	</div>
    </main>
       
	<jsp:include page="./footer.jsp" />
</body>
</html>