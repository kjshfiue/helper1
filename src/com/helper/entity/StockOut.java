package com.helper.entity;

import java.util.Date;

/*
 * ������:���ⵥ�ݹ���
 * @author:����̩
 */
public class StockOut {
	private String code;
	private Date outDate;
	private String customerCode;//�ͻ����
	private String contActer;//�ͻ���ϵ��
	private String teltphone;
	private String fax;
	private String outType;
	private String isInVoice;//�Ƿ�Ʊ
	private String address;
	private String remarks;
	private String isShow;
	private Double nums;//��������
	private Double numSprice;//�����ܼ�ֵ
	private String state;//���ⵥ�����״̬
	private Date addDate;
	private String addUser;
	private String addUserName;
	private String addIp;
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Date getOutDate() {
		return outDate;
	}
	public void setOutDate(Date outDate) {
		this.outDate = outDate;
	}
	public String getCustomerCode() {
		return customerCode;
	}
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}
	public String getContActer() {
		return contActer;
	}
	public void setContActer(String contActer) {
		this.contActer = contActer;
	}
	public String getTeltphone() {
		return teltphone;
	}
	public void setTeltphone(String teltphone) {
		this.teltphone = teltphone;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getOutType() {
		return outType;
	}
	public void setOutType(String outType) {
		this.outType = outType;
	}
	public String getIsInVoice() {
		return isInVoice;
	}
	public void setIsInVoice(String isInVoice) {
		this.isInVoice = isInVoice;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getIsShow() {
		return isShow;
	}
	public void setIsShow(String isShow) {
		this.isShow = isShow;
	}
	public Double getNums() {
		return nums;
	}
	public void setNums(Double nums) {
		this.nums = nums;
	}
	public Double getNumSprice() {
		return numSprice;
	}
	public void setNumSprice(Double numSprice) {
		this.numSprice = numSprice;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public Date getAddDate() {
		return addDate;
	}
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	public String getAddUser() {
		return addUser;
	}
	public void setAddUser(String addUser) {
		this.addUser = addUser;
	}
	public String getAddUserName() {
		return addUserName;
	}
	public void setAddUserName(String addUserName) {
		this.addUserName = addUserName;
	}
	public String getAddIp() {
		return addIp;
	}
	public void setAddIp(String addIp) {
		this.addIp = addIp;
	}
	
	
	
}
