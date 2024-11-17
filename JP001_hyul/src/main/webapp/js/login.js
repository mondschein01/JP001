function clickSubmit() {
    let els = document.querySelectorAll(".userInput");
    let hasEmptyField = false;

    for (let i = 0; i < els.length; i++) {
        if (els[i].value == null || els[i].value.length == 0) {
            els[i].focus();
            hasEmptyField = true;
            break;
        }
    }

    if (!hasEmptyField) {
        document.getElementById('loginForm').submit();
    }
}

// 미사용
function clickBtn(self) {
    let url;
    console.log(self.innerHTML);
    switch (self.innerHTML) {
    case "회원가입":
        url = "/JP001_hyul/member/join";
        sendXHR(url);
        break;

    case "아이디 찾기":
        url = "/JP001_hyul/member/find-id";
        sendXHR(url);
        break;

    case "비밀번호 찾기":
        url = "/JP001_hyul/member/find-pw";
        sendXHR(url);
        break;
    }
}

// 미사용
function sendXHR(_url) {
    let xhr = new XMLHttpRequest();
    let httpMethod = "POST";
    let requestURL = _url;
    let isAsync = true;

    xhr.open(httpMethod, requestURL, isAsync);

    xhr.send();
}

// 미사용
function sendXHRJson(_url, arg1, arg2) {
    let xhr = new XMLHttpRequest();
    let httpMethod = "POST";
    let requestURL = _url;
    let isAsync = true;

    xhr.open(httpMethod, requestURL, isAsync);
    xhr.setRequestHeader("Content-Type", "application/json");

    xhr.onload = function() {
        console.log(xhr.responseText);
    };

    let data = JSON.stringify(
        {
            "mem_id":arg1,
            "mem_pw":arg2
        }
    );

    xhr.send(data);
}

/*
application/x-www-form-urlencoded
application/json
text/plain
multipart/from-data

HTTP 응답상태 코드  status code(200~ 500)  200번대 ok  
400번대 클라이언트 요청 잘못 했을때  
500번대 서버에서 에러발생
200: "OK" 201:"ok" 요청이 성공적인 표현 post요청에 대한 응답결과
403: "허가금지"
404: "Not Found"

XHR readyState
0 (uninitialized) - (request가 초기화되지 않음)
1 (loading) - (서버와의 연결이 성사됨)
2 (loaded) - (서버가 request를 받음)
3 (interactive) - (request(요청)을 처리하는 중)
4 (complete) - (request에 대한 처리가 끝났으며 응답할 준비가 완료됨)

*/