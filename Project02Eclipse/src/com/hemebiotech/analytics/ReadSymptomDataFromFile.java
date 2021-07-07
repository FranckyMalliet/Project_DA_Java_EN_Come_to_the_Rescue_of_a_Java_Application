package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/**
 * ReadSymptomDataFromFile create an ordered list, 
 * This list include symptoms and their occurrences. 
 * The interface is here for long term uses if the program need to be changed.
 */

public class ReadSymptomDataFromFile implements ISymptomReader {

	private final String filepath;

	public ReadSymptomDataFromFile(String filepath) {
		// Avoid sending nothing in parameter
		this.filepath = Objects.requireNonNull(filepath);
	}

	public Map<String, Integer> GetSymptoms() {

		// Create an ordered Map by using TreeMap
		Map<String, Integer> symptomsList = new TreeMap<String, Integer>();

		try (InputStream symptomsAdress = new FileInputStream(filepath);
				BufferedReader reader = new BufferedReader(new InputStreamReader(symptomsAdress))) {

			// Analyze the file, create non existent symptoms, increment the existing
			for (String line = reader.readLine(); line != null; line = reader.readLine()) {
				symptomsList.put(line, symptomsList.getOrDefault(line, 0) + 1);
			}

		} catch (IOException error) {
			throw new IllegalStateException("file not found");
		}

		return symptomsList;
	}
}
