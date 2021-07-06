package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Main function of this program 
 * @author Francky Malliet
 *
 */


public class AnalyticsCounter {
	
	/**
	 *	Initialize variables for the main function  
	 */
	
	/*private static int headacheCount = 0;
	private static int rashCount = 0;		
	private static int pupilCount = 0;*/		
	
	private static Map<String, Integer> symptomsList = new TreeMap<String, Integer>();	
	
	public static void main(String args[]) {
		
		/**
		 * Create a reader for symptoms.txt
		 * Count the number of headache, rash and pupil 
		 */
		
		// Call the class AnalyticsFolderAndFile to create the folder for the result
		AnalyticsFolderAndFile folderAndFile = new AnalyticsFolderAndFile();
		folderAndFile.createFolder();
		
			
		// Reader who will get the informations from symptoms.txt
		try {
			
		//ReadSymptomDataFromFile SymptomData = new ReadSymptomDataFromFile("E://Users/Francky Malliet/git/Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application/Project02Eclipse/symptoms.txt");
			
		InputStream symptomsAdress = new FileInputStream("E://Users/Francky Malliet/git/Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application/Project02Eclipse/symptoms.txt");
		BufferedReader reader = new BufferedReader(new InputStreamReader(symptomsAdress));
		
		//This HashMap get all the different symptoms as Keys and iterate them with each encounter in a file
		
		for(String line = reader.readLine(); line != null; line = reader.readLine()) {
			if(!symptomsList.containsKey(line)) {
				symptomsList.put(line, 1);
			} else {
				/*for(Entry<String, Integer> elements : symptomsList.entrySet()) {
				if(elements.getKey() == line) {*/
					int count = symptomsList.get(line);
					symptomsList.put(line, count + 1);
			}
		}
			
			for(Entry<String, Integer> elements : symptomsList.entrySet()) {
				System.out.println(elements);
			}
				/*}
			}*/

		// https://beginnersbook.com/2014/07/java-check-if-a-particular-value-exists-in-hashmap-example/
		
		/*for(String line = reader.readLine(); line != null; line = reader.readLine()) {
			System.out.println("symptom from file: " + line);
			
			if (line.equals("headache")) {
				headacheCount++;
				System.out.println("number of headaches: " + headacheCount);
			}
			else if (line.equals("rash")) {
				rashCount++;
				System.out.println("number of rashs: " + rashCount);
			}
			else if (line.contains("pupils")) {
				pupilCount++;
				System.out.println("number of pupils " + pupilCount);
			} 
		}*/
		
			// Close the reader for memory
			reader.close();
		
		} catch(IOException e) {
			System.out.println("file not found");
		}
			
		// next generate output
		try {
			
			/**
			 * 	Create a file and then write the data on it 
			 *	Call the class AnalyticsFolderAndFile to create the file for the result  
			 */
			
			FileWriter writer = new FileWriter (folderAndFile.createFile(), true);
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
