package courseSystem.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * An <tt>Outputable</tt> object that maintains the set of marks a student has
 * for all his/her courses.
 * <p>
 * <tt> map </tt> - a <tt>HashMap</tt> where the key is a <tt>String</tt> that
 * is the course code (ex. MIE350) and the value is an <tt>int</tt> that is the
 * mark.
 * <p>
 * Required format in marks list file: <br>
 * studentID,courseCode1,mark1,courseCode2,mark2,
 */
public class CourseMarks implements Outputable {
	private Map map = new HashMap();

	public String getOutputLine() {
		String output_line = "";
		for (Iterator i = map.keySet().iterator(); i.hasNext();) {
			String code = (String) i.next();
			output_line = output_line + code + "," + map.get(code) + ",";
		}
		return output_line;
	}

	// public void readData(Iterator args){
	public void readData(int studId) {
		String qStr = "SELECT S.Stid, T.CrsID, T.Grade FROM Student S  INNER JOIN Transcript T on (S.stID=t.stID) Where S.stid ="
				+ studId + ";";
		ResultSet dataInput = Main.runSelect(qStr);
		try {
			while (dataInput.next()) {
				String code = dataInput.getString("CrsID");
				int mark = Integer.parseInt((String) dataInput.getString("Grade"));
				addMark(code, mark);

			}
		} catch (SQLException se) {
			SQLExceptionHandler.handleException(se);
		}
		// while(args.hasNext()){
		// String code = (String)args.next();
		// int mark = Integer.parseInt( (String) args.next());
		// addMark(code,mark);
		// }
	}

	public String getDisplay() {
		String output_line = "";
		for (Iterator i = map.keySet().iterator(); i.hasNext();) {
			String code = (String) i.next();
			output_line = output_line +"  -- " +code + ": " + map.get(code) + "\n";
		}
		return output_line;
	}

	public boolean updateMark(int studId, String course_code, int mark) {
		String qStr = "UPDATE Transcript Set Grade= " + mark + " WHERE StID =" + studId + " AND CrsId = '" + course_code
				+ "'";
		boolean updateResult = Main.runUpdate(qStr);
		return updateResult;
	}

	public void editMark(String course_code, int mark) {
		if (!map.containsKey(course_code)) {
			throw new CMSError("can't find mark to edit in course " + course_code);
		} else {
			addMark(course_code, mark);
		}
	}

	public void addMark(String course_code, int mark) {
		map.put(course_code, new Integer(mark));
	}

	public boolean insertMark(int studID, String crsCode, int mark) {
		String qStr = "INSERT INTO Transcript Values (" + studID + ", '" + crsCode + "', " + mark + ")";
		boolean updateResult = Main.runUpdate(qStr);
		return updateResult;
	}
}
