package com.helper.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.helper.dao.BaseDao;
import com.helper.dao.StockOutDao;
import com.helper.entity.PageBean;
import com.helper.entity.StockOut;

public class StockOutDaoImpl extends BaseDao implements StockOutDao {

	@Override
	public int insert(StockOut stockOut) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String code) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public StockOut findAll(StockOut stockOut) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(String code) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PageBean searchPageBean(int pageNo, int pageSize,
			HashMap<String, String> map) {
		// TODO Auto-generated method stub
		String sql = "select * from stockout where 1=1 ";
		List<Object> pstm = new ArrayList<Object>();
		if(map.size()>0){
			
			if(map.get("code")!=null && map.get("code")!=""){
				sql += " and code=? ";
				pstm.add(map.get("code"));
			}
			if(map.get("date1")!=null && map.get("date1")!=""){
				sql += " and indate=? ";
				pstm.add(map.get("date1"));
			}
			if(map.get("date2")!=null && map.get("date2")!=""){
				sql += " and outdate=? ";
				pstm.add(map.get("date2"));
			}
			if(map.get("name")!=null && map.get("name")!=""){
				sql += " and customerCode=? ";
				pstm.add(map.get("name"));
			}
		}
		Object[] object1 = pstm.toArray();
		sql += " order by code ";
		pstm.add(pageNo*pageSize);
		pstm.add((pageNo-1)*pageSize);
		Object[] object2 = pstm.toArray();
		ResultSet rs = super.executeQueryForPage(sql, object2);
		PageBean pageBean = null;
		List<StockOut> list = new ArrayList<StockOut>();
		StockOut stockOut=null;
		
		System.out.println("开始获取数据");
		try {
			while(rs.next()){
				
				stockOut = new StockOut();
				stockOut.setCode(rs.getString("code"));
				stockOut.setOutDate(rs.getTimestamp("outdate"));
				stockOut.setCustomerCode(rs.getString("customercode"));
				stockOut.setContActer(rs.getString("contacter"));
				stockOut.setTelphone(rs.getString("telphone"));
				stockOut.setFax(rs.getString("fax"));
				stockOut.setOutType(rs.getString("outtype"));
				
				stockOut.setIsInVoice(rs.getString("isinvoice"));
				stockOut.setAddress(rs.getString("address"));
				stockOut.setRemarks(rs.getString("remarks"));
				stockOut.setIsShow(rs.getString("isshow"));
				stockOut.setNums(rs.getDouble("nums"));
				stockOut.setNumSprice(rs.getDouble("numsprice"));
				stockOut.setState(rs.getString("state"));
			
				stockOut.setAddDate(rs.getTimestamp("adddate"));
				stockOut.setAddUser(rs.getString("adduser"));
				stockOut.setAddUserName(rs.getString("addusername"));
				stockOut.setAddIp(rs.getString("addip"));
				
				list.add(stockOut);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		if(list!=null){
			String sql2 = "select count(*) count from ("+sql+")";
			int total = super.executeTotalCount(sql2,object1);
			pageBean = new PageBean();
			pageBean.setTotal(total);
			pageBean.setData(list);
		}
		return pageBean;
	}

}
