package data.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import data.DataRequestResponse;
import data.EchoOutputConfig;
import data.IDataStorage;
import data.InputConfig;
import data.InputConfig.InputConfigVisitor;
import data.CsvInputConfig;
import data.FileInputConfig;
import data.FileOutputConfig;
import data.OutputConfig;
import data.OutputConfig.OutputConfigVisitor;
import utils.Status;

public class DataStorageSystemImpl implements IDataStorage {

	@Override
	public Status appendSingleResult(OutputConfig out, String result) {
		try {
			OutputConfig.visitOutputConfig(out, new OutputConfigVisitor() {
				@Override
				public void visitFile(FileOutputConfig fileOutputConfig) {
					writeToFile(fileOutputConfig.getFileName(), result);	
				}
				
				@Override
				public void visitEchoOut(EchoOutputConfig eOutConf) {
					eOutConf.append(result);
				}
				
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
			return new DataRequestResponse(Status.OK,
					InputConfig.visitInputConfig(in, new InputConfigVisitor<Iterator<Integer>>() {

						@Override
						public Iterator<Integer> visitFile(FileInputConfig fileInputConfig) {
							return getFileBasedIterator(fileInputConfig.getFileName());
						}

						@Override
						public Iterator<Integer> visitCsv(CsvInputConfig csvInputConfig) {
							return getCsvBasedIterator(csvInputConfig.getCsv());
						}

					}));
		} catch (NumberFormatException nfe) {
			return new DataRequestResponse(Status.BAD_INPUT, null);
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
				Scanner in = new Scanner(text);
				boolean closed = false;

				@Override
				public boolean hasNext() {
					return in.hasNextInt();
				}

				@Override
				public Integer next() {
					int result = in.nextInt();
					try {
						if(!hasNext()) {
							text = buff.readLine();							
						}
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
		try {
			return new Iterator<Integer>() {
				boolean closed = false;
				String text = sanitizeInputData(data);
				BufferedReader buff = new BufferedReader(new StringReader(text));
				String line = buff.readLine();
				
				@Override
				public boolean hasNext() {
					return line != null;
				}

				@Override
				public Integer next() {
					int result = Integer.parseInt(line);
					try {
						line = buff.readLine();
						if (!hasNext()) {
							buff.close();
							closed = true;
						}
					} catch (IOException e) {
						throw new RuntimeException(e);
					}
					return result;
				}
			};
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Sanitizes a supposedly CSV set of numbers into line-separated numbers,
	 * removing commas and whitespace.
	 * 
	 * @param data the string containing the numbers.
	 */
	private String sanitizeInputData(String data) {
		String[] temp = data.split("[ ,]+");
		String result = "";
		for (int i = 0; i < temp.length; i++) {
			try {
				result += Integer.parseInt(temp[i])+System.lineSeparator();
			} catch (NumberFormatException e) {
				System.out.println("Bad input: " + e.getLocalizedMessage());
			} finally {
				// Do nothing for now.
			}
		}
		return result;
	}

	private void writeToFile(String fileName, String text) {
		try (FileWriter writer = new FileWriter(new File(fileName), true)) {
			writer.append(text);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
