-- account
-- money(decimal),  account_seq(decial), account_num, 
-- account_type, create_date, limit
-- 시퀀스를 이렇게 주면 자동으로 1씩 증가하게 할 수 있음
CREATE SEQUENCE account_seq START WITH 1000;

CREATE TABLE account(
	account_seq DECIMAL PRIMARY KEY,
	account_num VARCHAR2(20),
	account_type VARCHAR2(20),
	create_date DATE,
	money DECIMAL,
	limit DECIMAL
);

INSERT INTO account VALUES(
	account_seq.nextval, '123-456-789', '일반통장', SYSDATE, 0, 0
);

INSERT INTO account(
 account_seq, account_num, account_type, create_date, money, limit
) 
VALUES(
	account_seq.nextval, '125-222-222', '일반통장', SYSDATE, 1000, 0
);

INSERT INTO account(
 account_seq, account_num, account_type, create_date, money, limit
) 
VALUES(
	account_seq.nextval, '125-300-000', '일반통장', SYSDATE, 2000, 0
);

INSERT INTO account(
 account_seq, account_num, account_type, create_date, money, limit
) 
VALUES(
	account_seq.nextval, '125-300-001', '일반통장', SYSDATE, 3000, 0
);

INSERT INTO account(
 account_seq, account_num, account_type, create_date, money, limit
) 
VALUES(
	account_seq.nextval, '125-300-002', '일반통장', SYSDATE, 2000, 0
);

INSERT INTO account(
 account_seq, account_num, account_type, create_date, money, limit
) 
VALUES(
	account_seq.nextval, '125-300-003', '일반통장', SYSDATE, 1000, 0
);

INSERT INTO account(
 account_seq, account_num, account_type, create_date, money, limit
) 
VALUES(
	account_seq.nextval, '125-300-004', '일반통장', SYSDATE, 7000, 0
);

INSERT INTO account(
 account_seq, account_num, account_type, create_date, money, limit
) 
VALUES(
	account_seq.nextval, '125-300-005', '일반통장', SYSDATE, 6000, 0
);

INSERT INTO account(
 account_seq, account_num, account_type, create_date, money, limit
) 
VALUES(
	account_seq.nextval, '125-300-006', '일반통장', SYSDATE, 3000, 0
);

INSERT INTO account(
 account_seq, account_num, account_type, create_date, money, limit
) 
VALUES(
	account_seq.nextval, '125-300-007', '일반통장', SYSDATE, 2000, 0
);


DROP TABLE account;
SELECT * FROM account;
SELECT * FROM TAB;

