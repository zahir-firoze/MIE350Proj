package com.vgi.tuple;

public class MaxPlayer {
	/*
	 * MaxPlayer class is primary used to hold information for the FilterFunction for VideoGame objects
	 */
	private int numPlayers;
	private boolean moreThan4;
	
	//use this when the specification is >4
	public MaxPlayer(int numPlayers,boolean moreThan4 ){
		this.numPlayers = numPlayers;
		this.moreThan4 = moreThan4;
	}
	
	public MaxPlayer(int numPlayers){
		this.numPlayers = numPlayers;
		if(numPlayers <= 4){
			this.moreThan4 = false;
		}
		else{
			this.moreThan4 = true;
		}
	}
	
	public int getNumPlayers(){
		return numPlayers;
	}
	
	public boolean isMoreThan4(){
		return moreThan4;
	}
	
	public void setNumPlayers(int numPlayers){
		this.numPlayers = numPlayers;
	}
	
	public void setMoreThan4(boolean moreThan4 ){
		this.moreThan4 = moreThan4;
	}
	
	@Override
	public String toString() {
		return "MaxPlayer [ numPlayers=" + numPlayers +", moreThan4=" + moreThan4+"]";
	}
	
}
