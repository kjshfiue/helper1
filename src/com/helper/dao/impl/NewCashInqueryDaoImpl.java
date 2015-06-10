package com.helper.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.helper.dao.BaseDao;
import com.helper.entity.NewCashInquery;

public class NewCashInqueryDaoImpl extends BaseDao {
	public List<NewCashInquery> findCashInquery(String code,int first,int second){
		String sql="select * from purchaseorder_detail ord join purchaseinquery que on ord.xcode=que.code join baseparts bas on bas.partscode=ord.pcode where dcode="+code;
		List<NewCashInquery> list=new ArrayList<NewCashInquery>();
		NewCashInquery nci=null;
		
		ResultSet rs=super.executeQueryForPage(sql,first,second);
		try {
			NewCashInqueryDaoImpl ndi=new NewCashInqueryDaoImpl();
			String price=ndi.findNewsPrice(code);
			while(rs.next()){
				nci=new NewCashInquery();
				nci.setLastPrice(price);
				nci.setdPrice(rs.getString("saleprice"));
				nci.setMarks(rs.getString("remarks"));
				nci.setNum(rs.getString("numsprice"));
				nci.setNumber(rs.getString("nums"));
				nci.setPjBrand(rs.getString("PARTSBRAND"));
				nci.setPjCode(rs.getString("PARTSCODE"));
				nci.setPjName(rs.getString("PARTSNAME"));
				nci.setPjXinghao(rs.getString("PARTSMODEL"));
				nci.setXunCode(rs.getString("code"));
				list.add(nci);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	public String findNewsPrice(String code){
		String sql="select bas.SALEPRICE from purchaseorder_detail ord join purchaseinquery que on ord.xcode=que.code join baseparts bas on bas.partscode=ord.pcode where dcode="+code;
		ResultSet rs=super.executeQuery(sql);
		String price=null;
		try {
			while(rs.next()){
				price=rs.getString("saleprice");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return price;
		}

}
