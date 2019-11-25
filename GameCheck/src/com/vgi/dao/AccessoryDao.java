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
import com.vgi.tuple.PriceRange;
import com.vgi.util.DbUtil;

public class AccessoryDao {
	/**
	 * This class handles all of the Accessory-related methods
	 * (filter/sort/get).
	 */
//	public static void main(String[] args){
//		AccessoryDao test = new AccessoryDao();
//		HashMap<String,Object> input = new HashMap<String,Object>();
//		
//		input.put("Price",15.99);
//		input.put("ConsoleCompatibility","Nintendo3DS");
//		input.put("Description","Hi Ciel");
//		System.out.println(test.getFilteredAccessories(input));
//	}
	private Connection connection;
	
	public AccessoryDao() {
		/**
		 * Get the database connection.
		 */
		connection = DbUtil.getConnection();
	}

	
	public List<Accessory> getFilteredAccessories(HashMap<String,Object> selectedAttributes){
		List<Accessory> accessoriesList = new ArrayList<Accessory>();
		String sqlQueryStatement = "SELECT * FROM Accessories";
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
					else if (selectedAttributes.get(f) instanceof PriceRange){
						PriceRange tempPR = (PriceRange) value;
						
						
						if(tempPR.getOneSideRange() && tempPR.getApplyGreaterSign()){
							//the price range is one sided with a ">" sign
							sqlQueryStatement = sqlQueryStatement + ">" + tempPR.getOneSidedLimit();
						}
						else if(tempPR.getOneSideRange() && !tempPR.getApplyGreaterSign()){
							//the price range is one sided with a "<" sign
							sqlQueryStatement = sqlQueryStatement + "<" + tempPR.getOneSidedLimit();
						}
						else{
							//format the query for the two bound price ranges
							sqlQueryStatement = sqlQueryStatement + ">=" + tempPR.getLowerLimit() + " AND " + columnName + "<=" + tempPR.getUpperLimit() ;
						}
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
				Accessory accessory = new Accessory();
				accessory.setUPCNumber(rs.getInt("UPC"));
				accessory.setName(rs.getString("Name"));
				accessory.setConsoleCompatability(rs.getString("ConsoleCompatibility"));
				accessory.setPrice(rs.getDouble("Price"));
				accessory.setDescription(rs.getString("Description"));
				accessory.setImageFileName(rs.getString("imageFileName"));
				//System.out.println(rs.getString("imageFileName"));
				accessoriesList.add(accessory);
			}
			
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return accessoriesList;
	}
 
}
