package user.impl;

import compute.Coordinator;
import user.AbstractUser;

public class UserImpl extends AbstractUser {

	/**
	 * Creates a new <code>UserImpl</code> object with a default set of delimiters:
	 * <code>':'</code> between input and output for a single computation, and
	 * <code>','</code> between pairs of results.
	 * 
	 * @param src a String containing the filepath to the source file to be read.
	 * @param dst a String containing the filepath to output to.
	 * @param eng a Computation Engine-wrapper object that handles the inner
	 *            workings of the job specified here.
	 */
	public UserImpl(String src, String dst, Coordinator eng) {
		this.source = src;
		this.destination = dst;
		this.engine = eng;
		// A set of default delimiters (semi-colons between input and result, and commas
		// between result pairs)
		eng.setDelimiters(':', ',');
	}

	/**
	 * Creates a new <code>UserImpl</code> object with a default set of delimiters:
	 * <code>':'</code> between input and output for a single computation, and
	 * <code>','</code> between pairs of results.
	 * 
	 * @param src  a String containing the filepath to the source file to be read.
	 * @param dst  a String containing the filepath to output to.
	 * @param eng  a Computation Engine-wrapper object that handles the inner
	 *             workings of the job specified here.
	 * @param pair the delimiter between the input of a single computation and its
	 *             result
	 * @param end  the delimiter between two pairs of input-result groups
	 */
	public UserImpl(String src, String dst, Coordinator eng, char pair, char end) {
		this.source = src;
		this.destination = dst;
		this.engine = eng;
		// A set of default delimiters (semi-colons between input and result, and commas
		// between result pairs)
		eng.setDelimiters(pair, end);
	}

	@Override
	public void startJob() {
		
	}

}
