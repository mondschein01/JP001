<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="kor">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./../css/hyulmap.css" type="text/css">
    <script src="./../js/hyulmap.js" type="text/javascript"></script>
    <title>혈자리총서</title>
</head>
<body onload="mInit()">
    <div id="wrapper">
	    <jsp:include page="./header.jsp" />

        <main>
            <div id="root">
                <div id="menu">
                    <ul>
                    </ul>
                </div>
                <div id="submenu">
                </div>
                <div id="container_description">
                    <div id="lo_left">
                        <img src="">
                    </div>
                    <div id="lo_right">
                        <div id="box_desc">
                            <h1 id="category">Category</h1>
                            <h2 id="hyulName">hyulName</h2>
                            <h3 id="hyulPos">hyulPos</h3>
                            <p id="hyulPosDesc">hyulPosDesc</p>
                            <h3 id="hyulSelect">hyulSelect</h3>
                            <p id="hyulSelectDesc">hyulSelectDesc</p>
                            <h3 id="wayToChim">wayToChim</h3>
                            <p id="wayToChimDesc">wayToChimDesc</p>
                            <h3 id="hyulEffect">hyulEffect</h3>
                            <p id="hyulEffectDesc">hyulEffectDesc</p>
                        </div>
                    </div>
                </div>
            </div>
        </main>

        <jsp:include page="./footer.jsp" />
    </div>
</body>
</html>