/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javax.swing.JTextArea;

public class Display {

	public Display(String[][] dataTable, JTextArea textArea) {
		textArea.setText(null);
		String line = "";
		for (int i = 0; dataTable[i][0] != null; i++) {
			for (int j = 0; j < dataTable[0].length; j++) {
	//			System.out.print(dataTable[i][j] + " ");
				line += dataTable[i][j] + " ";
			}
			textArea.setText(textArea.getText() + line + "\n");
			line = "";
		}
	}

}
