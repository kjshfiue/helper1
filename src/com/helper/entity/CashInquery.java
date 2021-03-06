package com.helper.entity;

import java.util.Date;


public class CashInquery {
	    String code;//报价单编号
	    Date addDate;//报价日期
	    String supplierCode;//客户编号
	    String contacter;//联系人
	    String telphone;//电话
	    String fax;//传真
	    String nums;//总数量
	    String numSprice;//总价格
	    String isShow;//是否显示
	    String state;//状态
	    String remarks;//备注
	    String addUser;//操作日期
	    String addUserName;//操作人姓名
	    String addIP;//操作IP
	    String comPCode;//所属公司
	    
		public CashInquery() {
			super();
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public Date getAddDate() {
			return addDate;
		}

		public void setAddDate(Date addDate) {
			this.addDate = addDate;
		}

		public String getSupplierCode() {
			return supplierCode;
		}

		public void setSupplierCode(String supplierCode) {
			this.supplierCode = supplierCode;
		}

		public String getContacter() {
			return contacter;
		}

		public void setContacter(String contacter) {
			this.contacter = contacter;
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

		public String getNums() {
			return nums;
		}

		public void setNums(String nums) {
			this.nums = nums;
		}

		public String getNumSprice() {
			return numSprice;
		}

		public void setNumSprice(String numSprice) {
			this.numSprice = numSprice;
		}

		public String getIsShow() {
			return isShow;
		}

		public void setIsShow(String isShow) {
			this.isShow = isShow;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getRemarks() {
			return remarks;
		}

		public void setRemarks(String remarks) {
			this.remarks = remarks;
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

		public String getAddIP() {
			return addIP;
		}

		public void setAddIP(String addIP) {
			this.addIP = addIP;
		}

		public String getComPCode() {
			return comPCode;
		}

		public void setComPCode(String comPCode) {
			this.comPCode = comPCode;
		}

		public CashInquery(String code, Date addDate, String supplierCode,
				String contacter, String telphone, String fax, String nums,
				String numSprice, String isShow, String state, String remarks,
				String addUser, String addUserName, String addIP,
				String comPCode) {
			super();
			this.code = code;
			this.addDate = addDate;
			this.supplierCode = supplierCode;
			this.contacter = contacter;
			this.telphone = telphone;
			this.fax = fax;
			this.nums = nums;
			this.numSprice = numSprice;
			this.isShow = isShow;
			this.state = state;
			this.remarks = remarks;
			this.addUser = addUser;
			this.addUserName = addUserName;
			this.addIP = addIP;
			this.comPCode = comPCode;
		}
		

}
