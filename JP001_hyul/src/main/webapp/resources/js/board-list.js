let recordCntPerPage;

function clickWriteBtn(){
    location.href = "/JP001_hyul/resources/jsp/board-write.jsp";
}

function changeSelectValue() {
    recordCntPerPage = document.querySelector("#recordCntPerPage").value;
    // 페이지 수가 변경될 때 첫 페이지로 돌아가도록 curPageIdx=0 추가
    location.href = `/JP001_hyul/resources/jsp/board-list.jsp?recordCntPerPage=${recordCntPerPage}`;
}

function clickBoardTitle(idx_board) {
    // console.log(idx_board);
    location.href = `/JP001_hyul/resources/jsp/board-view.jsp?idx=${idx_board}`;
}

function clickPagination(obj, curBlockIdx, totalBlockCnt, recordCntPerPage, pageCntPerBlock){
    if (obj.innerText === "<") {
        // console.log("명령 : 블럭 인덱스 --");
        if (curBlockIdx > 0) {
            curBlockIdx = curBlockIdx - 1;
            location.href = `/JP001_hyul/resources/jsp/board-list.jsp?recordCntPerPage=${recordCntPerPage}&curPageIdx=${curBlockIdx*pageCntPerBlock}&curBlockIdx=${curBlockIdx}`;
        }
    }
    else if (obj.innerText === ">") {
        // console.log("명령 : 블럭 인덱스 ++");

        if (curBlockIdx < totalBlockCnt-1) {
            curBlockIdx = curBlockIdx + 1;
            location.href = `/JP001_hyul/resources/jsp/board-list.jsp?recordCntPerPage=${recordCntPerPage}&curPageIdx=${curBlockIdx*pageCntPerBlock}&curBlockIdx=${curBlockIdx}`;
        }
    }
    else {
        // console.log("명령 : 페이지 넘버 교체");
        location.href = `/JP001_hyul/resources/jsp/board-list.jsp?recordCntPerPage=${recordCntPerPage}&curPageIdx=${obj.innerText-1}&curBlockIdx=${curBlockIdx}`;
    }
    // console.log("변경할 페이지 인덱스 : " + obj.innerText);
    // console.log("현재 페이지 인덱스 : " + curPageIdx);
    // console.log("현재 블럭 인덱스 : " + curBlockIdx);
}


