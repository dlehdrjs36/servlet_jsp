CREATE TABLE "BOARD"."MEMBER"  (	
	"ID" VARCHAR2(50 BYTE) NOT NULL ENABLE, 
	"PASSWORD" VARCHAR2(50 BYTE) NOT NULL ENABLE, 
	"NAME" VARCHAR2(50 BYTE), 
	"GENDER" VARCHAR2(10 BYTE), 
	"BIRTHDAY" DATE, 
	"EMAIL" VARCHAR2(100 BYTE), 
	"PHONE_NUM" VARCHAR2(50 BYTE), 
	"ADDR" VARCHAR2(1000 BYTE), 
	"REG_DATE" DATE DEFAULT sysdate, 
	"ADDR_DETAIL" VARCHAR2(1000 BYTE), 
	"ADDR_NUM" VARCHAR2(20 BYTE), 
	 CONSTRAINT "PK_MEMBER" PRIMARY KEY ("ID")
  );

   COMMENT ON COLUMN "BOARD"."MEMBER"."ID" IS '아이디';
   COMMENT ON COLUMN "BOARD"."MEMBER"."PASSWORD" IS '비밀번호';
   COMMENT ON COLUMN "BOARD"."MEMBER"."NAME" IS '이름';
   COMMENT ON COLUMN "BOARD"."MEMBER"."GENDER" IS '성별';
   COMMENT ON COLUMN "BOARD"."MEMBER"."BIRTHDAY" IS '생일';
   COMMENT ON COLUMN "BOARD"."MEMBER"."EMAIL" IS '이메일';
   COMMENT ON COLUMN "BOARD"."MEMBER"."PHONE_NUM" IS '전화번호';
   COMMENT ON COLUMN "BOARD"."MEMBER"."ADDR" IS '주소';
   COMMENT ON COLUMN "BOARD"."MEMBER"."REG_DATE" IS '등록일';
   COMMENT ON COLUMN "BOARD"."MEMBER"."ADDR_DETAIL" IS '상세주소';
   COMMENT ON COLUMN "BOARD"."MEMBER"."ADDR_NUM" IS '우편번호';
   COMMENT ON TABLE "BOARD"."MEMBER"  IS '회원가입';