/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Dimension;
import java.util.ArrayList;

public class DataContainer implements Cloneable {

	private ArrayList<ArrayList<String>> cube = new ArrayList();
	private ArrayList<String> header = new ArrayList();
	// stores all unique values for each header unit
	private ArrayList<ArrayList<String>> subHeaders = new ArrayList();
	private ArrayList<Integer> subHeadersSums = new ArrayList();
	private ArrayList<UniqueRecord> classList = new ArrayList();
	private int height;
	private int width;

	public void addClassList(UniqueRecord newUniqueRecord) {
		this.classList.add(newUniqueRecord);
	}

	public ArrayList<ArrayList<String>> getSubheaders() {
		return subHeaders;
	}

	public void setSubheaders(ArrayList<ArrayList<String>> subheaders) {
		this.subHeaders = subheaders;
	}

	public ArrayList<Integer> getSubheadersSums() {
		return subHeadersSums;
	}

	public void setSubheadersSums(ArrayList<Integer> subheadersSums) {
		this.subHeadersSums = subheadersSums;
	}

	public ArrayList<UniqueRecord> getClassList() {
		return classList;
	}

	public void setClassList(ArrayList<UniqueRecord> classList) {
		this.classList = classList;
	}

	public ArrayList<ArrayList<String>> getCube() {
		return cube;
	}

	public void setCube(ArrayList<ArrayList<String>> cube) {
		this.cube = cube;
	}

	public ArrayList<String> getHeader() {
		return header;
	}

	public void setHeader(ArrayList<String> Header) {
		this.header = Header;
	}

	public ArrayList<ArrayList<String>> getHeaderValues() {
		return subHeaders;
	}

	public void setHeaderValues(ArrayList<ArrayList<String>> HeaderValues) {
		this.subHeaders = HeaderValues;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	// what for is that
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
