let el_boardParent;

function mInit() {
    document.querySelector("tableParent");
}

function createTable() {
    /*
    // 게시판 리스트 (Select)

    0) 메뉴에서 게시판을 누르면,
    1) /board << 여기로 이동
    2) BoardController 실행 (read = Get 요청)
    3) BoardService에서 
    4) BoardDAO를 이용해서 (SELECT * FROM t_board;)
    5) BoardDTO를 통해
    6) ArrayList<BoardDTO>를 받아온다.

    7) boardService에서 createBoard 메소드가 페이지네이션 등 전부 작업 후 return
    8) BoardController가 return JSON을 디스패처리퀘스트에 담아서 /jsp/board.jsp로 이동

    9) 자바스크립트가 테이블 생성

    // 게시글 읽기 (Read) | board-read.jsp
    0) 리스트에서 게시글 중 하나를 클릭하면 (read = Get 요청)
    1) List를 생성할 때 <td><a></a><td> 구조로 히면 페이지 이동이니까...
    2) 게시글 번호 (pk)를 Get 방식으로 /board/read로 쏘면
    3) BoardController가 Service를 통해 ArrayList<BoardDTO>를 Json으로 받은 뒤
    4) /jsp/board-read.jsp로 forward
    5) /jsp/board-read.jsp에서 request 안의 json 데이터를 get해서 JavaScript로 페이지 구현
    6) 관리자 계정일 때에는  q


    // 게시글 쓰기 (Create) | board-write.jsp 에서 write
    
    // 게시글 수정 (Update) | board-write.jsp 에서 update
    0) board-write.jsp 에서
    1) 관리자 계정일 때,
    2) 삭제 버튼을 누르면
    3) Javascript를 통해 비밀번호를 입력 받고,
    4) 비밀번호가 일치하면,
    5) /board 로 게시글 번호를 담아서 delete 요청을 보낸다
    6) BoardController는 /delete 요청이 들어오면
    7) Service를 통해 DB 안의 해당 data row를 삭제


    // 게시글 삭제 (Delete) 
    0) board-read.jsp 에서
    1) 관리자 계정일 때,
    2) 삭제 버튼을 누르면
    3) Javascript를 통해 비밀번호를 입력 받고,
    4) 비밀번호가 일치하면,
    5) /board 로 게시글 번호를 담아서 delete 요청을 보낸다
    6) BoardController는 /delete 요청이 들어오면
    7) Service를 통해 DB 안의 해당 data row를 삭제

    게시판 리스트
    게시판 쓰기(수정)
    게시판 읽기
    게시판 삭제
    
    */
}