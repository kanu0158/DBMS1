package domain;

public class AccountBean {
	public final static String BANK_NAME = "비트뱅크";
	public final static String ACCOUNT_TYPE = "기본통장";
	public final static String WITHDRAW_SUCCESS = "출금성공";
	public final static String WITHDRAW_FAIL = "잔액부족";
	public final static String DEPOSIT_SUCCESS = "입금성공";
	public final static String DEPOSIT_FAIL = "적합한 입력값이 아님";
	protected int money;// 잔액, 계좌 랜덤
	protected String name, accountNo, uid, pass, accountType, createDate;// uid는 아이디 , createDate는 계좌생성일 블로그에서 오늘날짜 뽑는
																			// 로직 가져다쓰세요.
	// 통장 123-345-678 의 형태가 되도록 코딩 math.random()이용해서
	public void setMoney(int money) {
		this.money = money;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public int getMoney() {
		return money;
	}

	public String getName() {
		return name;
	}
	public String getUid() {
		return uid;
	}
	public String getPass() {
		return pass;
	}

	public String getAccountType() {
		return accountType;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public String getCreateDate() {
		return createDate;
	}

	public String toString() {
		return String.format("%s\n%s\n계좌번호: %s\n이름: %s\n아이디: %s\n비밀번호: %s\n생성일: %s\n잔액: %d\n", BANK_NAME, getAccountType(), getAccountNo(),
				getName(),getUid(),getPass(), getCreateDate(), getMoney());	
	}
}
