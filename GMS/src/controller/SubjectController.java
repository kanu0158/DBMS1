package controller;

import javax.swing.JOptionPane;

import dao.ExamDAOImple;
import domain.ExamBean;
import domain.MemberBean;
import service.ExamServiceImpl;
import service.MemberServiceImpl;

enum SubjectButt {
	EXIT, NAMEMONTH, EXAM;
}
public class SubjectController {
	private static SubjectController instance = new SubjectController();
	public static SubjectController getInstance() {return instance;}
	private SubjectController() {};
	
	public static void main(String[] args) {
		ExamBean examBean;
		while(true) {
			switch((SubjectButt) JOptionPane.showInputDialog(null, "MAIN PAGE", "SELECT MENU",
					JOptionPane.QUESTION_MESSAGE, null, new SubjectButt[] { SubjectButt.EXIT, SubjectButt.NAMEMONTH,
							SubjectButt.EXAM},
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
