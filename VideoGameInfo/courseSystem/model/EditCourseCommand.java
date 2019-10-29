package courseSystem.model;

import java.util.Iterator;

/**
 * Implementation of <tt>Command</tt> used to handle the editCourse command
 * <p>
 * Required format in commands file (quotations indicates literal value): <br>
 * "editCourse",courseCode,courseName,professorID(int),
 */
class EditCourseCommand implements Command {
	/**
	 * reads in a new course from <tt>args</tt> then edits the existing course
	 * in Main if it exists
	 */
	public void execute(Iterator args) {
		try {
			Course new_course = new Course();
			new_course.readUpdateData(args);
			Main.editCourse(new_course);
			Main.logFile.write(" - Course " + new_course.getCode() + " successfully edited.");
		} catch (NotFoundException e) {
			throw new CMSError(e.getMessage());
		}
	}
}