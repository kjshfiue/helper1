package com.helper.entity;

public class PrividerName {
	private String salerCode;
	private String saerName;
	private String salerLegaler;
	private String salerFax;
	private String salerAddress;
	private String salerTelphone;
	public String getSalerTelphone() {
		return salerTelphone;
	}
	public void setSalerTelphone(String salerTelphone) {
		this.salerTelphone = salerTelphone;
	}
	public String getSalerCode() {
		return salerCode;
	}
	public void setSalerCode(String salerCode) {
		this.salerCode = salerCode;
	}
	public String getSaerName() {
		return saerName;
	}
	public void setSaerName(String saerName) {
		this.saerName = saerName;
	}
	public String getSalerLegaler() {
		return salerLegaler;
	}
	public void setSalerLegaler(String salerLegaler) {
		this.salerLegaler = salerLegaler;
	}
	public String getSalerFax() {
		return salerFax;
	}
	public void setSalerFax(String salerFax) {
		this.salerFax = salerFax;
	}
	public String getSalerAddress() {
		return salerAddress;
	}
	public void setSalerAddress(String salerAddress) {
		this.salerAddress = salerAddress;
	}
	public PrividerName(String salerCode, String saerName, String salerLegaler,
			String salerFax, String salerAddress,String salerTelphone) {
		super();
		this.salerTelphone = salerTelphone;
		this.salerCode = salerCode;
		this.saerName = saerName;
		this.salerLegaler = salerLegaler;
		this.salerFax = salerFax;
		this.salerAddress = salerAddress;
	}
	public PrividerName() {
		super();
	}
	
	
	

}
