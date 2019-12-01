package com.vgi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import java.util.ArrayList;
import java.util.List;

import com.vgi.model.CustomerRatingReview;
import com.vgi.util.DbUtil;

public class CustomerRatingReviewDao {
	/**
	 * This class handles all of the CustomerRatingReview-related methods
	 * (add/update/delete/get).
	 */
	private Connection connection;

	public CustomerRatingReviewDao() {
		
		/**
		 * Get the database connection.
		 */
		connection = DbUtil.getConnection();
	}
	/**
	 * This method adds a new rating to the database.
	 */
	public String addRatingReview(CustomerRatingReview crr){
		
		//this will return a message that will be sent as feedback to the user
		String outputMessage;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO CustomerRatingReview(UPCNumber,Email,Rating,Review) VALUES (?, ?, ?, ? )");
			// Parameters start with 1
			preparedStatement.setInt(1, crr.getUPCNumber());
			preparedStatement.setString(2, crr.getEmail());
			preparedStatement.setDouble(3, crr.getRating());
			preparedStatement.setString(4, crr.getReview());
			preparedStatement.executeUpdate();
			
			//if it reaches this point, the execution was successful
			outputMessage = "Successfully added your review!";
		} catch (SQLException e) {
			e.printStackTrace();
			outputMessage = "ERROR: Your review could not be added";
		}
		
		return outputMessage;
	}
	
	/**
	 * This method updates a user's review and rating into the database.
	 */
	public String updateRatingReview(CustomerRatingReview crr){
		
		//this will return a message that will be sent as feedback to the user
		String outputMessage;
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("UPDATE CustomerRatingReview SET Rating=?,Review=?"
							+ " WHERE Email=? AND UPCNumber=?");
			// Parameters start with 1
			
			preparedStatement.setDouble(1, crr.getRating());
			preparedStatement.setString(2, crr.getReview());
			preparedStatement.setString(3, crr.getEmail());
			preparedStatement.setInt(4,crr.getUPCNumber());
			preparedStatement.executeUpdate();
			
			//if it reaches this point, the execution was successful
			outputMessage = "Successfully updated your review!";
		} catch (SQLException e) {
			e.printStackTrace();
			outputMessage = "ERROR: Your review could not be updated";
		}
		
		return outputMessage;
	}

	public String deleteRatingReview(String email,int upc){
		//this will return a message that will be sent as feedback to the user
		String outputMessage;
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("DELETE FROM CustomerRatingReview WHERE Email=? AND UPCNumber=?");
			// Parameters start with 1
			preparedStatement.setString(1,email);
			preparedStatement.setInt(2, upc);
			preparedStatement.executeUpdate();
			
			//if it reaches this point, the execution was successful
			outputMessage = "Successfully deleted your review!";
		} catch (SQLException e) {
			e.printStackTrace();
			outputMessage = "ERROR: Your review could not be deleted";
		}
		
		return outputMessage;
	}
	
	public CustomerRatingReview retrieveRatingReview(String email,int upc){
		/*
		 * Gets the review for a specific product and email
		 */
		CustomerRatingReview crr = new CustomerRatingReview();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT * FROM CustomerRatingReview WHERE Email=? AND UPCNumber=?");
			// Parameters start with 1
			preparedStatement.setString(1,email);
			preparedStatement.setInt(2, upc);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				crr = new CustomerRatingReview();
				crr.setUPCNumber(rs.getInt("UPCNumber"));
				crr.setEmail(rs.getString("Email"));
				crr.setRating(rs.getDouble("Rating"));
				crr.setReview(rs.getString("Review"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		return crr;
	}
	/*
	 * Get all reviews for the specified product
	 */
	public List<CustomerRatingReview> getProductReviews(int upcNumber){
		List<CustomerRatingReview> ratingReviewList = new ArrayList<CustomerRatingReview>();
		CustomerRatingReview crr;
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT * FROM CustomerRatingReview WHERE UPCNumber=?");
			preparedStatement.setInt(1, upcNumber);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				crr = new CustomerRatingReview();
				crr.setUPCNumber(rs.getInt("UPCNumber"));
				crr.setEmail(rs.getString("Email"));
				crr.setRating(rs.getDouble("Rating"));
				crr.setReview(rs.getString("Review"));
				
				//add the review to the list
				ratingReviewList.add(crr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ratingReviewList;
	}
	/*
	 * Get all reviews for the specified product
	 */
	public List<CustomerRatingReview> getReviewsForProductPage(int upcNumber){
		List<CustomerRatingReview> ratingReviewList = new ArrayList<CustomerRatingReview>();
		CustomerRatingReview crr;
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT * FROM CustomerRatingReview WHERE UPCNumber=?");
			preparedStatement.setInt(1, upcNumber);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				crr = new CustomerRatingReview();
				crr.setUPCNumber(rs.getInt("UPCNumber"));
				crr.setEmail(rs.getString("Email"));
				crr.setRating(rs.getDouble("Rating"));
				crr.setReview(rs.getString("Review"));
				
				//add the review to the list
				ratingReviewList.add(crr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//retrieve a smaller size of review list for the product page
		//want to display 3 reviews max
		if(ratingReviewList.size() > 3){
			List<CustomerRatingReview> reducedList = new ArrayList<CustomerRatingReview>();
			
			for(int i = 0; i < 3; i++){
				reducedList.add(ratingReviewList.get(i));
			}
			return reducedList;
		}
		else{
			return ratingReviewList;
		}
		
	}
	/*
	 * Get average rating for the specified product
	 */
	public double getProductAverageRating(int upcNumber){
		double averageRating = 0.0;
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT AVG(Rating) FROM CustomerRatingReview WHERE UPCNumber=?");
			preparedStatement.setInt(1, upcNumber);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {

				averageRating = rs.getDouble(1);
	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return averageRating;
	}
	
}
