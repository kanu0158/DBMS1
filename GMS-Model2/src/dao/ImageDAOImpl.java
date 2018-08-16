package dao;

import java.util.Map;

import domain.ImageBean;
import template.*;

public class ImageDAOImpl implements ImageDAO{
	private static ImageDAO instance = new ImageDAOImpl();
	private ImageDAOImpl() {}
	public static ImageDAO getInstance() {return instance;}
	private QueryTemplate q;
	@Override
	public void insert(Map<?, ?> param) {
		System.out.println("ImageDAOImpl insert메소드 내부");
		q = new AddQuery();
		q.play(param);
	}

	@Override
	public ImageBean selectOne(Map<?, ?> param) {
		System.out.println("ImageDAOImpl selectOne메소드 내부");
		q = new RetrieveQuery();
		q.play(param);
		return (q.getList().isEmpty() == true)?null:(ImageBean) q.getList().get(0);
	}

}
