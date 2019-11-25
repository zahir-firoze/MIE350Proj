package com.vgi.model;

public class Accessory extends Product {
	private String name;
	private String consoleCompatability;
	
	public String getName(){
		return name;
	}
	public String getConsoleCompatability(){
		return consoleCompatability;
	}
	
	public void setName(String name){
		this.name = name;
	}
	public void setConsoleCompatability(String consoleCompatability){
		this.consoleCompatability = consoleCompatability;
	}
	
	@Override
	public String toString() {
		return "Accessory [" + super.toString() + ", name="+ name + ", consoleCompatability=" + consoleCompatability +"]";
	}
}
