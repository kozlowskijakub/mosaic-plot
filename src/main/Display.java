/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.TextArea;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;

public class Display {

	public Display(DataContainer storedData, JTextArea textArea) {
		textArea.setText(null);
		String line;
		for (int i = 0; i < storedData.getHeight(); i++) {
			line = storedData.getClassList().get(i).getMyClass() + " "
					+ storedData.getClassList().get(i).getAge() + " "
					+ storedData.getClassList().get(i).getSex() + " "
					+ storedData.getClassList().get(i).getSurvived() + " ";
			textArea.setText(textArea.getText() + line + "\n");
		}
	}

}
