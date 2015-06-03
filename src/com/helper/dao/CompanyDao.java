package com.helper.dao;

import com.helper.entity.Company;



public interface CompanyDao {
	
	public Company findById(String cid);
	public Company findCompany();
	public int update(Company company);
	public int insert(Company company);
	public int find(String cid);
	
}
