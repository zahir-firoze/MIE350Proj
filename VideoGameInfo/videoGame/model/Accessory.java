package videoGame.model;

import java.util.NoSuchElementException;

public class Accessory extends Product{
	private String name;
	
	/**
	 * Obtains values for VideoGame object
	 * respectively, contained in <tt>Main.dataInput</tt> 
	 *
	 * @param args - <tt>Iterator</tt> containing arguments from data files
	 * TODO fix error thrown
	 * @throws <tt>CMSError</tt> for error converting ID number to 
	 * <tt>int</tt> from <tt>String</tt> 
	 */
	public void readData (int aUpcNumber, double aPrice,String aTitle, String aConsoleCompatability,String aDescription,String aName) {
		try {
			super.readData(aUpcNumber, aPrice, aConsoleCompatability,aDescription);
			
			this.name = aName;
			
		}
		catch (NoSuchElementException e) {
			throw new CMSError("Not enough attributes for Accessory");
		}
	}
	
	//TODO: Rewrite the getOutputLine() and displayInfo() methods
//
//	/**
//	 * 
//	 * @return <tt>String</tt> with person's ID number, last name, first name, and email, 
//	 * in the same format as the input file
//	 */
//	public String getOutputLine () {
	
//		return super.getOutputLine() + ;
//	}
//	
//	/** 
//	 * Prints person's name and email to the log file
//	 *
//	 */
//	public void displayInfo () {
//		super.displayInfo();
//		Main.logFile.write(" - Last Name: " + lastName);
//		Main.logFile.write(" - First Name: " + firstName);
//		Main.logFile.write(" - Email: " + email);
//	}
//	
	
	
	public String getName(){
		return name;
	}

}
