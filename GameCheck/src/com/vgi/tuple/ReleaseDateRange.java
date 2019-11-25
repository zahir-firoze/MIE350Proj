package com.vgi.tuple;

public class ReleaseDateRange {
	private String startDate;
	private String  endDate;
	private String oneSidedDate;
	private boolean oneSideRange;
	private boolean applyGreaterSign;
	
	public ReleaseDateRange(String startDate,String  endDate){
		this.startDate = startDate;
		this.endDate = endDate;
		this.oneSideRange = false;
	}
	public ReleaseDateRange(String oneSidedDate,boolean applyGreaterSign ){
		this.oneSidedDate = oneSidedDate;
		this.applyGreaterSign = applyGreaterSign;
		this.oneSideRange = true;
	}
	
	public String  getStartDate(){
		return startDate;
	}
	
	public String getEndDate(){
		return endDate;
	}
	
	public String getOneSidedDate(){
		return oneSidedDate; 
	}
	
	public boolean getApplyGreaterSign(){
		return applyGreaterSign;
	}
	public boolean getOneSideRange(){
		return oneSideRange;
	}
	
	public void setStartDate(String startDate){
		this.startDate = startDate;
	}
	
	public void setEndDate(String endDate){
		this.endDate = endDate;
	}
	public void setOneSidedLimit(String oneSidedDate){
		this.oneSidedDate = oneSidedDate;
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
			output = "PriceRange [ oneSidedDate=" +oneSidedDate +", applyGreaterSign=" + applyGreaterSign + "]";
		}
		else{
			output = "PriceRange [ startDate=" + startDate +", lowerLimit=" + endDate+ "]";
		}
		return output;
	}
}
