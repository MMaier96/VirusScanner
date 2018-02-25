package application.directory.files;

import static application.logger.Logger.printInfo;

import application.virusscanner.IVirusScanner;

public class Executable extends File{

	public Executable(String fileName) {
		super(fileName + ".exe");
	}
	
	@Override
	public boolean accept(IVirusScanner virusScanner) {
		printInfo(unitName + " scanned!");
		return false;
	}
}
