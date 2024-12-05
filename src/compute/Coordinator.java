package compute;

/**
 * This outlines the behavior for a computation coordinator in our application
 * model.
 */
public abstract class Coordinator implements IComputeCoordinator {

	/** The pair delimiter */
	protected String pair;
	/** The result delimiter */
	protected String end;
	/** The computation core (can be whatever you'd like) */
	protected ICore computation;

}
