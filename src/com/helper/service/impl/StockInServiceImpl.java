package com.helper.service.impl;

import java.util.HashMap;

import com.helper.dao.StockInDao;
import com.helper.dao.impl.StockInDaoImpl;
import com.helper.entity.PageBean;
import com.helper.entity.StockIn;
import com.helper.service.StockInService;

public class StockInServiceImpl implements StockInService {
	
	StockInDao stockInDao = new StockInDaoImpl();
	@Override
	public int insertStockIn(StockIn stockin) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteStockIn(String code) {
		// TODO Auto-generated method stub
		return stockInDao.delete(code);
	}

	
	@Override
	public int updateStockIn(String code,StockIn stockIn) {
		// TODO Auto-generated method stub
		return stockInDao.update(code,stockIn);
	}

	@Override
	public StockIn findAllStockIn() {
		// TODO Auto-generated method stub
		return stockInDao.findAll();
	}

	@Override
	public StockIn findStockIn(String code) {
		// TODO Auto-generated method stub
		return stockInDao.findById(code);
	}

	@Override
	public PageBean searchPageBean(int pageNo, int pageSize,
			HashMap<String, String> map) {
		// TODO Auto-generated method stub
		return stockInDao.searchPageBean(pageNo, pageSize, map);
	}

}
