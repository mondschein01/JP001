<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="./../css/header.css" type="text/css">
<script src="./../js/header.js" type="text/javascript"></script>
<header>
    <nav>
        <ul>
            <li><a href="/JP001_hyul/jsp/home.jsp">모두의 혈자리</a></li>
            <li><a href="/JP001_hyul/jsp/saju.jsp">사주추천혈자리</a></li>
            <li><a href="/JP001_hyul/jsp/keyword.jsp">키워드혈자리</a></li>
            <li><a href="/JP001_hyul/jsp/map.jsp">혈자리총서</a></li>
            <li><a href="/JP001_hyul/jsp/board-list.jsp">게시판</a></li>
			<%
				String curUserId = (String) session.getAttribute("curUserId");
				if (curUserId != null) {
			%>
				<li><a href="/JP001_hyul/member/info"><%=curUserId+"님"%></a></li>
				<li><a href="/JP001_hyul/member/logout">로그아웃</a></li>
			<%
				}
				else {
			%>
				<li><a href="/JP001_hyul/jsp/login.jsp">로그인</a></li>
				<li><a href="/JP001_hyul/jsp/join.jsp">회원가입</a></li>
			<%	
				}
			%>
        </ul>
    </nav>
</header>