package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.Objects;
import java.util.Map.Entry;

/**
 * WriteDataResults write all the data coming from a Map to a file.
 */

public class WriteDataResults implements IWriteDataResults {

	private final static Calendar GREGORIAN_CALENDAR = new GregorianCalendar();
	private final Map<String, Integer> symptomsList;
	private final AnalyticsFolderAndFile resultFile;

	/**
	 * @param symptomsList Map of Strings with numeric values,
	 * @param resultFile Instance of AnalyticsFolderAndFile class,
	 * Take a Map and an object AnalyticsFolderAndFile that give all
	 * the required elements to create a file with the final data.
	 */

	public WriteDataResults(Map<String, Integer> symptomsList, AnalyticsFolderAndFile resultFile) {
		this.symptomsList = Objects.requireNonNull(symptomsList);
		this.resultFile = Objects.requireNonNull(resultFile);
	}
	
	/**
	 * Read a Map,
	 * Write on a file all the data coming from this Map
	 */
	
	public void getResults() {

		try (FileWriter writer = new FileWriter(resultFile.createFile(), true);
				BufferedWriter buffer = new BufferedWriter(writer)) {

			buffer.newLine();

			// Write lines of data coming from the ordered map
			for (Entry<String, Integer> elements : symptomsList.entrySet()) {
				buffer.write(elements.getKey() + " " + elements.getValue());
				buffer.newLine();
			}

			buffer.newLine();

			// add a feature that give a record of the time the analyze has been made
			buffer.write("Results done the " + GREGORIAN_CALENDAR.getTime());

			buffer.newLine();
			buffer.newLine();

		} catch (IOException error) {
			throw new IllegalStateException("File doesn't exist");
		}
	}
}