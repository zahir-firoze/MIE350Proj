package com.vgi.model;

public class Product {
	protected int upcNumber;
	protected double price;
	
	protected String consoleCompatability;
	protected String description;
		

	public int getUPCNumber(){
		return upcNumber;
	}
	
	public double getPrice(){
		return price;
	}
	public String getConsoleCompatability(){
		return consoleCompatability;
	}
	public String getDescription(){
		return description;
	}
	
	@Override
	public String toString() {
		return "upcNumber=" + upcNumber + ", price=" + price
				+ ", consoleCompatability=" + consoleCompatability + ", description=" + description;
	}
}
