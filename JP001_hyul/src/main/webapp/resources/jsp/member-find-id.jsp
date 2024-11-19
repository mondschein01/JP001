<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>아아디 찾기</title>
    <link rel="stylesheet" href="./../css/member-find-id.css">
    <script src="./../js/member-find-id.js"></script>
</head>
<body>
    <div id="wrapper">
	    <jsp:include page="./header.jsp" />

	    <main>
	        <div id="root">
	            <form action="return false" method="post" name="form_find-id">
	                <table>
	                    <tr>
	                        <td><label for="mem_name">이름</label></td>
	                        <td><input type="text" id="mem_name" class="userInput" name="mem_name"></td>
	                    </tr>
	                    <tr>
	                        <td><label for="mem_email">이메일</label></td>
	                        <td><input type="text" id="mem_email" class="userInput" name="mem_email"></td>
	                    </tr>
	                </table>
	                <div>
	                    <input type="button" value="찾기" onclick="clickSubmitBtn(this)">
	                </div>
	            </form>
	        </div>
	    </main>

        <jsp:include page="./footer.jsp" />
    </div>
</body>
</html>