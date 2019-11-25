package videoGame.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ProductList {
	private Map map = new HashMap();

	public void add(Product new_product) {
		map.put(new Integer(new_product.getUPCNumber()),new_product);
	}

	public boolean has(int upcNum) {
		return map.containsKey(new Integer(upcNum));
	}

	public boolean has(Product product) {
		return map.containsKey(new Integer(product.getUPCNumber()));
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

	
}
