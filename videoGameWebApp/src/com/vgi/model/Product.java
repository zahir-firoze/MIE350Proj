package com.vgi.model;

public class Product {
	protected int upcNumber;
	protected double price;
	
	
	protected String description;
	protected String imageFileName;	

	public int getUPCNumber(){
		return upcNumber;
	}
	
	public double getPrice(){
		return price;
	}
	
	public String getDescription(){
		return description;
	}
	
	public String getImageFileName(){
		return imageFileName;
	}
	
	public void setUPCNumber(int upc){
		this.upcNumber = upc;
	}
	
	public void setPrice(double price){
		this.price = price;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
	public void setImageFileName(String imageFileName){
    	this.imageFileName = imageFileName;
	}
	@Override
	public String toString() {
		return "upcNumber=" + upcNumber + ", price=" + price+ ", description=" + description;
	}
}
