package controller;

import javax.swing.JOptionPane;

import dao.ExamDAOImple;
import domain.ExamBean;
import domain.MemberBean;
import service.ExamServiceImpl;
import service.MemberServiceImpl;

enum MemberButt {
	EXIT, NAMEMONTH, EXAM;
}
public class MemberController {
	private static MemberController instance = new MemberController();
	public static MemberController getInstance() {return instance;}
	private MemberController() {};
	
	public static void main(String[] args) {
		ExamBean examBean;
		while(true) {
			switch((MemberButt) JOptionPane.showInputDialog(null, "MAIN PAGE", "SELECT MENU",
					JOptionPane.QUESTION_MESSAGE, null, new MemberButt[] { MemberButt.EXIT, MemberButt.NAMEMONTH,
							MemberButt.EXAM},
					null)) {
			case EXIT:return;
			case NAMEMONTH: // 이름, 월 입력 몇월시험인지 (홍길동,7)
				examBean = new ExamBean();
				examBean.setMemId(JOptionPane.showInputDialog("이름"));
				examBean.setMonth(JOptionPane.showInputDialog("월"));
				ExamServiceImpl.getInstance().createExam(examBean);
				break;
			case EXAM:// 90,80,70,70,80 JAVA,SQL,R,HTML5,PYTHON
				examBean = new ExamBean();
				examBean.setScore(JOptionPane.showInputDialog("점수"));
				ExamServiceImpl.getInstance().createExam(examBean);
				break;
			default:break;
			}
		}
	}
	
}
