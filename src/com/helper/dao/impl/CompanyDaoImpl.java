package com.helper.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.helper.dao.BaseDao;
import com.helper.dao.CompanyDao;
import com.helper.entity.Company;


public class CompanyDaoImpl extends BaseDao implements CompanyDao {

	public Company findById(String cid) {
		// TODO Auto-generated method stub
		String sql="select * from basecompany where code=?";
		ResultSet rs=super.executeQuery(sql,cid);
		Company company=null;
		try {
			if(rs.next()){
				company=new Company();
				company.setCid(rs.getString("code"));
				company.setcName(rs.getString("compname"));
				company.setcAddress(rs.getString("compaddress"));
				company.setcPostCode(rs.getString("comppostCode"));
				company.setcPhone(rs.getString("compphone"));
				company.setcFax(rs.getString("compfax"));
				company.setcUrl(rs.getString("compurl"));
				company.setcEmail(rs.getString("compemail"));
				company.setcLegaler(rs.getString("complegaler"));
				company.setcAgent(rs.getString("compagent"));
				company.setcAccount(rs.getString("compaccount"));
				company.setcBank(rs.getString("compbank"));
				company.setcTax(rs.getString("comptax"));
				company.setcMark(rs.getString("remarks"));
				company.setcShow(rs.getString("isshow"));
				company.setcDate(rs.getTime("adddate"));
				company.setcLogo(rs.getString("complogo"));
				company.setcUser(rs.getString("adduser"));
				company.setcUserName(rs.getString("addusername"));
				company.setcIp(rs.getString("addip"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		return company;
		
	}

	
	public int find(String cid) {
		// TODO Auto-generated method stub
		String sql="select code from basecompany";
		if(sql!=null){
			if(sql.equals(cid)){
				return 1;
			}
			return 0;
		}
		return 0;
		
	}
	public int update(Company company) {
		// TODO Auto-generated method stub
		
		String sql="update basecompany set compname=?,compaddress=?," +
				"comppostcode=?,compphone=?,compfax=?,compurl=?,"+
				"compemail=?,complegaler=?,compagent=?,"+
				"compaccount=?,compbank=?,comptax=?,remarks=? where code=?";
		
		return super.executeUpdate(sql,
				new Object[]{company.getcName(),company.getcAddress(),
				company.getcPostCode(),company.getcPhone(),company.getcFax(),
				company.getcUrl(),company.getcEmail(),company.getcLegaler(),
				company.getcAgent(),company.getcAccount(),company.getcBank(),
				company.getcTax(),company.getcMark(),company.getCid()}
		);
	}
	public int insert(Company company) {
		// TODO Auto-generated method stub
		String sql="insert into basecompany(code,compname,compaddress,comppostcode,compphone,compfax,compurl,compemail,complegaler,compagent,compaccount,compbank,comptax,remarks) " +
				"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int ret= super.executeUpdate(sql,new Object[]{
				company.getCid(),company.getcName(),company.getcAddress(),
				company.getcPostCode(),company.getcPhone(),company.getcFax(),
				company.getcUrl(),company.getcEmail(),company.getcLegaler(),
				company.getcAgent(),company.getcAccount(),company.getcBank(),
				company.getcTax(),company.getcMark()});
		return ret;

	}


	@Override
	public Company findCompany() {
		// TODO Auto-generated method stub
		String sql="select * from basecompany";
		ResultSet rs=super.executeQuery(sql);
		Company company = null;
		try {
			if(rs.next()){
				company=new Company();
				company.setCid(rs.getString("code"));
				company.setcName(rs.getString("compname"));
				company.setcAddress(rs.getString("compaddress"));
				company.setcPostCode(rs.getString("comppostCode"));
				company.setcPhone(rs.getString("compphone"));
				company.setcFax(rs.getString("compfax"));
				company.setcUrl(rs.getString("compurl"));
				company.setcEmail(rs.getString("compemail"));
				company.setcLegaler(rs.getString("complegaler"));
				company.setcAgent(rs.getString("compagent"));
				company.setcAccount(rs.getString("compaccount"));
				company.setcBank(rs.getString("compbank"));
				company.setcTax(rs.getString("comptax"));
				company.setcMark(rs.getString("remarks"));
				company.setcShow(rs.getString("isshow"));
				company.setcDate(rs.getTime("adddate"));
				company.setcLogo(rs.getString("complogo"));
				company.setcUser(rs.getString("adduser"));
				company.setcUserName(rs.getString("addusername"));
				company.setcIp(rs.getString("addip"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			super.closeAll();
		}
		return company;
	}

	

}
