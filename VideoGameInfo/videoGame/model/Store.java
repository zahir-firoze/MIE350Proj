package videoGame.model;

public class Store {
	private int storeID;
	private int telephoneNumber;
	private String name;
	private String address;
	private String postalCode;
	private String city;
	private String province;
	private String daysOfOperation;
	
	
	
	//TODO see what object gets returned when parsing openingTime and closingTime from the table
	private int openingTime;
	private int closingTime;
	
	public void readData (int storeID, int telephoneNumber, String name,String postalCode,String city,String province,String daysOfOperation, int openingTime,int closingTime) {
		try {
			this.storeID = storeID;
			this.telephoneNumber = telephoneNumber;
			this.name = name;
			this.postalCode = postalCode;
			this.city = city;
			this.province = province;
			this.daysOfOperation = daysOfOperation;
			
			
			
			//TODO see what object gets returned when parsing openingTime and closingTime from the table
			this.openingTime = openingTime;
			this.closingTime = closingTime;
			
		}
		catch(NumberFormatException e) {
			//TODO make a new exception error for video game store
			throw new CMSError("Error converting storeID to int");
		}
	}
	//TODO: Rewrite the getOutputLine() and displayInfo() methods
	//
//		/**
//		 * 
//		 * @return <tt>String</tt> with person's ID number, last name, first name, and email, 
//		 * in the same format as the input file
//		 */
//		public String getOutputLine () {
		
//			return super.getOutputLine() + ;
//		}
	//	
//		/** 
//		 * Prints person's name and email to the log file
//		 *
//		 */
//		public void displayInfo () {
//			super.displayInfo();
//			Main.logFile.write(" - Last Name: " + lastName);
//			Main.logFile.write(" - First Name: " + firstName);
//			Main.logFile.write(" - Email: " + email);
//		}
	//	

	public int getStoreID(){
		return storeID;
	}
	public int getTelephoneNumber(){
		return telephoneNumber;
	}
	public String getAddress(){
		return address;
	}
	public String getName(){
		return name;
	}
	public String getPostalCode(){
		return postalCode;
	}
	public String getCity(){
		return city;
	}
	public String getProvince(){
		return province;
	}
	public String getDaysOfOperation(){
		return daysOfOperation;
	}
	
	
	
	//TODO change return type of get method
	public int getOpeningTime(){
		return openingTime;
	}
	//TODO change return type of get method
	public int getClosingTime(){
		return closingTime;	
	}

}
