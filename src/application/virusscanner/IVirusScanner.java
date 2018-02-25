package application.virusscanner;

import application.directory.Directory;
import application.directory.files.Document;
import application.directory.files.DynamicLinkedLibrary;
import application.directory.files.Executable;

public interface IVirusScanner {

	boolean visit(DynamicLinkedLibrary dll);
	boolean visit(Document doc);
	boolean visit(Executable exe);
	void visit(Directory directory);
}
