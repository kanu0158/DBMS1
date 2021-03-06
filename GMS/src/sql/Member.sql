select * from tab;
-- member 
-- userid,password,name,ssn,regidate,addr_seq,phone,email,profile,
-- access_num, credit_rating
ALTER TABLE member ADD CONSTRAINT address_fk_address_seq FOREIGN KEY (address_seq) REFERENCES address(address_seq);
ALTER TABLE member ADD CONSTRAINT account_fk_account_seq FOREIGN KEY (account_seq) REFERENCES account(account_seq);
CREATE TABLE member(
	userid VARCHAR2(20) CONSTRAINT member_pk_userid PRIMARY KEY,
	password VARCHAR2(20),
	name VARCHAR2(20),
	ssn VARCHAR2(8),
	regidate DATE,
	phone VARCHAR2(13),
	email VARCHAR2(20),
	profile VARCHAR2(15),
	access_num VARCHAR2(8),
	credit_rating DECIMAL,
	address_seq DECIMAL,
	account_seq DECIMAL
);
--userid, password, name, ssn, regidate, phone, email, profile, access_num, credit_rating, addr_seq, account_seq

INSERT INTO member(
	userid, password, name, ssn, regidate,
	phone, email, profile, access_num, credit_rating,
	address_seq, account_seq

) 
VALUES(
	'kim', '1', '김유신', '900101-1', SYSDATE,
	'010-1234-1111', 'kim@test.com', 'kim.jpg', '', 5,
	1000, 1000
);

INSERT INTO member(
	userid, password, name, ssn, regidate,
	phone, email, profile, access_num, credit_rating,
	address_seq, account_seq

) 
VALUES(
	'lee', '1', '이순신', '890101-1', SYSDATE,
	'010-1234-2222', 'lee@test.com', 'lee.jpg', '', 5,
	1001, 1001
);

INSERT INTO member(
	userid, password, name, ssn, regidate,
	phone, email, profile, access_num, credit_rating,
	address_seq, account_seq

) 
VALUES(
	'young', '30', '영심이', '890101-1', SYSDATE,
	'010-3000-3000', 'young@test.com', 'young.jpg', '', 5,
	1002, 1002
);

INSERT INTO member(
	userid, password, name, ssn, regidate,
	phone, email, profile, access_num, credit_rating,
	address_seq, account_seq

) 
VALUES(
	'ill', '31', '일심이', '880101-1', SYSDATE,
	'010-3000-3001', 'ill@test.com', 'ill.jpg', '', 5,
	1003, 1003
);

INSERT INTO member(
	userid, password, name, ssn, regidate,
	phone, email, profile, access_num, credit_rating,
	address_seq, account_seq

) 
VALUES(
	'chu', '32', '추심이', '870101-1', SYSDATE,
	'010-3000-3002', 'chu@test.com', 'chu.jpg', '', 5,
	1004, 1004
);

INSERT INTO member(
	userid, password, name, ssn, regidate,
	phone, email, profile, access_num, credit_rating,
	address_seq, account_seq

) 
VALUES(
	'sam', '33', '삼심이', '870101-1', SYSDATE,
	'010-3000-3003', 'sam@test.com', 'sam.jpg', '', 5,
	1005, 1005
);

INSERT INTO member(
	userid, password, name, ssn, regidate,
	phone, email, profile, access_num, credit_rating,
	address_seq, account_seq

) 
VALUES(
	'sa', '34', '사심이', '790101-1', SYSDATE,
	'010-3000-3004', 'sa@test.com', 'sa.jpg', '', 5,
	1006, 1006
);

INSERT INTO member(
	userid, password, name, ssn, regidate,
	phone, email, profile, access_num, credit_rating,
	address_seq, account_seq

) 
VALUES(
	'oh', '35', '오심이', '780101-1', SYSDATE,
	'010-3000-3005', 'oh@test.com', 'oh.jpg', '', 5,
	1007, 1007
);

INSERT INTO member(
	userid, password, name, ssn, regidate,
	phone, email, profile, access_num, credit_rating,
	address_seq, account_seq

) 
VALUES(
	'youk', '36', '육심이', '770101-1', SYSDATE,
	'010-3000-3006', 'youk@test.com', 'youk.jpg', '', 5,
	1008, 1008
);

INSERT INTO member(
	userid, password, name, ssn, regidate,
	phone, email, profile, access_num, credit_rating,
	address_seq, account_seq

) 
VALUES(
	'chil', '37', '칠심이', '760101-1', SYSDATE,
	'010-3000-3007', 'chil@test.com', 'chil.jpg', '', 5,
	1009, 1009
);

DESC memeber;
SELECT * FROM member;
-- 조인 JOIN
SELECT * FROM member, account
WHERE member.account_seq = account.account_seq
AND member.userid = 'kim'
;

SELECT * FROM member, account
WHERE member.account_seq = account.account_seq
AND member.userid = 'chu'
;

SELECT userid, name, account_num, city, province 
FROM member m, account ac, address ad
WHERE m.account_seq = ac.account_seq
AND m.account_seq = ad.address_seq
AND m.userid = 'sa'
;

SELECT userid, name, account_num, city, province 
FROM member m, account ac, address ad
WHERE m.account_seq = ac.account_seq
AND m.address_seq = ad.address_seq
AND m.userid = 'oh'
;

DROP TABLE member;
