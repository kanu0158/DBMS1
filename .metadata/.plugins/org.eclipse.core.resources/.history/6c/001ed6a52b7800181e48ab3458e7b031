package domain;

public class MinusAccountBean extends AccountBean {
	public final static String ACCOUNT_TYPE="마이너스통장";
	protected String limit;
	@Override
	public void setAccountType(String accountType) {
		super.setAccountType(accountType);
	}
	public void setLimit(String limit) {
		this.limit = limit;
	}
	public String getLimit() {
		return limit;
	}
	@Override
	public String toString() {
		return String.format("%s\n%s\n계좌번호: %s\n이름: %s\n아이디: %s\n비밀번호: ****\n생성일: %s\n잔액: %d\n한도: %s\n", BANK_NAME, getAccountType(), getAccountNo(),
				getName(),getUid(), getCreateDate(), getMoney(),getLimit());	
	}

}
