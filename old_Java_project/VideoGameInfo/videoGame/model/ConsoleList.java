package videoGame.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ConsoleList {
	private Map map = new HashMap();

	public void add(Console new_console) {
		map.put(new_console.getName(),new_console);
	}

	public boolean has(String name) {
		return map.containsKey(name);
	}

	public boolean has(Console store) {
		return map.containsKey(store.getName());
	}

	public int size() {
		return map.size();
	}

	

	/**
	 * 
	 * @return <tt>Iterator</tt> of all students in the list in no specific
	 *         order.
	 */
	public Iterator iterator() {
		return map.values().iterator();
	}
	

	//TODO change this method and give description with attributes for the Console class
//	public boolean insert(Student student) {
//
//		int stid = student.getId();
//		String stfname = student.getFirstName();
//		String stlname = student.getLastName();
//		String stemail = student.getEmail();
//
//		String qStr = "INSERT INTO Student Values ('" + stid + "', '" + stfname + "', '" + stlname + "', '" + stemail
//				+ "')";
//		boolean updateResult = Main.runUpdate(qStr);
//		return updateResult;
//	}
}
