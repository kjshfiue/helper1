package com.helper.service.impl;

import java.util.List;

import com.helper.dao.StockInDetailDao;
import com.helper.dao.impl.StockInDetailDaoImpl;
import com.helper.entity.StockInDetail;
import com.helper.service.StockInDetailService;

public class StockInDetailServiceImpl implements StockInDetailService{
	StockInDetailDao stockInDetailDao = new StockInDetailDaoImpl();
	@Override
	public List<StockInDetail> findDatailByInCode(String inCode) {
		// TODO Auto-generated method stub
		return stockInDetailDao.findDatailByInCode(inCode);
	}

}
