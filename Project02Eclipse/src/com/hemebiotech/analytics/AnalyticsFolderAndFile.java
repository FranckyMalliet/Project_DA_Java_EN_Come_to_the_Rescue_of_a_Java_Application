package com.hemebiotech.analytics;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 * This class has two methods : createFolder and createFile 
 * They need to get the filepath with the result file format like this :
 * "C://AnalyticsCounter/results.txt" 
 * createFolder create a folder parent to the results.txt
 * createFile create the final results of the analyze
 */

public class AnalyticsFolderAndFile {

	private final String filepath;

	public AnalyticsFolderAndFile(String filepath) {
		// Avoid sending nothing in parameter
		this.filepath = Objects.requireNonNull(filepath);
	}

	// Create the folder who will get the analyze file
	public void createFolder() {
		File folder = new File(filepath).getParentFile();

		if (!folder.exists()) {
			folder.mkdir();
		}
	}

	// Create the file who will get the results
	public File createFile() {
		File result = new File(filepath);

		try {
			if (!result.exists()) {
				result.createNewFile();
			}
		} catch (IOException error) {
			throw new IllegalStateException("File doesn't exist");
		}

		return result;
	}
}