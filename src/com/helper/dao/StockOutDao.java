package com.helper.dao;

import java.util.HashMap;

import com.helper.entity.PageBean;
import com.helper.entity.StockOut;

public interface StockOutDao {
	public int insert(StockOut stockOut);
	public int delete (String code);
	public StockOut findAll(StockOut stockOut);
	public int update(String code);
	public PageBean searchPageBean(int pageNo,int pageSize,HashMap<String,String> map);
}
