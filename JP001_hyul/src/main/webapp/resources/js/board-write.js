let userInputs;

function clickWriteBtn(){
    userInputs = document.forms[0].getElementsByClassName("userInput");

    document.getElementById('hiddenTitle').value = userInputs[0].value;
    document.getElementById('hiddenWriter').value = userInputs[1].value;
    document.getElementById('hiddenContent').value = userInputs[2].value;
    document.getElementById('hiddenMethod').value = "insert";

    document.forms[0].action = "/JP001_hyul/resources/jsp/board-send.jsp";

    document.forms[0].method = "POST";

    document.forms[0].submit();
}

function clickUpdateBtn(idx){
    // console.log(idx);
    userInputs = document.forms[0].getElementsByClassName("userInput");

    document.getElementById('hiddenTitle').value = userInputs[0].value;
    document.getElementById('hiddenWriter').value = userInputs[1].value;
    document.getElementById('hiddenContent').value = userInputs[2].value;
    document.getElementById('hiddenMethod').value = "update";

    let hiddenIdx = document.createElement('input');
    hiddenIdx.type = 'hidden';
    hiddenIdx.name = 'idx';
    hiddenIdx.value = idx;
    document.forms[0].appendChild(hiddenIdx);

    document.forms[0].action = "/JP001_hyul/resources/jsp/board-send.jsp";

    document.forms[0].method = "POST";

    document.forms[0].submit();
}
