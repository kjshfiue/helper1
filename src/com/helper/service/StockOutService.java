package com.helper.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.helper.entity.PageBean;
import com.helper.entity.StockIn;
import com.helper.entity.StockOut;

public interface StockOutService {
	public int insertStockOut(StockOut stockOut);
	public int deleteStockOut(String code);
	public StockOut findAllStockOut(StockOut stockOut);

	public int updateStockOut(String code,StockOut stockOut);
	public List<Map<String,Object>> findAllStock(HashMap<String, String> map);
	public PageBean searchPageBean(int pageNo,int pageSize,HashMap<String,String> map);
}
