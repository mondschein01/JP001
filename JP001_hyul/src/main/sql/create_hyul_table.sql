CREATE TABLE hyul (
	category nvarchar2(200),
	hyulName nvarchar2(200) PRIMARY KEY,
	hyulPos NCLOB,
	hyulSelect NCLOB,
	wayToChim NCLOB,
	hyulEffect nvarchar2(1000),
	imgPath varchar2(1000)
);
