DROP TABLE member;
purge recyclebin;

CREATE TABLE member (
    mem_id varchar2(20) PRIMARY KEY,
    mem_pw varchar2(200),
    mem_name varchar2(10),
    mem_email varchar2(60),
    mem_gender varchar2(6),
    mem_birth varchar2(8)
);