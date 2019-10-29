package courseSystem.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 
 * The list of all courses indexed by course code
 *
 */
public class CourseList {
	private Map map = new HashMap();

	/**
	 * Adds a course
	 * 
	 * @param new_course
	 *            - new <tt>Course</tt> to add
	 */
	public void add(Course new_course) {
		map.put(new_course.getCode(), new_course);
	}

	/**
	 * 
	 * @param course_code
	 *            <tt>String</tt>
	 * @return if course with code <tt>course_code</tt> is in the list
	 */
	public boolean has(String course_code) {
		return map.containsKey(course_code);
	}

	/**
	 * 
	 * @param course
	 *            <tt>Course</tt>
	 * @return if course is in the list
	 */
	public boolean has(Course course) {
		return map.containsKey(course.getCode());
	}

	public int size() {
		return map.size();
	}

	public Course get(String course_code) throws NotFoundException {
		if (!has(course_code)) {
			throw new NotFoundException(course_code);
		}
		return (Course) map.get(course_code);
	}

	public Iterator iterator() {
		return map.values().iterator();
	}

	public boolean insert(Course course) {

		String code = course.getCode();
		String name = course.getName();
		int profId = course.getProfId();
		String qStr = "INSERT INTO Course Values ('" + code + "', '" + name + "')";
		boolean updateResult = Main.runUpdate(qStr);
		return updateResult;
	}

	public boolean insertT(Course course) {

		String code = course.getCode();
		int profId = course.getProfId();
		String qStr = "INSERT INTO Teaches (ProfID, CrsID) Values (" + profId + ", '" + code + "')";
		boolean updateResult = Main.runUpdate(qStr);
		return updateResult;
	}

}
