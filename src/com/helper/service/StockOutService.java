package com.helper.service;

import com.helper.entity.StockOut;

public interface StockOutService {
	public int insertStockOut(StockOut stockOut);
	public int deleteStockOut(String code);
	public StockOut findAllStockOut(StockOut stockOut);
	public int updateStockOut(String code);
}
