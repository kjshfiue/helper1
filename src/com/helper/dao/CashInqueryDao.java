package com.helper.dao;

import java.util.HashMap;
import java.util.List;

import com.helper.entity.CashInquery;
import com.helper.entity.PageBean;

public interface CashInqueryDao {
	//	按指定条件搜索询价单据信息；
	PageBean  searchPartBySth(int pageNo,int pageSize,HashMap<String,String> map);
    //增加、修改、删除询价单据；
	int addCashInqueryList(CashInquery cashInquery);
	//删除询价单据
	int delCashInqueryList(String code);
	//修改询价单据；
	int updateCashInqueryList(CashInquery cashInquery);
	//获得全部信息---临时替换第一条方法
	PageBean getAllPartInfo(int pageNo,int pageSize);
	
	
}
