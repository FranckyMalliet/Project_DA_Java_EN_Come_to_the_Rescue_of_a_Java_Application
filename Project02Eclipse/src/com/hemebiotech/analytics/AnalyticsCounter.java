package com.hemebiotech.analytics;


import java.util.Map;
import java.util.TreeMap;

/**
 * Main function of this program 
 * @author Francky Malliet
 *
 */

public class AnalyticsCounter {
	
	private static Map<String, Integer> symptomsList = new TreeMap<String, Integer>();
	
	public static void main(String args[]) {
		
		/**
		 * Create a reader for symptoms.txt
		 * Count the number of headache, rash and pupil 
		 */
		
		// Call the class AnalyticsFolderAndFile to create the folder for the result
		AnalyticsFolderAndFile folderAndFile = new AnalyticsFolderAndFile();
		folderAndFile.createFolder();
		
		// Call the class ReadSymptonDataFromFile to read the data by giving his path
		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile("E://Users/Francky Malliet/git/Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application/Project02Eclipse/symptoms.txt");
		symptomsList = reader.GetSymptoms();
		
		// Call the class WriteDataResults to create the results file
		WriteDataResults results = new WriteDataResults(symptomsList);
		results.getResults();	
	}
}
