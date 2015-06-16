package com.helper.entity;

import java.util.Date;

/*
 * 库存管理:入库单据管理
 * @author:王开泰
 */
public class StockIn {
	
	private String code;
	private Date inDate;
	private String supplierCode;//供应商编号
	private String contActer;//联系人
	private String teltphone;
	private String fax;
	private String inType;
	private String isRoad;//入库用途
	private String isInVoice;//是否开票
	private String remarks;
	private String isShow;//是否显示
	private Double nums ;//入库配件数量
	private Double numSprice;//入库配件总价值
	private String state;//入库单状态
	private String compCode;//所属公司
	private Date addDate;//操作日期
	private String addUser;//操作帐号
	private String addUserName;//操作人姓名
	private String addIp;//操作IP
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Date getInDate() {
		return inDate;
	}
	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}
	public String getSupplierCode() {
		return supplierCode;
	}
	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
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
	public String getInType() {
		return inType;
	}
	public void setInType(String inType) {
		this.inType = inType;
	}
	public String getIsRoad() {
		return isRoad;
	}
	public void setIsRoad(String isRoad) {
		this.isRoad = isRoad;
	}
	public String getIsInVoice() {
		return isInVoice;
	}
	public void setIsInVoice(String isInVoice) {
		this.isInVoice = isInVoice;
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
	public String getCompCode() {
		return compCode;
	}
	public void setCompCode(String compCode) {
		this.compCode = compCode;
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
