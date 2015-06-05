package com.helper.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.helper.dao.BaseDao;
import com.helper.dao.StockInDao;
import com.helper.entity.StockIn;

public class StockInDaoImpl extends BaseDao implements StockInDao {

	@Override
	public int insert(StockIn stockin) {
		// TODO Auto-generated method stub
		String sql="insert into stockin(code,indate,suppliercode,nums,numsprice,state,addusername) values(?,?,?,?,?,?,?)";
		int ret=super.executeUpdate(sql, new Object[]{stockin.getCode(),stockin.getInDate(),
				stockin.getSupplierCode(),stockin.getNums(),stockin.getNumSprice(),
				stockin.getState(),stockin.getAddUserName()});
		return ret;
	}

	@Override
	public int delete(String code) {
		// TODO Auto-generated method stub
		String sql="delete from stockin where code=?";
		int ret=super.executeUpdate(sql, new Object[]{code});
		return ret;
	}

	@Override
	public StockIn findAll() {
		// TODO Auto-generated method stub
		
		String sql="select * from stockin ";
		ResultSet rs=super.executeQuery(sql);
		StockIn stockIn=new StockIn();
		try {
			while(rs.next()){
				
				stockIn.setCode(rs.getString("code"));
				stockIn.setInDate(rs.getDate("isdate"));
				stockIn.setSupplierCode(rs.getString("supplierercode"));
				stockIn.setContActer(rs.getString("contacter"));
				stockIn.setTeltphone(rs.getString("teltphone"));
				stockIn.setFax(rs.getString("fax"));
				stockIn.setInType(rs.getString("intype"));
				stockIn.setIsRoad(rs.getString("isload"));
				stockIn.setIsInVoice(rs.getString("isinvoice"));
				stockIn.setRemarks(rs.getString("remarks"));
				stockIn.setIsShow(rs.getString("isshow"));
				stockIn.setNums(rs.getDouble("nums"));
				stockIn.setNumSprice(rs.getDouble("numsprice"));
				stockIn.setState(rs.getString("state"));
				stockIn.setCompCode(rs.getString("compcode"));
				stockIn.setAddDate(rs.getDate("adddate"));
				stockIn.setAddUser(rs.getString("adduser"));
				stockIn.setAddUserName(rs.getString("addusername"));
				stockIn.setAddIp(rs.getString("addip"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		return stockIn;
	}

	@Override
	public int update(StockIn stockIn) {
		// TODO Auto-generated method stub
		String sql="update stockin set code=?,indate=?,suppliercode=?,nums=?,numSpric,state=?,addUserName?";
		int ret=super.executeUpdate(sql, new Object[]{stockIn.getCode(),stockIn.getInDate(),stockIn.getSupplierCode(),
				stockIn.getNums(),stockIn.getNumSprice(),
				stockIn.getState(),stockIn.getAddUserName()});
		return ret;
	}

	@Override
	public StockIn findById(String code) {
		// TODO Auto-generated method stub
		String sql="select * from stockin where code=?";
		ResultSet rs=super.executeQuery(sql, code);
		StockIn stockIn=new StockIn();
		try {
			while(rs.next()){
				stockIn.setCode(rs.getString("code"));
				stockIn.setInDate(rs.getDate("isdate"));
				stockIn.setSupplierCode(rs.getString("supplierercode"));
				stockIn.setContActer(rs.getString("contacter"));
				stockIn.setTeltphone(rs.getString("teltphone"));
				stockIn.setFax(rs.getString("fax"));
				stockIn.setInType(rs.getString("intype"));
				stockIn.setIsRoad(rs.getString("isload"));
				stockIn.setIsInVoice(rs.getString("isinvoice"));
				stockIn.setRemarks(rs.getString("remarks"));
				stockIn.setIsShow(rs.getString("isshow"));
				stockIn.setNums(rs.getDouble("nums"));
				stockIn.setNumSprice(rs.getDouble("numsprice"));
				stockIn.setState(rs.getString("state"));
				stockIn.setCompCode(rs.getString("compcode"));
				stockIn.setAddDate(rs.getDate("adddate"));
				stockIn.setAddUser(rs.getString("adduser"));
				stockIn.setAddUserName(rs.getString("addusername"));
				stockIn.setAddIp(rs.getString("addip"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		return stockIn;
	}

}
