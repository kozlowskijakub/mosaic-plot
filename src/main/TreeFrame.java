package main;

import java.awt.MenuBar;
import java.io.File;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JTree;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class TreeFrame extends JFrame {

	private JTree fileTree;
	private FileSystemModel fileSystemModel;
	private JTextArea fileDetailsTextArea = new JTextArea();

	public TreeFrame(String directory, final FilePathContainer myPath, final JLabel pathArea) {

		super("JTree FileSystem Viewer - JavaProgrammingForums.com");
		fileDetailsTextArea.setEditable(false);
		fileSystemModel = new FileSystemModel(new File(directory));

		JScrollPane scrollPane = new JScrollPane();
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, scrollPane, new JScrollPane(fileDetailsTextArea));

		fileTree = new JTree(fileSystemModel);
		fileTree.setEditable(true);
		scrollPane.setViewportView(fileTree);

		JButton btnLoad = new JButton("Load");

		JButton btnClose = new JButton("Close");

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(
				groupLayout
						.createSequentialGroup()
						.addGroup(
								groupLayout
										.createParallelGroup(Alignment.LEADING)
										.addComponent(splitPane, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
										.addGroup(
												groupLayout.createSequentialGroup().addComponent(btnLoad, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
														.addGap(10).addComponent(btnClose, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE))).addGap(0)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(
				groupLayout.createSequentialGroup().addComponent(splitPane, GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnLoad).addComponent(btnClose)).addGap(10)));
		getContentPane().setLayout(groupLayout);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setAlwaysOnTop(true);
		setSize(400, 300);
		setVisible(true);

		/****************************************************** START ACTIONS ******************************************************/
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					File file = (File) fileTree.getLastSelectedPathComponent();

					if (file.isDirectory()) {
						JOptionPane.showMessageDialog(null, "\'" + file.getPath() + " is a directory " + "\'", "Alert", JOptionPane.ERROR_MESSAGE);
					} else if (file.isFile()) {
						myPath.setFilePath(file.getPath());
						pathArea.setText(file.getPath());
						dispose();
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Select the proper file.", "Alert", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		fileTree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent event) {
				File file = (File) fileTree.getLastSelectedPathComponent();
				fileDetailsTextArea.setText(getFileDetails(file));
			}
		});
		/****************************************************** END ACTIONS ******************************************************/
	}

	private String getFileDetails(File file) {
		if (file == null)
			return "";
		StringBuffer buffer = new StringBuffer();
		buffer.append("Name: " + file.getName() + "\n");
		buffer.append("Path: " + file.getPath() + "\n");
		buffer.append("Size: " + file.length() + "\n");
		return buffer.toString();
	}

	public String getFilePath() {
		File file = (File) fileTree.getLastSelectedPathComponent();
		return file.getPath();
	}
}

class FileSystemModel implements TreeModel {
	private File root;

	private Vector listeners = new Vector();

	public FileSystemModel(File rootDirectory) {
		root = rootDirectory;
	}

	public Object getRoot() {
		return root;
	}

	public Object getChild(Object parent, int index) {
		File directory = (File) parent;
		String[] children = directory.list();
		return new TreeFile(directory, children[index]);
	}

	public int getChildCount(Object parent) {
		File file = (File) parent;
		if (file.isDirectory()) {
			String[] fileList = file.list();
			if (fileList != null)
				return file.list().length;
		}
		return 0;
	}

	public boolean isLeaf(Object node) {
		File file = (File) node;
		return file.isFile();
	}

	public int getIndexOfChild(Object parent, Object child) {
		File directory = (File) parent;
		File file = (File) child;
		String[] children = directory.list();
		for (int i = 0; i < children.length; i++) {
			if (file.getName().equals(children[i])) {
				return i;
			}
		}
		return -1;

	}

	public void valueForPathChanged(TreePath path, Object value) {
		File oldFile = (File) path.getLastPathComponent();
		String fileParentPath = oldFile.getParent();
		String newFileName = (String) value;
		File targetFile = new File(fileParentPath, newFileName);
		oldFile.renameTo(targetFile);
		File parent = new File(fileParentPath);
		int[] changedChildrenIndices = { getIndexOfChild(parent, targetFile) };
		Object[] changedChildren = { targetFile };
		fireTreeNodesChanged(path.getParentPath(), changedChildrenIndices, changedChildren);

	}

	private void fireTreeNodesChanged(TreePath parentPath, int[] indices, Object[] children) {
		TreeModelEvent event = new TreeModelEvent(this, parentPath, indices, children);
		Iterator iterator = listeners.iterator();
		TreeModelListener listener = null;
		while (iterator.hasNext()) {
			listener = (TreeModelListener) iterator.next();
			listener.treeNodesChanged(event);
		}
	}

	public void addTreeModelListener(TreeModelListener listener) {
		listeners.add(listener);
	}

	public void removeTreeModelListener(TreeModelListener listener) {
		listeners.remove(listener);
	}

	private class TreeFile extends File {
		public TreeFile(File parent, String child) {
			super(parent, child);
		}

		public String toString() {
			return getName();
		}
	}
}
