package labs.lab2;

public class GroceryBill {
	
	// ADD INSTANCE VARIABLES HERE
	private int discount;
	private double itemTotal;
	
	public GroceryBill(double itemTotal) {
		this.itemTotal = itemTotal;
		if (itemTotal > 210) {
			discount = 20;
		}
		else if (itemTotal > 150) {
			discount = 15;
		}
		else if (itemTotal > 60) {
			discount = 10;
		}
		else if (itemTotal >= 10) {
			discount = 5;
		}
		else {
			discount = 0;
		}
		// FILL IN
	}
	
	
	public double getDiscount() {
		return discount; // FIX ME
	}
	
	
	/**
	 * 
	 * @return	the amount owed, after applying:
	 * 1. Any discount
	 * 2. A 10% sales tax
	 */
	public double getAmountOwed() {
		double decimalDiscount = discount / 100.0;
		itemTotal -= itemTotal * decimalDiscount;
		itemTotal += itemTotal * .1;
		return itemTotal; // FIX ME
	}
}