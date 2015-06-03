package com.helper.service.impl;

import com.helper.dao.CompanyDao;
import com.helper.dao.impl.CompanyDaoImpl;
import com.helper.entity.Company;
import com.helper.service.CompanyService;


public class CompanyServiceImpl implements CompanyService {
	
	private CompanyDao companyDao=new CompanyDaoImpl();
	
	

	public int insertCompany(Company company) {
		// TODO Auto-generated method stub
		return companyDao.insert(company);
	}

	public Company findByIdCompany(String cid) {
		// TODO Auto-generated method stub
		
		return companyDao.findById(cid);
	}

	public int updateCompany(Company company) {
		// TODO Auto-generated method stub
		return companyDao.update(company);
	}

	@Override
	public Company findCompany() {
		// TODO Auto-generated method stub
		return companyDao.findCompany();
	}

}
