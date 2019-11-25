package com.vgi.model;

public class Inventory {
	private int upcNumber;
	private int storeID;
	private int quantity;
	
	//Getter methods
	public int getUPCNumber(){
		return upcNumber;
	}
	
	
	public int getStoreID(){
		return storeID;
	}
	
	
	public int getQuantity(){
		return quantity;
	}
	
	//Setter methods
	
	public void setUPCNumber(int upcNumber){
		this.upcNumber = upcNumber;
	}
	
	public void setStoreID(int storeID){
		this.storeID = storeID;
	}
	
	public void setQuantity(int quantity){
		this.quantity = quantity;
	}
	
	//Output
	
	@Override
	public String toString(){
		/*return "Inventory [upcNumber=${upcNumber}, storeID=${storeID}, "
				+ "quantity=${quantity}]";*/
		return "Inventory [UPCNumber= " + upcNumber + ", StoreID = " +storeID
				+ ", Quantity = " +quantity +"]";
	}
}