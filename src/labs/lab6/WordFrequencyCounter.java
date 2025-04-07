package labs.lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Counts the frequencies of words in a file and generates a frequency graph
 */
public class WordFrequencyCounter {

	// ADD YOUR INSTANCE VARIABLES HERE

	private ArrayList<String> words = new ArrayList<String>();
	private ArrayList<String> uniqueWords = new ArrayList<String>();
	private ArrayList<Integer> wordCounts = new ArrayList<Integer>();
	private ArrayList<String> histogram = new ArrayList<String>();
	private String fileName;
	/**
	 * Constructor
	 * 
	 * @param fileName name of file from which to count word frequencies
	 */
	public WordFrequencyCounter(String fileName) {
		this.fileName = fileName;
		try (Scanner inputFile = new Scanner(new File(this.fileName))) {
			while (inputFile.hasNext()) {
				words.add(inputFile.next().toLowerCase().replaceAll("[^a-zA-Z0-9\\s]", ""));
			}
			
			for (String word : words) {
	            if (uniqueWords.contains(word)) {
	                int index = uniqueWords.indexOf(word);
	                wordCounts.set(index, wordCounts.get(index) + 1);
	            } else {
	                uniqueWords.add(word);
	                wordCounts.add(1);
	            }
	        }
			for (int i = 0; i < uniqueWords.size(); i++) {
				histogram.add(uniqueWords.get(i) + ": " + "*".repeat(wordCounts.get(i)));
			}
			Collections.sort(histogram, new Comparator<String>() {
	            @Override
	            public int compare(String wc1, String wc2) {
	                // First, compare by count in descending order
	                int countComparison = Integer.compare(wc2.substring(wc2.lastIndexOf(":") + 2).length(), wc1.substring(wc1.lastIndexOf(":") + 2).length());
	                if (countComparison != 0) {
	                    return countComparison; // Higher count first
	                }
	                // If counts are the same, compare by word lexicographically
	                return wc1.compareTo(wc2);
	            }
	        });
			
		} catch (FileNotFoundException e) { System.out.print("File: " + this.fileName + " not found"); }
		// FILL IN
	}

	/**
	 * Returns a word frequency graph based on the input file. Words are sorted
	 * based on frequency (more frequent words appear first) and then by name
	 * (lexicographically). 
	 * 
	 * Convert all words into lower case for the analysis and graph generation.
	 * 
	 * @return a word frequency graph based on the input file
	 */
	public String getFrequencyGraph() {
		String graph = "";
		for (int i = 0; i < histogram.size(); i++) {
			graph += histogram.get(i) + "\n";
		}
		return graph;
	}
}