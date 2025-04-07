package labs.lab1;

/**
 * A rechargeable battery.
 */
public class Battery {

	// ADD YOUR INSTANCE VARIABLES HERE
	private double cap;
	private double max;
	/**
	 * Create a battery with specified capacity.
	 * 
	 * @param capacity maximum capacity, measured in milliampere hours
	 */
	public Battery(double capacity) {
		cap = capacity;
		max = cap;
		// FILL IN
	}


	/**
	 * Drain capacity of the battery by given amount.
	 * 
	 * @param amount amount of battery used (assume it will not be > its current capacity
	 */
	public void drain(double amount) {
		cap -= amount;
		// FILL IN
	}


	/**
	 * Recharge the battery to maximum capacity.
	 */
	public void charge() {
		cap = max;
		// FILL IN
	}


	/**
	 * Retrieve the battery's current capacity.
	 * 
	 * @return remaining capacity
	 */
	public double getRemainingCapacity() {
		return cap; // FIX ME
	}
}
