package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/**
 * CounterSymptomData put every symptoms in a Map and count them
 */

public class CounterSymptomData implements ICounterSymptomData {

	private final List<String> listSymptoms;

	/**
	 * @param listSymptoms List of Strings,
	 * Class Constructor
	 */
	
	public CounterSymptomData(List<String> listSymptoms) {
		// Avoid sending nothing in parameter
		this.listSymptoms = Objects.requireNonNull(listSymptoms);
	}

	/**
	 * Create a TreeMap by reading a list,
	 * @return a Map
	 */
	
	public Map<String, Integer> countSymptoms() {

		// Create an ordered Map by using TreeMap
		Map<String, Integer> symptomsList = new TreeMap<String, Integer>();

		// if the symptom doesn't exist, create it If the symptom already exist,
		// increment the value by one
		for (String list : listSymptoms) {
			symptomsList.put(list, symptomsList.getOrDefault(list, 0) + 1);
		}

		return symptomsList;
	}
}