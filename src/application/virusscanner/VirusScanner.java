package application.virusscanner;

import application.directory.Directory;
import application.directory.files.Document;
import application.directory.files.DynamicLinkedLibrary;
import application.directory.files.Executable;

public class VirusScanner implements IVirusScanner {

	@Override
	public boolean visit(DynamicLinkedLibrary dll) {
		dll.accept(this);
		return false;
	}

	@Override
	public boolean visit(Document doc) {
		doc.accept(this);
		return false;
	}

	@Override
	public boolean visit(Executable exe) {
		exe.accept(this);
		return false;
	}

	@Override
	public void visit(Directory directory) {
		if (directory instanceof Executable) {
			visit((Executable) directory);
		} else if (directory instanceof DynamicLinkedLibrary) {
			visit((DynamicLinkedLibrary) directory);
		} else if (directory instanceof Document) {
			visit((Document) directory);
		}
	}
}
