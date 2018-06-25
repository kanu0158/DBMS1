package controller;

import javax.swing.JOptionPane;

import domain.*;
import service.*;
import serviceImpl.*;

public class AccountController {
	private static AccountController instance = new AccountController();
	public static AccountController getInstance() {return instance;}
	private AccountController() {}
	public void account(AccountBean account) {
		AccountServiceImpl.getInstance().createAccount(account);
	}
	public void minusAccount(MinusAccountBean minusAccountBean) {
		AccountServiceImpl.getInstance().createMinus(minusAccountBean);
	}
	public void list() {
		//service.list();
	}
	public void findById() {
		AccountBean acb = new AccountBean();
		acb.setUid(JOptionPane.showInputDialog("id"));
		acb.setPass(JOptionPane.showInputDialog("pass"));
		//JOptionPane.showMessageDialog(null, service.findById(acb));
	}
	public void findByName() {
		//JOptionPane.showMessageDialog(null, service.findByName(JOptionPane.showInputDialog("이름")));
	}
	public void minusList() {
	}
	public void changePass() {
		AccountBean acb = new AccountBean();
		acb.setUid(JOptionPane.showInputDialog("id"));
		acb.setPass(JOptionPane.showInputDialog("pass") + "/" + JOptionPane.showInputDialog("newPass"));
		AccountServiceImpl.getInstance().updatePass(acb);
	}
	public void deleteAccount() {
		AccountBean acb = new AccountBean();
		acb.setUid(JOptionPane.showInputDialog("id"));
		acb.setPass(JOptionPane.showInputDialog("pass"));
		AccountServiceImpl.getInstance().deleteAccount(acb);
	}
}
