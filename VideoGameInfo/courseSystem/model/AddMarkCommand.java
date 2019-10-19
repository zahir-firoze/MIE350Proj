package courseSystem.model;

import java.sql.SQLException;
import java.util.Iterator;

/**
 * Implementation of <tt>Command</tt> used to handle the addMark command
 * <p>
 * Required format in commands file (quotations indicates literal value): <br>
 * "addMark",studentID(int),courseCode,mark(int),
 */
class AddMarkCommand implements Command {
	/**
	 * Adds new course mark to sudent from data read in from <tt>args</tt>
	 */
	public void execute(Iterator args) {
		try {
			int studId = Integer.parseInt((String) args.next());
			String crs_code = (String) args.next();
			int mark = Integer.parseInt((String) args.next());

			Student student = Main.findStudent(studId);
			boolean result = student.insertCourseMark(crs_code, mark);
			if (result) {
				Main.logFile.write(" - New mark for student " + studId + " successfully inserted.");
				try {
					Main.dbCon.commit();
				} catch (SQLException se) {
					SQLExceptionHandler.handleException(se);
				}
				student.addCourseMark(crs_code, mark);
				Main.logFile.write(" - New mark for student " + studId + " successfully added.");
			} else {
				try {
					Main.dbCon.rollback();
				} catch (SQLException se) {
					SQLExceptionHandler.handleException(se);
				}
				Main.logFile.write(" - New mark for student " + studId + " failed to be inserted and added.");
			}
		} catch (NumberFormatException e) {
			throw new CMSError("Error attempting to convert student ID or mark to int");
		} catch (NotFoundException e) {
			throw new CMSError(e.getMessage());
		}
	}
}