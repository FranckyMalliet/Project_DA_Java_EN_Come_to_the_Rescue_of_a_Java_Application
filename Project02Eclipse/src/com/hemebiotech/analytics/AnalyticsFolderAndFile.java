package com.hemebiotech.analytics;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 * This class has two methods : createFolder and createFile. 
 * They need to get the file path with the result file format like this :
 * "C://AnalyticsCounter/results.txt",
 * createFolder create a folder parent for the final file,
 * createFile create the final results of the analyze
 */

public class AnalyticsFolderAndFile {

	private final String filePath;

	/**
	 * @param filePath String of a file path,
	 * Class Constructor
	 */
	
	public AnalyticsFolderAndFile(String filePath) {
		// Avoid sending nothing in parameter
		this.filePath = Objects.requireNonNull(filePath);
	}

	/**
	 * Create a folder from a file path
	 */
	
	public void createFolder() {
		File folder = new File(filePath).getParentFile();

		if (!folder.exists()) {
			folder.mkdir();
		}
	}

	/**
	 * Create a file from a file path,
	 * @return a file
	 */
	
	public File createFile() {
		File result = new File(filePath);

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