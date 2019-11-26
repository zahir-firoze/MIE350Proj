package com.vgi.dao;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vgi.model.Console;
import com.vgi.model.Inventory;
import com.vgi.util.DbUtil;

public class ConsoleDao {

	private Connection connection;
	
	public ConsoleDao() {
		/**
		 * Get the database connection.
		 */
		connection = DbUtil.getConnection();
	}
	
	public Console getConsoleInfo(String consoleName) {
		/*This method returns an Console object containing information about 
		a given console, based on an input console name*/
		
		Console console= new Console();
		
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from Console where Name = ?");
			
			preparedStatement.setString(1, consoleName);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()){	
				console.setName(rs.getString("Name"));
				console.setInformationURL(rs.getString("InformationURL"));
				console.setPurchaseURL(rs.getString("PurchaseURL"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return console;
	}
}
