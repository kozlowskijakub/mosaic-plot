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

public class Reader {

	ArrayList<ArrayList<String>> myProperList = new ArrayList();
	String line;
	String splitedLine[];
	ArrayList<String> myList;
	File myFile;

	public void readToDataContainer(String fileName, DataContainer storedData) {
		myFile = new File(fileName);
		try {
			// initialize scanner
			Scanner in = new Scanner(myFile);

			myList = new ArrayList();
			line = in.nextLine();
			splitedLine = line.split(", ");
			// adds splited parts of file line (string) as a new element of list
			for (String element : splitedLine) {
				myList.add(element);
			}
			storedData.setHeader(myList);

			while (in.hasNext()) {
				myList = new ArrayList();
				line = in.nextLine();
				splitedLine = line.split(", ");
				// adds splited parts of file line (string) as a new element of
				// list

				for (String element : splitedLine) {
					if (element != "") {
						myList.add(element);
					}
				}
				myProperList.add(myList);
			}
		} catch (FileNotFoundException ex) {
			JOptionPane.showMessageDialog(null, "\"" + fileName + "\""
					+ " not found, please check it.");
		}catch(Error er){
			JOptionPane.showMessageDialog(null, "Data error.");
		}
		// storedData.setCube(myProperList);
		storedData.setHeight(myProperList.size());
		storedData.setWidth(storedData.getHeader().size());

		Converter myConversion = new Converter();
		myConversion.convert(myProperList, storedData);
	}
}
