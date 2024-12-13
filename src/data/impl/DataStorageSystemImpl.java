package data.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import data.DataRequestResponse;
import data.IDataStorage;
import data.InputConfig;
import data.InputConfig.InputConfigVisitor;
import data.CsvInputConfig;
import data.FileInputConfig;
import data.OutputConfig;
import utils.Status;

public class DataStorageSystemImpl implements IDataStorage {

	@Override
	public Status appendSingleResult(OutputConfig out, String result) {
		try {
			OutputConfig.visitOutputConfig(out, config -> {
				writeToFile(config.getFileName(), result);
			});
			return Status.OK;
		} catch (Exception e) {
			return Status.BAD;
		}
	}

	@Override
	public DataRequestResponse read(InputConfig in) {
		if (in == null) {
			return null;
		}

		try {
			return new DataRequestResponse(Status.OK, InputConfig.visitInputConfig(in, new InputConfigVisitor<Iterable<Integer>>() {

				@Override
				public Iterable<Integer> visitFile(FileInputConfig fileInputConfig) {
					return getFileBasedIterator(fileInputConfig.getFileName());
				}

				@Override
				public Iterable<Integer> visitCsv(CsvInputConfig csvInputConfig) {
					return getCsvBasedIterator(csvInputConfig.getCsv());
				}
				
			}));
		} catch (Exception e) {
			e.printStackTrace();
			return new DataRequestResponse(Status.BAD, null);
		}
	}

	private Iterator<Integer> getFileBasedIterator(String fileName) {
		try {
			return new Iterator<Integer>() {
				BufferedReader buff = new BufferedReader(new FileReader(new File(fileName)));
				String text = buff.readLine();
				boolean closed = false;

				@Override
				public boolean hasNext() {

					return text != null;
				}

				@Override
				public Integer next() {
					int result = Integer.parseInt(text);
					try {
						text = buff.readLine();
						if (!hasNext()) {
							buff.close();
							closed = true;
						}
					} catch (IOException e) {
						throw new RuntimeException(e);
					}

					return result;
				}

				@Override
				public void finalize() {
					if (!closed) {
						try {
							buff.close();
							closed = true;
						} catch (IOException e) {
							throw new RuntimeException(e);
						}
					}
				}

			};
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private Iterator<Integer> getCsvBasedIterator(String data) {
		//TODO Stubbed.
		return null;
	}
	
	
	private void writeToFile(String fileName, String text) {
		try (FileWriter writer = new FileWriter(new File(fileName), true)) {
			writer.append(text);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
