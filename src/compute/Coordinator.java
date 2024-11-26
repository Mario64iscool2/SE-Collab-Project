package compute;

/**
 * This outlines the behavior for a computation coordinator in our application
 * model.
 */
public abstract class Coordinator implements IComputeCoordinator {

	/** The pair delimiter */
	protected char pair;
	/** The result delimiter */
	protected char end;
	/** The computation core (can be whatever you'd like) */
	protected ICore computation;

}
