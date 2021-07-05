package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Main function of this program 
 * @author Francky Malliet
 *
 */


public class AnalyticsCounter {
	
	/**
	 *	Initialize variables for the main function  
	 */
	
	private static int headacheCount = 0;
	private static int rashCount = 0;		
	private static int pupilCount = 0;		
	
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
			
		InputStream symptomsAdress = new FileInputStream("E://Users/Francky Malliet/git/Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application/Project02Eclipse/symptoms.txt");
		BufferedReader reader = new BufferedReader(new InputStreamReader(symptomsAdress));
		
		for(String line = reader.readLine(); line != null; line = reader.readLine()) {
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
		}
		
			// Close the reader for memory
			reader.close();
		
		} catch(IOException e) {
			System.out.println("file not found");
		}
			
		// next generate output
		try {
			// Call the class AnalyticsFolderAndFile to create the file for the result
			FileWriter writer = new FileWriter (folderAndFile.createFile(), true);
			BufferedWriter bw = new BufferedWriter(writer);
			bw.write("headache: " + headacheCount);
			bw.newLine();
			bw.write("rash: " + rashCount);
			bw.newLine();
			bw.write("dialated pupils: " + pupilCount);
			
			System.out.println("Je vais ici");
			
			bw.close();
			writer.close();
			
		} catch (IOException e) {
			System.out.println("File does not exist");
		}
		
	}
}
