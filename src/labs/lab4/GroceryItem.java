package labs.lab4;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Represents a perishable, edible item with an expiration date
 */
public class GroceryItem extends MerchandiseItem {

	// ADD YOUR INSTANCE VARIABLES HERE

	private String expirationDate;
	/**
	 * Constructor
	 * 
	 * @param name           name of item
	 * @param price          price of item
	 * @param expirationDate expiration date of item, in the format YYYY-MM-DD
	 */
	public GroceryItem(String name, double price, String expirationDate) {
		super(name, price);
		// FILL IN
		this.expirationDate = expirationDate;
	}


	/**
	 * Returns the expiration date, in the format YYYY-MM-DD
	 * 
	 * @return the expiration date, in the format YYYY-MM-DD
	 */
	public String getExpirationDate() {
		return expirationDate; // FIX ME
	}


	/**
	 * Sets the expiration date
	 * 
	 * @param s new expiration date, in the format YYYY-MM-DD
	 */
	public void setExpirationDate(String s) {
		// FILL IN
		expirationDate = s;
	}


	@Override
	public String purchase(String purchaseDate) {
		LocalDate date = LocalDate.parse(purchaseDate);
        LocalDate shippingDate = date.plus(1, ChronoUnit.DAYS);
        if (shippingDate.getDayOfWeek().getValue() == 6) {
        	shippingDate = shippingDate.plus(2, ChronoUnit.DAYS);
        }
        else if (shippingDate.getDayOfWeek().getValue() == 7) {
        	shippingDate = shippingDate.plus(1, ChronoUnit.DAYS);
        }
        return shippingDate.toString(); // FIX ME
	}


	@Override
	public boolean equals(Object otherObject) {
		if (!super.equals(otherObject)) { return false; }
		if (otherObject instanceof GroceryItem) {
			GroceryItem other = (GroceryItem) otherObject;
			return this.getName().equals(other.getName()) && this.getPrice() == other.getPrice() && expirationDate == other.getExpirationDate(); // FIX ME
		}
		return false;
	}


	@Override
	public String toString() {
		return super.toString() + ", expiration date: " + getExpirationDate(); // FIX ME
	}

}