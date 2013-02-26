package main;

import java.io.File;

import javax.naming.directory.DirContext;

// how the node looks like
public class TreeNode extends File {
	public TreeNode(File parent, String child) {
		super(parent, child);
	}

	public String toString() {
		return getName();
	}
}