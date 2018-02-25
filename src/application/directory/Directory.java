package application.directory;

import java.util.ArrayList;
import java.util.List;

import application.Application;
import application.directory.files.File;

public abstract class Directory {
	protected int indentDepth = 0;
	public String unitName;
	protected Directory parentUnit;
	protected List<Directory> units;
	protected List<String> idTags;

	public Directory(String unitName) {
		this.unitName = unitName;
		this.units = new ArrayList<>();
		this.idTags = new ArrayList<>();
		addIdTag(unitName);
	}

	private void addIdTag(String idTag) {
		idTags.add(idTag);
	}

	public void addUnit(Directory directory) {
		directory.setParent(this);
		units.add(directory);
	}

	public void addUnits(Directory... directories) {
		for (Directory directory : directories) {
			addUnit(directory);
		}
	}

	public Directory getSuperiorUnit() {
		return parentUnit;
	}

	protected String indent(int depth) {
		StringBuilder stringBuilder = new StringBuilder();
		do {
			stringBuilder.append("+ ");
		} while (depth-- > (0 + (this instanceof File?1:0)));
		if (this instanceof File) {
			stringBuilder.append("- ");
		}
		return stringBuilder.toString();
	}

	public final boolean isComposite() {
		return !units.isEmpty();
	}

	public final void printStructure() {
		System.out.print((isComposite() ? "\n" : ""));
		System.out.println(Application.prefix + indent(indentDepth) + unitName
				+ (getSuperiorUnit() == null ? " (mainfolder)" : (isComposite() ? " (subfolder)" : "")));
		for (Directory directory : units) {
			directory.indentDepth = indentDepth + 1;
			directory.printStructure();
		}
	}

	private void setParent(Directory directory) {
		parentUnit = directory;
	}
}
