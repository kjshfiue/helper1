package com.helper.service;
import java.util.List;
import com.helper.entity.StockInDetail;

public interface StockInDetailService {
	
	public List<StockInDetail> findDatailByInCode(String inCode);
}
