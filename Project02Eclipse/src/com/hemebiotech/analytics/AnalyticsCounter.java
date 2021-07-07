package com.hemebiotech.analytics;

import java.util.Map;

/**
 * AnalyticsCounter extract informations from a file, These informations
 * consists of counting the occurrences of a symptom
 * 
 * @author Francky Malliet
 **/

public class AnalyticsCounter {

	public static void main(String args[]) {

		/**
		 * Call the class AnalyticsFolderAndFile to create the folder for the result,
		 * You need to provide the full file path with the final file to be fully
		 * operational
		 */

		AnalyticsFolderAndFile folderAndFile = new AnalyticsFolderAndFile("C://AnalyticsCounter/results.txt");
		folderAndFile.createFolder();

		/**
		 * Call the class ReadSymptonDataFromFile to read the data by giving his file
		 * path,
		 */

		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile(
				"E://Users/Francky Malliet/git/Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application/Project02Eclipse/symptoms.txt");
		Map<String, Integer> symptomsList = reader.GetSymptoms();

		/**
		 * Call the class WriteDataResults to create the results file, folderAndFile is
		 * in parameter, giving the necessary file path to be create and stored
		 */

		WriteDataResults results = new WriteDataResults(symptomsList, folderAndFile);
		results.getResults();
	}
}
