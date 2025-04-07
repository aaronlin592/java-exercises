package labs.lab7;

import java.util.PriorityQueue;

/**
 * Class for simulating a queue for a theme park attraction.
 */
public class ThemeParkQueue {

	// ADD YOUR INSTANCE VARIABLES HERE
	private PriorityQueue<String> premium;
	private PriorityQueue<String> standard;

	/**
	 * Constructor
	 */
	public ThemeParkQueue() {
		// FILL IN
		premium = new PriorityQueue<String>();
		standard = new PriorityQueue<String>();
	}


	/**
	 * Adds a person to the standard line
	 * 
	 * @param guestName name of the guest
	 */
	public void addStandardGuest(String guestName) {
		// FILL IN
		standard.add(guestName);
	}


	/**
	 * Adds a person to the premium line
	 * 
	 * @param guestName name of the guest
	 */
	public void addPremiumGuest(String guestName) {
		// FILL IN
		premium.add(guestName);
	}


	/**
	 * Handles the next action and returns a string indicating what that next action
	 * is, in the format: "[GUEST_NAME] entering from [PREMIUM/STANDARD] line"
	 * 
	 * @return a string indicating the next action
	 */
	public String handleNextAction() {
		String action = "";
		if (!premium.isEmpty()) {
			action = premium.poll() + " entering from premium line";
		}
		else if (!standard.isEmpty()) {
			action = standard.poll() + " entering from standard line";
		}
		return action; // FIX ME
	}

}
