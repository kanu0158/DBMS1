package enums;

import template.ColumnFinder;

/*static String으로 두면 나중에 쿼리가 많아지면 메모리에(상수풀에) 산더미처럼 쌓이게 된다. 그러면 문제가 생길 수 있어
그렇기때문에 static(시작하자마자 미리 땅을 점유하게되므로)으로 하지 말고 enum으로 처리해서 상황끝나면 가비지컬렉터에 의해 처리되도록 한다*/
/*static의 final을 대체하기 위해 enum을 사용한다*/
/*앤트맨처럼 긴 쿼리문을 이넘의 짧은걸로 대체할수있음 속도에선 이넘값으로 호출하니 약간 느릴순있지만 장점이 크기때문에 감수할만 하다*/
public enum ImageQuery {
INSERT,
RETRIEVE
;
@Override
public String toString() {
	String query = "";
	switch (this) {
	case INSERT:
		query = " INSERT INTO IMAGE  "
				+ " ( "
				+ " IMG_SEQ,IMGNAME,EXTENSION,USERID "
				+ " ) "
				+ " VALUES "
				+ " (  IMG_SEQ.NEXTVAL, ?, ?, ? ) ";
		break;
	case RETRIEVE:
		query = "SELECT * "
				+" FROM "
				+" ( "
				+"  SELECT * "
				+ " FROM IMAGE "
				+ " WHERE USERID LIKE ? "
				+ " ORDER BY IMG_SEQ DESC  "
				+" ) "
				+" WHERE ROWNUM = 1 ";
		
		break;
	}
	return query;
}
}