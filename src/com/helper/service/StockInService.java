package com.helper.service;

import java.util.HashMap;

import com.helper.entity.PageBean;
import com.helper.entity.StockIn;

public interface StockInService {
	
	public int insertStockIn(StockIn stockIn);
	public int deleteStockIn(String code);
	public StockIn findAllStockIn();
	public StockIn findStockIn(String code);
	public int updateStockIn(String code,StockIn stockIn);
	public PageBean searchPageBean(int pageNo,int pageSize,HashMap<String,String> map);
}
