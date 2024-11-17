<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	/*
		1. 사용자로부터 생년월일을 입력 받고 ajax로 서버에 보낸다.
		2. 서버에서 오행을 구한다.
		3. 서버에서 오행에 따른 추천 혈자리 데이터를 구한다.
		4. 2, 3을 클라이언트로 보낸다.
		4. 클라이언트에서 자바스크립트로 오행에 따른 오각형을 그린다.
		5. 클라이언트에서 자바스크립트로 text를 교체한다.
	*/
	 function clickXuxingInquiryBtn() {
		console.log("hi");

	}

</script>
<link rel="stylesheet" type="text/css" href="./../css/saju.css">
</head>
<body>
    <jsp:include page="./header.jsp" />
    <main>
    	<div id="root">
    		<div id="layout_left">
    			<div id="box_leftTop">
    				<form action="return false" >
    					<div id="box_input_name">
	    					<label for="saju_name">이름</label>
	    					<input type="text" id="saju_name" name="saju_name" placeholder="">
    					</div>
    					<div id="box_input_birthDate">
	    					<label for="saju_birthDate">생년월일</label>
	    					<input type="text" id="saju_birthDate" name="saju_birthDate" placeholder="">
    					</div>
    					<div id="box_input_birthTime">
	    					<label for="saju_birthTime">생년월일</label>
	    					<input type="text" id="saju_birthTime" name="saju_birthTime" placeholder="">
    					</div>
    					<div id="box_toggle_gender">
	    					<label for="male">남자</label>
	    					<input type="radio" id="male" name="saju_gender">
	    					<label for="female">여자</label>
	    					<input type="radio" id="female" name="saju_gender">
    					</div>
    					<div id="box_toggle_calendar">
	    					<label for="solar">양력</label>
	    					<input type="radio" id="solar" name="saju_calendar">
	    					<label for="lunar">음력</label>
	    					<input type="radio" id="lunar" name="saju_calendar">
    					</div>
    					<div id="box_toggle_month">
	    					<label for="normal">평달</label>
	    					<input type="radio" id="normal" name="saju_month">
	    					<label for="abnormal">윤달</label>
	    					<input type="radio" id="abnormal" name="saju_month">
    					</div>
    					<input type="button" value="조회하기" onclick="clickXuxingInquiryBtn()">
    					<input type="reset" value="초기화">
    				</form>
    			</div>
    			<div id="box_leftBot">
    				<div id="box_img">
    					<img src="./../img/saju/xuxing_rst_img.png">
    				</div>
    			</div>
    		</div>
    		<div id="layout_right">
    			<div id="box_rightTop">
    				<div id="box_user_data">
    					<span id="box_user_name">
    						ㅇㅇㅇ님 (ㅇㅇ세)
    					</span>
    					<span id="box_user_brithDataTime">
    						(양력) 1987년 05월 25일 06:02
    					</span>
    				</div>
    				<div id="box_xuxing_rst">
    					<div id="box_xuxing_mok" class="box_xuxing">
    						<p>목</p>
    						<p>1개</p>
    					</div>
    					<div id="box_xuxing_hwa" class="box_xuxing">
    						<p>화</p>
    						<p>1개</p>
    					</div>
    					<div id="box_xuxing_to" class="box_xuxing">
    						<p>토</p>
    						<p>1개</p>
    					</div>
    					<div id="box_xuxing_kin" class="box_xuxing">
    						<p>금</p>
    						<p>1개</p>
    					</div>
    					<div id="box_xuxing_su" class="box_xuxing">
    						<p>수</p>
    						<p>1개</p>
    					</div>
    				</div>
    			</div>
    			<div id="box_rightBot">
    				<div id="box_xixing_desc">
    					<div id="box_title">
    					</div>
    					<div id="box_rst1">
    						<div class="rst_title">
    							<h3>☞ 금(金) 부족 (폐, 대장 관련):</h3>
    						</div>
    						<div class="rst_desc">
    							<p>태연(太淵): 폐경의 원혈로서, 기침, 천식, 폐 질환을 조절합니다.</p>
    							<p>합곡(合谷): 대장경의 중요한 혈자리로, 기운을 돌리고, 폐의 기능을 보완해줍니다.</p>
    						</div>
    					</div>
    				</div>
    			</div>
    		</div>
    	</div>
    </main>

	<jsp:include page="./footer.jsp" />
</body>
</html>