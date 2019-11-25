package com.vgi.model;

public class Store {
	private int storeID;
	private int telephoneNumber;
	private String name;
	private String address;
	private String postalCode;
	private String city;
	private String province;
	private String daysOfOperation;
	
	//TODO see what object gets returned when parsing openingTime and closingTime from the table
	private int openingTime;
	private int closingTime;
	
	//TODO change return type of get method
	public int getOpeningTime(){
		return openingTime;
	}
	//TODO change return type of get method
	public int getClosingTime(){
		return closingTime;	
	}
	
	public int getStoreID(){
		return storeID;
	}
	public int getTelephoneNumber(){
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
	
	@Override
	public String toString(){
		return "Store [ storeID=${storeID}, telephoneNumber=${telephoneNumber}, name=${name},address=${address}, postalCode=${postalCode}, city=${city}, province=${province}, daysOfOperation=${daysOfOperation}, openingTime=${openingTime}, closingTime=${closingTime} ]";
	}
	

}
