package courseSystem.model;

/**
 * Exception in our system raised when an object cannot be found in the list that it is
 * supposed to be in.
 *
 */
public class NotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public NotFoundException(String msg){
		super(msg);
	}

}
