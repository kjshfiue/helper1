package com.helper.service;

import java.util.HashMap;

import com.helper.entity.PageBean;
import com.helper.entity.StockIn;

public interface StockInService {
	
	public int insertStockIn(StockIn stockin);
	public int deleteStockIn(String code);
	public StockIn findAllStockIn();
	public StockIn findStockIn(String code);
	public int updateStockIn(String code);
	public PageBean searchPageBean(int pageNo,int pageSize,HashMap<String,String> map);
}
