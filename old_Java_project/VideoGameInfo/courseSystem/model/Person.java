package courseSystem.model;
import java.util.Iterator;

/**
 * <tt>abstract class</tt> containing methods and fields to used by concrete objects
 * that represent different sub-classes of people
 * <p>
 * <tt> idNum </tt> - a <tt>int</tt> containing the person's ID number
 * <br>
 * <tt> lastName </tt> - a <tt>String</tt> containing the person's last name
 * <br>
 * <tt> firstName </tt> - a <tt>String</tt> containing the person's first name
 * <br>
 * <tt> email </tt> - a <tt>String</tt> containing the person's e-mail address
 */
abstract class Person implements Outputable {
	private int idNum;
	private String lastName;
	private String firstName;
	private String email;
	
	/**
	 * Obtains ID number, last name, first name and email from the first four arguments, 
	 * respectively, contained in <tt>Main.dataInput</tt> 
	 *
	 * @param args - <tt>Iterator</tt> containing arguments from data files
	 * @throws <tt>CMSError</tt> for error converting ID number to 
	 * <tt>int</tt> from <tt>String</tt>
	 */
	public void readData (int pID, String pFirstName, String pLastName, String pEmail) {
		try {
			this.idNum = pID;
			this.lastName = pLastName;
			this.firstName = pFirstName;
			this.email = pEmail;
		}
		catch(NumberFormatException e) {
			throw new CMSError("Error converting ID to int");
		}
	}
	
	public void readUpdateData (Iterator args) {
		try {
			idNum = Integer.parseInt((String)args.next());
			lastName = (String)args.next();
			firstName = (String)args.next();
			email = (String)args.next();
		}
		catch(NumberFormatException e) {
			throw new CMSError("Error converting ID to int");
		}
	}
	public void edit(Person person){
		changeFirstName(person.getFirstName());
		changeLastName(person.getLastName());
		changeEmail(person.getEmail());
	}
	
	/**
	 * 
	 * @return <tt>String</tt> containing person's first name
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * 
	 * @return <tt>String</tt> containing person's last name
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * 
	 * @return <tt>String</tt> containing person's email address
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * 
	 * @return <tt>int</tt> containing person's ID number
	 */
	public int getId() {
		return idNum;
	}
	
	/**
	 * Changes <tt>firstName</tt> to supplied value
	 * 
	 * @param newFName - <tt>String</tt> containing new first name
	 */
	public void changeFirstName(String newFName) {
		firstName = newFName;
	}
	
	/**
	 * Changes <tt>lastName</tt> to supplied value
	 * 
	 * @param newLName - <tt>String</tt> containing new last name 
	 */
	public void changeLastName(String newLName) {
		lastName = newLName;
	}
	
	/**
	 * Changes <tt>email</tt> to supplied value
	 * 
	 * @param newEmail - <tt>String</tt> containing new email address
	 */
	public void changeEmail(String newEmail) {
		email = newEmail;
	}
	
	/**
	 * Changes <tt>idNum</tt> to supplied value
	 * 
	 * @param newId - <tt>int</tt> containing new ID number
	 */
	public void changeId (int newId) {
		idNum = newId;
	}
	
	/**
	 * 
	 * @return <tt>String</tt> with person's ID number, last name, first name, and email, 
	 * in the same format as the input file
	 */
	public String getOutputLine () {
		return idNum + "," + lastName + "," + firstName + "," + email + ",";
	}
	
	/** 
	 * Prints person's name and email to the log file
	 *
	 */
	public void displayInfo () {
		Main.logFile.write(" - Last Name: " + lastName);
		Main.logFile.write(" - First Name: " + firstName);
		Main.logFile.write(" - Email: " + email);
	}
}
