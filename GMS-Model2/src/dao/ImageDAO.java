package dao;

import java.util.Map;

import domain.ImageBean;

public interface ImageDAO {
	public void insert(Map<?,?> param);
	public ImageBean selectOne(Map<?,?> param);
}
