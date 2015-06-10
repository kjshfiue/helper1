package com.helper.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jxl.write.WriteException;

import com.helper.entity.CashInquery;
import com.helper.entity.PageBean;
import com.helper.entity.Parts;

public interface CashInqueryDao {
	//	按指定条件搜索询价单据信息；
	PageBean  searchPartBySth(int pageNo,int pageSize,HashMap<String, String> map);
    //增加、修改、删除询价单据；
	int addCashInqueryList(CashInquery cashInquery);
	//删除询价单据
	int delCashInqueryList(String code);
	//修改询价单据；
	int updateCashInqueryList(CashInquery cashInquery);
	//获得全部信息---临时替换第一条方法
	PageBean getAllPartInfo(int pageNo,int pageSize);
	//利用JDBC进行批处理操作执行删除
	//int delBatch(String []object);
	//将数据导出为EXCEL形式
	void outputExecle(CashInquery cashInquery) ;
	//将搜索到符合条件的数据全部导出为excel
     List<Map<String,Object>> findAllBCashInquery(HashMap<String, String> map);
     //获得BasePart表中基本数据
     List<Parts> getBasePart(String code);

	
}
