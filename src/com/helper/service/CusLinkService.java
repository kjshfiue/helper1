package com.helper.service;

import java.util.List;
import java.util.Map;

import com.helper.dao.impl.PageBean;
import com.helper.entity.CustomerLink;

public interface CusLinkService {
	public PageBean findByPage(int pagenumber, int pagesize,String code,String name, String Date);
	public int Deletecus(String code);
	public int addCus(CustomerLink c);
	public int changeCus(CustomerLink c);
	public int  OutExcel(List<CustomerLink> l);
	public int getTotal(String code, String name,String cc);
	public List<CustomerLink> OutExcel(String code, String name, String cc);
	public void outWord(Map<String,Object> dataMap,String fileName);
}
