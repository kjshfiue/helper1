package com.helper.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.helper.entity.PageBean;
import com.helper.entity.StockIn;
import com.helper.entity.StockOut;

public interface StockOutDao {
	public int insert(StockOut stockOut);
	public int delete (String code);
	public StockOut findAll(StockOut stockOut);
	public int update(String code,StockOut stockOut);

	public List<Map<String,Object>> find(HashMap<String,String> map);
	public PageBean searchPageBean(int pageNo,int pageSize,HashMap<String,String> map);
}
