<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>키워드 사주</title>
<link rel="stylesheet" type="text/css" href="./../css/keyword.css">
<script type="text/javascript"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
    <jsp:include page="./header.jsp" />
    <main>
    	<div id="root">
	    	<div id="layout_top">
	    		<div id="box_search">
	    			<form id="" action="/JP001_hyul/keyword/search">
	    				<input type="text" placeholder="Search..." name="search">
	    				<button type="submit"><i class="fa fa-search"></i></button>
	    			</form>
	    		</div>
	   		</div>
			<!-- 키워드 클릭 시, 검색 수행 -->
	   		<div id="layout_mid">
				<div id="box_keyword">
					<ul id="ul_keyword">
						<li><a>두통</a></li>
						<li><a>치통</a></li>
						<li><a>생리통</a></li>
					</ul>
				</div>
	   		</div>
    		<div id="layout_bot">
	    		<!-- 도움이 되는 혈자리 키워드 리스트 /
				 혈자리 이미지 / 지압법 -->
				 <div id="box_search_rst">
					<div id="box_rst_keyword">
						<ul>
							<li><a>LU3</a></li>
							<li><a>LU3</a></li>
							<li><a>LU3</a></li>
						</ul>
					</div>
					<div>
						<div id="box_rst_left">
							<img src="">
						</div>
						<div id="box_rst_right">
							<p>LU3 어쩌구저쩌구</p>
						</div>
					</div>
				 </div>
    		</div>
    	</div>
    </main>
	<jsp:include page="./footer.jsp" />
</body>
</html>

<!-- 
	페이지의 일부만 교체하는 거니까 AJAX와 JSON을 이용해서 redrawing을 하면 되는 거고

	키워드 중에 랜덤으로 뽑아서 	
	




 -->