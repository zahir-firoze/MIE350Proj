package courseSystem.model;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 
 * The list of all professors indexed by the professor's ID
 *
 */
public class ProfessorList {
	private Map map = new HashMap();
	
	public void add(Professor new_prof){
		map.put(new Integer(new_prof.getId()),new_prof);
	}
	public boolean has(int prof_id){
		return map.containsKey(new Integer(prof_id));
	}
	public boolean has(Professor prof){
		return map.containsKey(new Integer(prof.getId()));
	}
	public int size(){
		return map.size();
	}
	public Professor get(int prof_id) throws NotFoundException{
		if (!has(prof_id)){
			throw new NotFoundException("can't find professor" + prof_id);
		}
		return (Professor) map.get(new Integer(prof_id));
	}
	public Iterator iterator(){
		return map.values().iterator();
	}
	public boolean insert (Professor professor) {

	    int profId = professor.getId();
	    String profFname = professor.getFirstName();
	    String profLname = professor.getLastName();
	    String profEmail = professor.getEmail();
	    String office = professor.getOffice();

	    String qStr = "INSERT INTO Professor Values ('" + profId + "', '"+ profFname + "', '"+ profLname + "', '"+ profEmail + "', '"+ office + "')";
		boolean updateResult = Main.runUpdate(qStr);
		return updateResult;
}

}
