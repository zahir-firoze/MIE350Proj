package com.vgi.dao;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vgi.model.Inventory;
import com.vgi.util.DbUtil;


public class InventoryDao {
	
	private Connection connection;
	
	public InventoryDao() {
		/**
		 * Get the database connection.
		 */
		connection = DbUtil.getConnection();
	}
	
	public List<Inventory> getProductInventory(int upc) {
		/*This method returns a list of inventory objects corresponding to a product
		 of interest's UPC number from all stores.*/
		List<Inventory> productstock = new ArrayList<Inventory>();
		
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from Inventory where UPCNumber = ?");
			
			preparedStatement.setInt(1, upc);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Inventory inventory = new Inventory();
				inventory.setUPCNumber(rs.getInt("UPCNumber"));
				inventory.setStoreID(rs.getInt("StoreID"));
				inventory.setQuantity(rs.getInt("Quantity"));
				productstock.add(inventory);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productstock;
	}
	
}
