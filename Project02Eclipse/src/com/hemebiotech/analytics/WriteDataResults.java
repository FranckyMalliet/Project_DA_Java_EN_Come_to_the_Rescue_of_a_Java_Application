package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.Map.Entry;

public class WriteDataResults extends AnalyticsFolderAndFile{

	private Map<String, Integer> symptomsList;

	public WriteDataResults(Map<String, Integer> symptomsList) {
		this.symptomsList = symptomsList;
	}
	
	public void getResults() {
	
	try {
		
		/**
		 * 	Create a file and then write the data on it 
		 *	Call the class AnalyticsFolderAndFile to create the file for the result  
		 */
		
		FileWriter writer = new FileWriter (super.createFile(), true);
		BufferedWriter bw = new BufferedWriter(writer);
		
		bw.newLine();
		
		for(Entry<String, Integer> elements : symptomsList.entrySet()) {
			bw.write(elements.getKey() + " " + elements.getValue());
			bw.newLine();
		}
		
		Calendar c = new GregorianCalendar();
		
		bw.newLine();
		bw.write("Results done the " + c.getTime());
		System.out.println("Je vais ici");
		
		bw.close();
		writer.close();
		
	} catch (IOException e) {
		System.out.println("File does not exist");
	}
	}	
}
