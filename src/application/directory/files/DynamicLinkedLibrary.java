package application.directory.files;

import static application.logger.Logger.printInfo;

import application.virusscanner.IVirusScanner;

public class DynamicLinkedLibrary extends File{

	public DynamicLinkedLibrary(String fileName) {
		super(fileName + ".dll");
	}
	
	@Override
	public boolean accept(IVirusScanner virusScanner) {
		printInfo(unitName + " scanned!");
		return false;
	}
}
