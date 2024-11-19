function clickSubmitBtn() {
    chk_validate();
}

function chk_validate() {
    let userInputs = document.forms[0].getElementsByClassName("userInput");

    let chk_isValidateOk = true;
    let regExp;
    let alertMsg;

    for (let i = 0; i < userInputs.length; i++) {
        // 공백 체크
        // console.log(userInputs[i].id);
        if (userInputs[i].value.length == 0) {
            userInputs[i].focus();
            return;
        }

        // 유효값 검증
        switch (userInputs[i].id) {
            case "mem_id":
                regExp = /^(?=.*[0-9a-z]).{4,10}$/
                chk_isValidateOk = regExp.test(userInputs[i].value);
                if (!chk_isValidateOk) {
                    console.log(userInputs[i].value);
                    alertMsg = "아이디는 4자 이상 10자 이하의 소문자와 숫자로만 이루어져야 합니다.";
                }
                break;
            case "mem_pw":
                regExp = /^(?=.*[a-zA-Z])(?=.*[0-9]).{6,12}$/
                chk_isValidateOk = regExp.test(userInputs[i].value);
                if (!chk_isValidateOk) {
                    alertMsg = "비밀번호는 6자 이상 12자 이내의의 숫자와 영문의 조합이어야 합니다.";
                // *~`!^
                }
                break;
            case "mem_name":
                regExp = /^[가-힣]{2,5}$/
                chk_isValidateOk = regExp.test(userInputs[i].value);
                if (!chk_isValidateOk) {
                    alertMsg = "이름은 2자에서 5자 사이의 한글이어야 합니다.";
                }
                break;
            case "mem_birth": // 1900 01 01
                regExp = /^(19[0-9]{2}|20[0-9]{2})(0[1-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])$/
                chk_isValidateOk = regExp.test(userInputs[i].value);
                if (!chk_isValidateOk) {
                    alertMsg = "생년월일은 19901010의 형식을 갖춰 제대로 입력해야 합니다.";
                }
                break;
            case "mem_email":
                regExp = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
                chk_isValidateOk = regExp.test(userInputs[i].value);
                if (!chk_isValidateOk) {
                    alertMsg = "test01@test.com의 이메일 형식에 따라 입력해야 합니다.";
                }
                break;
        }

        if (!chk_isValidateOk) {
            console.log(userInputs[i].id);
            alert(alertMsg);
            userInputs[i].focus();
            return;
        }
    }

    if (chk_isValidateOk) {
        document.forms[0].submit();
    }

}