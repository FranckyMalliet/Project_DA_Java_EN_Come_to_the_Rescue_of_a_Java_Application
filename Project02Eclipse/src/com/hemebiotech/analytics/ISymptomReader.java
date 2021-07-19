package com.hemebiotech.analytics;

import java.util.List;

/**
 * Created for more robust code If the List has to change, it can use the
 * interface ISymptomReader
 */

public interface ISymptomReader {

	/**
	 * read data files,
	 * @return a list of Strings 
	 */
	
	List<String> getSymptoms();
}