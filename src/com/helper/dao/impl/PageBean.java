package com.helper.dao.impl;

import java.util.List;

import com.helper.entity.CashInquery;

public class PageBean {
	
	
	 private int total;
	 private List datelist;
	 
	 
	 
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List getDatelist() {
		return datelist;
	}
	public void setDatelist(List datelist) {
		this.datelist = datelist;
	}
	public void setData(List<CashInquery> list) {
		// TODO Auto-generated method stub
		
	}
}
