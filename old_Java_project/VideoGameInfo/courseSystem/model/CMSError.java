package courseSystem.model;

/**
 * Exception in our system that (unless handled in another way) simply prints an
 * error message and exits
 *
 */
public class CMSError extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CMSError(String msg) {
		super(msg);
	}
}
