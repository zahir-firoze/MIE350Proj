package com.vgi.tuple;

public class PriceRange {
	private double upperLimit;
	private double lowerLimit;
	private double oneSidedLimit;
	
	//true -> apply ">" ; false -> apply "<"
	private boolean oneSideRange;
	private boolean applyGreaterSign;
	
	public PriceRange(double lowerLimit, double upperLimit){
		this.upperLimit = upperLimit;
		this.lowerLimit = lowerLimit;
		this.oneSideRange = false;
	}
	
	public PriceRange(double oneSidedLimit,boolean applyGreaterSign ){
		this.oneSidedLimit = oneSidedLimit;
		this.applyGreaterSign = applyGreaterSign;
		this.oneSideRange = true;
		
	}
	
	public double getUpperLimit(){
		return upperLimit;
	}
	public double getLowerLimit(){
		return lowerLimit;
	}
	public double getOneSidedLimit(){
		return oneSidedLimit;
	}
	public boolean getApplyGreaterSign(){
		return applyGreaterSign;
	}
	public boolean getOneSideRange(){
		return oneSideRange;
	}
	/*
	 * Setters
	 */
	public void setUpperLimit(double upperLimit){
		this.upperLimit = upperLimit;
	}
	public void setLowerLimit(double lowerLimit){
		this.lowerLimit = lowerLimit;
	}
	public void setOneSidedLimit(double oneSidedLimit){
		this.oneSidedLimit = oneSidedLimit;
	}
	public void setApplyGreaterSign(boolean applyGreaterSign){
		this.applyGreaterSign = applyGreaterSign;
	}
	public void getOneSideRange(boolean oneSideRange){
		this.oneSideRange = oneSideRange;
	}
	@Override
	public String toString() {
		String output;
		if (oneSideRange){
			output = "PriceRange [ oneSidedLimit=" + oneSidedLimit +", applyGreaterSign=" + applyGreaterSign + "]";
		}
		else{
			output = "PriceRange [ upperLimit=" +upperLimit +", lowerLimit=" + lowerLimit + "]";
		}
		return output;
	}
}
