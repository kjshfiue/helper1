package com.helper.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.helper.dao.BaseDao;
import com.helper.dao.OrderDao;
import com.helper.entity.Order;

public class OrderImpl extends BaseDao implements OrderDao{

	@Override
	public List<Order> findOrders(String s1, String s2, String s3, String s4,int first,int second) {
		// TODO Auto-generated method stub
		String sql="select * from purchaseorder where 1=1";
		if(s1!=null){
			sql=sql+"and code="+s1;
		}
		if(s2!=null){
			sql=sql+"and ORDERDATE="+s2;
			
		}
		if(s3!=null){
			sql=sql+"and DELIVERYDATE="+s3;
		}
		if(s4!=null){
			sql=sql+"and SUPPLIERCODE="+s4;
		}
		
		ResultSet rs=super.executeQueryForPage(sql,first,second);
		List<Order> list=new ArrayList<Order>();
		Order ord=null;
		try {
			while(rs.next()){
				ord=new Order();
				ord.setAddDate(rs.getString("adddate"));
				ord.setAddIp(rs.getString("addip"));
				ord.setAdduser(rs.getString("adduser"));
				ord.setAddUserName(rs.getString("addusername"));
				ord.setBusinesser(rs.getString("businesser"));
				ord.setCode(rs.getString("code"));
				ord.setContacter(rs.getString("contacter"));
				ord.setDeliverydate(rs.getString("deliverydate"));
				ord.setFax(rs.getString("fax"));
				ord.setIsshow(rs.getString("isshow"));
				ord.setNums(rs.getString("nums"));
				ord.setNumsprice(rs.getString("numsprice"));
				ord.setOrderDate(rs.getString("orderdate"));
				ord.setRemarks(rs.getString("remarks"));
				ord.setState(rs.getString("state"));
				ord.setSuppliercode(rs.getString("suppliercode"));
				ord.setTelphone(rs.getString("telphone"));
				ord.setTrans(rs.getString("trans"));
				list.add(ord);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insert(Order ord) {
		// TODO Auto-generated method stub
	String sql="insert into purchaseorder values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	Object obj[]=new Object[18];
obj[0]=ord.getCode();
try {
	java.util.Date date1=new SimpleDateFormat("yyyy/MM/dd").parse(ord.getOrderDate());
	java.sql.Date newdate1=new java.sql.Date(date1.getTime());
	
	obj[1]=newdate1;
} catch (ParseException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
obj[2]=ord.getSuppliercode();
obj[3]=ord.getContacter();
obj[4]=ord.getTelphone();
obj[5]=ord.getFax();
obj[6]=ord.getTrans();
try {
	java.util.Date date2=new SimpleDateFormat("yyyy/MM/dd").parse(ord.getDeliverydate());
	java.sql.Date newdate2=new java.sql.Date(date2.getTime());
	obj[7]=newdate2;
} catch (ParseException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}

obj[8]=ord.getBusinesser();
obj[9]=ord.getRemarks();
obj[10]=ord.getIsshow();
obj[11]=ord.getNums();
obj[12]=ord.getNumsprice();
obj[13]=ord.getState();
try {
	java.util.Date date=new SimpleDateFormat("yyyy/MM/dd").parse(ord.getAddDate());
	java.sql.Date newdate=new java.sql.Date(date.getTime());
	obj[14]=newdate;
} catch (ParseException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}

	

obj[15]=ord.getAdduser();
obj[16]=ord.getAddUserName();
obj[17]=ord.getAddIp();
	int flag=super.executeUpdate(sql, obj);
		return flag;
	}
	//É¾³ý¶©µ¥
	public int deleteMessage(String code){
		Object obj[]=new Object[1];
		obj[0]=code;
		String sql="delete from purchaseorder where code= ?";
		int flag=super.executeUpdate(sql,obj);
		return flag;

	
		
	}
	//ÐÞ¸Ä¶©µ¥
	public int updateMessage(Order ord){
		String sql="update purchaseorder set orderdate=?,suppliercode=?,contacter=?,telphone=?,fax=?,trans=?,deliverydate=?,businesser=?,remarks=?,isshow=?,nums=?,numsprice=?,state=?,adddate=?,adduser=?,addusername=?,addip=?  where code = ?";
		Object obj[]=new Object[18];
		obj[17]=ord.getCode();
		try {
			java.util.Date date1=new SimpleDateFormat("yyyy/MM/dd").parse(ord.getOrderDate());
			java.sql.Date newdate1=new java.sql.Date(date1.getTime());
			
			obj[0]=newdate1;
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		obj[1]=ord.getSuppliercode();
		obj[2]=ord.getContacter();
		obj[3]=ord.getTelphone();
		obj[4]=ord.getFax();
		obj[5]=ord.getTrans();
		try {
			java.util.Date date2=new SimpleDateFormat("yyyy/MM/dd").parse(ord.getDeliverydate());
			java.sql.Date newdate2=new java.sql.Date(date2.getTime());
			obj[6]=newdate2;
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		obj[7]=ord.getBusinesser();
		obj[8]=ord.getRemarks();
		obj[9]=ord.getIsshow();
		obj[10]=ord.getNums();
		obj[11]=ord.getNumsprice();
		obj[12]=ord.getState();
		try {
			java.util.Date date=new SimpleDateFormat("yyyy/MM/dd").parse(ord.getAddDate());
			java.sql.Date newdate=new java.sql.Date(date.getTime());
			obj[13]=newdate;
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		obj[14]=ord.getAdduser();
		obj[15]=ord.getAddUserName();
		obj[16]=ord.getAddIp();
		int flag=super.executeUpdate(sql,obj);
		
		return flag;
	}

}
