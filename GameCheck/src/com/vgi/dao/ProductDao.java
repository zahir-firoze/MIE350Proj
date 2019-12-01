package com.vgi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vgi.model.VideoGame;
import com.vgi.util.DbUtil;

public class ProductDao {
private Connection connection;
	
	public ProductDao(){
		/**
		 * Get the database connection.
		 */
		connection = DbUtil.getConnection();
	}
	
	/*
	 * Returns boolean value to determine if the upc number is for a videogame
	 */
	public boolean isVideoGame(int upcNumber){
		boolean found = false;
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT * FROM VideoGames WHERE UPC=?");
			preparedStatement.setInt(1, upcNumber);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				found = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return found;
	}
	
	/*
	 * Returns boolean value to determine if the upc number is for an accessory
	 */
	public boolean isAccessory(int upcNumber){
		boolean found = false;
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT * FROM Accessories WHERE UPC=?");
			preparedStatement.setInt(1, upcNumber);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				found = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return found;
	}
}
