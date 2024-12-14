package user.impl;

import java.util.Scanner;

import compute.ComputationResult;
import compute.impl.CoordinatorImpl;
import compute.impl.NextPrimeCompute;
import data.impl.DataStorageSystemImpl;
import user.IJobSpec.InputType;
import user.IJobSpec.OutputType;
import user.JobSpec;

public class Client {

	boolean showHelp = false;
	boolean cliIn = true;
	boolean cliOut = true;
	String inPath = "";
	String outPath = "";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Client client = new Client();
		if (args.length > 0) {
			// Try to parse args as spec and location
			// -h Prints CLI Help, ignore all other flags.
			// -i Specifies input file. If absent, request user input.
			// -o Specifies output location. If absent, to stdout.
			for (int i = 0; i < args.length; i++) {
				if (args[i] == "-h") {
					client.showHelp = true;
					// Force skip the rest of the loop.
					break;
				}
				if (args[i] == "-i") {
					if (i + 1 < args.length) {
						client.inPath = args[i + 1];
						client.cliIn = false;
					}
				}
				if (args[i] == "-o") {
					if (i + 1 < args.length) {
						client.outPath = args[i + 1];
						client.cliOut = false;
					}
				}
			}
		}

		if (client.showHelp) {
			System.out.println("Compute Server Demo");
			System.out.println("Usage: client.java [-h] (Prints Help Text)");
			System.out.println("       client.java [options]");
			System.out.println("Options:");
			System.out.println("   -i [filepath] (Specifies the text input file you'd like to use."
					+ "\r\n   If omitted, you will be prompted for input.)");
			System.out.println("   -o [filepath] (Specifies the output location."
					+ "\r\n   If omitted, results will print to this terminal.)");
			return;
		}
		String inputs = "";
		if (client.cliIn) {
			Scanner in = new Scanner(System.in);
			System.out.println(
					"Input the numbers you'd like to operate on as a list, separated by commas \",\" or spaces.");
			inputs = in.nextLine();
			in.close();
			System.out.println(inputs);
		}
		JobSpec spec = new JobSpec(!client.cliIn ? client.inPath : inputs, client.outPath, ",", System.lineSeparator(),
				client.cliIn ? InputType.CSV : InputType.FILE, client.cliOut ? OutputType.CLI : OutputType.FILE);
		// Ideally I don't need to have a local copy of this, just testing because I
		// don't understand GRPC.
		CoordinatorImpl c = new CoordinatorImpl(new NextPrimeCompute(), new DataStorageSystemImpl());
		System.out.println(spec.toString());
		ComputationResult res = c.compute(spec);
		switch(res.getType()) {
		case FILE:
			System.out.println("Done! Output is located at: " + res.getOutput());
			break;
		case CLI:
			System.out.println("Done!"+System.lineSeparator()+"Output:"+System.lineSeparator()+res.getOutput());
			break;
		}
		return;
	}

}
