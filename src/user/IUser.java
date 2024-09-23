package user;

import utils.Status;

public interface IUser {
	
	public Status setSource(String path);
	public Status setDestination(String path);

}
