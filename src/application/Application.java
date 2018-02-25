package application;

import application.directory.Directory;
import application.directory.Folder;
import application.directory.files.Document;
import application.directory.files.DynamicLinkedLibrary;
import application.directory.files.Executable;

import static application.logger.Logger.*;

public class Application {

	public static final String prefix = "          ";

	public static void main(String... args) {
		printMessage(" Application started! ");

		printInfo("Creating folder and files ...");
		Directory partition = new Folder("partition");

		Directory files = new Folder("files");

		Directory documents = new Folder("documents");
		Directory bills = new Document("bills");
		Directory creditCards = new Document("creditCards");
		Directory household = new Document("household");

		Directory librarys = new Folder("librarys");
		Directory safeips = new DynamicLinkedLibrary("safeips");
		Directory vcruntime140_app = new DynamicLinkedLibrary("vcruntime140_app");
		Directory kisacrypto = new DynamicLinkedLibrary("kisacrypto");

		Directory executables = new Folder("executables");
		Directory word = new Executable("word");
		Directory excel = new Executable("excel");
		Directory browser = new Executable("browser");
		printInfo("Finished creating folder and files!");

		printInfo("Adding: files <- (multiple Documents)");
		documents.addUnits(creditCards, bills, household);

		printInfo("Adding: files <- (multiple Executables)");
		executables.addUnits(word, excel, browser);

		printInfo("Adding: files <- (multiple DynamicLinekdLibrarys)");
		librarys.addUnits(safeips, vcruntime140_app, kisacrypto);

		printInfo("Adding: files <- librarys");
		files.addUnit(librarys);

		printInfo("Adding: files <- executables");
		files.addUnit(executables);

		printInfo("Adding: files <- documents");
		files.addUnit(documents);

		// force error message
		household.addUnit(household);

		printInfo("Adding: partition <- files");
		partition.addUnit(files);

		printMessage("Printing the recursive structure of mainfolder ...");
		partition.printStructure();

		printMessage(" Application finished! ");
	}
}