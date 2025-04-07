package labs.lab3;

import java.util.ArrayList;

public class Inventory {
	// ADD YOUR INSTANCE VARIABLES HERE
	
	private ArrayList<Item> inventory;
	/**
	 * Constructs a new Inventory
	 */
	public Inventory() {
		// FILL IN
		this.inventory = new ArrayList<Item>();
	}
	
	
	/**
	 * If an item with the given item's description does not already exist
	 * in the inventory, adds that item to the inventory. If an item with
	 * the given item's description does exist, updates that item with 
	 * the given item's values.
	 * 
	 * @param item	item to add/update
	 */
	public void addOrUpdateItem(Item item) {
		// FILL IN
		boolean isInInventory = false;
		for (Item i : inventory) {
			if (i.getDescription().equals(item.getDescription())) {
				i.setCurrentStock(item.getCurrentStock());
				i.setTargetStock(item.getTargetStock());
				isInInventory = true;
				break;
			}
		}
		if (!isInInventory) {
			inventory.add(item);
		}
	}
	
	
	/**
	 * Removes item with the given description, if it exists
	 * 
	 * @param description	description of item to remove
	 */
	public void removeItemWithDescription(String description) {
		// FILL IN
		for (int i = 0; i < inventory.size(); i++) {
			if (inventory.get(i).getDescription().equals(description)) {
				inventory.remove(i);
			}
		}
	}
	
	
	/**
	 * Returns a report of items that are under-stocked (items whose
	 * current stock is less than their target stock)
	 * 
	 * @return	a string that reports which items need to be ordered
	 * and how many of each. If no items are under-stocked, report reads
	 * "No items under-stocked".
	 */
	public String getUnderstockReport() {
		ArrayList<String> understockedItemStrings = new ArrayList<String>();
		for (Item item : inventory) {
			if (item.getCurrentStock() < item.getTargetStock()) {
				understockedItemStrings.add("Order " + (item.getTargetStock() - item.getCurrentStock()) + " more of " + item.getDescription());
			}
		}
		if (understockedItemStrings.size() > 1) {
			String report = "";
			for (int i = 0; i < understockedItemStrings.size() - 1; i++) {
				report += understockedItemStrings.get(i) + " | ";
			}
			return report + understockedItemStrings.get(understockedItemStrings.size() - 1); 
		}
		else if (understockedItemStrings.size() == 1) {
			return understockedItemStrings.get(0);
		}
		else {
			return "No items under-stocked";
		}
		
		// FIX ME
	}
	
	
	/**
	 * Returns a report of items that are over-stocked (items whose
	 * current stock is more than their target stock)
	 * 
	 * @return	a string that reports which items are overstocked and
	 * by how much. If no items are over-stocked, report reads
	 * "No items over-stocked".
	 */
	public String getOverstockReport() {
		ArrayList<String> overstockedItemStrings = new ArrayList<String>();
		for (Item item : inventory) {
			if (item.getCurrentStock() > item.getTargetStock()) {
				overstockedItemStrings.add(item.getDescription() + " over-stocked by " + (item.getCurrentStock() - item.getTargetStock()) + " items");
			}
		}
		if (overstockedItemStrings.size() > 1) {
			String report = "";
			for (int i = 0; i < overstockedItemStrings.size() - 1; i++) {
				report += overstockedItemStrings.get(i) + " | ";
			}
			return report + overstockedItemStrings.get(overstockedItemStrings.size() - 1); 
		}
		else if (overstockedItemStrings.size() == 1) {
			return overstockedItemStrings.get(0);
		}
		else {
			return "No items over-stocked";
		} // FIX ME
	}
}