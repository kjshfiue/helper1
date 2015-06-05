package com.helper.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.helper.dao.BaseDao;
import com.helper.dao.SaleOrderDao;
import com.helper.entity.PageBean;
import com.helper.entity.SaleOrder;

public class SaleOrderDaoImpl extends BaseDao implements SaleOrderDao {

	@Override
	public PageBean findSaleOrder(int pageNo,int pageSize,Map<String,String> map) {
		// TODO Auto-generated method stub
		String sql = "select * from SALEORDER where 1=1 ";
		List<Object> list = new ArrayList<Object>();
		if(map.size()>0){
			if(map.get("code")!=null&&map.get("code")!=""){
				sql += "and code like ? ";
				list.add("%"+map.get("code")+"%");
			}
			if(map.get("startDate")!=null&&map.get("startDate")!=""){
				sql += "and orderdate>? ";
				list.add(map.get("startDate"));
			}
			if(map.get("endDate")!=null&&map.get("endDate")!=""){
				sql += "and orderdate<? ";
				list.add(map.get("endDate"));
			}
			if(map.get("customerCode")!=null&&map.get("customerCode")!=""){
				sql += "and customerCode like ? ";
				list.add("%"+map.get("customerCode")+"%");
			}
		}
		Object[] param1 = list.toArray();
		list.add(pageNo*pageSize);
		list.add((pageNo-1)*pageSize);
		Object[] params = list.toArray();
		ResultSet rs = super.executeQueryForPage(sql, params);
		SaleOrder saleOrder = null;
		List<SaleOrder> saleOrderlist = new ArrayList<SaleOrder>();
		try {
			while(rs.next()){
				saleOrder = new SaleOrder();
				saleOrder.setCode(rs.getString("code"));
				saleOrder.setOrderDate(rs.getTimestamp("orderDate"));
				saleOrder.setCustomerCode(rs.getString("customerCode"));
				saleOrder.setNums(rs.getInt("nums"));
				saleOrder.setNumSprice(rs.getInt("numSprice"));
				saleOrder.setContacter(rs.getString("contacter"));
				saleOrder.setTelPhone(rs.getString("telPhone"));
				saleOrder.setState(rs.getString("state"));
				saleOrder.setAddUserName(rs.getString("addUserName"));
				saleOrderlist.add(saleOrder);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql2 = "select count(*) count "+sql.substring(sql.indexOf("from"));
		int total = super.executeTotalCount(sql2, param1);
		PageBean pageBean = new PageBean();
		pageBean.setData(saleOrderlist);
		pageBean.setTotal(total);
		super.closeAll();
		return pageBean;
	}

	@Override
	public int addSaleOrder(SaleOrder s) {
		// TODO Auto-generated method stub
		String sql1 = "insert into SALEORDER(code,OrderDate,CustomerCode,Nums,NumSprice,"
				+ "Contacter,TelPhone,State,AddUserName) values(?,?,?,?,?,?,?,?,?)";
		//String sql2 = "insert into SALORDER_DETAIL values(?,?,?,?,?,?,?,?,?)";
		List<Object> list = new ArrayList<Object>();
		list.add(s.getCode());
		list.add(s.getOrderDate());
		list.add(s.getCustomerCode());
		list.add(s.getNums());
		list.add(s.getNumSprice());
		list.add(s.getContacter());
		list.add(s.getTelPhone());
		list.add(s.getState());
		list.add(s.getAddUserName());
		Object[] param = list.toArray();
		return super.executeUpdate(sql1, param);
	}

	@Override
	public int deleteByCode(String code) {
		// TODO Auto-generated method stub
		String sql1 = "delete from SALEORDER where code="+code;
		String sql2 = "delete from SALORDER_DETAIL where code="+code;
		Connection conn = super.getConnection();
		int ret[] = new int[2];
		try {
			Statement state = conn.createStatement();
			conn.setAutoCommit(false);
			state.addBatch(sql1);
			state.addBatch(sql2);
			ret = state.executeBatch();
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret[0];
	}

	@Override
	public int deleteBatchByCode(List<String> codeList) {
		// TODO Auto-generated method stub
		String sql1 = "delete from SALEORDER where code=";
		String sql2 = "delete from SALORDER_DETAIL where code=";
		Connection conn = super.getConnection();
		int ret[] = new int[2];
		try {
			Statement state = conn.createStatement();
			conn.setAutoCommit(false);
			for(int i=0;i<codeList.size();i++){
				String code = codeList.get(i);
				state.addBatch(sql1+code);
				state.addBatch(sql2+code);
			}
			ret = state.executeBatch();
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret[0];
	}

	@Override
	public int updateByCode(String code,SaleOrder s) {
		// TODO Auto-generated method stub
		String sql = "update  SALEORDER set code=? where code=?";
		List<Object> list = new ArrayList<Object>();
		list.add(s.getCode());
		list.add(code);
		Object[] paramValues = list.toArray();
		int ret = super.executeUpdate(sql, paramValues);
		return ret;
	}

}
