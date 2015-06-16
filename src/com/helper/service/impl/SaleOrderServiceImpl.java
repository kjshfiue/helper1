package com.helper.service.impl;

import java.util.List;

import java.util.Map;

import com.helper.dao.SaleOrderDao;
import com.helper.dao.impl.SaleOrderDaoImpl;
import com.helper.entity.PageBean;
import com.helper.entity.SaleOrder;
import com.helper.entity.SaleOrderDetail;
import com.helper.service.SaleOrderService;


public class SaleOrderServiceImpl implements SaleOrderService {
	private SaleOrderDao saleOrderDao = new SaleOrderDaoImpl();

	@Override
	public PageBean findSaleOrder(int pageNo, int pageSize, Map<String, String> map) {
		// TODO Auto-generated method stub
		return saleOrderDao.findSaleOrder(pageNo,pageSize,map);
		
	}

	@Override
	public int addSaleOrder(SaleOrder s) {
		// TODO Auto-generated method stub
		return saleOrderDao.addSaleOrder(s);
		
	}

	@Override
	public int deleteByCode(String code) {
		// TODO Auto-generated method stub
		return saleOrderDao.deleteByCode(code);
	}

	@Override
	public int deleteBatchByCode(List<String> codeList) {
		// TODO Auto-generated method stub
		return saleOrderDao.deleteBatchByCode(codeList);
	}

	@Override
	public int updateByCode(String code,SaleOrder s) {
		// TODO Auto-generated method stub
		return saleOrderDao.updateByCode(code,s);
	}

	@Override
	public List<SaleOrderDetail> findDatailByCode(String code) {
		// TODO Auto-generated method stub
		return saleOrderDao.findDatailByCode(code);
	}
	

}
