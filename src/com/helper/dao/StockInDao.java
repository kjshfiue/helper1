package com.helper.dao;

import java.util.List;

import com.helper.dao.impl.PageBean;
import com.helper.entity.CustomerLink;
import com.helper.entity.StockIn;

public interface StockInDao {
	
	
	public int insert(StockIn stockin);
	public int delete (String code);
	public StockIn findAll();
	public StockIn findById(String code);
	public int update(StockIn stockIn);
	
}
