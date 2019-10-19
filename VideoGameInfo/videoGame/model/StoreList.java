package videoGame.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class StoreList {
	private Map map = new HashMap();

	public void add(Store new_store) {
		map.put(new Integer(new_store.getStoreID()),new_store);
	}

	public boolean has(int storeID) {
		return map.containsKey(new Integer(storeID));
	}

	public boolean has(Store store) {
		return map.containsKey(new Integer(store.getStoreID()));
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
	

	//TODO change this method and give description with attributes for the Store class
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
