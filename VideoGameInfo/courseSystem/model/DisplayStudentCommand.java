package courseSystem.model;

import java.util.Iterator;

/**
 * Implementation of <tt>Command</tt> used to handle the displayStudent command
 * <p>
 * Required format in commands file (quotations indicates literal value): <br>
 * "displayStudent",studentID(int),
 */
class DisplayStudentCommand implements Command {
	/**
	 * Prints out student information to the log file for the studentID
	 * contained in the the next argument in <tt>args</tt>
	 */
	public void execute(Iterator args) {
		int studId = 0;

		try {
			studId = Integer.parseInt((String) args.next());
			Main.logFile.write("Information for student " + studId + ":");
			Student student = Main.findStudent(studId);
			student.displayInfo();
			student.displayMarks();
		} catch (NumberFormatException e) {
			throw new CMSError("Error attempting to convert student ID to int");
		} catch (NotFoundException e) {
			throw new CMSError(e.getMessage());
		}
	}
}
