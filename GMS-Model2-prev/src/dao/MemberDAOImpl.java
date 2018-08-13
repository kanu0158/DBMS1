package dao;

import java.util.*;
import domain.*;
import enums.Action;
import enums.Domain;
import enums.MemberQuery;
import template.ColumnFinder;
import template.QueryTemplate;
import template.SearchQuery;

public class MemberDAOImpl implements MemberDAO {
	private static MemberDAO instance = new MemberDAOImpl();
	public static MemberDAO getInstance() {return instance;}
	private MemberDAOImpl() {}
	private QueryTemplate q;
	@Override
	public void insert(MemberBean memberBean) {
		
	}
	@Override
	public List<MemberBean> selectSome(Map<?, ?> param) {
		System.out.println("dao selectSome메소드 내부 beginRow, endRow :" + param.get("beginRow") + " ," + param.get("endRow"));
		List<MemberBean> list = new ArrayList<>();
		q = new SearchQuery();
		q.play(param);
		for(Object s: q.getList()) {
			list.add((MemberBean)s);
		}
		System.out.println("dao selectList메소드 내부 list : "+list);
		return list;
	}
	@Override
	public MemberBean selectOne(String userid) {
		return null;
	}
	@Override
	public int count() {
		return 81;
	}
	@Override
	public void update(Map<?, ?> param) {
		
	}
	@Override
	public void delete(MemberBean memberBean) {
		
	}
	@Override
	public MemberBean login(MemberBean memberBean) {
		return null;
	}
}
