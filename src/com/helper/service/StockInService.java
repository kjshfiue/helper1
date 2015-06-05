package com.helper.service;

import com.helper.entity.StockIn;

public interface StockInService {
	
	public int insertStockIn(StockIn stockin);
	public int deleteStockIn(String code);
	public StockIn findAllStockIn();
	public StockIn findStockIn(String code);
	public int updateStockIn(String code);
}
