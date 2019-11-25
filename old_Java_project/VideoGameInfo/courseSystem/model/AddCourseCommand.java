package courseSystem.model;

import java.sql.SQLException;
import java.util.Iterator;

/**
 * Implementation of <tt>Command</tt> used to handle the addCourse command
 * <p>
 * 
 * Required format in commands file (quotations indicates literal value): <br>
 * "addCourse",courseCode,courseName,professorID(int),
 */
class AddCourseCommand implements Command {
	/**
	 * Adds new course to <tt>Main.courses</tt>, filled with data from arguments
	 * in <tt>Iterator args</tt>
	 */
	public void execute(Iterator args) {
		Course course = new Course();
		course.readUpdateData(args);
		boolean result1 = Main.insertCourse(course);
		boolean result2 = Main.insertTeaches(course);
		if (result1 && result2) {
			Main.logFile.write(" - New course " + course.getCode() + " successfully inserted.");
			try {
				Main.dbCon.commit();
			} catch (SQLException se) {
				SQLExceptionHandler.handleException(se);
			}
			Main.addCourse(course);
			Main.logFile.write(" - New course " + course.getCode() + " successfully added.");
		} else {
			try {
				Main.dbCon.rollback();
			} catch (SQLException se) {
				SQLExceptionHandler.handleException(se);
			}
			Main.logFile.write(" - New course " + course.getCode() + " failed to be inserted and added.");
		}
	}
}