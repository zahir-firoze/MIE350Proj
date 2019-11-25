package videoGame.model;

public class Console {
	private String name;
	private String informationURL;
	private String purchaseURL;
	
	public void readData (String name,String informationURL, String purchaseURL ) {
			this.name = name;
			this.informationURL = informationURL;
			this.purchaseURL = purchaseURL;
	
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

		public String getName(){
			return name;
		}
		
		
		public String getInformationURL(){
			return informationURL;
		}
		
		
		public String getPurchaseURL(){
			return purchaseURL;
		}
		
		
		
}
