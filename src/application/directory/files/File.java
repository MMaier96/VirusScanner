package application.directory.files;

import static application.logger.Logger.printError;

import application.directory.Directory;

public abstract class File extends Directory implements IFile{

	public File(String fileName) {
		super(fileName);
	}
	
	
	
	@Override
	public void addUnit(Directory directory) {
		printError("Cannot add unit to a file! You tried: " + this.unitName + " <- " + directory.unitName);
	}
}
