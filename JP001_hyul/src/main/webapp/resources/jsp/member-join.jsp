<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
    <link rel="stylesheet" href="./../css/member-join.css">
    <script src="./../js/member-join.js"></script>
</head>
<body>
    <div id="wrapper">
	    <jsp:include page="./header.jsp" />

	    <main>
	        <div id="root">
	            <form action="/JP001_hyul/member/join" method="post" name="form_join">
	                <table>
	                    <tr>
	                        <td><label for="mem_id">아이디</label></td>
	                        <td><input type="text" id="mem_id" class="userInput"
	                            name="mem_id">
	                        </td>
	                    </tr>
	                    <tr>
	                        <td><label for="mem_pw">비밀번호</label></td>
	                        <td><input type="password" id="mem_pw" class="userInput"
	                            name="mem_pw">
	                        </td>
	                    </tr>
	                    <tr>
	                        <td><label for="mem_name">이름</label></td>
	                        <td><input type="text" id="mem_name" class="userInput"
	                            name="mem_name">
	                        </td>
	                    </tr>
	                    <tr>
	                        <td><label for="mem_birth">생년월일</label></td>
	                        <td><input type="text" id="mem_birth" class="userInput"
	                            name="mem_birth">
	                        </td>
	                    </tr>
	                    <tr>
	                        <td><span>성별</span></td>
	                        <td>
	                            <label for="male">남자</label>
	                            <input type="radio" id="male"
	                            name="mem_gender" value="male" checked>
	                            <label for="female">여자</label>
	                            <input type="radio" id="female"
	                            name="mem_gender" value="female">
	                        </td>
	                    </tr>
	                    <tr>
	                        <td><label for="mem_email">이메일</label></td>
	                        <td><input type="text" id="mem_email" class="userInput"
	                            name="mem_email" pattern="">
	                        </td>
	                    </tr>
	                </table>
	                <div>
	                    <input type="button" value="회원가입" onclick="clickSubmitBtn()">
	                    <input type="reset" value="초기화">
	                </div>
	            </form>
	        </div>
	    </main>

        <jsp:include page="./footer.jsp" />
    </div>
</body>
</html>