package application.directory.files;

import application.virusscanner.IVirusScanner;

public interface IFile {
	boolean accept(IVirusScanner virusScanner);
}
