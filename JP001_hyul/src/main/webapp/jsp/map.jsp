<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kor">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>모두의혈자리 - 혈자리총서</title>
    <link rel="stylesheet" href="./../css/map.css" type="text/css">
    <script src="./../js/map.js" type="text/javascript"></script>
</head>
<body onload="mInit()">
    <div id="wrapper">
	    <jsp:include page="./header.jsp" />
        
        <main>
            <div id="menu">
                <ul>
                    <li><a>수태음폐경</a></li>
                    <li><a>수양명대장경</a></li>
                    <li><a>족양명위경</a></li>
                    <li><a>족태음비경</a></li>
                    <li><a>수소음심경</a></li>
                    <li><a>수태양소장경</a></li>
                    <li><a>족태양방광경</a></li>
                    <li><a>족소음신경</a></li>
                    <li><a>수궐음심포경</a></li>
                    <li><a>수소양삼초경</a></li>
                    <li><a>족소양담경</a></li>
                    <li><a>족궐음간경</a></li>
                    <li><a>임맥</a></li>
                    <li><a>독맥</a></li>
                    <li><a>경외기혈</a></li>
                    <li><a>이침</a></li>
                    <li><a>족침</a></li>
                    <li><a>수지학</a></li>
                </ul>
            </div>
            <div id="submenu">
            </div>
            <div id="lo_root">
                <div id="lo_left">
                    <img src="./../img/map/BL/bl1.png">
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
        </main>
        
        <jsp:include page="./footer.jsp" />
    </div>
</body>
</html>