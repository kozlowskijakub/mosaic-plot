/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.TextArea;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**************************************************************************************************************************
 * 
 * READS THE FILE AND STORES ALL DATA IN CONTAINER
 * 
 **************************************************************************************************************************/
public class Reader {

	private static Object[][] dataTable = null;
	String line;
	String splitedLine[];
	File myFile;

	/**************************************************************************************************************************
	 * 
	 * FLAT DATA FILE FORMAT
	 * 
	 **************************************************************************************************************************/
	public String[][] readTo2DTable(String fileName) {
		myFile = new File(fileName);
		try {
			Scanner in = new Scanner(myFile); // initialize scanner
			line = in.nextLine();
			splitedLine = line.split(", ");
			// adds splited parts of file line (string) as a new element of list
			dataTable = new String[count(fileName) + 1][splitedLine.length];

			int i = 0;
			for (String element : splitedLine) {
				dataTable[0][i] = element;
				i++;

			}
			i = 1;
			int j = 0;
			while (in.hasNext()) {
				line = in.nextLine();
				splitedLine = line.split(", ");
				// adds splited parts of file line (string) as a new element of
				// list

				for (String element : splitedLine) {
					if (element != "") {
						dataTable[i][j] = element;
						j++;
					}
				}
				j = 0;
				i++;
			}
			System.out.println("checkpoint");
			return (String[][]) dataTable;
		} catch (FileNotFoundException ex) {
			JOptionPane.showMessageDialog(null, "\"" + fileName + "\"" + " not found, please check it.");
		} catch (Error er) {
			JOptionPane.showMessageDialog(null, "Data error.");
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "File format error.");
		}
		return null;

	}

	/**************************************************************************************************************************
	 * 
	 * TABLE DATA FILE FORMAT
	 * 
	 **************************************************************************************************************************/
	public String[][] readReadyTable(String fileName) {
		myFile = new File(fileName);
		try {
			Scanner in = new Scanner(myFile); // initialize scanner
			line = in.nextLine();
			splitedLine = line.split(" ");
			// adds splited parts of file line (string) as a new element of list
			dataTable = new String[count(fileName) + 1][splitedLine.length];

			int i = 0;
			for (String element : splitedLine) {
				dataTable[0][i] = element;
				i++;

			}
			i = 1;
			int j = 0;
			while (in.hasNext()) {
				line = in.nextLine();
				splitedLine = line.split(", ");
				// adds splited parts of file line (string) as a new element of
				// list

				for (String element : splitedLine) {
					if (element != "") {
						dataTable[i][j] = element;
						j++;
					}
				}
				j = 0;
				i++;
			}
			System.out.println("checkpoint");
			return (String[][]) dataTable;
		} catch (FileNotFoundException ex) {
			JOptionPane.showMessageDialog(null, "\"" + fileName + "\"" + " not found, please check it.");
		} catch (Error er) {
			JOptionPane.showMessageDialog(null, "Data error.");
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "File format error.");
		}
		return null;
	}

	public int count(String filename) throws IOException {
		InputStream is = new BufferedInputStream(new FileInputStream(filename));
		try {
			byte[] c = new byte[2048];
			int count = 0;
			int readChars = 0;
			boolean empty = true;
			while ((readChars = is.read(c)) != -1) {
				empty = false;
				for (int i = 0; i < readChars; ++i) {
					if (c[i] == '\n')
						++count;
				}
			}
			return (count == 0 && !empty) ? 1 : count;
		} finally {
			is.close();
		}
	}
}
