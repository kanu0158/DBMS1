package controller;
import java.util.List;

import javax.swing.JOptionPane;
import domain.*;
import service.*;
import serviceImpl.*;


public class AdminController {
	private static AdminController instance = new AdminController();
	public static AdminController getInstance() {return instance;}
	private AdminController() {};
	public void add(StaffBean staff) {//직원
		AdminService service = new AdminServiceImpl();
		System.out.println("=======어드민 컨트롤러 ==========");
		System.out.println("화면에서 넘어온 객체:"+staff);
		service.createStaff(staff);
		//service.createStaff((StaffBean) member);
	}
	public List<MemberBean> memberList(){
		return null;
	}
	public List<MemberBean> findMemberByName(String param){
		return null;
		
	}
	public MemberBean findMemberById(MemberBean member) {
		return member;
		
	}
	public List<AccountBean> accountList(){
		return null;
		
	}
	public List<AccountBean> findAccountByName(String name){
		return null;
	}
}
