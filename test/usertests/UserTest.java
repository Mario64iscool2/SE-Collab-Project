package usertests;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import compute.Coordinator;
import compute.impl.EngineImpl;
import user.IUser;
import user.impl.UserImpl;
import utils.Status;

public class UserTest {
	
	@Test
	public void testUser() {
		//mock parameters
		String src = "src";
		String dst = "dst";
		Coordinator mockEngine = Mockito.mock(EngineImpl.class);
		
		//create instance with mock parameters
		IUser user1 = new UserImpl(src, dst, mockEngine);
		
		//test methods
		when(user1.setSource(src)).thenReturn(Status.OK);
		when(user1.setDestination(dst)).thenReturn(Status.OK);
		
		
		
	}
}
