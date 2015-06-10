package com.helper.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.helper.dao.BaseDao;
import com.helper.dao.StockInDao;
import com.helper.entity.PageBean;
import com.helper.entity.StockIn;

public class StockInDaoImpl extends BaseDao implements StockInDao {

	@Override
	public int insert(StockIn stockIn) {
		// TODO Auto-generated method stub
		//System.out.println("你的背包"+stockIn.getCode());
		String sql="insert into stockin(code,indate,suppliercode,contacter,teltphone,fax,intype,isinvoice,remarks) values(?,?,?,?,?,?,?,?,?)";
		int ret=super.executeUpdate(sql, new Object[]{stockIn.getCode(),new java.sql.Date(stockIn.getInDate().getTime()),
				stockIn.getSupplierCode(),stockIn.getContActer(),stockIn.getTeltphone(),
				stockIn.getFax(),stockIn.getInType(),stockIn.getIsInVoice(),stockIn.getRemarks()});
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
				stockIn.setInDate(rs.getDate("indate"));
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
	public int update(String code,StockIn stockIn) {
		// TODO Auto-generated method stub
		String sql="update stockin set indate=?,suppliercode=?,nums=?,numsprice=?,state=?,addusername=? where code=?";
		int ret=super.executeUpdate(sql, new Object[]{new java.sql.Date(stockIn.getInDate().getTime()),
				stockIn.getSupplierCode(),stockIn.getNums(),
				stockIn.getNumSprice(),stockIn.getState(),
				stockIn.getAddUserName(),code});
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
				stockIn.setInDate(rs.getDate("indate"));
				stockIn.setSupplierCode(rs.getString("suppliercode"));
				stockIn.setContActer(rs.getString("contacter"));
				stockIn.setTeltphone(rs.getString("teltphone"));
				stockIn.setFax(rs.getString("fax"));
				stockIn.setInType(rs.getString("intype"));
				stockIn.setIsRoad(rs.getString("isroad"));
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
	public PageBean searchPageBean(int pageNo, int pageSize,
			HashMap<String, String> map) {
		// TODO Auto-generated method stub
		String sql = "select * from stockin where 1=1 ";
		List<Object> pstm = new ArrayList<Object>();
		if(map.size()>0){
			
			if(map.get("code")!=null && map.get("code")!=""){
				sql += " and code=? ";
				pstm.add(map.get("code"));
			}
			if(map.get("date1")!=null && map.get("date1")!=""){
				sql += " and indate>=? ";
				pstm.add(map.get("date1"));
			}
			if(map.get("date2")!=null && map.get("date2")!=""){
				sql += " and indate<=? ";
				pstm.add(map.get("date2"));
			}
			if(map.get("name")!=null && map.get("name")!=""){
				sql += " and supplierCode=? ";
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
		List<StockIn> list = new ArrayList<StockIn>();
		StockIn stockIn=null;
		
		System.out.println("开始获取数据");
		try {
			while(rs.next()){
				
				stockIn = new StockIn();
				stockIn.setCode(rs.getString("code"));
				stockIn.setInDate(new java.util.Date(rs.getDate("indate").getTime()));
				stockIn.setSupplierCode(rs.getString("suppliercode"));
				stockIn.setContActer(rs.getString("contacter"));
				stockIn.setTeltphone(rs.getString("teltphone"));
				stockIn.setFax(rs.getString("fax"));
				stockIn.setInType(rs.getString("intype"));
				stockIn.setIsRoad(rs.getString("isroad"));
				stockIn.setIsInVoice(rs.getString("isinvoice"));
				stockIn.setRemarks(rs.getString("remarks"));
				stockIn.setIsShow(rs.getString("isshow"));
				stockIn.setNums(rs.getDouble("nums"));
				stockIn.setNumSprice(rs.getDouble("numsprice"));
				stockIn.setState(rs.getString("state"));
				stockIn.setCompCode(rs.getString("compcode"));
				Date adddate=null;
				if(rs.getDate("adddate")!=null){
					stockIn.setAddDate(new java.util.Date(rs.getDate("adddate").getTime()));
				}
				stockIn.setAddDate(rs.getTimestamp("adddate"));
				stockIn.setAddUser(rs.getString("adduser"));
				stockIn.setAddUserName(rs.getString("addusername"));
				stockIn.setAddIp(rs.getString("addip"));
				list.add(stockIn);
				
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

	@Override
	public List<Map<String, Object>> find(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		String sql = "select * from stockin where 1=1 ";
		List<Object> pstm = new ArrayList<Object>();
		//System.out.println("开始了");
		if(map.size()>0){
			
			if(map.get("code")!=null && map.get("code")!=""){
				sql += " and code=? ";
				pstm.add(map.get("code"));
			}
			if(map.get("date1")!=null && map.get("date1")!=""){
				sql += " and indate>=? ";
				pstm.add(map.get("date1"));
			}
			if(map.get("date2")!=null && map.get("date2")!=""){
				sql += " and indate<=? ";
				pstm.add(map.get("date2"));
			}
			if(map.get("name")!=null && map.get("name")!=""){
				sql += " and supplierCode=? ";
				pstm.add(map.get("name"));
			}
		}
		Object[] object = pstm.toArray();
		sql += " order by code";
		ResultSet rs = super.executeQuery(sql, object);
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		Map<String,Object> baseMap = null;
		System.out.println("导出数据，开始获取数据");
		try {
			while(rs.next()){
				baseMap = new HashMap<String,Object>();
				baseMap.put("code",rs.getString("code"));
				baseMap.put("indate",new java.util.Date(rs.getTimestamp("indate").getTime()));
				baseMap.put("suppliercode",rs.getString("suppliercode"));
				baseMap.put("contacter",rs.getString("contacter"));
				baseMap.put("teltphone",rs.getString("teltphone"));
				baseMap.put("fax",rs.getString("fax"));
				baseMap.put("intype",rs.getString("intype"));
				baseMap.put("isroad",rs.getString("isroad"));
				baseMap.put("isinvoice",rs.getString("isinvoice"));
				baseMap.put("remarks",rs.getString("remarks"));
				baseMap.put("isshow",rs.getString("isshow"));
				baseMap.put("nums",rs.getDouble("nums"));
				baseMap.put("numsprice",rs.getDouble("numsprice"));
				baseMap.put("comcode",rs.getString("compcode"));
				baseMap.put("adddate",new java.util.Date(rs.getTimestamp("adddate").getTime()));
				baseMap.put("adduser",rs.getString("adduser"));
				baseMap.put("addusername",rs.getString("addusername"));
				baseMap.put("addip",rs.getString("addip"));
				
				list.add(baseMap);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return list;
	}
}
