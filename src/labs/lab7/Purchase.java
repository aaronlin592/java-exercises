package labs.lab7;

import java.time.LocalDate;

/**
 * Represents a purchase
 *
 */
public class Purchase implements Comparable<Purchase> {

	// ADD YOUR INSTANCE VARIABLES HERE
	private LocalDate date;
	private String description;
	private double amount;
	

	/**
	 * Constructs a new Purchase
	 * 
	 * @param date        the date of the purchase
	 * @param description a description of the purchase
	 * @param amount      the amount of the purchase (if < 0, sets it to 0)
	 */
	public Purchase(LocalDate date, String description, double amount) {
		// FILL IN
		this.date = date;
		this.description = description;
		this.amount = amount;
	}


	public LocalDate getDate() {
		return date; // FIX ME
	}


	public String getDescription() {
		return description; // FIX ME
	}


	public double getAmount() {
		return amount; // FIX ME
	}


	/**
	 * Returns a string representing this purchase, consisting of the date,
	 * description, and amount, each separated by a single space
	 */
	@Override
	public String toString() {
		return date.toString() + " " + description + " " + amount; // FIX ME
	}


	/**
	 * Returns true if the date, description, and amount all match
	 */
	@Override
	public boolean equals(Object o) {
		Purchase other = (Purchase) o;
		return date.equals(other.getDate()) && description.equals(other.getDescription()) && amount == other.getAmount() ; // FIX ME
	}


	/**
	 * Compares first by date (earlier dates first), then by amount (higher amounts
	 * first), then by description (lexicographically)
	 */
	public int compareTo(Purchase other) {
		if (date.compareTo(other.date) != 0) {
			return date.compareTo(other.date);
		}
		else {
			if (amount < other.amount) {
				return 1;
			}
			else if (amount > other.amount) {
				return -1;
			}
			else {
				return description.compareTo(other.description);
			}
		}
	}

}