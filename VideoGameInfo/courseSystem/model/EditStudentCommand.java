package courseSystem.model;

import java.util.Iterator;

/**
 * Implementation of <tt>Command</tt> used to handle the editStudent command
 * <p>
 * Required format in commands file (quotations indicates literal value): <br>
 * "editStudent",studentID(int),lastName,firstName,email,
 */
class EditStudentCommand implements Command {

	/**
	 * Reads in a new student from <tt>args</tt> then edits this student in main
	 * if it exists
	 */
	public void execute(Iterator args) {

		try {
			Student new_student = new Student();
			new_student.readUpdateData(args);
			Main.editStudent(new_student);
		} catch (NumberFormatException e) {
			throw new CMSError("Error attempting to convert student ID to int");
		} catch (NotFoundException e) {
			throw new CMSError(e.getMessage());
		}
	}
}
