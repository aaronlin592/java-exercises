package labs.lab6;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Reads in a sales file and calculates the total amount for each service
 * category when requested
 */
public class SalesTally {

	// ADD YOUR INSTANCE VARIABLES HERE

	ArrayList<Sale> sales = new ArrayList<>();
	/**
	 * Constructor
	 * 
	 * @param salesFileName sales file name
	 */
	public SalesTally(String salesFileName) {
		// FILL IN
		try (Scanner inputFile = new Scanner(new File(salesFileName))) {
			while (inputFile.hasNextLine()) {
				String[] next = inputFile.nextLine().split(";");
				sales.add(new Sale(next[0], next[1], Double.parseDouble(next[2]), next[3]));
			}
		} catch (FileNotFoundException e) { System.out.print("File: " + salesFileName + " not found"); }
	}


	/**
	 * Returns the total amount of sales for the given category
	 * 
	 * @param category
	 * 
	 * @return total amount of sales for the given category
	 */
	public double getCategoryTotal(String category) {
		double sum = 0.0;
		for (Sale s: sales) {
			if (s.getServiceCategory().equals(category)) {
				sum += s.getAmount();
			}
		}
		return sum; // FIX ME
	}

}
