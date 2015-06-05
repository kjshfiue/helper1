package com.helper.dao;

import java.util.HashMap;
import java.util.List;


import com.helper.entity.PageBean;
import com.helper.entity.StockIn;

public interface StockInDao {
	
	
	public int insert(StockIn stockin);
	public int delete (String code);
	public StockIn findAll();
	public StockIn findById(String code);
	public int update(StockIn stockIn);
	public PageBean searchPageBean(int pageNo,int pageSize,HashMap<String,String> map);
	
}
