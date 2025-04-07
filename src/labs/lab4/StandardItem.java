package labs.lab4;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Represents a non-grocery and non-digital item in the online store
 */
public class StandardItem extends MerchandiseItem {

	// ADD YOUR INSTANCE VARIABLES HERE

	private String description;
	/**
	 * Constructor
	 * 
	 * @param name        item name
	 * @param price       item price
	 * @param description item description
	 */
	public StandardItem(String name, double price, String description) {
		super(name, price);
		// FILL IN
		this.description = description;
	}


	/**
	 * Returns item's description
	 * 
	 * @return item's description
	 */
	public String getDescription() {
		return description; // FIX ME
	}


	/**
	 * Sets item's description
	 * 
	 * @param s new description
	 */
	public void setDescription(String s) {
		// FILL IN
		description = s;
	}


	@Override
	public String purchase(String purchaseDate) {
		LocalDate shippingDate = LocalDate.parse(purchaseDate);
		for (int i = 1; i <= 5; i++) {
			shippingDate = shippingDate.plus(1, ChronoUnit.DAYS);
			if (shippingDate.getDayOfWeek().getValue() == 6) {
				shippingDate = shippingDate.plus(1, ChronoUnit.DAYS);
			}
			if (shippingDate.getDayOfWeek().getValue() == 7) {
				shippingDate = shippingDate.plus(1, ChronoUnit.DAYS);
			}
		}
        return shippingDate.toString();
	}


	@Override
	public String toString() {
		return super.toString() + ", description: " + getDescription(); // FIX ME
	}


	@Override
	public boolean equals(Object otherObject) {
		if (!super.equals(otherObject)) { return false; }
		if (otherObject instanceof StandardItem) {
			StandardItem other = (StandardItem) otherObject;
			return this.getName().equals(other.getName()) && this.getPrice() == other.getPrice() && description == other.getDescription(); // FIX ME
		}
		return false;
	}

}