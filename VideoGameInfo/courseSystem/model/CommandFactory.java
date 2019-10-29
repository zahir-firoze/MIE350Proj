package courseSystem.model;

/**
 * An implementation of the factory design pattern to generate Command objects
 * based on a string specifying the name of the command.
 *
 */
class CommandFactory {
	/**
	 * Factory method used to return a concrete <tt>Command</tt> based upon
	 * supplied command type
	 * 
	 * @param cmd
	 *            <tt>String</tt> containing type of command
	 * @return concrete <tt>Command</tt>
	 */
	public static Command getCommand(String cmd) {
		if (cmd.equals("addStudent"))
			return new AddStudentCommand();
		else if (cmd.equals("addProfessor"))
			return new AddProfessorCommand();
		else if (cmd.equals("addCourse"))
			return new AddCourseCommand();
		else if (cmd.equals("addMark"))
			return new AddMarkCommand();
		else if (cmd.equals("displayStudent"))
			return new DisplayStudentCommand();
		else if (cmd.equals("displayProfessor"))
			return new DisplayProfessorCommand();
		else if (cmd.equals("displayCourse"))
			return new DisplayCourseCommand();
		else if (cmd.equals("editStudent"))
			return new EditStudentCommand();
		else if (cmd.equals("editProfessor"))
			return new EditProfessorCommand();
		else if (cmd.equals("editCourse"))
			return new EditCourseCommand();
		else if (cmd.equals("editMark"))
			return new EditMarkCommand();
		else {
			throw new CMSError("Error: Attempted to run non-existent command : " + cmd);
		}
	}
}
