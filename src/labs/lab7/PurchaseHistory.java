package labs.lab7;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a record of purchases
 *
 */
public class PurchaseHistory {

	// ADD YOUR INSTANCE VARIABLES EHRE
	private ArrayList<Purchase> purchases;

	public PurchaseHistory() {
		purchases = new ArrayList<Purchase>();
		// FILL IN
	}


	/**
	 * Adds a purchase to the history
	 * 
	 * @param date        date of purchase
	 * @param description description of purchase
	 * @param amount      amount of purchase
	 */
	public void addPurchase(LocalDate date, String description, double amount) {
		// FILL IN
		purchases.add(new Purchase(date, description, amount));
	}


	/**
	 * Removes all purchases matching the given parameters from the history
	 * 
	 * @param date        date of purchase
	 * @param description description of purchase
	 * @param amount      amount of purchase
	 * 
	 * @return the number of purchases matching the parameters and therefore removed
	 */
	public int removePurchase(LocalDate date, String description, double amount) {
		int count = 0;
	    var iterator = purchases.iterator();
	    while (iterator.hasNext()) {
	        Purchase p = iterator.next();
	        if (p.equals(new Purchase(date, description, amount))) {
	            iterator.remove();
	            count++;
	        }
	    }
	    return count;
	}


	/**
	 * Gets a list of all purchases that fall within a date range
	 * 
	 * @param start start of the date range (inclusive)
	 * @param end   end of the date range (inclusive)
	 * 
	 * @return a list of purchases in the date range, in sorted order
	 */
	public List<Purchase> getPurchasesInDateRange(LocalDate start, LocalDate end) {
		ArrayList<Purchase> purchasesInDateRange = new ArrayList<Purchase>();
		for (Purchase p : purchases) {
			LocalDate date = p.getDate();
			if ((date.isAfter(start) || date.equals(start)) && (date.isBefore(end) || date.equals(end))) {
				purchasesInDateRange.add(p);
			}
		}
		Collections.sort(purchasesInDateRange);
		return purchasesInDateRange; // FIX ME
	}


	/**
	 * Gets the total of all purchases that fall within a date range
	 * 
	 * @param start start of the date range (inclusive)
	 * @param end   end of the date range (inclusive)
	 * 
	 * @return the total of purchases in the date range
	 */
	public double getPurchaseTotalInDateRange(LocalDate start, LocalDate end) {
		double total = 0.0;
		List<Purchase> pur = this.getPurchasesInDateRange(start, end);
		for (Purchase p : pur) {
			total += p.getAmount();
		}
		return total; // FIX ME
	}


	/**
	 * Gets a list of all purchases that match a description
	 * 
	 * @param description the description to match
	 * 
	 * @return a list of purchases matching the description, in sorted order
	 */
	public List<Purchase> getPurchasesMatchingDescription(String description) {
		ArrayList<Purchase> purchasesInMatchingDescription = new ArrayList<Purchase>();
		for (Purchase p : purchases) {
			if (p.getDescription().equals(description)) {
				purchasesInMatchingDescription.add(p);
			}
		}
		Collections.sort(purchasesInMatchingDescription);
		return purchasesInMatchingDescription; // FIX ME
	}


	/**
	 * Gets the total of all purchases that match a description
	 * 
	 * @param description the description to match
	 * 
	 * @return the total of purchases that match the description
	 */
	public double getPurchaseTotalMatchingDescription(String description) {
		List<Purchase> pur = this.getPurchasesMatchingDescription(description);
		double total = 0.0;
		for (Purchase p : pur) {
			total += p.getAmount();
		}
		return total; // FIX ME
	}


	/**
	 * Gets a list of all purchases that fall within an amount range
	 * 
	 * @param min lower bound of the amount range (inclusive)
	 * @param max upper bound of the amount range (inclusive)
	 * 
	 * @return a list of purchases in the amount range, in sorted order
	 */
	public List<Purchase> getPurchasesInAmountRange(double min, double max) {
		ArrayList<Purchase> purchasesInAmtRange = new ArrayList<Purchase>();
		for (Purchase p : purchases) {
			if (p.getAmount() >= min && p.getAmount() <= max) {
				purchasesInAmtRange.add(p);
			}
		}
		Collections.sort(purchasesInAmtRange);
		return purchasesInAmtRange;
	}


	/**
	 * Gets the total of all purchases that fall within an amount range
	 * 
	 * @param min lower bound of the amount range (inclusive)
	 * @param max upper bound of the amount range (inclusive)
	 * 
	 * @return the total of purchases in the amount range
	 */
	public double getPurchaseTotalInAmountRange(double min, double max) {
		List<Purchase> pur = this.getPurchasesInAmountRange(min, max);
		double total = 0.0;
		for (Purchase p : pur) {
			total += p.getAmount();
		}
		return total;
	}


	/**
	 * Gets the most expensive purchase(s) made within a date range.
	 * 
	 * @param start start of the date range (inclusive)
	 * @param end   end of the date range (inclusive)
	 * 
	 * @return a sorted list of the most expensive purchase(s) made within the date
	 *         range
	 */
	public List<Purchase> getMaxPurchaseInDateRange(LocalDate start, LocalDate end) {
		List<Purchase> purInDateRange = this.getPurchasesInDateRange(start, end);
		ArrayList<Purchase> maxPurchases = new ArrayList<Purchase>();
		if (purInDateRange.isEmpty()) {
			return new ArrayList<Purchase>();
		}
		else {
			Purchase max = purInDateRange.get(0);
			for (Purchase p : purInDateRange) {
				if (p.getAmount() >= max.getAmount()) {
					max = p;
				}
			}
			for (Purchase p : purInDateRange) {
				if (max.getAmount() == p.getAmount()) {
					maxPurchases.add(p);
				}
			}
			Collections.sort(maxPurchases);
			return maxPurchases;
		}
	}


	/**
	 * Gets the least expensive purchase(s) made within a date range.
	 * 
	 * @param start start of the date range (inclusive)
	 * @param end   end of the date range (inclusive)
	 * 
	 * @return a sorted list of the least expensive purchase(s) made within the date
	 *         range
	 */
	public List<Purchase> getMinPurchaseInDateRange(LocalDate start, LocalDate end) {
		List<Purchase> purInDateRange = this.getPurchasesInDateRange(start, end);
		ArrayList<Purchase> minPurchases = new ArrayList<Purchase>();
		if (purInDateRange.isEmpty()) {
			return new ArrayList<Purchase>();
		}
		else {
			Purchase min = purInDateRange.get(0);
			for (Purchase p : purInDateRange) {
				if (p.getAmount() <= min.getAmount()) {
					min = p;
				}
			}
			for (Purchase p : purInDateRange) {
				if (min.getAmount() == p.getAmount()) {
					minPurchases.add(p);
				}
			}
			Collections.sort(minPurchases);
			return minPurchases;
		}
	}


	/**
	 * Returns a string representing all the purchases in the history, sorted, with
	 * a comma and space between each one
	 */
	@Override
	public String toString() {
		Collections.sort(purchases);
		List<String> purchasesStr = new ArrayList<String>();
		for (Purchase p : purchases) {
			purchasesStr.add(p.toString());
		}
		String str = String.join(", ", purchasesStr);
		return str; // FIX ME
	}

}
