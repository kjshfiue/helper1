package com.helper.entity;

public class SaleOrderDetail {
	private String code;//��ϸ����
	private String scode;//���۵����
	private String sqcode;//���۵����
	private String pcode;//������
	private int nums;//����
	private int price;//���۵���
	private String state;//�Ƿ����0-δ���� 1-ȫ������ 2-���ֳ���
	private int cknums;//��������
	private String remarks;//��ע
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
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
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
