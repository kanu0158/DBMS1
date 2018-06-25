package repositoryImpl;

import java.util.List;

import domain.AccountBean;
import domain.MinusAccountBean;
import repository.AccountDAO;

public class AccountDAOImpl implements AccountDAO {
	public static AccountDAO instance = new AccountDAOImpl();
	public static AccountDAO getInstance() {return instance;}
	private AccountDAOImpl() {}
	@Override
	public void insertAccount(AccountBean account) {
		if(account instanceof AccountBean) {
			System.out.println("daoImpl에 도착한 멤버:"+account);
		}else {
			System.out.println("daoImpl에 도착한 멤버:"+(MinusAccountBean)account);
		}
	}
	@Override
	public List<AccountBean> selectAccountList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AccountBean> selectAccountById(AccountBean account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countAccounts() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateAccount(AccountBean account) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAccount(AccountBean account) {
		// TODO Auto-generated method stub
		
	}

}
