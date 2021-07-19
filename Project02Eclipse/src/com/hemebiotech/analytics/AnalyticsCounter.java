package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * AnalyticsCounter extract informations from a file, 
 * These informations consists of counting the occurrences of a symptom
 * 
 * @author Francky Malliet
 **/

public class AnalyticsCounter {

	/**
	 * The application's entry point,
	 * @param args an array of command-line arguments for the application
	 */
	
	public static void main(String args[]) {

		/**
		 * Call the class AnalyticsFolderAndFile to create the folder for the result,
		 * You need to provide the full file path with the final file to be fully
		 * operational
		 */

		AnalyticsFolderAndFile folderAndFile = new AnalyticsFolderAndFile("C://AnalyticsCounter/results.out");
		folderAndFile.createFolder();

		/**
		 * Call the class ReadSymptonDataFromFile to read the data by giving his file path,
		 * It will create a List with each symptoms written
		 */

		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile(
				"E://Users/Francky Malliet/git/Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application/Project02Eclipse/symptoms.txt");
		List<String> symptomsReader = reader.getSymptoms();

		/**
		 * Call the class CounterSymptomData to count the occurrences of each symptom in the List given by ReadSymptomDataFromFile,
		 * It will create a Map with each symptoms and their occurrences
		 */
		
		CounterSymptomData counter = new CounterSymptomData(symptomsReader);
		Map<String, Integer> symptomsList = counter.countSymptoms(); 
		
		/**
		 * Call the class WriteDataResults to create the results file, folderAndFile is
		 * in parameter, giving the necessary file path to be create and stored,
		 */

		WriteDataResults results = new WriteDataResults(symptomsList, folderAndFile);
		results.getResults();
	}
}