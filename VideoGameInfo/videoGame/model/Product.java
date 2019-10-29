package videoGame.model;

public class Product {
	protected int upcNumber;
	protected double price;
	
	protected String consoleCompatability;
	protected String description;
	
	/**
	 * Obtains values for Product object
	 * respectively, contained in <tt>Main.dataInput</tt> 
	 *
	 * @param args - <tt>Iterator</tt> containing arguments from data files
	 * TODO fix error thrown
	 * @throws <tt>CMSError</tt> for error converting ID number to 
	 * <tt>int</tt> from <tt>String</tt> 
	 */
	public void readData (int pUpcNumber, double pPrice, String pConsoleCompatability,String pDescription) {
		try {
			this.upcNumber = pUpcNumber;
			this.price = pPrice;
			this.consoleCompatability = pConsoleCompatability;
			this.description = pDescription;
			
			
		}
		catch(NumberFormatException e) {
			//TODO make a new exception error for video game store
			throw new CMSError("Error converting UPC_Number to int");
		}
	}
	
	//TODO: Rewrite the getOutputLine() and displayInfo() method
//
//	/**
//	 * 
//	 * @return <tt>String</tt> with person's ID number, last name, first name, and email, 
//	 * in the same format as the input file
//	 */
//	public String getOutputLine () {
//		return idNum + "," + lastName + "," + firstName + "," + email + ",";
//	}
//	
//	/** 
//	 * Prints person's name and email to the log file
//	 *
//	 */
//	public void displayInfo () {
//		Main.logFile.write(" - Last Name: " + lastName);
//		Main.logFile.write(" - First Name: " + firstName);
//		Main.logFile.write(" - Email: " + email);
//	}
//	
	public int getUPCNumber(){
		return upcNumber;
	}
	
	public double getPrice(){
		return price;
	}
	public String getConsoleCompatability(){
		return consoleCompatability;
	}
	public String getDescription(){
		return description;
	}
}
