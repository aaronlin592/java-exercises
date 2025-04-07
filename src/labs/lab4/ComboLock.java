package labs.lab4;

/**
 * A class to simulate a combination lock.
 */
public class ComboLock {
	// ADD YOUR INSTANCE VARIABLES HERE

	private int num1;
	private int num2;
	private int num3;
	private int current = 0;
	
	private int rightCount = 0;
	private int leftCount = 0;
	
	private boolean canOpen = false;
	/**
	 * Initializes the combination of the lock. Assume all inputs are valid ints
	 * between 0 and 39 inclusive
	 * 
	 * @param num1 first number to turn right to
	 * @param num2 second number to turn left to
	 * @param num3 third number to turn right to
	 */
	public ComboLock(int num1, int num2, int num3) {
		// FILL IN
		this.num1 = num1;
		this.num2 = num2;
		this.num3 = num3;
	}

	/**
	 * Resets the state of the lock so that it can be opened again; resets the
	 * dial so that it points to 0
	 */
	public void reset() {
		// FILL IN
		current = 0;
		
		rightCount = 0;
		leftCount = 0;
	}

	/**
	 * Turns lock left given number of ticks.
	 * 
	 * @param ticks number of ticks to turn left; assume ticks always between 0 
	 * and 39 inclusive
	 */
	public void turnLeft(int ticks) {
		// FILL IN
		current = (current + ticks) % 40;
		if (rightCount == 1 && leftCount == 0 && current == num2) {
			leftCount++;
		}
		else {
			leftCount++;
			canOpen = false;
		}
	}

	/**
	 * Turns lock right given number of ticks
	 * 
	 * @param ticks number of ticks to turn right; assume ticks always between 0
	 * and 39 inclusive
	 */
	public void turnRight(int ticks) {
		// FILL IN
		current = (current + 40 - ticks) % 40;
		if (rightCount == 0 && leftCount == 0 && current == num1) {
			rightCount++;
		}
		else if (rightCount == 1 && leftCount == 1 && current == num3) {
			rightCount++;
			canOpen = true;
		}
		else {
			canOpen = false;
		}
	}

	/**
	 * Returns true if the lock can be opened now, false otherwise
	 * 
	 * @return true if lock is in open state
	 */
	public boolean open() {
		return canOpen; // FIX ME
	}
}
