package user;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import compute.Coordinator;
import utils.Status;

public abstract class AbstractUser implements IUser {

	protected String source = "";
	protected String destination;
	protected Coordinator engine;

	@Override
	public Status setSource(String path) {
		try (FileReader fr = new FileReader(path)) {
			source = path;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return source.isEmpty() ? Status.BAD : Status.OK;
	}

	@Override
	public Status setDestination(String path) {

		return null;
	}

}
