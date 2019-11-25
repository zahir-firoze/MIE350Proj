package courseSystem.model;

import java.sql.SQLException;
import java.util.Iterator;

/**
 * Implementation of <tt>Command</tt> used to handle the addStudent command
 * <p>
 * Required format in commands file (quotations indicates literal value): <br>
 * "addStudent",studentID(int),lastName,firstName,email,
 */
class AddStudentCommand implements Command {
	final static int OFFSET = 1;

	/**
	 * Reads in a new student from <tt>args</tt> and adds to the system
	 */
	public void execute(Iterator args) {
		Student student = new Student();
		student.readUpdateData(args);
		boolean result = Main.insertStudent(student);
		// insert student into the database
		if (result) {
			Main.logFile.write(" - New student " + student.getId() + " successfully inserted.");
			try {
				Main.dbCon.commit();
			} catch (SQLException se) {
				SQLExceptionHandler.handleException(se);
			}
			Main.addStudent(student);
			// add student to the list in the current instance of your application
			Main.logFile.write(" - New student " + student.getId() + " successfully added.");
		} else {
			try {
				Main.dbCon.rollback();
			} catch (SQLException se) {
				SQLExceptionHandler.handleException(se);
			}
			Main.logFile.write(" - New student " + student.getId() + " failed to be inserted and added.");
		}
	}
}
