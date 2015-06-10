package com.helper.service;

import java.util.HashMap;

import com.helper.entity.PageBean;
import com.helper.entity.StockOut;

public interface StockOutService {
	public int insertStockOut(StockOut stockOut);
	public int deleteStockOut(String code);
	public StockOut findAllStockOut(StockOut stockOut);
	public int updateStockOut(String code);
	public PageBean searchPageBean(int pageNo,int pageSize,HashMap<String,String> map);
}
