package com.vgi.model;

public class CustomerRatingReview {
	private int upcNumber;
	private String email;
	private double rating;
	private String review;
	
	public int getUPCNumber(){
		return upcNumber;
	}
	public double getRating(){
		return rating;
	}
	public String getEmail(){
		return email;
	}
	public String getReview(){
		return review;
	}
	
	@Override 
	public String toString(){
		return "CustomerRatingReview [ upcNumber=${upcNumber}, email=${email}, rating=${rating}, review=${review}";
	}
	
}
