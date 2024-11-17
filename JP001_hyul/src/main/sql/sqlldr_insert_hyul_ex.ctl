LOAD DATA
CHARACTERSET AL32UTF8
INFILE 'C:\data_update_ex.csv' "str '\r\n'"
APPEND
INTO TABLE HYULMAP
FIELDS TERMINATED BY '|'
TRAILING NULLCOLS
(
  category CHAR(200),
  hyulName CHAR(200),
  hyulPos CHAR(4000),
  hyulSelect CHAR(4000),
  wayToChim CHAR(4000),
  hyulEffect CHAR(1000),
  imgPath CHAR NULLIF imgPath=BLANKS
)