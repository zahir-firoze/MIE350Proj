package com.vgi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vgi.model.Accessory;
import com.vgi.model.VideoGame;
import com.vgi.util.DbUtil;

public class VideoGameDao {

	private Connection connection;
	
	public VideoGameDao(){
		/**
		 * Get the database connection.
		 */
		connection = DbUtil.getConnection();
	}
	//TODO
	public List<VideoGame> getFilteredVideoGames(HashMap<String,Object> selectedAttributes){
		List<VideoGame> accessoriesList = new ArrayList<VideoGame>();
		String sqlQueryStatement = "SELECT * FROM VideoGames";
		String columnName;
		Object value;
		int counter = 1; //leave this at 1!!
		int sizeOfFilter = 0;
		try{
			Statement statement = connection.createStatement();
			
			
			//map can be of dynamic size
			
			if (!selectedAttributes.isEmpty()){
				//search in map which filters are to be applied for the SQL query
				//this for each loop creates the SQL Query
				sqlQueryStatement = sqlQueryStatement + " WHERE";
				sizeOfFilter = selectedAttributes.keySet().size();
				for (Object f : selectedAttributes.keySet()){
					//System.out.println(selectedAttributes.get(f).getClass());
					columnName = (String) f;
					value = selectedAttributes.get(f) ;
					sqlQueryStatement = sqlQueryStatement + " " + columnName;
					//format the query based on the object in the hashmap
					if (selectedAttributes.get(f) instanceof java.lang.String){
						sqlQueryStatement = sqlQueryStatement + "='" + value+"'";
					}
					else{
						sqlQueryStatement = sqlQueryStatement + "=" + value;
					}
					if (counter < sizeOfFilter){
						sqlQueryStatement = sqlQueryStatement + " AND";
					}
					counter++;
					//SELECT * FROM Accessories WHERE ConsoleCompatibility = '3DS' AND Price < 16;
				}
			}
			System.out.println("Query : " + sqlQueryStatement);
			//execute the dynamically created query
			ResultSet rs = statement.executeQuery(sqlQueryStatement);
			//save the list of found accessories in the list
			while (rs.next()) {
				VideoGame vg = new VideoGame();
				vg.setUPCNumber(rs.getInt("UPC"));
				vg.setTitle(rs.getString("Title"));
				vg.setDeveloper(rs.getString("Developer"));
				vg.setConsole(rs.getString("Console"));
				vg.setGenre(rs.getString("Genre"));
				vg.setReleaseDate(rs.getDate("Release_Date"));
				vg.setConsumerRating(rs.getDouble("Consumer_Rating"));
				vg.setEsrbRating(rs.getString("ESRB_Rating"));
				vg.setPrice(rs.getDouble("Price"));
				vg.setDescription(rs.getString("Description"));
				vg.setMaxPlayers(rs.getInt("Max_Players"));
				vg.setImageFileName(rs.getString("ImageFileName"));
				accessoriesList.add(vg);
			}
			
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return accessoriesList;
	}
 
}
