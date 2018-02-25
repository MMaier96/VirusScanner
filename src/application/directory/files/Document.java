package application.directory.files;

import application.virusscanner.IVirusScanner;

import static application.logger.Logger.*;

public class Document extends File{

	public Document(String fileName) {
		super(fileName + ".docx");
	}

	@Override
	public boolean accept(IVirusScanner virusScanner) {
		printInfo(unitName + " scanned!");
		return false;
	}
}
