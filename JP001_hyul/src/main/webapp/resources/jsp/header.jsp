<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="/JP001_hyul/resources/css/header.css">
<script src="/JP001_hyul/resources/js/header.js"></script>

<header>
    <nav>
        <ul>
            <li><a href="/JP001_hyul/main.jsp">모두의 혈자리</a></li>
            <li><a href="/JP001_hyul/resources/jsp/saju.jsp">사주 혈자리</a></li>
            <li><a href="/JP001_hyul/resources/jsp/keyword.jsp">키워드 혈자리</a></li>
            <li><a href="/JP001_hyul/resources/jsp/hyulmap.jsp">혈자리 총서</a></li>
            <li><a href="/JP001_hyul/resources/jsp/board-list.jsp">공지사항</a></li>
			<c:choose>
				<c:when test="${sessionScope.curUserId == null}">
					<li><a href="/JP001_hyul/resources/jsp/member-login.jsp">로그인</a></li>
            		<li><a href="/JP001_hyul/resources/jsp/member-join.jsp">회원가입</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="/JP001_hyul/resources/jsp/member-info.jsp">${sessionScope.curUserName}님</a></li>
            		<li><a href="/JP001_hyul/member/logout">로그아웃</a></li>
				</c:otherwise>
			</c:choose>
        </ul>
    </nav>
</header>
