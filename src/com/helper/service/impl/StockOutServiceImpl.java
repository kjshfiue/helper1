package com.helper.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.helper.dao.StockOutDao;
import com.helper.dao.impl.StockOutDaoImpl;
import com.helper.entity.PageBean;
import com.helper.entity.StockOut;
import com.helper.service.StockOutService;

public class StockOutServiceImpl implements StockOutService {
	
	StockOutDao stockOutDao = new StockOutDaoImpl();
	@Override
	public int insertStockOut(StockOut stockOut) {
		// TODO Auto-generated method stub
		return stockOutDao.insert(stockOut);
	}

	@Override
	public int deleteStockOut(String code) {
		// TODO Auto-generated method stub
		return stockOutDao.delete(code);
	}

	@Override
	public StockOut findAllStockOut(StockOut stockOut) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateStockOut(String code,StockOut stockOut) {
		// TODO Auto-generated method stub
		return stockOutDao.update(code,stockOut);
	}

	@Override
	public PageBean searchPageBean(int pageNo, int pageSize,
			HashMap<String, String> map) {
		// TODO Auto-generated method stub
		return stockOutDao.searchPageBean(pageNo, pageSize, map);
	}

	@Override
	public List<Map<String, Object>> findAllStock(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		return stockOutDao.find(map);
	}

}
