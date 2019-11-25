package courseSystem.model;

import java.sql.SQLException;
import java.util.Iterator;

/**
 * Implementation of <tt>Command</tt> used to handle the addProfessor command
 * <p>
 * Required format in commands file (quotations indicates literal value): <br>
 * "addProfessor",professorID(int),lastName,firstName,email,officeLocation,
 */
class AddProfessorCommand implements Command {
	/**
	 * Reads in a new professor from <tt>args</tt> and adds to the system
	 */
	public void execute(Iterator args) {
		Professor professor = new Professor();
		professor.readUpdateData(args);
		boolean result = Main.insertProfessor(professor);
		// insert student into the database
		if (result) {
			Main.logFile.write(" - New professor " + professor.getId() + " successfully inserted.");
			try {
				Main.dbCon.commit();
			} catch (SQLException se) {
				SQLExceptionHandler.handleException(se);
			}
			Main.addProfessor(professor);
			Main.logFile.write(" - New professor " + professor.getId() + " successfully added.");
		} else {
			try {
				Main.dbCon.rollback();
			} catch (SQLException se) {
				SQLExceptionHandler.handleException(se);
			}
			Main.logFile.write(" - New professor " + professor.getId() + " failed to be inserted and added.");
		}
	}
}