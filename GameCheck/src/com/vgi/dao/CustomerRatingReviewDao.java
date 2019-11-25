package com.vgi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import com.vgi.model.CustomerRatingReview;

public class CustomerRatingReviewDao {
	/**
	 * This class handles all of the CustomerRatingReview-related methods
	 * (add/update/delete/get).
	 */
	private Connection connection;

	public CustomerRatingReviewDao() {
		//TODO
		/**
		 * Get the database connection.
		 */
		
	}
	
	public void addRatingReview(CustomerRatingReview crr){
		/**
		 * This method adds a new student to the database.
		 */
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into Customer_Rating_Review(UPC,Email,Rating,Review) values (?, ?, ?, ? )");
			// Parameters start with 1
			preparedStatement.setInt(1, crr.getUPCNumber());
			preparedStatement.setString(2, crr.getEmail());
			preparedStatement.setDouble(3, crr.getRating());
			preparedStatement.setString(4, crr.getReview());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//TODO
	public void updateRatingReview(CustomerRatingReview crr){
	}
	//TODO
	public void deleteRatingReview(CustomerRatingReview crr){
		
	}
	//TODO
//	public List<String> getProductReviews(int upcNumber){
//		/*
//		 * Get all reviews for the specified product
//		 */
//		return
//	}
	//TODO
	
//	public double getProductAverageRating(int upcNumber){
//		/*
//		 * Get average rating for the specified product
//		 */
//		return
//	}
	
}
