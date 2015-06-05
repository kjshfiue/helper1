package com.helper.dao;

import com.helper.entity.StockOut;

public interface StockOutDao {
	public int insert(StockOut stockOut);
	public int delete (String code);
	public StockOut findAll(StockOut stockOut);
	public int update(String code);
}
