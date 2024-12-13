package data.impl;

import java.util.List;

import data.OutputSource;
import utils.Status;

public class EchoOut implements OutputSource {

	@Override
	public List<String> getOutput() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Status write(String s) {
		//I would like to go across the process boundary back to our root process. System.out.print in this scope might not work.
		System.out.println(s);
		return Status.OK;
	}

}
