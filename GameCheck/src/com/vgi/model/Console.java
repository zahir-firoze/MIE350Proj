package com.vgi.model;

public class Console {
	private String name;
	private String informationURL;
	private String purchaseURL;
	
	public String getName(){
		return name;
	}
	
	
	public String getInformationURL(){
		return informationURL;
	}
	
	
	public String getPurchaseURL(){
		return purchaseURL;
	}
	
	@Override
	public String toString(){
		return "Console [name=${name}, informationURL=${informationURL}, purchaseURL=${purchaseURL}]";
	}
}
