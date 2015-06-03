package com.helper.dao;

import java.util.List;

import com.helper.dao.impl.PageBean;
import com.helper.entity.CustomerLink;


public interface  CusLInkDao {
	public int insert(CustomerLink c);
	public int delete (String code);
	public PageBean selectAll(int pagenumber,int pagesize,String code,String name, String Date);
	public int update(CustomerLink rs);
	public CustomerLink selectByCode(String code);
	public int selectTotal(String code, String name,String cc);
	public List<CustomerLink> selectAll(String code,String name, String cc);
}
