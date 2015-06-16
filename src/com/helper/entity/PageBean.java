package com.helper.entity;

import java.util.List;

public class PageBean {
	
	private List Data;
	private int pageSize;
	private int pageNo;
	private int pageCount;
	private int total;
	public List getData() {
		return Data;
	}
	public void setData(List data) {
		Data = data;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
}
