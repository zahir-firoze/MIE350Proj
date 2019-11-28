package com.vgi.dao;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vgi.model.Inventory;
import com.vgi.model.Store;
import com.vgi.util.DbUtil;

public class StoreDao {
	
	private Connection connection;
	
	public StoreDao() {
		/**
		 * Get the database connection.
		 */
		connection = DbUtil.getConnection();
	}
	
	public Store getStore(int storeID) {
		/*This method returns a store based on StoreID.*/
		Store store = new Store();
		
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from Store where StoreID = ?");
			
			preparedStatement.setInt(1, storeID);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) { //is loop necessary?
				store.setStoreID(rs.getInt("StoreID"));
				store.setName(rs.getString("Name"));
				store.setStreetAddress(rs.getString("StreetAddress"));
				store.setPostalCode(rs.getString("PostalCode"));
				store.setCity(rs.getString("City"));
				store.setProvince(rs.getString("Province"));
				store.setOpeningTime(rs.getString("OpeningTime"));
				store.setClosingTime(rs.getString("ClosingTime"));
				store.setDaysOfOperation(rs.getString("DaysofOperation"));
				store.setTelephoneNumber(rs.getString("TelephoneNumber"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return store;
	}
}
