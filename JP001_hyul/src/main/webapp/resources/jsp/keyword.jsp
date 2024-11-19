<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%

	if (request.getAttribute("recommKeyword") == null) {
		request.getRequestDispatcher("/keyword/get-keyword").forward(request, response);
	}
	
	JSONObject jo = (JSONObject) request.getAttribute("recommKeyword");
	String[] keyAry = (String[]) jo.get("recommKeyword");
	
	request.setAttribute("keyAry", keyAry);

%>

<!DOCTYPE html>
<html lang="kor">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./../css/keyword.css" type="text/css">
    <script src="./../js/keyword.js" type="text/javascript"></script>
    <title>키워드혈자리</title>
</head>
<body>
    <div id="wrapper">
	    <jsp:include page="./header.jsp" />

        <main>
            <div id="root">
                <div id="box_search">
                    <form onsubmit="return false">
                        <input type="text" placeholder="검색창" name="searchbar">
                        <input type="button" value="검색" onclick="clickQueryBtn()">
                    </form>
                </div>
                <div id="box_keyword">
                    <ul>
                    	<c:forEach var="key" items="${keyAry}">
	                        <li onclick="clickRecommKeyword(this)">${key}</li>
                        </c:forEach>
                    </ul>
                </div>
                <div id="container_description">
                    <div id="lo_left">
                        <img src="" alt="혈자리 이미지">
                    </div>
                    <div id="lo_right">
                        <div id="box_desc">
                            <h1 id="category" class="desc">Category</h1>
                            <h2 id="hyulName" class="desc">hyulName</h2>
                            <h3 id="hyulPos" >부위</h3>
                            <p id="hyulPosDesc" class="desc">hyulPosDesc</p>
                            <h3 id="hyulSelect" >취혈</h3>
                            <p id="hyulSelectDesc" class="desc">hyulSelectDesc</p>
                            <h3 id="wayToChim" >침구법</h3>
                            <p id="wayToChimDesc" class="desc">wayToChimDesc</p>
                            <h3 id="hyulEffect" >주치증</h3>
                            <p id="hyulEffectDesc" class="desc">hyulEffectDesc</p>
                        </div>
                    </div>
                </div>
                <div id="box_queryResult">
                    <ul>
                    </ul>
                </div>
            </div>
        </main>

        <jsp:include page="./footer.jsp" />
    </div>
</body>
</html>