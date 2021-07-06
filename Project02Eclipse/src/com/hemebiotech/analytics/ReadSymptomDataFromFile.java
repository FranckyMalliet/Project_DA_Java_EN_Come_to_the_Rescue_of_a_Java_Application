package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile {

	private String filepath;
	
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	
	private static Map<String, Integer> symptomsList = new TreeMap<String, Integer>();
	
	
	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}
	
	public Map<String, Integer> GetSymptoms() {
		
		try {
				
			InputStream symptomsAdress = new FileInputStream(filepath);
			BufferedReader reader = new BufferedReader(new InputStreamReader(symptomsAdress));
			
			//This TreeMap get all the different symptoms as Keys and iterate them with each encounter in a file
			
			for(String line = reader.readLine(); line != null; line = reader.readLine()) {
				if(!symptomsList.containsKey(line)) {
					symptomsList.put(line, 1);
				} else {
					int count = symptomsList.get(line);
					symptomsList.put(line, count + 1);
				}
			}
				
				for(Entry<String, Integer> elements : symptomsList.entrySet()) {
					System.out.println(elements);
				}
				
				reader.close();
				
		} catch(IOException e) {
			System.out.println("file not found");
		}
		
		return symptomsList;
	}
}
