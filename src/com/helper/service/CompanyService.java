package com.helper.service;

import com.helper.entity.Company;

public interface CompanyService {
	
	public int updateCompany(Company company);
	public int insertCompany(Company company);
	public Company findByIdCompany(String cid);
	public Company findCompany();
}
