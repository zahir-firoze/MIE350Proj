package videoGame.model;

public class CustomerRatingReview {
	private int upcNumber;
	private String email;
	private double rating;
	private String review;
	
	public void readData (int upcNumber, String email, double rating, String review ) {
		try {
			this.upcNumber = upcNumber;
			this.email = email;
			this.rating = rating;
			this.review = review;
			
		}
		catch(NumberFormatException e) {
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
	public double getRating(){
		return rating;
	}
	public String getEmail(){
		return email;
	}
	public String getRating(){
		return review;
	}
	
	
}
