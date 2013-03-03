package main;


public class DataContainer implements Cloneable {
	
	private String [][] data = null;
	private String [] header = null;
	
	
	DataContainer(String [][] table){
		splitHeader(table);
	}

	public void splitHeader(String [][] table){
		
		String [][] splitedTable = new String[table.length][table[0].length];
		String [] splitedHeader = new String[table[0].length];
		
		for(int i = 0; i < table[0].length; i++){
			splitedHeader[i] = table[0][i];
		}
		this.header = splitedHeader;
		
		for(int i = 0; i < table.length-1; i++){
			for(int j = 0; j < table[0].length;j++){
				splitedTable[i][j] = table[i+1][j];
			}
		}
		this.data = splitedTable;
	}

	public String[][] getData() {
		return data;
	}

	public String[] getHeader() {
		return header;
	}


}
