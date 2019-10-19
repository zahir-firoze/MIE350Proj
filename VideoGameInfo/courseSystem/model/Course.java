package courseSystem.model;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An <tt>Outputable</tt> object that represents a course.
 * <p>
 * <tt> code </tt> - a <tt>String</tt> containing the course code (ex. MIE350)
 * <br>
 * <tt> name </tt> - a <tt>String</tt> containing course name (ex. Design and
 * Analysis of Information Systems) <br>
 * <tt> profId </tt> - a <tt>int</tt> containing the ID number of the course's
 * professor
 * <p>
 * Required format in course list file: <br>
 * courseCode,courseName,professorID,
 */
class Course implements Outputable {
	private String code;
	private String name;
	private int profId;

	/**
	 * Obtains course code, name and professor ID number from the first three
	 * arguments
	 *
	 * @param args
	 *            - <tt>Iterator</tt> containing arguments from data files
	 * @throws <tt>CMSError</tt>
	 *             error reading in new Course
	 */
	public void readData(String code, String name, int profId) {
		try {
			this.code = code;
			this.name = name;
			this.profId = profId;
		} catch (NumberFormatException e) {
			throw new CMSError("Error converting professor ID to int");
		} catch (NoSuchElementException e) {
			throw new CMSError("Not enough arguments for Course");
		}
	}

	public void readUpdateData(Iterator args) {
		try {
			code = (String) args.next();
			name = (String) args.next();
			profId = Integer.parseInt((String) args.next());
		} catch (NumberFormatException e) {
			throw new CMSError("Error converting ID to int");
		}
	}

	/**
	 * 
	 * @param course
	 *            = <tt>Course</tt> object with new data fields to update the
	 *            tuple in database
	 */

	public boolean update(Course course) {
		String code = course.getCode();
		String name = course.getName();
		int profId = course.getProfId();
		String qStr = "UPDATE Course Set CrsName = '" + name + "' WHERE CrsId = '" + code + "'; ";
		boolean updateResult1 = Main.runUpdate(qStr);
		if (updateResult1) {
			try {
				Main.dbCon.commit();
			} catch (SQLException se) {
				SQLExceptionHandler.handleException(se);
			}
		}
		qStr = "UPDATE Teaches Set ProfId = " + profId + " WHERE CrsId = '" + code + "'; ";
		boolean updateResult2 = Main.runUpdate(qStr);
		if (updateResult2) {
			try {
				Main.dbCon.commit();
			} catch (SQLException se) {
				SQLExceptionHandler.handleException(se);
			}
		}
		boolean result = updateResult1 && updateResult2;
		return result;
	}

	/**
	 * 
	 * @param course
	 *            = <tt>Course</tt> object with new data fields
	 */
	public void edit(Course course) {
		name = course.getName();
		profId = course.getProfId();
	}

	/**
	 * 
	 * @return <tt>int</tt> containing professor ID number
	 */
	public int getProfId() {
		return profId;
	}

	/**
	 * 
	 * @return <tt>String</tt> containing course code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 
	 * @return <tt>String</tt> containing course name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @return <tt>String</tt> with course code, course name, and professor ID
	 *         number, in the same format as the input file
	 */
	public String getOutputLine() {
		return code + "," + name + "," + profId + ",";
	}

	/**
	 * Prints course name and professor ID to log file
	 *
	 */
	public void displayInfo() {
		Main.logFile.write(" - Course Name: " + name);
		Main.logFile.write(" - Professor ID: " + profId);
	}
}
