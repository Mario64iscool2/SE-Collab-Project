package data;

public interface OutputConfig {

	static interface OutputConfigVisitor {
		public void visitFile(FileOutputConfig fOutConf);
		public void visitEchoOut(EchoOutputConfig eOutConf);
	}

	static void visitOutputConfig(OutputConfig conf, OutputConfigVisitor visitor) {
		if (conf instanceof FileOutputConfig) {
			visitor.visitFile((FileOutputConfig) conf);
		}
		if (conf instanceof EchoOutputConfig) {
			visitor.visitEchoOut((EchoOutputConfig) conf);
		} else {
			throw new RuntimeException("Unexpected config type: " + conf.getClass());
		}
	}

}
