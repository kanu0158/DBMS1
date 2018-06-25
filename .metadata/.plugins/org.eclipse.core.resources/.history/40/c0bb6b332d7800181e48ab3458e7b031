package serviceImpl;

import java.util.*;
import controller.*;
import domain.*;
import repositoryImpl.*;
import service.*;

public class AccountServiceImpl implements AccountService{
	private static AccountService instance = new AccountServiceImpl();
	public static AccountService getInstance() {return instance;}
	private AccountServiceImpl() {};
	@Override
	public void createAccount(AccountBean account) {
		System.out.println("=======멤버 서비스 ==========");
		System.out.println("컨트롤러에서 넘어온 객체:"+account);
		account.setAccountType("기본통장");
		account.setCreateDate(AdminServiceImpl.getInstance().createDate());
		account.setAccountNo(AdminServiceImpl.getInstance().createAccountNo());
		AccountDAOImpl.getInstance().insertAccount(account);
	}
	@Override
	public void createMinus(MinusAccountBean minusAccount) {
		System.out.println("=======멤버 서비스 ==========");
		System.out.println("컨트롤러에서 넘어온 객체:"+minusAccount);
		minusAccount.setAccountType("마이너스통장");
		minusAccount.setCreateDate(AdminServiceImpl.getInstance().createDate());
		minusAccount.setAccountNo(AdminServiceImpl.getInstance().createAccountNo());
		AccountDAOImpl.getInstance().insertAccount(minusAccount);
	}
	@Override
	public AccountBean findAccountById(AccountBean account) {
		AccountBean temp = new AccountBean();
		String uid = account.getUid();
		String pass = account.getPass();
		//temp = AccountDAOImpl.getInstance().get(AccountDAOImpl.getInstance().indexOf(account));
		if(temp == null) {
			System.out.println("null");
		}else if(!temp.getPass().equals(pass)) {
			System.out.println("패스가달라");
		}else {
			System.out.println("찾기완료");
		}
		return temp;
	}
	@Override
	public void updatePass(AccountBean account) {
		String id = account.getUid();
		String newPass = account.getPass().split("/")[1];
		account.setPass(account.getPass().split("/")[0]);
		AccountBean ab = findAccountById(account);
		if(ab == null) {
			System.out.println("없는 아이디입니다.");
		}else {
			ab.setPass(newPass);
		}
	}

	@Override
	public void deleteAccount(AccountBean account) {
		AccountBean ab = findAccountById(account);
		/*if(ab == null) {
			System.out.println("없는 아이디");
		}else {
			list.remove(list.indexOf(ab));
		}*/
	}
}
