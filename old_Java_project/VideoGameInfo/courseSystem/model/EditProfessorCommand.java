package courseSystem.model;
import java.util.Iterator;

/**
 * Implementation of <tt>Command</tt> used to handle the editProfessor command
 * <p>
 * Required format in commands file (quotations indicates literal value):
 * <br>
 * "editProfessor",professorID(int),lastName,firstName,email,officeLocation,
 */
class EditProfessorCommand implements Command {
	/**
	 * Reads in a new course from <tt>args</tt> then edits the existing
	 * course in Main if it exists 
	 */
	public void execute (Iterator args) {
		try {
			Professor new_professor = new Professor();
			new_professor.readUpdateData(args);
			Main.editProfessor(new_professor);
			Main.logFile.write(" - Professor " + new_professor.getId() + " successfully edited.");
		}
		catch(NumberFormatException e) {
			throw new CMSError("Error attempting to convert professor ID to int");
		}
		catch(NotFoundException e){
			throw new CMSError(e.getMessage());
		}
	}
}