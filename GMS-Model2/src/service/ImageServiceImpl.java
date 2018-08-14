package service;

import java.util.Map;

import dao.ImageDAOImpl;
import domain.ImageBean;

public class ImageServiceImpl implements ImageService {
	private static ImageService instance = new ImageServiceImpl();
	private ImageServiceImpl() {}
	public static ImageService getInstance() {return instance;}
	@Override
	public void add(Map<?, ?> param) {
		ImageDAOImpl.getInstance().insert(param);
		
	}

	@Override
	public ImageBean retrieve(Map<?, ?> param) {
		return ImageDAOImpl.getInstance().selectOne(param);
	}

}
