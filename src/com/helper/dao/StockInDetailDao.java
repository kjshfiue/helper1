package com.helper.dao;

import java.util.List;


import com.helper.entity.StockInDetail;

public interface StockInDetailDao {
	
	public List<StockInDetail> findDatailByInCode(String inCode);
}
