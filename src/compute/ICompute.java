package compute;

/** The computation core component of the Computation Engine.
 * @version 0.1
 * @author mario64iscool2
 */
public interface ICompute {

	/**
	 * This will run the computation to be implemented
	 * @param i the integer input
	 * @return the resultant long
	 */
	long compute(int i);
	
}
abstract class icompute implements ICompute{
}
