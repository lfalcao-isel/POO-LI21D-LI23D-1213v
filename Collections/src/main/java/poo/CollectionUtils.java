package poo;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

public class CollectionUtils {

	public <T> T max(Collection<T> coll, Comparator<T> cmp) {
		Iterator<T> iter = coll.iterator();
		T max = null;

		if (iter.hasNext() == false) {
			return max;
		}
		max = iter.next();

		while (iter.hasNext()) {
			T curr = iter.next();
			if (cmp.compare(max, curr) < 0) {
				max = curr;
			}
		}

		return max;

	}
}
