package courseSystem.model;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Extension of <tt>Person</tt> containing the additional fields and methods
 * required to represent professors
 * <p>
 * <tt> office </tt> - a <tt>String</tt> containing the professor's office
 * location (ex. BA8120)
 * <p>
 * Required format in professor list file: <br>
 * professorID,lastName,firstName,email,officeLocation,
 */
class Professor extends Person {
	private String office;

	/**
	 * Executes <tt>addData</tt> in <tt>Person</tt> then also obtains office
	 * location from the fifth argument contained in <tt>Main.dataInput</tt>
	 * 
	 * @param args
	 *            - <tt>Iterator</tt> containing arguments from data files
	 */
	public void readData(int pID, String pFirstName, String pLastName, String pEmail, String pOffice) {
		super.readData(pID, pFirstName, pLastName, pEmail);
		try {
			this.office = pOffice;
		} catch (NoSuchElementException e) {
			throw new CMSError("Not enough attributes for Professsor");
		}
	}

	public void readUpdateData(Iterator args) {
		super.readUpdateData(args);
		try {
			office = (String) args.next();
		} catch (NoSuchElementException e) {
			throw new CMSError("Not enough arguments for Professsor");
		}
	}

	public void edit(Professor edited) {
		super.edit(edited);
		changeOffice(edited.getOffice());
	}

	/**
	 * 
	 * @return <tt>String</tt> containing professor's office location
	 */
	public String getOffice() {
		return office;
	}

	/**
	 * Changes <tt>office</tt> to supplied value
	 * 
	 * @param newOffice
	 *            - <tt>String</tt> containing new office location
	 */
	public void changeOffice(String newOffice) {
		office = newOffice;
	}

	/**
	 * Executes <tt>getOutputLine</tt> in <tt>Person</tt> then also adds office
	 * location to output line
	 * 
	 * @return <tt>String</tt> with professors's ID number, last name, first
	 *         name, email, and office location, in the same format as the input
	 *         file
	 */
	public String getOutputLine() {
		return super.getOutputLine() + office + ",";
	}

	/**
	 * Calls <tt>displayInfo</tt> in <tt>Person</tt> and prints office location
	 * to log file
	 *
	 */
	public void displayInfo() {
		super.displayInfo();
		Main.logFile.write(" - Office: " + office);
	}

	public boolean update(Professor professor) {
		int profId = professor.getId();
		String proffname = professor.getFirstName();
		String proflname = professor.getLastName();
		String profemail = professor.getEmail();
		String office = professor.getOffice();

		String qStr = "UPDATE Professor Set FirstName = '" + proffname + "', LastName ='" + proflname + "', Email = '"
				+ profemail + "', Office = '" + office + "' WHERE ProfID =" + profId + "; ";
		boolean updateResult = Main.runUpdate(qStr);
		return updateResult;
	}

}
