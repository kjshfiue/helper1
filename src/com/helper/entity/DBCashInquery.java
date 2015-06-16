package com.helper.entity;

public class DBCashInquery {
	
	private String pcode;
	private String nums;
	private String price;
	private String remarks;
	private String partsName;
	private String partsBrand;
	
	private String partsmodel;
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public String getNums() {
		return nums;
	}
	public void setNums(String nums) {
		this.nums = nums;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getPartsName() {
		return partsName;
	}
	public void setPartsName(String partsName) {
		this.partsName = partsName;
	}
	public String getPartsBrand() {
		return partsBrand;
	}
	public void setPartsBrand(String partsBrand) {
		this.partsBrand = partsBrand;
	}
	
	public String getPartsmodel() {
		return partsmodel;
	}
	public void setPartsmodel(String partsmodel) {
		this.partsmodel = partsmodel;
	}
	public DBCashInquery() {
		super();
	}
	public DBCashInquery(String pcode, String nums, String price,
			String remarks, String partsName, String partsBrand,
			String partsmodel) {
		super();
		this.pcode = pcode;
		this.nums = nums;
		this.price = price;
		this.remarks = remarks;
		this.partsName = partsName;
		this.partsBrand = partsBrand;
		this.partsmodel = partsmodel;
	}

}
