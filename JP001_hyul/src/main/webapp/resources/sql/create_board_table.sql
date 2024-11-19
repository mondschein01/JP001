DROP TABLE board;
purge recyclebin;

CREATE TABLE board (
    bd_idx number(38) PRIMARY KEY,
    bd_title varchar2(255),
    bd_writer varchar2(50),
    bd_content CLOB,
    bd_hits number(38),
    bd_regTime DATE DEFAULT SYSDATE
);

CREATE SEQUENCE bd_idx_seq 
INCREMENT BY 1 
START WITH 1 
MINVALUE 1 
MAXVALUE 999999
NOCYCLE
NOCACHE
ORDER;

