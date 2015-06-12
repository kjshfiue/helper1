package com.helper.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.helper.dao.BaseDao;
import com.helper.dao.StockOutDao;
import com.helper.entity.PageBean;
import com.helper.entity.StockOut;

public class StockOutDaoImpl extends BaseDao implements StockOutDao {

	@Override
	public int insert(StockOut stockOut) {
		// TODO Auto-generated method stub
		//System.out.println("你的背包"+stockOut.getCode());
				String sql="insert into stockout(code,outdate,customercode,contacter,telphone,fax,outtype,isinvoice,remarks) values(?,?,?,?,?,?,?,?,?)";
				int ret=super.executeUpdate(sql, new Object[]{stockOut.getCode(),new java.sql.Date(stockOut.getOutDate().getTime()),
						stockOut.getCustomerCode(),stockOut.getContActer(),stockOut.getTelphone(),
						stockOut.getFax(),stockOut.getOutType(),stockOut.getIsInVoice(),stockOut.getRemarks()});
				return ret;
	}

	@Override
	public int delete(String code) {
		// TODO Auto-generated method stub
		String sql="delete from stockout where code=?";
		int ret=super.executeUpdate(sql, new Object[]{code});
		return ret;
	}

	@Override
	public StockOut findAll(StockOut stockOut) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(String code,StockOut stockOut) {
		// TODO Auto-generated method stub
		String sql="update stockout set outdate=?,customercode=?,nums=?,numsprice=?,state=?,addusername=? where code=?";
		int ret=super.executeUpdate(sql, new Object[]{new java.sql.Date(stockOut.getOutDate().getTime()),
				stockOut.getCustomerCode(),stockOut.getNums(),
				stockOut.getNumSprice(),stockOut.getState(),
				stockOut.getAddUserName(),code});
		return ret;
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
				sql += " and outdate>=? ";
				pstm.add(map.get("date1"));
			}
			if(map.get("date2")!=null && map.get("date2")!=""){
				sql += " and outdate<=? ";
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
				//System.out.println("niu"+new java.util.Date(rs.getDate("outdate").getTime()));
				stockOut.setOutDate(new java.util.Date(rs.getDate("outdate").getTime()));
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
				Date adddate=null;
				if(rs.getDate("adddate")!=null){
					stockOut.setAddDate(new java.util.Date(rs.getDate("adddate").getTime()));
				}
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

	@Override
	public List<Map<String, Object>> find(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		String sql = "select * from stockout where 1=1 ";
		List<Object> pstm = new ArrayList<Object>();
		//System.out.println("开始了");
		if(map.size()>0){
			
			if(map.get("code")!=null && map.get("code")!=""){
				sql += " and code=? ";
				pstm.add(map.get("code"));
			}
			if(map.get("date1")!=null && map.get("date1")!=""){
				sql += " and outdate>=? ";
				pstm.add(map.get("date1"));
			}
			if(map.get("date2")!=null && map.get("date2")!=""){
				sql += " and outdate<=? ";
				pstm.add(map.get("date2"));
			}
			if(map.get("name")!=null && map.get("name")!=""){
				sql += " and customercode=? ";
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
				baseMap.put("outdate",new java.util.Date(rs.getTimestamp("outdate").getTime()));
				baseMap.put("customercode",rs.getString("customercode"));
				baseMap.put("contacter",rs.getString("contacter"));
				baseMap.put("telphone",rs.getString("telphone"));
				baseMap.put("fax",rs.getString("fax"));
				baseMap.put("outtype",rs.getString("outtype"));
				baseMap.put("address",rs.getString("address"));
				baseMap.put("isinvoice",rs.getString("isinvoice"));
				baseMap.put("remarks",rs.getString("remarks"));
				baseMap.put("isshow",rs.getString("isshow"));
				baseMap.put("nums",rs.getDouble("nums"));
				baseMap.put("numsprice",rs.getDouble("numsprice"));
				
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
