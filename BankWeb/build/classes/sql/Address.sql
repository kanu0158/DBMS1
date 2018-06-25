-- address
-- addr_seq (DECIMAL, pk)
-- zipcode
-- province 경기도
-- city 서울시, 안양시
-- gugun 강남구, 가평군
-- doro 백범로 15번길
CREATE SEQUENCE address_seq START WITH 1000;
CREATE TABLE address(
	address_seq DECIMAL PRIMARY KEY,
	zipcode VARCHAR2(20),
	province VARCHAR2(20),
	city VARCHAR2(20),
	gugun VARCHAR2(20),
	doro VARCHAR2(20)
);
INSERT INTO address(
	address_seq, zipcode, province, city, gugun, doro
)
VALUES(
	address_seq.nextval,'11111','','서울시','강남구','백범로 15번길'
);

INSERT INTO address(
	address_seq, zipcode, province, city, gugun, doro
)
VALUES(
	address_seq.nextval,'22222','경기도','','가평','가평로 1번길'
);

INSERT INTO address(
	address_seq, zipcode, province, city, gugun, doro
)
VALUES(
	address_seq.nextval,'300000','경기도','','판교','판교로 1번길'
);

INSERT INTO address(
	address_seq, zipcode, province, city, gugun, doro
)
VALUES(
	address_seq.nextval,'300001','경기도','','판교','판교로 2번길'
);

INSERT INTO address(
	address_seq, zipcode, province, city, gugun, doro
)
VALUES(
	address_seq.nextval,'300002','경기도','','판교','판교로 3번길'
);

INSERT INTO address(
	address_seq, zipcode, province, city, gugun, doro
)
VALUES(
	address_seq.nextval,'300003','경기도','','판교','판교로 4번길'
);

INSERT INTO address(
	address_seq, zipcode, province, city, gugun, doro
)
VALUES(
	address_seq.nextval,'300004','경기도','','판교','판교로 5번길'
);

INSERT INTO address(
	address_seq, zipcode, province, city, gugun, doro
)
VALUES(
	address_seq.nextval,'300005','경기도','','판교','판교로 6번길'
);

INSERT INTO address(
	address_seq, zipcode, province, city, gugun, doro
)
VALUES(
	address_seq.nextval,'300006','경기도','','판교','판교로 7번길'
);

INSERT INTO address(
	address_seq, zipcode, province, city, gugun, doro
)
VALUES(
	address_seq.nextval,'300007','경기도','','판교','판교로 8번길'
);

DROP TABLE address;
SELECT * FROM address;
