package controller;

import java.util.List;

import javax.swing.JOptionPane;

import domain.ExamBean;
import domain.MemberBean;
import service.ExamServiceImpl;
import service.MemberServiceImpl;

enum ExamButt {
	EXIT, NAMEMONTH, EXAM;
}
public class ExamController {
	private static ExamController instance = new ExamController();
	public static ExamController getInstance() {return instance;}
	private ExamController() {};
	
	public static void main(String[] args) {
		ExamBean examBean = null;
		MemberBean memberBean = null;
		while(true) {
			switch((ExamButt) JOptionPane.showInputDialog(null, "MAIN PAGE", "SELECT MENU",
					JOptionPane.QUESTION_MESSAGE, null, new ExamButt[] { ExamButt.EXIT, ExamButt.NAMEMONTH,
							ExamButt.EXAM},
					null)) {
			case EXIT:return;
			case NAMEMONTH: // 이름, 월 입력 몇월시험인지 (홍길동,7)
				examBean = new ExamBean();
				memberBean = new MemberBean();
				String[] arr = JOptionPane.showInputDialog("이름/월").split("/");
				examBean.setMonth("7");
				//List<MemberBean> list = MemberServiceImpl.getInstance().findByName(arr[0]);
				/*if(list.size()==0) {
					System.out.println("해당 이름의 학생이 없어요");
				}else if(list.size()==1) {
					examBean.setMemId(list.get(0).getMemId());
				}else {
					System.out.println(list);
				}*/
				examBean.setMemId("저스티스4");
				//ExamServiceImpl.getInstance().createExam(examBean);
				break;
			case EXAM:// 90,80,70,70,80 JAVA,SQL,R,HTML5,PYTHON
				examBean.setScore(JOptionPane.showInputDialog("점수"));
				ExamServiceImpl.getInstance().createExam(examBean);
				break;
			default:break;
			}
		}
	}
	
}
