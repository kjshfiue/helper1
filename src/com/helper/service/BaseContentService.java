package com.helper.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.helper.entity.BaseContent;
import com.helper.entity.PageBean;

public interface BaseContentService {
	public int addBaseContent(BaseContent b);
	public int deleteByCode(String categorycode, String code);
	public int deleteBatchByCode(List<HashMap<String,String>> list);
	public int updateByCode(String up_categorycode,String up_code,BaseContent b);
	public PageBean findPageBean(int pageNo,int pageSize);
	public PageBean searchPageBean(int pageNo,int pageSize,HashMap<String,String> map);
	public List<String> findCategoryCodes();
	public List<Map<String,Object>> findAllBaseContent(HashMap<String, String> map);
}
