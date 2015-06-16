package com.helper.entity;

import java.util.Date;

/*
 * 库存管理:出库单据管理
 * @author:王开泰
 */
public class StockOut {
	private String code;
	private Date outDate;
	private String customerCode;//客户编号
	private String contActer;//客户联系人
	private String telphone;
	private String fax;
	private String outType;
	private String isInVoice;//是否开票
	private String address;
	private String remarks;
	private String isShow;
	private Double nums;//出库数量
	private Double numSprice;//出库总价值
	private String state;//出库单据审核状态
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
	public String getTelphone() {

		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
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
