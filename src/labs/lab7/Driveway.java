package labs.lab7;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Class for simulating a driveway and a street, using stacks of cars with
 * license plate numbers as representation.
 */
public class Driveway {
	private Stack<Integer> driveway; // represents cars in the driveway
	private Stack<Integer> street; // represents cars on the street

	/**
	 * Constructor
	 */
	public Driveway() {
		// FILL IN
		driveway = new Stack<Integer>();
		street = new Stack<Integer>();
	}

	
	/**
	 * Returns a String representation of the driveway. For a driveway stack
	 * with cars 1, 2, 3, and 4, with 1 first-in and 4 first-out, the string
	 * returned by this method would be: "Driveway: 1 2 3 4"
	 * 
	 * @return	a String representation of this driveway
	 */
	public String getDriveway() {
		StringBuilder sb = new StringBuilder("Driveway: ");
	    for (int plate : driveway) {
	        sb.append(plate).append(" ");
	    }
	    return !driveway.isEmpty() ? sb.toString().trim() : sb.toString(); // FIX ME
	}

	
	/**
	 * Returns a String representation of the street. For a street stack 
	 * with cars 1, 2, 3, and 4, with 1 first-in and 4 first-out, the string 
	 * returned by this method would be: "Street: 1 2 3 4"
	 * 
	 * @return	a String representation of the street
	 */
	public String getStreet() {
		StringBuilder sb = new StringBuilder("Street: ");
	    for (int plate : street) {
	        sb.append(plate).append(" ");
	    }
	    return !street.isEmpty() ? sb.toString().trim() : sb.toString(); // FIX ME
	}

	
	/**
	 * Adds the given license plate to the driveway if it's not already in the
	 * driveway. Returns a log of the process.
	 * 
	 * @param licensePlate number of license plate.
	 * 
	 * @return a log of the process
	 */
	public List<String> add(int licensePlate) {
		List<String> addLog = new ArrayList<String>();
		if (driveway.contains(licensePlate)) {
			addLog.add("That car is already in the driveway.");
		}
		else {
			driveway.push(licensePlate);
			addLog.add(getDriveway());
			addLog.add(getStreet());
		}
		return addLog; // FIX ME
	}

	/**
	 * Remove the given license plate from the driveway if it's in the driveway.
	 * Returns a log of the process
	 * 
	 * @param licensePlate number of license plate.
	 * 
	 * @return a log of the process
	 */
	public List<String> remove(int licensePlate) {
		List<String> removeLog = new ArrayList<>();
        if (!driveway.contains(licensePlate)) {
            removeLog.add("That car is not in the driveway.");
        } else {
            while (!driveway.isEmpty() && driveway.peek() != licensePlate) {
                street.push(driveway.pop());
                removeLog.add(getDriveway());
                removeLog.add(getStreet());
            }
            if (!driveway.isEmpty()) {
                driveway.pop();
                if (!driveway.isEmpty() && !street.isEmpty()) {
                	driveway.push(street.pop());
	                removeLog.add(getDriveway());
	                removeLog.add(getStreet());
                }
                else if (!driveway.isEmpty()) {
                	removeLog.add(getDriveway());
	                removeLog.add(getStreet());
                }
            }
            while (!street.isEmpty()) {
                driveway.push(street.pop());
                removeLog.add(getDriveway());
                removeLog.add(getStreet());
            }
        }
        if (removeLog.isEmpty()) {
        	removeLog.add(getDriveway());
            removeLog.add(getStreet());
        }
        return removeLog;
	}
}
