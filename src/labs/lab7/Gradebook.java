package labs.lab7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * A program to add, remove, modify or print student names and grades.
 */
public class Gradebook {

	private Map<String, String> grades; // maps names to grades

	public Gradebook() {
		grades = new HashMap<>();
		// FILL IN
	}


	/**
	 * Adds a new entry. If the name already exists in the gradebook, overwrites the
	 * old grade with the new one.
	 * 
	 * @param name  student name
	 * @param grade student grade
	 */
	public void addEntry(String name, String grade) {
		// FILL IN
		grades.put(name, grade);
	}


	/**
	 * Removes the entry for the given name if it exists
	 * 
	 * @param name student name to remove
	 */
	public void removeEntry(String name) {
		// FILL IN
		grades.remove(name);
	}


	/**
	 * Modifies the entry for the given name if it exists
	 * 
	 * @param name  student name
	 * @param grade new grade
	 */
	public void modifyEntry(String name, String grade) {
		// FILL IN
		grades.replace(name, grade);
	}


	/**
	 * Returns an array of strings representing the gradebook, with
	 * each string in this format: [NAME] [GRADE]
	 * 
	 * The array must be sorted by name.
	 * 
	 * @return	an array of strings representing the gradebook
	 */
	public String[] getEntries() {
		TreeMap<String, String> sortedGrades = new TreeMap<>(grades);
		String[] entries = new String[sortedGrades.size()];
		
		int index = 0;
	    for (Map.Entry<String, String> entry : sortedGrades.entrySet()) {
	        entries[index++] = entry.getKey() + " " + entry.getValue();
	    }
	    
		return entries; // FILL IN
	}

}