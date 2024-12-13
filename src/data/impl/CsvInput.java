package data.impl;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import data.InputSource;

public class CsvInput implements InputSource {

	public CsvInput(String data) {
		String[] temp = data.split("[^0-9-]+");
		in = Arrays.asList(temp).stream().map(parse).collect(Collectors.toList());
	}

	Function<String, Integer> parse = (s) -> {
		return Integer.parseInt(s);
	};

	private final List<Integer> in;

	@Override
	public List<Integer> getInputs() {
		// TODO Auto-generated method stub
		return in;
	}

}
