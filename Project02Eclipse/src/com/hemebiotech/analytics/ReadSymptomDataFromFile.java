package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ReadSymptomDataFromFile read a file with data and create a List of symptoms
 */

public class ReadSymptomDataFromFile implements ISymptomReader {

	private final String filPath;

	/**
	 * @param filePath String of a file path,
	 * Class Constructor
	 */
	
	public ReadSymptomDataFromFile(String filePath) {
		this.filPath = Objects.requireNonNull(filePath);
	}

	/**
	 * Create a List of symptoms by reading the given file to analyze,
	 * @return list of Strings
	 */
	
	public List<String> getSymptoms() {
		ArrayList<String> result = new ArrayList<String>();

		if (filPath != null) {
			try (BufferedReader reader = new BufferedReader(new FileReader(filPath));) {

				String line = reader.readLine();

				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}

			} catch (IOException error) {
				throw new IllegalStateException("file doesn't found");
			}
		}

		return result;
	}
}