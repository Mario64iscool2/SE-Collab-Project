package data;

public interface OutputConfig {

	static interface OutputConfigVisitor {
		public void visitFile(FileOutputConfig fOutConf);
	}

	static void visitOutputConfig(OutputConfig conf, OutputConfigVisitor visitor) {
		if (conf instanceof FileOutputConfig) {
			visitor.visitFile((FileOutputConfig) conf);
		} else {
			throw new RuntimeException("Unexpected config type: " + conf.getClass());
		}
	}

}
