package labs.lab3;

import java.util.ArrayList;

public class DailySalesTally {

	// ADD YOUR INSTANCE VARIABLES HERE
	private ArrayList<Purchase> purchases;
	

	public DailySalesTally() {
		// FILL IN
		this.purchases = new ArrayList<Purchase>();
	}


	/**
	 * Adds a purchase to the tally
	 * 
	 * @param p	the purchase
	 */
	public void addPurchase(Purchase p) {
		// FILL IN
		double discountPrice = p.isBoutiquePurchase() ? p.getPrice() * .95 : p.getPrice();
		for (Purchase pur : purchases) {
			if (p.getClientName().equals(pur.getClientName())) {
				discountPrice *= 0.9;
				break;
			}
		}
		purchases.add(new Purchase(p.getDescription(), p.getClientName(), discountPrice, p.isBoutiquePurchase()));
	}
	
	
	/**
	 * Calculates the total for the day for the client with the given name
	 * 
	 * @param clientName	name of the client for whom to calculate the total
	 * @return				total for the given client
	 */
	public double getTotalForClient(String clientName) {
		double clientTotal = 0.0;
		for (Purchase p : purchases) {
			if (p.getClientName().equals(clientName)) {
				clientTotal += p.getPrice();
			}
		}
		return clientTotal; // FIX ME
	}


	/**
	 * Calculates the grand total for the day for all purchases
	 * 
	 * @return	the grand total for the day for all purchases
	 */
	public double getGrandTotal() {
		double grandTotal = 0.0;
		for (Purchase p : purchases) {
			grandTotal += p.getPrice();
		}
		return grandTotal; // FIX ME
	}
}