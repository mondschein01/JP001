function clickListBtn() {
    location.href = '/JP001_hyul/resources/jsp/board-list.jsp';
}

function clickDeleteBtn(idx) {
    let hiddenIdx = document.createElement('input');
    hiddenIdx.type = 'hidden';
    hiddenIdx.name = 'idx';
    hiddenIdx.value = idx;

    let hiddenMethod = document.createElement('input');
    hiddenMethod.type = 'hidden';
    hiddenMethod.name = 'method';
    hiddenMethod.value = 'delete';

    document.forms[0].appendChild(hiddenIdx);
    document.forms[0].appendChild(hiddenMethod);

    document.forms[0].action = "/JP001_hyul/resources/jsp/board-send.jsp";

    document.forms[0].method = "POST";

    document.forms[0].submit();
}

function clickUpdateBtn(idx) {
    userInputs = document.forms[0].getElementsByClassName("userInput");

    document.forms[0].action = "/JP001_hyul/resources/jsp/board-write.jsp?idx="+idx;

    document.forms[0].method = "POST";

    document.forms[0].submit();
}