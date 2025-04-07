package labs.lab3;

/**
 * Represents a purchase made in Robert's doggy spa/boutique
 */
public class Purchase {

	// ADD YOUR INSTANCE VARIABLES HERE
	private String description = "";
	private String clientName = "";
	private double price = 0.0;
	private boolean boutiquePurchase = false;
	
	/**
	 * Constructs a new Purchase
	 * 
	 * @param description		description of the purchase
	 * @param clientName		name of client who made the purchase
	 * @param price				price of the purchase
	 * @param boutiquePurchase	whether or not this was a boutique purchase
	 */
	public Purchase(String description, String clientName, double price, boolean boutiquePurchase) {
		this.description = description;
		this.clientName = clientName;
		this.price = price;
		this.boutiquePurchase = boutiquePurchase;
		// FILL IN
	}
	
	
	public String getDescription() {
		return description; // FIX ME
	}
	
	
	public String getClientName() {
		return clientName; // FIX ME
	}


	public double getPrice() {
		return price; // FIX ME
	}


	public boolean isBoutiquePurchase() {
		return boutiquePurchase; // FIX ME
	}
}