package labs.lab1;

/**
 * A class for representing a microwave oven.
 */
public class Microwave {

	// ADD INSTANCE VARIABLES HERE
	private int timer;
	private int powerLevel;
	/**
	 * Creates a microwave with 0 seconds on the timer and at power level 1
	 */
	public Microwave() {
		timer = 0;
		powerLevel = 1;
		// FILL IN
	}

	/**
	 * Increases the time on the timer by 30 seconds
	 */
	public void increaseTime() {
		timer += 30;
		// FILL IN
	}

	/**
	 * Switches the power level from 1 to 2, or vice versa
	 */
	public void switchPower() {
		if (powerLevel == 1) {
			powerLevel = 2;
		}
		else if (powerLevel == 2) {
			powerLevel = 1;
		}
		// FILL IN
	}

	/**
	 * Resets the microwave to its initial state.
	 */
	public void reset() {
		timer = 0;
		powerLevel = 1;
		// FILL IN
	}

	/**
	 * Starts the machine, and returns information about its cooking state
	 * 
	 * @return	a message containing information about its cooking state ("Cooking 
	 * for ... seconds at level ...")
	 */
	public String start() {
		return "Cooking for " + timer + " seconds at level " + powerLevel; // FIX ME
	}

}
