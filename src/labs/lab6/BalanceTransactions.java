package labs.lab6;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * A utility class for validating the cash on hand amount at the end of the day with the 
 * amount recorded in a file
 */

public class BalanceTransactions {

	/**
	 * Given a starting balance (amount of cash at the beginning of the day) and an
	 * ending balance (amount of cash at the end of the day), checks whether the
	 * actual amount of cash at the end of the day equals the expected value (within
	 * an 1E-3 error margin)
	 * 
	 * @param startBalance amount of cash at the beginning of the day; assume always
	 *                     >= 0
	 * @param endBalance   amount of cash at the end of the day
	 * @param filename     name of file containing transactions
	 * 
	 * @return a string indicating whether the end of day total was balanced or not
	 *         (either "End of day total is properly balanced." or "End of day total
	 *         is not balanced."
	 */
	public static String balance(double startBalance, double endBalance, String filename) {
		try (Scanner inputFile = new Scanner(new File(filename))) {
			double received = startBalance;
			double paid = 0.0;
			double current;
			while (inputFile.hasNext()) {
				if (inputFile.hasNextInt()) {
					inputFile.nextInt();
				}
				if (inputFile.hasNextDouble()) {
					current = inputFile.nextDouble();
					String transaction = inputFile.next();
					if (transaction.equals("R")) {
						received += current;
					}
					else if (transaction.equals("P")) {
						paid += current;
					}
				}
			}
			double remaining = Math.round((received - paid) * 100.0) / 100.0;
			return (remaining == endBalance) ? "End of day total is properly balanced." : "End of day total is not balanced.";
		} catch (FileNotFoundException e) { System.out.print("File: " + filename + " not found"); return "";}
	}
}
