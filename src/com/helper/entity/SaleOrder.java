package com.helper.entity;

import java.util.Date;

public class SaleOrder {
	private String code;//销售单编号
	private Date orderDate;//订单日期
	private String customerCode;//客户编号
	private String contacter;//联系人
	private String telPhone;//联系电话
	private String fax;//传真
	private String trans;//运输方式
	private String businesser;//业务员
	private Date deliveryDate;//交货日期
	private String remarks;//备注
	private String isShow;//是否显示1-显示，0-不显示
	private int nums;//配件数量
	private int numSprice;//销售单总价格
	private String state;//审核状态1-已审核
	private Date addDate;//操作日期
	private String addUser;//操作人
	private String addUserName;//操作人姓名
	private String addIp;//操作IP
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getCustomerCode() {
		return customerCode;
	}
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}
	public String getContacter() {
		return contacter;
	}
	public void setContacter(String contacter) {
		this.contacter = contacter;
	}
	public String getTelPhone() {
		return telPhone;
	}
	public void setTelPhone(String telPhone) {
		this.telPhone = telPhone;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getTrans() {
		return trans;
	}
	public void setTrans(String trans) {
		this.trans = trans;
	}
	public String getBusinesser() {
		return businesser;
	}
	public void setBusinesser(String businesser) {
		this.businesser = businesser;
	}
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
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
	public int getNums() {
		return nums;
	}
	public void setNums(int nums) {
		this.nums = nums;
	}
	public int getNumSprice() {
		return numSprice;
	}
	public void setNumSprice(int numSprice) {
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
