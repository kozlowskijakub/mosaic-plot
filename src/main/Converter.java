/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;

/**
 * 
 * @author Jakub
 */

// convert arraylist of arraylists to uniqueRecord list
public class Converter {

	public void convert(ArrayList<ArrayList<String>> lista,
			DataContainer storedData) {
		UniqueRecord newUniqueRecord;
		String value = "";

		for (int i = 0; i < lista.size(); i++) {
			newUniqueRecord = new UniqueRecord();
			value = lista.get(i).get(0);
			newUniqueRecord.setMyClass(value);
			value = lista.get(i).get(1);
			newUniqueRecord.setAge(value);
			newUniqueRecord.setSex(lista.get(i).get(2));
			newUniqueRecord.setSurvived(lista.get(i).get(3));
			storedData.addClassList(newUniqueRecord);
		}
	}
}
