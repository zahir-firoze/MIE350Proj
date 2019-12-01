package com.vgi.model;

public class Store {
	private int storeID;
	private String telephoneNumber;
	private String name;
	private String address;
	private String postalCode;
	private String city;
	private String province;
	private String daysOfOperation;
	
	
	private String openingTime;
	private String closingTime;
	
	public Store(){
		
	}
	public Store(Store store){
		this.storeID = store.getStoreID();
		this.telephoneNumber = store.getTelephoneNumber();
		this.name = store.getName();
		this.address = store.getAddress();
		this.postalCode = store.getPostalCode();
		this.city = store.getCity();
		this.province = store.getProvince();
		this.daysOfOperation = store.getDaysOfOperation();
		
		
		this.openingTime = store.getOpeningTime();
		this.closingTime = store.getClosingTime();
	}
	public String getOpeningTime(){
		return openingTime;
	}
	
	public String getClosingTime(){
		return closingTime;	
	}
	
	public int getStoreID(){
		return storeID;
	}
	public String getTelephoneNumber(){
		return telephoneNumber;
	}
	public String getAddress(){
		return address;
	}
	public String getName(){
		return name;
	}
	public String getPostalCode(){
		return postalCode;
	}
	public String getCity(){
		return city;
	}
	public String getProvince(){
		return province;
	}
	public String getDaysOfOperation(){
		return daysOfOperation;
	}
	
	//setters
	
	public void setStoreID(int storeID){
		this.storeID = storeID;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setStreetAddress(String StreetAddress){
		this.address = StreetAddress;
	}
	
	public void setPostalCode(String postalCode){
		this.postalCode = postalCode;
	}
	
	public void setCity(String city){
		this.city = city;
	}
	
	public void setProvince(String province){
		this.province = province;
	}
	
	public void setOpeningTime(String openingTime){
		this.openingTime = openingTime;
	}
	
	public void setClosingTime(String closingTime){
		this.closingTime = closingTime;
	}
	
	public void setDaysOfOperation(String daysOfOperation){
		this.daysOfOperation = daysOfOperation;
	}

	public void setTelephoneNumber(String telephoneNumber){
		this.telephoneNumber = telephoneNumber;
	}
	
	
	@Override
	public String toString(){
		//return "Store [ storeID=${storeID}, telephoneNumber=${telephoneNumber}, name=${name},address=${address}, postalCode=${postalCode}, city=${city}, province=${province}, daysOfOperation=${daysOfOperation}, openingTime=${openingTime}, closingTime=${closingTime} ]";
		
		return "Store [StoreID= " +storeID +", Name = " +name
		+ ", StreetAddress = " +address +", PostalCode = " +postalCode
		+ ", City = " +city
		+ ", Province = " +province
		+ ", OpeningTime = " +openingTime
		+ ", ClosingTime = " +closingTime
		+ ", DaysofOperation = " +daysOfOperation
		+ ", TelephoneNumber = " +telephoneNumber
		+ " ]";
	}
	

}
