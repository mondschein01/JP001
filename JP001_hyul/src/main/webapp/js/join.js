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
        document.getElementById('joinForm').submit();
    }
}