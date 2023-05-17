package MainPackage;


abstract class ProcessFile {// ABSTRACTION REQUIREMENT
	protected String fileContents = "";
	protected String filepath = null;

	// constructor
	public ProcessFile(String filepath) {
		this.filepath = filepath;
	}

	// Will return the fileContnets string
	public String getFileContents() {
		return fileContents;
	}

	// Will return the name of the file
	public String getFilepath() {
		return filepath;
	}
}
