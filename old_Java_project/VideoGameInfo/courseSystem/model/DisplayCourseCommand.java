package courseSystem.model;

import java.util.Iterator;

/**
 * Implementation of <tt>Command</tt> used to handle the displayCourse command
 * <p>
 * Required format in commands file (quotations indicates literal value): <br>
 * "displayCourse",courseCode,
 */
class DisplayCourseCommand implements Command {
	/**
	 * Prints out course information to the log file for the course code
	 * contained in the the next argument in <tt>args</tt>
	 */
	public void execute(Iterator args) {
		try {
			String crscode = (String) args.next();
			Main.logFile.write("Information for course " + crscode + ":");
			Main.findCourse(crscode).displayInfo();
		} catch (NotFoundException e) {
			throw new CMSError(e.getMessage());
		}
	}
}
