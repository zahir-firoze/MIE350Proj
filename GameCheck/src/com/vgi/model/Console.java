package com.vgi.model;

public class Console {
	private String name;
	private String informationURL;
	private String purchaseURL;
	
	//Getter methods
	
	public String getName(){
		return name;
	}
	
	
	public String getInformationURL(){
		return informationURL;
	}
	
	
	public String getPurchaseURL(){
		return purchaseURL;
	}
	
	//Setter methods
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setInformationURL(String informationURL){
		this.informationURL = informationURL;
	}
	
	public void setPurchaseURL(String purchaseURL){
		this.purchaseURL = purchaseURL;
	}
	
	//Output
	
	@Override
	//public String toString(){
		//return "Console [name=${name}, informationURL=${informationURL}, purchaseURL=${purchaseURL}]";
	public String toString(){
		return "Console [Name= " +name +", InformationURL = " +informationURL
				+ ", PurchaseURL = " +purchaseURL +"]";
	}
}
