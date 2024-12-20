<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="kor">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./../css/saju.css" type="text/css">
    <script src="./../js/saju.js" type="text/javascript"></script>
    <title>사주혈자리</title>
</head>
<body>
    <div id="wrapper">
	    <jsp:include page="./header.jsp" />

        <main>
            <div id="root">
                <div id="container_left">
                    <div id="box_top">
                        <form action="">
                            <table>
                                <tr>
                                    <td><label for="">이름</label></td>
                                    <td><input type="text"></td>
                                    <td><label for="">생년월일</label></td>
                                    <td><input type="text"></td>
                                    <td><label for="">출생시간</label></td>
                                    <td><input type="text"></td>
                                </tr>
                                <tr>
                                    <td>
                                        <div id="box_radioBtn_gender" class="radio_toggleType">
                                            <input type="radio" id="male" name="gender" checked>
                                            <label for="male">남자</label>
                                            <input type="radio" id="female" name="gender">
                                            <label for="female">여자</label>
                                        </div>
                                    </td>
                                    <td>
                                    <div id="box_radioBtn_calendarType" class="radio_toggleType">
                                        <input type="radio" id="solar" name="calendarType" checked>
                                        <label for="solar">양력</label>
                                        <input type="radio" id="lunar" name="calendarType">
                                        <label for="lunar">음력</label>
                                    </div>
                                    </td>
                                    <td>
                                    <div id="box_radioBtn_monthType" class="radio_toggleType">
                                        <input type="radio" id="normal" name="monthType" checked>
                                        <label for="normal">평달</label>
                                        <input type="radio" id="leap" name="monthType">
                                        <label for="leap">윤달</label>
                                    </div>
                                    </td>
                                    <td>
                                    <div id="box_funcBtn_inquire" class="funcBtn_type1">
                                        <button>조회하기</button>
                                    </div>
                                    </td>
                                    <td>
                                    <div id="box_funcBtn_reset" class="funcBtn_type1">
                                        <button>Reset</button>
                                    </div>
                                    </td>
                                </tr>
                            </table>
                        </form>
                    </div>
                    <div id="box_bot">
                        <img src="" alt="">
                        <canvas></canvas>
                    </div>
                </div>
                <div id="container_right">
                    <div id="box_top">
                        <div>
                            <span></span>
                            <span></span>
                        </div>
                        <div>
                            <span></span>
                            <span></span>
                        </div>
                    </div>
                    <div id="box_bot">
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