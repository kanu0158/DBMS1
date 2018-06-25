package controller;
import javax.swing.JOptionPane;
import domain.*;
import service.*;
import serviceImpl.*;
public class MemberController {
	private static MemberController instance = new MemberController();
	public static MemberController getInstance() {
		return instance;
	}
	private MemberController() {}
	public void join(UserBean user) {//유저
		System.out.println("=======멤버 컨트롤러 ==========");
		System.out.println("화면(index->register)에서 넘어온 객체:"+user);
		MemberServiceImpl.getInstance().createUser(user);
	}
	public void memberList() {
		MemberBean member = null; 
		//service.list();
	}
	public void findById() {
		MemberBean member = null; 
		member = new MemberBean();
		member.setUid(JOptionPane.showInputDialog("아이디"));
		member.setPass(JOptionPane.showInputDialog("패스워드"));
		//JOptionPane.showMessageDialog(null,service.findById(member));
	}
	public void findByName() {
		MemberBean member = null; 
		//JOptionPane.showMessageDialog(null, service.findByName(JOptionPane.showInputDialog("이름")));
	}
	public void count() {
		MemberBean member = null; 
		//JOptionPane.showMessageDialog(null, service.selectCount());
	}
	public void update() {
		MemberBean member = null; 
		member = new MemberBean();
		member.setUid(JOptionPane.showInputDialog("아이디"));
		member.setPass(JOptionPane.showInputDialog("패스워드")
				+
				"/"
				+
				JOptionPane.showInputDialog("새 패스워드"));
		MemberServiceImpl.getInstance().updatePass(member);
	}
	public void withdrawal() {
		MemberBean member = null; 
		member = new MemberBean();
		member.setUid(JOptionPane.showInputDialog("아이디"));
		member.setPass(JOptionPane.showInputDialog("패스워드")
				+
				"/"
				+
				JOptionPane.showInputDialog("패스워드 확인")
				);
		MemberServiceImpl.getInstance().deleteMember(member);
	}
}
