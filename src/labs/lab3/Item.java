package labs.lab3;

/**
 * Represents an item in the inventory
 */
public class Item {
	// ADD YOUR INSTANCE VARIABLES EHRE
	
	private String description;
	private int targetStock;
	private int currentStock;
	
	/**
	 * Constructs a new Item
	 * 
	 * @param description	string description of the item
	 * @param targetStock	how many of the item should be kept in stock
	 * @param currentStock	how many of the item is currently in stock
	 */
	public Item(String description, int targetStock, int currentStock) {
		// FILL IN
		this.description = description;
		this.targetStock = targetStock;
		this.currentStock = currentStock;
	}
	
	
	/**
	 * Returns a string description of the item
	 * 
	 * @return	a string description of the item
	 */
	public String getDescription() {
		return description; // FIX ME
	}
	
	
	/**
	 * Returns how many of the item should be kept in stock
	 * 
	 * @return	how many of the item should be kept in stock
	 */
	public int getTargetStock() {
		return targetStock; // FIX ME
	}
	
	
	/**
	 * Returns how many of the item is currently in stock
	 * 
	 * @return	how many of the item is currently in stock
	 */
	public int getCurrentStock() {
		return currentStock; // FIX ME
	}
	
	
	/**
	 * Sets the target stock to a new amount
	 * 
	 * @param targetStock	how many of the item should be kept in stock
	 */
	public void setTargetStock(int targetStock) {
		// FILL IN
		this.targetStock = targetStock;
	}
	
	
	/**
	 * Sets the current stock to a new amount
	 * 
	 * @param currentStock	how many of the item is currently in stock
	 */
	public void setCurrentStock(int currentStock) {
		// FILL IN
		this.currentStock = currentStock;
	}
}