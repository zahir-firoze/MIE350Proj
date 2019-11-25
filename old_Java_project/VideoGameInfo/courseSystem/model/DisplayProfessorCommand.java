package courseSystem.model;

import java.util.Iterator;

/**
 * Implementation of <tt>Command</tt> used to handle the displayProfessor
 * command
 * <p>
 * Required format in commands file (quotations indicates literal value): <br>
 * "displayProfessor",professorID(int),
 */
class DisplayProfessorCommand implements Command {
	/**
	 * Prints out professor information to the log file for the professorID
	 * contained in the the next argument in <tt>args</tt>
	 */
	public void execute(Iterator args) {
		int profId = 0;

		try {
			profId = Integer.parseInt((String) args.next());
		} catch (NumberFormatException e) {
			throw new CMSError("Error attempting to convert professor ID to int");
		}

		boolean teaching = false;
		try {
			Main.logFile.write("Information for professor " + profId + ":");
			Main.findProfessor(profId).displayInfo();
			Main.logFile.write(" - Courses taught:");
			Iterator courses = Main.getCourses();
			while (courses.hasNext()) {
				Course course = (Course) courses.next();
				if (profId == course.getProfId()) {
					Main.logFile.write(" --- "+course.getCode() + ": " + course.getName());
					teaching = true;
				}
			}
		} catch (NotFoundException e) {
			throw new CMSError(e.getMessage());
		}
		if (!teaching)
			Main.logFile.write(" --- Currently not teaching any courses");
	}
}