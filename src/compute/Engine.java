package compute;

import data.InputSource;
import data.OutputSource;

/**
 * This outlines the behavior for a computation engine in our application model.
 * @implSpec Any implementer must NOT be static, as the delimiters should not be global.
 * @apiNote Workflow: Instantiate → Set Delimiters → {@linkplain #Engine.compute(InputSource, OutputSource)}
 * @implNote Override {@link #Engine.compute()} if you intend to extend this for the sake of job management.
 * @implSpec {@link #compute(int, OutputSource)}
 */
public abstract class Engine implements IEngine {

	// The pair delimiter
	protected char pair;
	// The result delimiter
	protected char end;
	
	protected ICompute computation;

	@Override
	public void setDelimiters(char pair, char end) {
		// TODO Auto-generated method stub
		this.pair = pair;
		this.end = end;
	}

	@Override
	public String compute(InputSource<?> src, OutputSource dst) {
		
		return "".toString();
	}

}
