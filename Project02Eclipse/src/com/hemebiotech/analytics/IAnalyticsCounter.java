package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Created for more robust code If the Map has to change, it can use the
 * interface ISymptomReader
 */

public interface IAnalyticsCounter {
	
	/**
	 * read a list,
	 * @return a Map 
	 */
	
	Map<String,Integer> countSymptoms ();
}