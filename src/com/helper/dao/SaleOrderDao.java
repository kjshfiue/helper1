package com.helper.dao;

import java.util.List;
import java.util.Map;

import com.helper.entity.PageBean;
import com.helper.entity.SaleOrder;
import com.helper.entity.SaleOrderDetail;

public interface SaleOrderDao {
	
	public PageBean findSaleOrder(int pageNo,int pageSize,Map<String,String> map);
	public List<SaleOrderDetail> findDatailByCode(String code);
	public int addSaleOrder(SaleOrder s);
	public int deleteByCode(String code);
	public int deleteBatchByCode(List<String> codeList);
	public int updateByCode(String code,SaleOrder s);
}
