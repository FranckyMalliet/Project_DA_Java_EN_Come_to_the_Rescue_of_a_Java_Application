package com.hemebiotech.analytics;

import java.io.File;
import java.io.IOException;

public class AnalyticsFolderAndFile {
	
	// Create the folder who will get the analyze file
	public void createFolder() {
			File folder = new File("C://AnalyticsCounter");
			
			if(!folder.exists()) {
				folder.mkdir();
			}	
		}
	
	// Create the file who will get the results 
	 public File createFile() {
		 File result = new File("C://AnalyticsCounter/result.txt");
			
			try {
				if(!result.exists()) {
					result.createNewFile();
				}
			} catch (IOException e) {
				System.out.println("File does exist");
			}
			
		return result;
	 }
}