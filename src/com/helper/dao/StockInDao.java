package com.helper.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.helper.entity.PageBean;
import com.helper.entity.StockIn;

public interface StockInDao {
	
	public int insert(StockIn stockIn);
	public int delete (String code);
	public StockIn findAll();
	public StockIn findById(String code);
	public int update(String code,StockIn stockIn);
	public PageBean searchPageBean(int pageNo,int pageSize,HashMap<String,String> map);
	public List<Map<String,Object>> find(HashMap<String,String> map);
}
