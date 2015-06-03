package com.helper.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.helper.dao.BaseDao;
import com.helper.dao.CusLInkDao;
import com.helper.entity.CustomerLink;

public class CusLinkDaoImpl extends BaseDao implements CusLInkDao{
	//添加往来记录
	public int insert(CustomerLink c) {
		int ret = 0;
		String sql="insert into BaseCustomerSupplier (code,CATEGORYCODE,CSNAME,ADDDATE,TELEPHONE,ADDRESS,CONTACTER,REMARKS) values(" +
				" ?,?,?,?,?" +
				",?,?,?)";
		Object para[]=new Object[8];
		para[0]=c.getCode();
		para[1]=c.getCategoryCode();
		para[2]=c.getCsName();
		para[3]=new java.sql.Date(c.getAddDate().getTime());
		para[4]=c.getTelPhone();
		para[5]=c.getAddress();
		para[6]=c.getContActor();
		para[7]=c.getRemarks();
		ret=super.executeUpdate(sql, para);
		return ret;
	}
	//根据编号删除
	public int delete(String code) {
		int ret = 0;
		String sql = "delete BaseCustomerSupplier where code=?";
		ret = super.executeUpdate(sql, new Object[]{code});
		return ret;
	}
	//分页查找
	public PageBean  selectAll(int pagenumber, int pagesize,String code,String name, String Date) {
		PageBean pb = new PageBean();
		List<CustomerLink> cuslist= new ArrayList<CustomerLink>();
		
		String sql1="where 1=1";
		if(code!=null){
			sql1=sql1+"and code like '%"+code+"%'";
		}
		if(name!=null){
			sql1=sql1+"and CSNAME like '%"+name+"%'";
		}
	
		String sql = "select * from( select rownum r, A.* from (select * from BaseCustomerSupplier " 
				+sql1+
				" )A ) where r>? and r<=?";
		ResultSet rs=super.executeQuery(sql, new Object[]{(pagenumber-1)*pagesize,pagesize*pagenumber});
		try {
			while(rs.next()){
				CustomerLink c =  new CustomerLink();
				
				c.setCode( rs.getString("code"));//代码
				c.setCategoryCode( rs.getString("CATEGORYCODE"));//类型
				c.setAddDate(new Date(rs.getDate("ADDDATE").getTime()));//日期
				c.setCsName(rs.getString("CSNAME"));//名称
				c.setContActor(rs.getString("CONTACTER"));//联系人
				c.setTelPhone(rs.getString("TELEPHONE"));//电话
				c.setSpell(rs.getString("SPELL"));//拼音
				c.setAddress(rs.getString("ADDRESS"));//地址
				c.setIsShow(rs.getString("ISSHOW"));//是否显示
				
			
				
//				c.setMobliePhone(rs.getString("MOBILEPHONE"));//9
//				c.setFax(rs.getString("FAX"));//10
//				c.setEmail(rs.getString("EMAIL"));//11
//				c.setURL(rs.getString("URL"));
//				c.setProvince("PROVINCE");//14
//				c.setCity("CITY");//15
//				c.setQQ(rs.getString("QQ"));
//				c.setPostcod("POSTCODE");
//				c.setMSN(rs.getString("MSN"));
//				c.setAccount(rs.getString("ACCOUNT"));//19
//				c.setAliwang(rs.getString("ALIWANG"));//20
//				c.setBank(rs.getString("BANK"));
//				c.setLegaler(rs.getString("legaler"));
//				c.setTax(rs.getString("TAX"));
//				c.setAgent(rs.getString("AGENT"));//24
//				c.setRemarks(rs.getString("REMARKS"));//26
//				c.setAdduser(rs.getString("ADDUSER"));//27
//				c.setAssUserName(rs.getString("ADDUSERNAME"));
//				c.setAddIP(rs.getString("ADDIP"));
//				c.setCoompCode(rs.getString("COMPCODE"));
				cuslist.add(c);		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		pb.setDatelist(cuslist);
		return pb;
	}

	public int update(CustomerLink c) {
		// TODO Auto-generated method stub
		String sql = "update BASECUSTOMERSUPPLIER" +
				" set CATEGORYCODE=?,ADDDATE=?,CSNAME=?,CONTACTER=?," +
				     "TELEPHONE=?,REMARKS=?,ADDRESS=? " +
				"where code=?";
		Object para[]= new Object[]{
				c.getCategoryCode(),
				new java.sql.Date(c.getAddDate().getTime()),
				c.getCsName(),
				c.getContActor(),
				c.getTelPhone(),
				c.getRemarks(),
				c.getAddress(),
				c.getCode()
				//c.getSpell(),
				//c.getMobliePhone(),//rs.getString(),//"MOBILEPHONE"),),,//9
				//c.getFax(),//rs.getString(),//"FAX"),),,//10
				//c.getEmail(),//rs.getString(),//"EMAIL"),),,//11
				//c.getURL(),//rs.getString(),//"URL"),),,//12
				//rs.getString(),//"ADDRESS"),),,
				//c.getProvince(),//"PROVINCE"),,//14
				//c.getCity(),//"CITY"),,//15
				//c.getQQ(),//rs.getString(),//"QQ"),),,
				//c.getPostcod(),//"POSTCODE"),,
				//c.getMSN(),//rs.getString(),//"MSN"),),,
				//c.getAccount(),//rs.getString(),//"ACCOUNT"),),,//19
				//c.getAliwang(),//rs.getString(),//"ALIWANG"),),,//20
				//c.getBank(),//rs.getString(),//"BANK"),),,
				//c.getLegaler(),//rs.getString(),//"legaler"),),,
				//c.getTax(),//rs.getString(),//"TAX"),),,
				//c.getIsShow(),//rs.getString(),//"ISSHOW"),),,//25
				//rs.getString(),//"REMARKS"),),,//26
				//c.getAdduser(),//rs.getString(),//"ADDUSER"),),,//27
				//c.getAssUserName(),//rs.getString(),//"ADDUSERNAME"),),,
				//c.getAddIP(),//rs.getString(),//"ADDIP"),),,
				//c.getCoompCode()
				};//rs.getString(),//"COMPCODE"),),,CODE"););;
		super.executeUpdate(sql, para);
		return 0;
	}
	
	/*
	 *根据code获得
	 */
	public CustomerLink selectByCode(String code) {
		 CustomerLink c = new  CustomerLink();
		 String sql="select * from BASECUSTOMERSUPPLIER where code=?";
		ResultSet rs= super.executeQuery(sql,code);
		
		try {
			if(rs.next()){
				c.setCode(rs.getString("code"));
				System.out.println("PPPPPPP"+rs.getString("code"));
				c.setCategoryCode(rs.getString("CATEGORYCODE"));//类型
				c.setCsName(rs.getString("CSNAME"));//名称
				c.setContActor(rs.getString("CONTACTER"));//联系人
				c.setTelPhone(rs.getString("TELEPHONE"));//电话
				c.setAddress(rs.getString("ADDRESS"));//地址
				c.setRemarks(rs.getString("REMARKS"));//
	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
	}
	public int selectTotal(String code, String name, String cc) {
		// TODO Auto-generated method stub
		int total=0;
		String sql1="where 1=1";
		if(code!=null){
			sql1=sql1+"and code like '%"+code+"%'";
		}
		if(name!=null){
			sql1=sql1+"and CSNAME like '%"+name+"%'";
		}
		if(cc!=null&&cc!=""){
			
			sql1=sql1+"and ADDDATE=0'"+cc+"'";
		}
		String sql = "select count(*) count from(select * from BaseCustomerSupplier " 
		+sql1+")";
		ResultSet rs = super.executeQuery(sql);
		try {
			if(rs.next()){
				total = rs.getInt("count");
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return total;
	}
	public List<CustomerLink> selectAll(String code, String name, String cc) {
		// TODO Auto-generated method stub
		
List<CustomerLink> cuslist= new ArrayList<CustomerLink>();
		
		String sql1="where 1=1";
		if(code!=null){
			sql1=sql1+"and code like '%"+code+"%'";
		}
		if(name!=null){
			sql1=sql1+"and CSNAME like '%"+name+"%'";
		}
		String sql = "select * from BaseCustomerSupplier";
		ResultSet rs=super.executeQuery(sql);
		try {
			while(rs.next()){
				CustomerLink c =  new CustomerLink();
				
				c.setCode(rs.getString("code"));//代码
				c.setCategoryCode(rs.getString("CATEGORYCODE"));//类型
				c.setAddDate(new Date(rs.getDate("ADDDATE").getTime()));//日期
				c.setCsName(rs.getString("CSNAME"));//名称
				c.setContActor(rs.getString("CONTACTER"));//联系人
				c.setTelPhone(rs.getString("TELEPHONE"));//电话
				c.setSpell(rs.getString("SPELL"));//拼音
				c.setAddress(rs.getString("ADDRESS"));//地址
				c.setIsShow(rs.getString("ISSHOW"));//是否显示
				cuslist.add(c);					
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cuslist;
	}

}
