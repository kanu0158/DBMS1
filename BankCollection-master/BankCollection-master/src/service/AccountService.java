package service;

import java.util.*;

import domain.*;

public interface AccountService {
	public void createAccount(AccountBean account);
	public void createMinus(MinusAccountBean minusAccount);
	public AccountBean findAccountById(AccountBean account);
	public void updatePass(AccountBean account);
	public void deleteAccount(AccountBean account);
	
}
