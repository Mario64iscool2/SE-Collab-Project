package compute;

import user.IJobSpec;

/**
 * Handles Managing a Job given a Job Spec, and returns Results of operations
 * 
 * @apiNote {@link user#JobSpec} contains coordination info:
 *          <ul>
 *          <li>I/O Locations</li>
 *          <li>Delimiters</li>
 *          </ul>
 *          {@link compute#ComputationResult} contains the status of the computation and the destination path
 * @author mario64iscool2
 * @see {@link user#JobSpec} {@link compute#ComputationResult}
 */
public interface IComputeCoordinator {
	/**
	 * Retrieves the completed job's result
	 * 
	 * @param j a JobSpec object for the computation series to run.
	 * @return a string containing the job's result.
	 */
	public abstract ComputationResult compute(IJobSpec j);
}