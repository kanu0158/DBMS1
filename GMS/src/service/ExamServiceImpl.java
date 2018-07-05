package service;

import java.util.List;

import dao.ExamDAO;
import dao.ExamDAOImple;
import domain.ExamBean;

public class ExamServiceImpl implements ExamService{
	private static ExamService instance = new ExamServiceImpl();
	public static ExamService getInstance() {return instance;}
	private ExamServiceImpl() {}
	@Override
	public void createExam(ExamBean examBean) {
		ExamDAOImple.getInstance().insertExam(examBean);
	}
	@Override
	public List<ExamBean> findByAll() {
		// TODO Auto-generated method stub
		return ExamDAOImple.getInstance().selectExamList();
	};
	@Override
	public List<ExamBean> findBySome(String word) {
		// TODO Auto-generated method stub
		return ExamDAOImple.getInstance().selectExamSome(word);
	}
	@Override
	public void updateSome(ExamBean examBean) {
		ExamDAOImple.getInstance().updateExam(examBean);
		
	}
	@Override
	public void dropExam(ExamBean examBean) {
		ExamDAOImple.getInstance().deleteExam(examBean);
		
	}
	
	@Override
	public int count() {
		// TODO Auto-generated method stub
		return ExamDAOImple.getInstance().countExam();
	}
	@Override
	public ExamBean findByOne(ExamBean examBean) {
		return ExamDAOImple.getInstance().selectExamOne(examBean);
	}
	
	
}
