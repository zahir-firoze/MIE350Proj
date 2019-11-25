package courseSystem.model;
import java.util.Iterator;

/**
 * An extension of <tt>Person</tt> containing the additional fields and methods required 
 * to handle transactions involving students
 * <p>
 * <tt> courseList </tt> - a <tt>String array</tt> containing the codes for all of the student's courses
 * <br>
 * <tt> markList </tt> - a <tt>int array</tt> containing the student's grades for each course, in the same order as <tt>courseList</tt>
 * <p>
 * Required format in student list file:
 * <br>
 * studentID,lastName,firstName,email,
 * <p>
 * Required format in marks list file:
 * <br>
 * studentID,courseCode1,mark1,courseCode2,mark2,...,courseCodeN,markN,
 */
class Student extends Person {
	private CourseMarks courseMarks = new CourseMarks();
	
	/**
	 * Obtains course code and mark for every course the student has a mark for in the marksList file. 
	 * The codes and grades are contained in <tt>Main.args</tt> 
	 * 
	 * @param args - <tt>Iterator</tt> containing arguments from data files
	 */
	public void readMarks (int studId) {
		courseMarks.readData(studId);
	}
	
	/**
	 * 
	 * @return <tt>String</tt> with students's ID number, course code and mark for each course, 
	 * in the same format as the input file
	 */
	public String getMarksOutputLine () {
		return getId() + "," + courseMarks.getOutputLine();
	}
	
	/**
	 * Inserts a new course grade code to the end of <tt>courseList</tt>, or intializes <tt>courseList</tt>
	 * with the course code
	 * 
	 * @param crscode - <tt>String</tt> containing the course code to add
	 */
	public boolean insertCourseMark (String crscode,int mark) {
		boolean result = courseMarks.insertMark(this.getId(),crscode,mark);
		return result;
	}
	/**
	 * Appends a new course code to the end of <tt>courseList</tt>, or intializes <tt>courseList</tt>
	 * with the course code
	 * 
	 * @param crscode - <tt>String</tt> containing the course code to add
	 */
	public void addCourseMark (String crscode,int mark) {
		courseMarks.addMark(crscode,mark);
	}
	
	/**
	 * Prints courses student is enrolled in, and the corresponding marks, to the log file
	 *
	 */
	public void displayMarks() {
		Main.logFile.write(courseMarks.getDisplay());
	}
	
	/**
	 * Changes the mark in <tt>markList</tt> to the new supplied mark for the course code supplied
	 * 
	 * @param crscode - <tt>String</tt> containing course code
	 * @param mark - <tt>int</tt> containing mark
	 */
	public void editMark (String crscode, int mark) {
		courseMarks.editMark(crscode,mark);
	}

	public boolean updateMark (String crscode, int mark) {
		boolean result = courseMarks.updateMark(this.getId(),crscode,mark);
		return result;
	}
	public boolean  update(Student student){
	    int stid = student.getId();
	    String stfname = student.getFirstName();
	    String stlname = student.getLastName();
	    String stemail = student.getEmail();

	    String qStr = "UPDATE Student Set FirstName = '" + stfname + "', LastName ='"+ stlname + "', Email = '"+ stemail + "' WHERE StID ="+ stid + " ";
		boolean updateResult = Main.runUpdate(qStr);
		return updateResult;
	}

}
