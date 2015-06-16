package com.helper.entity;

import java.util.Date;


public class CustomerLink {
	   private String code;
	   private String categoryCode; //所属类别    
	   private Date addDate;//添加日期
	   public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	public Date getAddDate() {
		return addDate;
	}
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	public String getCsName() {
		return csName;
	}
	public void setCsName(String csName) {
		this.csName = csName;
	}
	public String getSpell() {
		return spell;
	}
	public void setSpell(String spell) {
		this.spell = spell;
	}
	public String getContActor() {
		return contActor;
	}
	public void setContActor(String contActor) {
		this.contActor = contActor;
	}
	public String getTelPhone() {
		return telPhone;
	}
	public void setTelPhone(String telPhone) {
		this.telPhone = telPhone;
	}
	public String getMobliePhone() {
		return mobliePhone;
	}
	public void setMobliePhone(String mobliePhone) {
		this.mobliePhone = mobliePhone;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getQQ() {
		return QQ;
	}
	public void setQQ(String qQ) {
		QQ = qQ;
	}
	public String getPostcod() {
		return postcod;
	}
	public void setPostcod(String postcod) {
		this.postcod = postcod;
	}
	public String getMSN() {
		return MSN;
	}
	public void setMSN(String mSN) {
		MSN = mSN;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getAliwang() {
		return aliwang;
	}
	public void setAliwang(String aliwang) {
		this.aliwang = aliwang;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getLegaler() {
		return legaler;
	}
	public void setLegaler(String legaler) {
		this.legaler = legaler;
	}
	public String getTax() {
		return tax;
	}
	public void setTax(String tax) {
		this.tax = tax;
	}
	public String getAgent() {
		return agent;
	}
	public void setAgent(String agent) {
		this.agent = agent;
	}
	public String getIsShow() {
		return isShow;
	}
	public void setIsShow(String isShow) {
		this.isShow = isShow;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getAdduser() {
		return adduser;
	}
	public void setAdduser(String adduser) {
		this.adduser = adduser;
	}
	public String getAssUserName() {
		return assUserName;
	}
	public void setAssUserName(String assUserName) {
		this.assUserName = assUserName;
	}
	public String getAddIP() {
		return addIP;
	}
	public void setAddIP(String addIP) {
		this.addIP = addIP;
	}
	public String getCoompCode() {
		return coompCode;
	}
	public void setCoompCode(String coompCode) {
		this.coompCode = coompCode;
	}
	private String csName;    //客户名称
	   private String spell;// 拼音                VARCHAR2(50),
	   private String contActor;    //'联系人       VARCHAR2(50),
	   private String telPhone;//联系电话            VARCHAR2(20),
	   private String mobliePhone;//移动电话         VARCHAR2(20),
	   private String fax;//传真                  VARCHAR2(20),
	   private String email;//电子邮箱                VARCHAR2(50),
	   private String URL;//公司网址                  VARCHAR2(50),
	   private String address;//公司地址              VARCHAR2(100),
	   private String province;//所属省份PROVINCE             VARCHAR2(20),
	   private String city;//所在城市                 VARCHAR2(20),
	   private String QQ ;//                  VARCHAR2(20),
	   private String postcod;//邮政编码             VARCHAR2(20),
	   private String MSN   ;//               VARCHAR2(50),
	   private String account;//开户账号              VARCHAR2(50),
	   private String aliwang; //阿里旺旺ALIWANG              VARCHAR2(50),
	   private String bank;//银行                 VARCHAR2(100),
	   private String legaler;//法人代表            VARCHAR2(50),
	   private String tax;//税号                  VARCHAR2(50),
	   private String agent;//委托代理                VARCHAR2(50),
	   private String isShow;//是否显示1显示0不显示               CHAR(1),
	   private String remarks;//备注             VARCHAR2(100),
	   private String adduser;//操作用户              VARCHAR2(20),
	   private String assUserName;//操作用户名          VARCHAR2(50),
	   private String addIP;//操作用户Ip                VARCHAR2(20),
	   private String coompCode;//所在公司          VARCHAR2(20),
}
