package courseSystem.model;

import java.util.Iterator;

/**
 * <tt>interface</tt> that defines form all concrete commands must take
 * <p>
 * Required format in commands file: <br>
 * commandType,argument1,...,argumentN,
 */
interface Command {
	public void execute(Iterator args);
}
