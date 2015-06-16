package com.helper.entity;

public class SaleOrderDetail {
	
	private String code;//明细单号
	private String scode;//销售单编号
	private String sqcode;//报价单编号
	private Parts part;//配件编号
	private int nums;//数量
	private int price;//销售单价
	private String state;//是否出库0-未出库 1-全部出库 2-部分出库
	private int cknums;//出库数量
	private String remarks;//备注
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getScode() {
		return scode;
	}
	public void setScode(String scode) {
		this.scode = scode;
	}
	public String getSqcode() {
		return sqcode;
	}
	public void setSqcode(String sqcode) {
		this.sqcode = sqcode;
	}
	public Parts getPcode() {
		return part;
	}
	public void setPcode(Parts part) {
		this.part = part;
	}
	public int getNums() {
		return nums;
	}
	public void setNums(int nums) {
		this.nums = nums;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getCknums() {
		return cknums;
	}
	public void setCknums(int cknums) {
		this.cknums = cknums;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}
