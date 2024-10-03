package data;

import java.util.Iterator;

/**
 * An InputSource<T> can take several forms, (more thinking aloud than anything)
 * InputSource<Integer>, InputSource<String> Input<List<Integer>>
 * 
 * @param <T>
 */
public interface InputSource<T> extends Iterator<T> {

}
