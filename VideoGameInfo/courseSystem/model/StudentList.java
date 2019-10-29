package courseSystem.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 
 * The list of all students indexed by the student's ID
 *
 */
public class StudentList {
	private Map map = new HashMap();

	public void add(Student new_student) {
		map.put(new Integer(new_student.getId()), new_student);
	}

	public boolean has(int student_id) {
		return map.containsKey(new Integer(student_id));
	}

	public boolean has(Student student) {
		return map.containsKey(new Integer(student.getId()));
	}

	public int size() {
		return map.size();
	}

	public Student get(int student_id) throws NotFoundException {
		if (!has(student_id)) {
			throw new NotFoundException("Cannot find student " + student_id);
		}
		return (Student) map.get(new Integer(student_id));
	}

	/**
	 * 
	 * @return <tt>Iterator</tt> of all students in the list in no specific
	 *         order.
	 */
	public Iterator iterator() {
		return map.values().iterator();
	}

	public boolean insert(Student student) {

		int stid = student.getId();
		String stfname = student.getFirstName();
		String stlname = student.getLastName();
		String stemail = student.getEmail();

		String qStr = "INSERT INTO Student Values ('" + stid + "', '" + stfname + "', '" + stlname + "', '" + stemail
				+ "')";
		boolean updateResult = Main.runUpdate(qStr);
		return updateResult;
	}
}
