create table image
(
  key NUMBER(38),
  path VARCHAR2(4000),
  title VARCHAR2(4000),
  content VARCHAR2(4000),
  thumnail VARCHAR2(4000),
  detail VARCHAR2(4000),
  price VARCHAR2(4000),
  hits VARCHAR2(4000)  
);

create table contact_information (
  name varchar2(40) not null primary key,
  mail varchar2(60) not null,
  message varchar2(4000) not null
);

create table subscribe (
  no number primary key,
  submail varchar2(60) not null
);

create table member ( 
id VARCHAR2(30) primary key,
pw VARCHAR2(30) not null,
phone VARCHAR2(50) not null,
address VARCHAR2(200) not null,
gender number not null,
name VARCHAR2(30) not null,
email VARCHAR2(100) not null,
member_date date default sysdate
);


create table searchData(
key NUMBER,
countryCode VARCHAR2(4000),
latitude VARCHAR2(4000),
longitude VARCHAR2(4000),
toName VARCHAR2(4000),
title VARCHAR2(4000),
content VARCHAR2(4000),
hits NUMBER
);

create table imageList(
toName VARCHAR2(4000),
countryCode VARCHAR2(4000),
imageName VARCHAR2(4000)
);

create sequence searchData_SEQ;
create sequence imageList_SEQ;

create sequence subscribe_seq; 
create sequence image_SEQ;

insert into SEARCHDATA values(searchdata_seq.nextval,'CN','37.09024','-95.71289100000001','중국', 'China', 'Welcome.', 0);
insert into SEARCHDATA values(searchdata_seq.nextval,'US','35.86166','104.19539699999996','미국', 'United States', 'Welcome', 0);
insert into SEARCHDATA values(searchdata_seq.nextval,'VN','14.058324','108.277199','베트남','Vietnam', 'Welcome', 0);
insert into SEARCHDATA values(searchdata_seq.nextval,'ES','40.46366700000001','-3.7492200000000366','스페인', 'Spain','Welcome', 0);
insert into SEARCHDATA values(searchdata_seq.nextval,'GB','55.378051','-3.43597299999999','영국', 'United Kingdom','Welcome', 0);
insert into SEARCHDATA values(searchdata_seq.nextval,'JP','36.204824','경도','일본', 'Japan','Welcome', 0);

insert into IMAGELIST values('중국','CN','중국1.jpg');
insert into IMAGELIST values('중국','CN','중국2.jpg');
insert into IMAGELIST values('중국','CN','중국3.jpg');
insert into IMAGELIST values('중국','CN','중국4.jpg');

insert into IMAGELIST values('미국','US','미국1.jpg');
insert into IMAGELIST values('미국','US','미국2.jpg');
insert into IMAGELIST values('미국','US','미국3.jpg');
insert into IMAGELIST values('미국','US','미국4.jpg');

insert into IMAGELIST values('베트남','VN','베트남1.jpg');
insert into IMAGELIST values('베트남','VN','베트남2.jpg');
insert into IMAGELIST values('베트남','VN','베트남3.jpg');
insert into IMAGELIST values('베트남','VN','베트남4.jpg');

insert into IMAGELIST values('스페인','ES','스페인1.jpg');
insert into IMAGELIST values('스페인','ES','스페인2.jpg');
insert into IMAGELIST values('스페인','ES','스페인3.jpg');
insert into IMAGELIST values('스페인','ES','스페인4.jpg');

insert into IMAGELIST values('영국','GB','영국1.jpg');
insert into IMAGELIST values('영국','GB','영국2.jpg');
insert into IMAGELIST values('영국','GB','영국3.jpg');
insert into IMAGELIST values('영국','GB','영국4.jpg');

insert into IMAGELIST values('일본','JP','일본1.jpg');
insert into IMAGELIST values('일본','JP','일본2.jpg');
insert into IMAGELIST values('일본','JP','일본3.jpg');
insert into IMAGELIST values('일본','JP','일본4.jpg');



