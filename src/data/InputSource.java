package data;

import java.util.Iterator;

/**
 * Effectively identical to {@link Iterator} unless we need additional functionality
 * @see java.util.Iterator
 * @param <T> The type of input data we would like to obtain, whether that be Strings, ints, longs, etc.
 */
public interface InputSource<T> extends Iterator<T> {
		
}
