package com.helper.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.helper.dao.BaseContentDao;
import com.helper.dao.impl.BaseContentDaoImpl;
import com.helper.entity.BaseContent;
import com.helper.entity.PageBean;
import com.helper.service.BaseContentService;

public class BaseContentServiceImpl implements BaseContentService {
	private BaseContentDao bcDao = new BaseContentDaoImpl();
	@Override
	public int addBaseContent(BaseContent b) {
		// TODO Auto-generated method stub
		return bcDao.addBaseContent(b);
	}

	@Override
	public int deleteByCode(String categorycode, String code) {
		// TODO Auto-generated method stub
		return bcDao.deleteByCode(categorycode, code);
	}

	@Override
	public int updateByCode(String up_categorycode,String up_code,BaseContent b) {
		// TODO Auto-generated method stub
		return bcDao.updateByCode(up_categorycode,up_code,b);
	}

	@Override
	public PageBean findPageBean(int pageNo,int pageSize) {
		// TODO Auto-generated method stub
		return bcDao.findPageBean(pageNo, pageSize);
	}

	@Override
	public List<String> findCategoryCodes() {
		// TODO Auto-generated method stub
		return bcDao.findCategoryCodes();
	}

	@Override
	public int deleteBatchByCode(List<HashMap<String,String>> list) {
		// TODO Auto-generated method stub
		return bcDao.deleteBatchByCode(list);
	}

	@Override
	public PageBean searchPageBean(int pageNo, int pageSize,
			HashMap<String, String> map) {
		// TODO Auto-generated method stub
		return bcDao.searchPageBean(pageNo, pageSize, map);
	}

	@Override
	public List<Map<String,Object>> findAllBaseContent(HashMap<String,String> map) {
		// TODO Auto-generated method stub
		return bcDao.findAllBaseContent(map);
	}

	@Override
	public List<BaseContent> findByCategoryCode(String categorycode) {
		// TODO Auto-generated method stub
		return bcDao.findByCategoryCode(categorycode);
	}

}
