package com.helper.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.helper.dao.BaseDao;
import com.helper.entity.NewCashInquery;

public class NewCashInqueryDaoImpl extends BaseDao {
	public List<NewCashInquery> findCashInquery(String code,int first,int second){
		String sql="select * from PURCHASEINQUERY where code = "+code;
		List<NewCashInquery> list=new ArrayList<NewCashInquery>();
		NewCashInquery nci=null;
		
		ResultSet rs=super.executeQueryForPage(sql,first,second);
		try {
			while(rs.next()){
				nci=new NewCashInquery();
				nci.setAddDate(rs.getString("adddate"));
				nci.setAddIP(rs.getString("addip"));
				nci.setAddUser(rs.getString("adduser"));
				nci.setAddUserName(rs.getString("addusername"));
				nci.setCode(rs.getString("code"));
				nci.setComPCode(rs.getString("compcode"));
				nci.setContacter(rs.getString("contacter"));
				nci.setFax(rs.getString("fax"));
				nci.setIsShow(rs.getString("isshow"));
				nci.setNums(rs.getString("nums"));
				nci.setNumSprice(rs.getString("numsprice"));
				nci.setRemarks(rs.getString("remarks"));
				nci.setState(rs.getString("state"));
				nci.setSupplierCode(rs.getString("suppliercode"));
				nci.setTelphone(rs.getString("telphone"));
				list.add(nci);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
}
