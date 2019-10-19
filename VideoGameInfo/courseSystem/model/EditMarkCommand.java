package courseSystem.model;

import java.sql.SQLException;
import java.util.Iterator;

/**
 * Implementation of <tt>Command</tt> used to handle the editMark command
 * <p>
 * Required format in commands file (quotations indicates literal value): <br>
 * "editMark",studentID(int),courseCode,mark(int),
 */
class EditMarkCommand implements Command {

	/**
	 * Finds student in <tt>Main.students</tt> corresponding to supplied student
	 * ID, then edits mark for the supplied course code with the supplied mark
	 * contained in the next two arguments in <tt>args</tt>
	 */
	public void execute(Iterator args) {
		try {
			int studId = Integer.parseInt((String) args.next());
			String crs_code = (String) args.next();
			int mark = Integer.parseInt((String) args.next());
			boolean result = Main.findStudent(studId).updateMark(crs_code, mark);
			if (result) {
				Main.logFile.write(" - The update query for student " + studId + " mark succeeded.");
				try {
					Main.dbCon.commit();
				} catch (SQLException se) {
					SQLExceptionHandler.handleException(se);
				}
				Main.findStudent(studId).editMark(crs_code, mark);
				Main.logFile.write(" - Mark for student " + studId + " successfully edited and inserted.");
			} else {
				try {
					Main.dbCon.rollback();
				} catch (SQLException se) {
					SQLExceptionHandler.handleException(se);
				}
				System.out.println("The update query for student " + studId + " mark failed.");
				Main.logFile.write(" - Mark for student " + studId + " failed to be edited.");
			}
		} catch (NumberFormatException e) {
			throw new CMSError("Error attempting to convert student ID or mark to int");
		} catch (NotFoundException e) {
			throw new CMSError(e.getMessage());
		}
	}
}