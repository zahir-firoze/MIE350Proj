/*
 * University of Toronto
 * MIE350 - Design & Analysis of Information Systems
 * Course Management System (CMS)
 */
package courseSystem.model;

import java.util.Iterator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Stores student, professor, marks and course data in respective objects. Reads
 * in data files and commands, intiates execution, and outputs modified data
 * files.
 * <p>
 * <tt> students </tt> - a <tt>Student array</tt> containing information about
 * every student. <br>
 * <tt> professors </tt> - a <tt>Professor array</tt> containing information
 * about every professor. <br>
 * <tt> courses </tt> - a <tt>Course array</tt> containing information about
 * every course.
 */
public class Main {
	private static StudentList students = new StudentList();
	private static ProfessorList professors = new ProfessorList();
	private static CourseList courses = new CourseList();
	public static Output logFile;
	public static Output resultFile;

	// Database Connection
	public static Connection dbCon;

	// Default file locations
	private static String DEFAULT_DIRECTORY = "./Data/";
	final static String STUDENTLIST_NAME = "StudentList";
	final static String PROFLIST_NAME = "ProfessorList";
	final static String MARKSLIST_NAME = "MarksList";
	final static String COURSELIST_NAME = "CourseList";
	public static String COMMANDS_NAME = "Commands.in";
	public static String LOG_NAME = "log.txt";

	private static String studentListLoc;
	private static String professorListLoc;
	private static String marksListLoc;
	private static String courseListLoc;
	private static String commandsLoc;
	private static String logLoc;

	/**
	 * This main method passes the application type (web or windows) to main1
	 * method Checks for arugments and assigns new values to data file locations
	 * if they exist. Calls methods to create log, add information to storage
	 * objects and intialize command execution.
	 * 
	 * @param args
	 *            - a <tt> String array </tt> containing arguments passed to
	 *            program (data directory location).
	 */
	public static void main(String[] args) {
		boolean webApp = false;

		Main.main1(args, webApp, DEFAULT_DIRECTORY);
	}

	public static void main1(String[] args, boolean webApp, String realPath) {

		dbCon = null;
		// change the default directory if the application runs as servlet.
		if (webApp) {

			DEFAULT_DIRECTORY = realPath;
			System.out.println("The application path is: " + realPath);
			logFile.write("The application path is: " + realPath);
		}

		try {
			Class.forName(DBConstants.DB_DRIVER);
		} catch (ClassNotFoundException cfe) {
			System.out.println("Failed loading the JDBC driver.");
			cfe.printStackTrace();
		}
		try {
			dbCon = DriverManager.getConnection(DBConstants.DB_CrsSystem);
		} catch (SQLException se) {
			SQLExceptionHandler.handleException(se);
		}
		try {
			dbCon.setAutoCommit(false); // to manage a transaction with multiple
										// SQL statements
		} catch (SQLException se) {
			SQLExceptionHandler.handleException(se);
		}

		String data_dir = DEFAULT_DIRECTORY;
		if (args.length > 0) {
			data_dir = args[0];
		}
		studentListLoc = data_dir + STUDENTLIST_NAME;
		professorListLoc = data_dir + PROFLIST_NAME;
		marksListLoc = data_dir + MARKSLIST_NAME;
		courseListLoc = data_dir + COURSELIST_NAME;
		commandsLoc = data_dir + COMMANDS_NAME;
		logLoc = data_dir + LOG_NAME;

		startLog();
		try {
			// read in data from the database and create all objects
			readInStudents();
			readInProfessors();
			readInMarks();
			readInCourses();

			// execute the commands in the command file
			doCommands();

			// write out the (changed) data to the datafiles
			writeOutStudents();
			writeOutProfessors();
			writeOutCourses();
			writeOutMarks();

			System.out.println("Execution successful: Please see log file for command execution details.");
			logFile.write("\r\nExecution successful: Please see log file for command execution details.");
		} catch (CMSError e) {
			logError(e.getMessage());
		}
		// close db connection
		try {
			dbCon.commit();
			dbCon.close();
		} catch (SQLException se) {
			SQLExceptionHandler.handleException(se);
		}

		closeLog();
	}

	/**
	 * Opens log file and outputs message indicating successful creation
	 * 
	 */

	public static void startLog() {
		System.out.println("Opening log file for output: " + logLoc);
		logFile = new Output(logLoc);
		logFile.open();
		logFile.write("Log Successfully Created\r\n");
	}

	/**
	 * Creates a new <tt>Student</tt> for every row in student list data file,
	 * then fills the new <tt>Student</tt> object with data in the row, and
	 * finally adds the student to the <tt>StudentList</tt>
	 * 
	 */

	public static ResultSet runSelect(String qStr) {
		String queryString = qStr;
		ResultSet inputList = null;
		Statement statement;
		if (dbCon == null) {
			return inputList;
		}
		try {
			statement = dbCon.createStatement();
			inputList = statement.executeQuery(queryString);
		} catch (SQLException se) {
			logFile.write("Execution of this query failed: " + queryString);
			SQLExceptionHandler.handleException(se);
		}
		logFile.write("Execution of this query succeeded: " + queryString);
		return inputList;
	}

	public static boolean runUpdate(String qStr) {
		String queryString = qStr;
		boolean result = false;
		Statement statement;
		PreparedStatement preparedStatement;
		if (dbCon == null) {
			return result;
		}
		try {
			statement = dbCon.createStatement();
			preparedStatement = dbCon.prepareStatement(queryString);
			preparedStatement.execute();
			result = true;
			statement.close();
			logFile.write("Execution of this query succeeded: " + queryString);
		} catch (SQLException se) {
			logFile.write("Execution of this query failed: " + queryString);
			SQLExceptionHandler.handleException(se);
		}
		// reza remove it
		// System.out.println(result);
		return result;
	}

	public static void readInStudents() {
		String qStr = "Select * from Student";
		ResultSet dataInput = runSelect(qStr);

		try {
			while (dataInput.next()) {
				int stid = dataInput.getInt("StID");
				String stfname = dataInput.getString("FirstName");
				String stlname = dataInput.getString("LastName");
				String stemail = dataInput.getString("Email");
				Student student = new Student();
				student.readData(stid, stfname, stlname, stemail);
				addStudent(student);

			}
		} catch (SQLException se) {
			SQLExceptionHandler.handleException(se);
		}

		logFile.write("Student list successfully inputted from database");
	}

	/**
	 * Creates a new <tt>Professor</tt> for every row in professor list data
	 * file, then fills <tt>object</tt> with data in the row.
	 * 
	 */
	public static void readInProfessors() {
		String qStr = "Select * from Professor";
		ResultSet dataInput = runSelect(qStr);
		try {
			while (dataInput.next()) {
				int prid = dataInput.getInt("ProfID");
				String prfname = dataInput.getString("FirstName");
				String prlname = dataInput.getString("LastName");
				String premail = dataInput.getString("Email");
				String proffice = dataInput.getString("Office");
				Professor professor = new Professor();
				professor.readData(prid, prfname, prlname, premail, proffice);
				addProfessor(professor);

			}
		} catch (SQLException se) {
			SQLExceptionHandler.handleException(se);
		}

		logFile.write("Professor list successfully inputted from " + professorListLoc);
	}

	/**
	 * Finds <tt>Student</tt> with same ID number for every row in marks list
	 * data file, then fills <tt>object</tt> with data in the row.
	 * 
	 * @throws <tt>NumberFormatException</tt>
	 *             for error converting ID number to <tt>int</tt> from
	 *             <tt>String</tt>
	 */
	public static void readInMarks() {
		String qStr = "Select stID from Student";
		ResultSet dataInput = runSelect(qStr);
		try {
			while (dataInput.next()) {
				int studId = dataInput.getInt("stID");

				try {
					Student student = findStudent(studId);
					student.readMarks(studId);
				} catch (NotFoundException e) {
					throw new CMSError(e.getMessage());
				} catch (NumberFormatException e) {
					throw new CMSError("readInMarks: Error attempting to convert student ID to int. from " + studId);
				}

			}
		} catch (SQLException se) {
			SQLExceptionHandler.handleException(se);
		}

		logFile.write("Marks list successfully inputted from " + marksListLoc);
	}

	/**
	 * Creates a new <tt>Course</tt> for every row in course list data file,
	 * then fills <tt>object</tt> with data in the row.
	 * 
	 */
	public static void readInCourses() {

		String qStr = "SELECT C.CrsID, C.CrsName, T.ProfID FROM Course C INNER JOIN Teaches T on (C.CrsID=T.CrsID);";
		ResultSet dataInput = runSelect(qStr);
		try {
			while (dataInput.next()) {
				String code = dataInput.getString("CrsID");
				String name = dataInput.getString("CrsName");
				int profId = dataInput.getInt("ProfID");
				Course course = new Course();
				course.readData(code, name, profId);
				addCourse(course);

			}
		} catch (SQLException se) {
			SQLExceptionHandler.handleException(se);
		}

		logFile.write("Course list successfully inputted from " + courseListLoc);
	}

	/**
	 * Reads in the command type, obtains the corresponding implementation, and
	 * then executes, for each command in the command file
	 * 
	 */
	public static void doCommands() {
		Input dataInput = new Input(commandsLoc);
		dataInput.open();
		int cmdCount = 0;
		while (dataInput.newLine()) {
			Iterator args = dataInput.grabArgs();
			String cmd = (String) args.next();
			Command newCommand = CommandFactory.getCommand(cmd);
			cmdCount++;
			logFile.write("\r\nStart Execution Command #" + cmdCount + ": " + dataInput.getLine());
			try {
				newCommand.execute(args);
			} catch (CMSError e) {
				throw new CMSError(
						e.getMessage() + " from " + dataInput.getFileDir() + " line " + dataInput.getLineIndex());
			}
			logFile.write("End Execution Command #" + cmdCount+"\r\n");
		}
		dataInput.close();
	}

	/**
	 * Prints the error message to the log file, closes the log, and exits the
	 * program
	 * 
	 * @param errMsg
	 *            - <tt>String</tt> containing error message
	 */
	public static void logError(String errMsg) {
		logFile.write(errMsg);
		System.err.println(errMsg);
		System.err.println("terminating program.");
	}

	/**
	 * Closes log file and outputs message indicating commands successfully
	 * completed
	 * 
	 */
	public static void closeLog() {
		System.out.println("Closing the log file: " + logLoc);
		logFile.close();
	}

	/**
	 * Creates an output file for the student list with same name and location
	 * as input, but with an out extension, then prints student information
	 * contained in <tt>students</tt> to the output file
	 * 
	 */
	public static void writeOutStudents() {
		String studentOutLoc = studentListLoc + ".out";
		writeOutList(studentOutLoc, getStudents());
		logFile.write("Student list successfully output to " + studentOutLoc);
	}

	private static void writeOutList(String listOutLoc, Iterator list) {
		Output dataOutput = new Output(listOutLoc);
		dataOutput.open();
		while (list.hasNext()) {
			Outputable next = (Outputable) list.next();
			dataOutput.write(next.getOutputLine());
		}
		dataOutput.close();
	}

	/**
	 * Creates an output file for the professor list with same name and location
	 * as input, but with an out extension, then prints professor information
	 * contained in <tt>professors</tt> to the output file
	 * 
	 */
	public static void writeOutProfessors() {
		String professorOutLoc = professorListLoc + ".out";
		writeOutList(professorOutLoc, getProfessors());
		logFile.write("Professor list successfully output to " + professorOutLoc);
	}

	/**
	 * Creates an output file for the course list with same name and location as
	 * input, but with an out extension, then prints course information
	 * contained in <tt>courses</tt> to the output file
	 * 
	 */
	public static void writeOutCourses() {
		String courseOutLoc = courseListLoc + ".out";
		writeOutList(courseOutLoc, getCourses());
		logFile.write("Course list successfully output to " + courseOutLoc);
	}

	/**
	 * Creates an output file for the course list with same name and location as
	 * input, but with an out extension, then prints course information
	 * contained in <tt>courses</tt> to the output file
	 * 
	 */
	public static void writeOutMarks() {
		// IH rewrite !
		String marksOutLoc = marksListLoc + ".out";
		Output dataOutput = new Output(marksOutLoc);
		dataOutput.open();
		Iterator students = getStudents();
		while (students.hasNext()) {
			Student student = (Student) students.next();
			dataOutput.write(student.getMarksOutputLine());
		}
		dataOutput.close();
		logFile.write("Marks list successfully output to " + marksOutLoc);
	}

	/**
	 * Inserts <tt>Student</tt> to <tt>student table in database</tt>
	 * 
	 * @param student
	 *            - <tt>Student</tt> to be inserted
	 */

	public static boolean insertStudent(Student student) {

		boolean result = students.insert(student);
		return result;
	}

	/**
	 * Adds <tt>Student</tt> to <tt>students</tt>
	 * 
	 * @param student
	 *            - <tt>Student</tt> to be added
	 */

	public static void addStudent(Student student) {

		students.add(student);
	}

	/**
	 * Inserts <tt>professor</tt> to <tt>Professor table in database</tt>
	 * 
	 * @param professor
	 *            - <tt>Professor</tt> to be inserted
	 */

	public static boolean insertProfessor(Professor professor) {
		boolean result = professors.insert(professor);
		return result;

	}

	/**
	 * /** Adds <tt>Professor</tt> to <tt>professors</tt>
	 * 
	 * @param professor
	 *            - <tt>Professor</tt> to be added
	 */
	public static void addProfessor(Professor professor) {
		professors.add(professor);
	}

	/**
	 * Inserts <tt>Course</tt> to <tt>courses</tt>
	 * 
	 * @param course
	 *            - <tt>Course</tt> to be inserted
	 */
	public static boolean insertTeaches(Course course) {
		boolean result = courses.insertT(course);
		return result;
	}

	/**
	 * Inserts <tt>Course</tt> to <tt>Teaches relation</tt>
	 * 
	 * @param course
	 *            - <tt>Course</tt> to be inserted
	 */
	public static boolean insertCourse(Course course) {
		boolean result = courses.insert(course);
		return result;
	}

	/**
	 * Adds <tt>Course</tt> to <tt>courses</tt>
	 * 
	 * @param course
	 *            - <tt>Course</tt> to be added
	 */
	public static void addCourse(Course course) {
		courses.add(course);
	}

	/**
	 * Finds student in <tt>students</tt> for a given student ID
	 * 
	 * @param studId
	 *            - <tt>int</tt> containing student ID
	 */
	public static Student findStudent(int studId) throws NotFoundException {
		return students.get(studId);
	}

	/**
	 * Finds professor in <tt>professors</tt> for a given professor ID
	 * 
	 * @param profId
	 *            - <tt>int</tt> containing professor ID
	 */
	public static Professor findProfessor(int profId) throws NotFoundException {
		return professors.get(profId);
	}

	/**
	 * Finds course in <tt>courses</tt> for a given course code
	 * 
	 * @param crscode
	 *            - <tt>String</tt> containing course code
	 */
	public static Course findCourse(String crscode) throws NotFoundException {
		return courses.get(crscode);
	}

	public static void editCourse(Course edited_course) throws NotFoundException {
		boolean result = findCourse(edited_course.getCode()).update(edited_course);
		if (result) {
			Main.logFile.write(" - Course " + edited_course.getCode() + " successfully updated.");
			findCourse(edited_course.getCode()).edit(edited_course);
			Main.logFile.write(" - Course " + edited_course.getCode() + " successfully edited.");
		} else {
			Main.logFile.write(" - Course " + edited_course.getCode() + " failed to be updated and edited.");
		}

	}

	public static void editProfessor(Professor edited_prof) throws NotFoundException {
		boolean result = findProfessor(edited_prof.getId()).update(edited_prof);
		if (result) {
			Main.logFile.write(" - Professor " + edited_prof.getId() + " successfully updated.");
			try {
				Main.dbCon.commit();
			} catch (SQLException se) {
				SQLExceptionHandler.handleException(se);
			}
			findProfessor(edited_prof.getId()).edit(edited_prof);
			Main.logFile.write(" - Professor " + edited_prof.getId() + " successfully edited.");
		} else {
			try {
				Main.dbCon.rollback();
			} catch (SQLException se) {
				SQLExceptionHandler.handleException(se);
			}
			Main.logFile.write(" - Professor " + edited_prof.getId() + " failed to be updated and edited.");
		}

	}

	public static void editStudent(Student edited_student) throws NotFoundException {
		boolean result = findStudent(edited_student.getId()).update(edited_student);
		if (result) {
			Main.logFile.write(" - Student " + edited_student.getId() + " successfully updated.");
			try {
				Main.dbCon.commit();
			} catch (SQLException se) {
				SQLExceptionHandler.handleException(se);
			}
			findStudent(edited_student.getId()).edit(edited_student);
			Main.logFile.write(" - Student " + edited_student.getId() + " successfully edited.");
		} else {
			try {
				Main.dbCon.rollback();
			} catch (SQLException se) {
				SQLExceptionHandler.handleException(se);
			}
			Main.logFile.write(" - Student " + edited_student.getId() + " failed to be updated and edited.");
		}
	}

	/**
	 * 
	 * @return - <tt>int</tt> containing the number of courses in the course
	 *         list
	 */
	public static int getNumCourses() {
		return courses.size();
	}

	/**
	 * 
	 * @return - <tt>Iterator</tt> containing all the courses in the course list
	 */
	public static Iterator getCourses() {
		return courses.iterator();
	}

	public static Iterator getProfessors() {
		return professors.iterator();
	}

	public static Iterator getStudents() {
		return students.iterator();
	}

}
