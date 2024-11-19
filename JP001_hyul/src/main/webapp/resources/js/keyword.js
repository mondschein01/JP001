let el_div_box_queryResult;

function clickQueryBtn() {
    // console.log("click QueryBtn");

    let url = "/JP001_hyul/keyword/query";
    let method = "POST";
    let xhr = new XMLHttpRequest();

    xhr.open(method, url, true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    let val = document.forms[0].elements['searchbar'].value;
    if (val == null || val.length == 0)
        return;
    let data = `q=${document.forms[0].elements['searchbar'].value}`;
    xhr.send(data);

    xhr.onload = () => {
        let jsonRep = JSON.parse(xhr.responseText);
        createResponseList(jsonRep);
        // console.log(jsonRep[0]);
    };
}

function clickRecommKeyword(obj) {
    // console.log("click keyword");
    document.forms[0].elements['searchbar'].value = obj.innerText;

    let url = "/JP001_hyul/keyword/query";
    let method = "POST";
    let xhr = new XMLHttpRequest();

    xhr.open(method, url, true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    let data = `q=${obj.innerText}`;
    xhr.send(data);

    xhr.onload = () => {
        let jsonRep = JSON.parse(xhr.responseText);
        createResponseList(jsonRep);
        // console.log(jsonRep[0]);
    };
}

/*
category
hyulEffect
hyulName
hyulPos
hyulSelect
imgPath
wayToChim
*/

function createResponseList(jsonAry){
    el_div_box_queryResult = document.querySelector("#box_queryResult");

    el_div_box_queryResult.firstElementChild.remove();

    let el_ul = document.createElement("ul");
    for (let i = 0; i < jsonAry.length; i++) {
        let el_li = document.createElement("li");
        el_li.innerText = jsonAry[i]['hyulName'];
        el_ul.append(el_li);
        el_li.onclick = () => {showDesc(jsonAry[i])};
    }
    el_div_box_queryResult.append(el_ul);
}

function showDesc(jo_hyul){
    // console.log(jo_hyul['category']);
    // console.log(jo_hyul['hyulEffect']);
    // console.log(jo_hyul['hyulName']);
    // console.log(jo_hyul['hyulPos']);
    // console.log(jo_hyul['hyulSelect']);
    // console.log(jo_hyul['imgPath']);
    // console.log(jo_hyul['wayToChim']);

    let desc = document.querySelectorAll(".desc");
    document.images[0].src = jo_hyul['imgPath'];
    desc[0].innerText = jo_hyul['category'];
    desc[1].innerText = jo_hyul['hyulName'];
    desc[2].innerText = jo_hyul['hyulPos'];
    desc[3].innerText = jo_hyul['hyulSelect'];
    desc[4].innerText = jo_hyul['wayToChim'];
    desc[5].innerText = jo_hyul['hyulEffect'];
}