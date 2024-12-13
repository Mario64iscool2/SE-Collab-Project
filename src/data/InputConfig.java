package data;

public interface InputConfig {
	static interface InputConfigVisitor<T> {
		public T visitFile(FileInputConfig fileInputConfig);
//		public T visitCsv(CsvInputConfig csvInputConfig);
	}

	static <T> T visitInputConfig(InputConfig config, InputConfigVisitor<T> visitor) {
		if (config instanceof FileInputConfig) {
			return visitor.visitFile((FileInputConfig) config);
		}
//		if (config instanceof CsvInputConfig) {
//			return visitor.visitCsv((CsvInputConfig) config);
//		}
		throw new RuntimeException("Unexpected config type: " + config.getClass());
	}
}
