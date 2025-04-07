package labs.lab1;

/**
 * This class models the circuit for a hallway light.
 */
public class Circuit {

	// ADD YOUR INSTANCE VARIABLES HERE
	private static int switch1 = 1;
	private static int switch2 = 2;
	private int switchState1 = 0;
	private int switchState2 = 0;
	private int lampState = 0;
	/**
	 * Gets the current state of the indicated switch
	 * 
	 * @param switchNum the number of the switch (1 or 2)
	 * @return the state of the indicated switch (0 = down, 1 = up)
	 */
	public int getSwitchState(int switchNum) {
		if (switchNum == switch1) {
			return switchState1;
		}
		else if (switchNum == switch2) {
			return switchState2;
		}
		else {
			return -1;
		}
		 // FIX ME
	}


	/**
	 * Gets the current state of the hallway lamp.
	 * 
	 * @return the state of the lamp (0 = off, 1 = on)
	 */
	public int getLampState() {
		return lampState; // FIX ME
	}


	/**
	 * Changes the indicated switch from up to down, or vice versa. Toggling the
	 * switch also changes the state of the lamp.
	 * 
	 * @param switch the number of the switch (1 or 2)
	 */
	public void toggleSwitch(int switchNum) {
		if (switchNum == 1) {
			if (lampState == 0) {
				lampState = 1;
			}
			else if (lampState == 1) {
				lampState = 0;
			}
			if (switchState1 == 0) {
				switchState1 = 1;
			}
			else if (switchState1 == 1) {
				switchState1 = 0;
			}
		}
		if (switchNum == 2) {
			if (lampState == 0) {
				lampState = 1;
			}
			else if (lampState == 1) {
				lampState = 0;
			}
			if (switchState2 == 0) {
				switchState2 = 1;
			}
			else if (switchState2 == 1) {
				switchState2 = 0;
			}
		}
		// FILL IN
	}
}
