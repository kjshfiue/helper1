package com.helper.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.helper.entity.PageBean;
import com.helper.dao.BaseDao;
import com.helper.dao.CashInqueryDao;
import com.helper.entity.CashInquery;

public class CashInqueryDaoImpl extends BaseDao implements CashInqueryDao{

	@Override
//	按指定条件搜索询价单据信息；
	public PageBean searchPartBySth(int pageNo,int pageSize,HashMap<String,String> map) {
		// TODO Auto-generated method stub
		PageBean pageBean=null;
		List <CashInquery> list =new ArrayList<CashInquery>();
		List<Object> pstm=new ArrayList<Object>();
		CashInquery cashInquery=null;
		ResultSet rs=null;
		
		String sql="select * from PURCHASEINQUERY where 1=1";
		if(map.get("code")!=null){
			sql+=" and code="+map.get("code");
		}
		if(map.get("endDate")!=null){
			sql+=" and addDate<"+map.get("endDate");
		}
		if(map.get("startDate")!=null){
			sql+=" and addDate>"+map.get("startDate");
		}
		if(map.get("comPCode")!=null){
			sql+=" and comPCode="+map.get("comPCode");
		}
		  Object[] object1=pstm.toArray();
		  pstm.add(pageNo*pageSize);
		  pstm.add((pageNo-1)*pageSize);
		  Object[] object2=pstm.toArray();

		   rs=super.executeQueryForPage(sql, object2);
		
		   try {
			while(rs.next()){
				cashInquery=new CashInquery();
				cashInquery.setCode(rs.getString("code"));
			    cashInquery.setAddDate(new java.util.Date(rs.getDate("addDate").getTime()));
			    cashInquery.setSupplierCode(rs.getString("supplierCode"));
				cashInquery.setContacter(rs.getString("contacter"));
				cashInquery.setTelphone(rs.getString("telphone"));
				cashInquery.setFax(rs.getString("fax"));
				cashInquery.setNums(rs.getString("nums"));
				cashInquery.setNumSprice(rs.getString("numSprice"));
				cashInquery.setIsShow(rs.getString("isShow"));
				cashInquery.setState(rs.getString("state"));
				cashInquery.setRemarks(rs.getString("remarks"));
				cashInquery.setAddUser(rs.getString("addUser"));
				cashInquery.setAddUserName(rs.getString("addUserName"));
				cashInquery.setAddIP(rs.getString("addIp"));
				cashInquery.setComPCode(rs.getString("comPCode"));
				list.add(cashInquery);
			   }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   if(list!=null){
			   String sql2 ="select count (*) count from ("+sql+")";
			   int total=super.executeTotalCount(sql2, object1);
			   pageBean=new PageBean();
			   pageBean.setTotal(total);
			   pageBean.setData(list);
		   }
		   
		return pageBean;
	}

	@Override
	//增加询价单据；
	public int addCashInqueryList(CashInquery cashInquery) {
		// TODO Auto-generated method stub
		String sql="insert into PURCHASEINQUERY (code,addDate,comPcode,nums,numSprice,contacter,"
				+ "telephone,state,remarks) values(?,sysDate,?,?,?,?,?,?,?) ";
		Object params[]=new Object[]{cashInquery.getCode(),cashInquery.getComPCode(),cashInquery.getNums()
				,cashInquery.getNumSprice(),cashInquery.getContacter(),cashInquery.getTelphone(),cashInquery.getState(),
				cashInquery.getRemarks()};
		int ret=super.executeUpdate(sql, params);
		return ret;
	}

	@Override
	//删除询价单据
	public int delCashInqueryList(String code) {
		// TODO Auto-generated method stub
		String sql="delete from PURCHASEINQUERY where code=?";
		Object []params=new Object[]{code};
		int ret=0;
		ret=super.executeUpdate(sql, params);
		return ret;
	}




	@Override
	public PageBean getAllPartInfo(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		PageBean pageBean=null;
		List<CashInquery> list=new ArrayList <CashInquery>();
		CashInquery cashInquery=null;
		String sql="select * from PURCHASEINQUERY where 1=1";
		ResultSet rs=super.executeQueryForPage(sql, pageNo, pageSize);
		   try {
				while(rs.next()){
					cashInquery=new CashInquery();
					cashInquery.setCode(rs.getString("code"));
				    cashInquery.setAddDate(new java.util.Date(rs.getDate("addDate").getTime()));
				    cashInquery.setSupplierCode(rs.getString("supplierCode"));
					cashInquery.setContacter(rs.getString("contacter"));
					cashInquery.setTelphone(rs.getString("telphone"));
					cashInquery.setFax(rs.getString("fax"));
					cashInquery.setNums(rs.getString("nums"));
					cashInquery.setNumSprice(rs.getString("numSprice"));
					cashInquery.setIsShow(rs.getString("isShow"));
					cashInquery.setState(rs.getString("state"));
					cashInquery.setRemarks(rs.getString("remarks"));
					cashInquery.setAddUser(rs.getString("addUser"));
					cashInquery.setAddUserName(rs.getString("addUserName"));
					cashInquery.setAddIP(rs.getString("addIp"));
					cashInquery.setComPCode(rs.getString("comPCode"));
					list.add(cashInquery);
				   }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   if(list!=null){
				   String sql2 ="select count (*) count from PURCHASEINQUERY";
				   int total=super.executeTotalCount(sql2);
				   pageBean=new PageBean();
				   pageBean.setTotal(total);
				   pageBean.setData(list);
			   }
		return pageBean;
	}
	//修改询价单据；
	public int updateCashInqueryList(CashInquery cashInquery) {
		String sql=" update PURCHASEINQUERY set addDate=sysDate ,comPCode =?,nums=? ,numSprice=? , contacter=? ,telphone=? ,state=?  where code=?" ;
		Object [] params=new Object[]{
				cashInquery.getComPCode(),cashInquery.getNums(),
				cashInquery.getNumSprice(),cashInquery.getContacter(),cashInquery.getTelphone(),
				cashInquery.getState(),cashInquery.getCode()};
	
		int ret=super.executeUpdate(sql, params);
		/*System.out.println("DAO"+ret);*/
		return ret;
	}
	
	//===================================测试================================
		public static void main(String[] args) {
			//PageBean pageBean=null;
			CashInqueryDao ciDao=new CashInqueryDaoImpl();
			
			CashInquery cashInquery=new CashInquery();
		    cashInquery.setComPCode("1234");
		    cashInquery.setNums("0012");
		    cashInquery.setNumSprice("0000");
		    cashInquery.setContacter("王五");
		    cashInquery.setTelphone("12345678");
		    cashInquery.setState("0");
		    cashInquery.setRemarks("你大爷1234");
		    cashInquery.setCode("2002");
		    //将数据写回数据库
		   System.out.println(ciDao.updateCashInqueryList(cashInquery)); 
			
		    /*HashMap<String,String> map=new HashMap<String,String>();
			map.put("code", "'2001'");
			map.put("startDate", "'01-6月-2015'");
			map.put("endDate","'09-6月-2015'");
			map.put("comPCode", "'200104'");
			List <CashInquery> list=new ArrayList<CashInquery>();
			
			pageBean=ciDao.searchPartBySth(1,10,map);
			System.out.println(pageBean.getTotal());*/
		}

}
