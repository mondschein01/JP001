// 수태음폐경
let sAry_lu = [
    '중부(中府)','운문(雲門)','천부(天府)','협백(俠白)','척택(尺澤)','공최(孔最)',
    '열결(列缺)','경거(經渠)','태연(太淵)','어제(魚際)','소상(少商)'
];
// 수양명대장경
let sAry_li = [
    '상양 (商陽)','이간 (二間)','삼간 (三間)','합곡 (合谷)','양계 (陽谿)',
    '편력 (偏歷)','온류 (溫溜)','하렴 (下廉)','상렴 (上廉)','수삼리 (手三里)',
    '곡지 (曲池)','주료 (肘髎)','수오리 (手五里)','비노 (臂臑)','견우 (肩髃)',
    '거골 (巨骨)','천정 (天鼎)','부돌 (扶突)','화료 (禾髎)','영향 (迎香)'
];
// 족양명위경
let sAry_st = [
    '승읍 (承泣)','사백 (四白)','거료 (巨髎)','지창 (地倉)','대영 (大迎)',
    '협거 (頰車)','하관 (下關)','두유 (頭維)','인영 (人迎)','수돌 (水突)',
    '기사 (氣舍)','결분 (缺盆)','기호 (氣戶)','고방 (庫房)','옥예 (屋翳)',
    '응창 (膺窗)','유중 (乳中)','유근 (乳根)','불용 (不容)','승만 (承滿)',
    '양문 (梁門)','관문 (關門)','태을 (太乙)','활육문 (滑肉門)','천추 (天樞)',
    '외릉 (外陵)','대거 (大巨)','수도 (水道)','귀래 (歸來)','기충 (氣衝)',
    '비관 (髀關)','복토 (伏兎)','음시 (陰市)','양구 (梁丘)','독비 (犢鼻)',
    '족삼리 (足三里)','상거허 (上巨虛)','조구 (條口)','하거허 (下巨虛)',
    '풍륭 (豊隆)','해계 (解谿)','충양 (衝陽)','함곡 (陷谷)','내정 (內庭)',
    '여태 (厲兌)'
];
// 족태음비경
let sAry_sp = [
    '은백 (隱白)','대도 (大都)','태백 (太白)','공손 (公孫)','상구 (商丘)',
    '삼음교 (三陰交)','누곡 (漏谷)','지기 (地機)','음릉천 (陰陵泉)',
    '혈해 (血海)','기문 (箕門)','충문 (衝門)','부사 (府舍)','복결 (腹結)',
    '대횡 (大橫)','복애 (腹哀)','식두 (食竇)','천계 (天谿)','흉향 (胸鄕)',
    '주영 (周榮)','대포 (大包)'
];
// 수소음심경
let sAry_ht = [
    '극천(極泉)','청령(青靈)','소해(少海)','영도(靈道)','통리(通里)',
    '음극(陰郄)','신문(神門)','소부(少府)','소충(少衝)'
];
// 수태양소장경
let sAry_si = [
    '소택 (少澤)','전곡 (前谷)','후계 (後谿)','완골 (腕骨)','양곡 (陽谷)',
    '양로 (養老)','지정 (支正)','소해 (小海)','견정 (肩貞)','노수 (臑兪)',
    '천종 (天宗)','병풍 (秉風)','곡원 (曲垣)','견외수 (肩外兪)','견중수 (肩中兪)',
    '천창 (天窓)','천용 (天容)','관료 (顴髎)','청궁 (聽宮)'
];
// 족태양방광경
let sAry_bl = [
    '정명(睛明)','찬죽(攢竹)','미충(眉衝)','곡차(曲差)','오처(五處)',
    '승광(承光)','통천(通天)','낙각(絡却)','옥침(玉枕)','천주(天柱)',
    '대저(大杼)','풍문(風門)','폐유(肺兪)','궐음유(厥陰兪)','심유(心兪)',
    '독유(督兪)','격유(膈兪)','간유(肝兪)','담유(膽兪)','비유(脾兪)',
    '위유(胃兪)','삼초유(三焦兪)','신유(腎兪)','기해유(氣海兪)',
    '대장유(大腸兪)','관원유(關元兪)','소장유(小腸兪)','방광유(膀胱兪)',
    '중려유(中膂兪)','백환유(白環兪)','상료(上髎)','차료(次髎)','중료(中髎)',
    '하료(下髎)','회양(會陽)','승부(承扶)','은문(殷門)','부극(浮郄)',
    '위양(委陽)','위중(委中)','부분(附分)','백호(魄戶)','고황(膏肓)',
    '신당(神堂)','의희(譩譆)','격관(膈關)','혼문(魂門)','양강(陽綱)',
    '의사(意舍)','위창(胃倉)','황문(肓門)','지실(志室)','포황(胞肓)',
    '질변(秩邊)','합양(合陽)','승근(承筋)','승산(承山)','비양(飛揚)',
    '부양(跗陽)','곤륜(崑崙)','복삼(僕參)','신맥(申脈)','금문(金門)',
    '경골(京骨)','속골(束骨)','족통곡(足通谷)','지음(至陰)'
];
// 족소음신경
let sAry_ki = [
    '용천 (湧泉)','연곡 (然谷)','태계 (太谿)','대종 (大鐘)','수천 (水泉)',
    '조해 (照海)','부류 (復溜)','교신 (交信)','축빈 (築賓)','음곡 (陰谷)',
    '횡골 (橫骨)','대혁 (大赫)','기혈 (氣穴)','사만 (四滿)','중주 (中注)',
    '황수 (肓兪)','상곡 (商曲)','석관 (石關)','음도 (陰都)','복통곡 (腹痛谷)',
    '유문 (幽門)','보랑 (步廊)','신봉 (神封)','영허 (靈墟)','신장 (神藏)',
    '욱중 (彧中)','수부 (兪府)'
]
// 수궐음심포경
let sAry_pc = [
    '천지(天池)','천천(天泉)','곡택(曲澤)','극문(郄門)','간사(間使)',
    '내관(內關)','대릉(大陵)','노궁(勞宮)','중충(中衝)'  
]
// 수소양삼초경
let sAry_te = [
    '관충(關衝)','액문(液門)','중저(中渚)','양지(陽池)','외관(外關)',
    '지구(支溝)','회종(會宗)','삼양락(三陽絡)','사독(四瀆)','천정(天井)',
    '청랭연(淸冷淵)','소락(消濼)','노회(臑會)','견료(肩髎)','천료(天髎)',
    '천유(天牖)','예풍(翳風)','계맥(瘈脈)','노식(顱息)','각손(角孫)',
    '이문(耳門)','화료(和髎)','사죽공(絲竹空)'
]
// 족소양담경
let sAry_gb = [
    '동자료(瞳子髎)','청회(聽會)','상관(上關)','함염(頷厭)','현로(懸顱)',
    '현리(懸釐)','곡빈(曲鬢)','솔곡(率谷)','천충(天衝)','부백(浮白)',
    '두규음(頭竅陰)','완골(完骨)','본신(本神)','양백(陽白)','두임읍(頭臨泣)',
    '목창(目窓)','정영(正營)','승령(承靈)','뇌공(腦空)','풍지(風池)',
    '견정(肩井)','연액(淵腋)','첩근(輒筋)','일월(日月)','경문(京門)',
    '대맥(帶脈)','오추(五樞)','유도(維道)','거료(居髎)','환도(環跳)',
    '풍시(風市)','중독(中瀆)','슬양관(膝陽關)','양릉천(陽陵泉)',
    '양교(陽交)','외구(外丘)','광명(光明)','양보(陽輔)','현종(懸鍾)',
    '구허(丘墟)','족임읍(足臨泣)','지오회(地五會)','협계(俠谿)','족규음(足竅陰)'
]
// 족궐음간경
let sAry_lr = [
    '대돈(大敦)','행간(行間)','태충(太衝)','중봉(中封)','여구(蠡溝)',
    '중도(中都)','슬관(膝關)','곡천(曲泉)','음포(陰包)','족오리(足五里)',
    '음렴(陰廉)','급맥(急脈)','장문(章門)','기문(期門)'
]
// 임맥
let sAry_gv = [
    '회음(會陰)','곡골(曲骨)','중극(中極)','관원(關元)','석문(石門)',
    '기해(氣海)','음교(陰交)','신궐(神闕)','수분(水分)','하완(下脘)',
    '건리(建里)','중완(中脘)','상완(上脘)','거궐(巨闕)','구미(鳩尾)',
    '중정(中庭)','단중(膻中)','옥당(玉堂)','자궁(紫宮)','화개(華蓋)',
    '선기(璇璣)','천돌(天突)','염천(廉泉)','승장(承漿)'
]
// 독맥
let sAry_cv = [
    '장강 (長强)','요수 (腰兪)','요양관 (腰陽關)','명문 (命門)','현추 (懸樞)',
    '척중 (脊中)','중추 (中樞)','근축 (筋縮)','지양 (至陽)','영대 (靈臺)',
    '신도 (神道)','신주 (身柱)','도도 (陶道)','대추 (大椎)','아문 (瘂門)',
    '풍부 (風府)','뇌호 (腦戶)','강간 (强間)','후정 (後頂)','백회 (百會)',
    '전정 (前頂)','신회 (顖會)','상성 (上星)','신정 (神庭)','소료 (素髎)',
    '수구 (水溝)','태단 (兌端)','은교 (齦交)'
]
// 경외기혈
let sAry_ex = [
    '사신총 (四神聰)','당양 (當陽)','인당 (印堂)','어요 (魚腰)','태양 (太陽)',
    '이첨 (耳尖)','구후 (球後)','상영향 (上迎香)','내영향 (內迎香)','취천 (聚泉)',
    '해천 (海泉)','금진 (金津)','옥액 (玉液)','예명 (翳明)','백로 (百勞)',
    '자궁 (子宮)','정천 (定喘)','협척 (夾脊)','위완하수 (胃脘下兪)',
    '비근 (痞根)','하극수 (下極兪)','요의 (腰宜)','요안 (腰眼)',
    '십칠추 (十七椎)','요기 (腰奇)','주첨 (肘尖)','이백 (二白)',
    '중천 (中泉)','중괴 (中魁)','대골공 (大骨空)','소골공 (小骨空)',
    '요통점 (腰痛點)','외노궁 (外勞宮)','팔사 (八邪)','사봉 (四縫)',
    '십선 (十宣)','관골 (髖骨)','학정 (鶴頂)','백충와 (百蟲窩)',
    '내슬안 (內膝眼)','슬안 (膝眼)','담낭 (膽囊)','난미 (闌尾)',
    '내과첨 (內踝尖)','외과첨 (外踝尖)','팔풍 (八風)','독음 (獨陰)','기단 (氣端)'
]
// 이침
let sAry_noname1 = [
    '이침 준비 중입니다.'
]
// 족침
let sAry_noname2 = [
    '족침 준비 중입니다.'
    
]
// 수지학
let sAry_noname3 = [
    '수지학 준비 중입니다.'
    
]
// 혈 이름 배열
let sAry_hyuls = [
    '수태음폐경','수양명대장경','족양명위경','족태음비경',
    '수소음심경','수태양소장경','족태양방광경','족소음신경',
    '수궐음심포경','수소양삼초경','족소양담경','족궐음간경',
    '임맥','독맥','경외기혈','이침','족침','수지학'
]
// 혈 이름 배열 객체
let obj_sAry = {
    수태음폐경: sAry_lu, 수양명대장경: sAry_li, 족양명위경: sAry_st, 
    족태음비경: sAry_sp, 수소음심경: sAry_ht, 수태양소장경: sAry_si,
    족태양방광경: sAry_bl, 족소음신경: sAry_ki, 수궐음심포경: sAry_pc, 
    수소양삼초경: sAry_te, 족소양담경: sAry_gb, 족궐음간경: sAry_lr, 
    임맥: sAry_gv, 독맥: sAry_cv, 경외기혈: sAry_ex, 
    이침: sAry_noname1, 족침: sAry_noname2, 수지학: sAry_noname3, 
}

let ary_el_li;
let el_subMenu;
let el_descBox;
let ary_el_subMenu_a;

function mInit() {
    ary_el_li = document.querySelectorAll("#menu li a");
    el_subMenu = document.querySelector("#submenu");
    el_descBox = document.querySelector("#box_desc");

    ary_el_li.forEach((item, idx) => {
        item.addEventListener('click', () => makeSubMenu(item, idx))
    });

    makeSubMenu(ary_el_li[0], 0);
}

// 서브 메뉴 만들기
function makeSubMenu(item, idx) {
    // submenu_a 배열 clear
    ary_el_subMenu_a = [];

    // 기존 서브 메뉴가 있다면 삭제
    if (el_subMenu.firstChild != null) {
        el_subMenu.firstChild.remove();
    }

    // 타겟 배열 지역변수 할당
    let tgAry = obj_sAry[sAry_hyuls[idx]]

    // ul 만들고
    let tmp_el_ul = document.createElement("ul");

    // li 만들고
    for (let i = 0; i < tgAry.length; i++) {
        let tmp_el_a = document.createElement("a");
        let tmp_textNode = document.createTextNode(`${i+1}. ${tgAry[i]}`);
        tmp_el_a.appendChild(tmp_textNode);

        let tmp_el_li = document.createElement("li");
        tmp_el_li.appendChild(tmp_el_a);
        tmp_el_ul.appendChild(tmp_el_li);

        // submenu_a 배열에 a 넣기
        ary_el_subMenu_a.push(tmp_el_a);

        // a에 이벤트 추가하기
        tmp_el_a.addEventListener('click', 
            () => activateSubMenu(tmp_el_a, sAry_hyuls[idx], tgAry[i]));
    }
    
    // 서브메뉴에 ul 추가
    el_subMenu.appendChild(tmp_el_ul);

    // 다른 item 활성화 삭제
    for (let i = 0; i < ary_el_li.length; i++) {
        ary_el_li[i].classList.remove("activate");
    }

    // 클릭한 menu 활성화 효과 주기
    item.classList.add("activate");
	
	
    // 서브 메뉴 활성화
    activateSubMenu(ary_el_subMenu_a[0], sAry_hyuls[idx], tgAry[0]);
}

function activateSubMenu(item, categoryName, hyulName) {
	
    // 다른 item 활성화 삭제
    for (let i = 0; i < ary_el_subMenu_a.length; i++) {
        ary_el_subMenu_a[i].classList.remove("activate");
		
    }

    // 클릭한 menu 활성화 효과 주기
    item.classList.add("activate");

	// ajax 호출	
	dataTrans(categoryName, hyulName);
}

function dataTrans(categoryName, hyulName){
	let xhr = new XMLHttpRequest();
	xhr.open("POST", "./../map", true);
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4 && xhr.status === 200) {
			let jsonRep = JSON.parse(xhr.responseText);
            udpImgAndText(jsonRep);
		}
	}
	
	let data = `cName=${categoryName}&hName=${hyulName}`;
	xhr.send(data);
}

function udpImgAndText(jsonRep){
    let vCategory = jsonRep['category'];
    let vHyulName = jsonRep['hyulName'];
    let vHyulPos = jsonRep['hyulPos'];
    let vHyulSelect = jsonRep['hyulSelect'];
    let vHyulWayToChim = jsonRep['wayToChim'];
    let vHyulEffect = jsonRep['hyulEffect'];
    let vImagPath = jsonRep['imgPath'];
	
    let el_category = el_descBox.children.item(0);
    el_category.innerHTML = vCategory;

    let el_hyulName = el_descBox.children.item(1);
    el_hyulName.innerHTML = vHyulName;
    
    el_descBox.children.item(2).innerHTML = "부위";
    let el_hyulPos = el_descBox.children.item(3);
    el_hyulPos.innerHTML = vHyulPos;

    el_descBox.children.item(4).innerHTML = "취혈";

    let el_hyulSelect = el_descBox.children.item(5);
    el_hyulSelect.innerHTML = vHyulSelect;

    el_descBox.children.item(6).innerHTML = "침구법";

    let el_wayToChim = el_descBox.children.item(7);
    el_wayToChim.innerHTML = vHyulWayToChim;

    el_descBox.children.item(8).innerHTML = "주치증";

    let el_hyulEffect = el_descBox.children.item(9);
    el_hyulEffect.innerHTML = vHyulEffect;

    document.images[0].src = vImagPath;
}