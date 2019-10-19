package videoGame.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class CustomerRatingReviewList {
	private Map map = new HashMap();

		//TODO create a new object that can be a key for the hashmap (upcNumber, email)
//	public void add(CustomerRatingReview new_crr) {
//		map.put(new_crr.),new_console);
//	}

//	public boolean has(String name) {
//		return map.containsKey(name);
//	}
//
//	public boolean has(Console store) {
//		return map.containsKey(store.getName());
//	}
//
//	public int size() {
//		return map.size();
//	}

	

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
	
	//TODO: write update method for customer
//	public boolean update(Professor professor) {
//		int profId = professor.getId();
//		String proffname = professor.getFirstName();
//		String proflname = professor.getLastName();
//		String profemail = professor.getEmail();
//		String office = professor.getOffice();
//
//		String qStr = "UPDATE Professor Set FirstName = '" + proffname + "', LastName ='" + proflname + "', Email = '"
//				+ profemail + "', Office = '" + office + "' WHERE ProfID =" + profId + "; ";
//		boolean updateResult = Main.runUpdate(qStr);
//		return updateResult;
//	}
}
