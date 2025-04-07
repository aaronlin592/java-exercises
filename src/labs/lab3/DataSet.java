package labs.lab3;

import java.util.ArrayList;

/**
 * This class is used to calculate the average, smallest, largest and range of
 * the values.
 */
public class DataSet {
	// ADD YOUR INSTANCE VARIABLES HERE

	private ArrayList<Double> dataSet;
	/**
	 * Constructs a DataSet object to hold the number of items, the extreme values
	 * and the sum.
	 */
	public DataSet() {
		// FILL IN
		this.dataSet = new ArrayList<Double>();
	}

	/**
	 * Adds a value to this data set.
	 * 
	 * @param x the input value
	 */
	public void add(double x) {
		// FILL IN
		dataSet.add(x);
	}
	
	/**
	 * Method used to calculate the sum of the data set.
	 * 
	 * @return sum the sum of the data set
	 */
	public double getSum() {
		double sum = 0.0;
		for (double value : dataSet) {
			sum += value;
		}
		return sum; // FIX ME
	}

	/**
	 * Method used to calculate the average of the data set.
	 * 
	 * @return average the average of the data set
	 */
	public double getAverage() {
		// Because sum is a double, sum / n will not throw an
		// exception.
		
		return this.getSum() / this.getCount(); // FIX ME
	}

	/**
	 * The smallest value contained in the data set.
	 * 
	 * @return the smallest value in the data set
	 */
	public double getSmallest() {
		double min = dataSet.get(0); 
		
		for (int i = 1; i < dataSet.size(); i++) { 
            if (dataSet.get(i) < min) { 
                min = dataSet.get(i); 
            } 
        }
		return min; // FIX ME
	}

	/**
	 * The largest value contained in the data set.
	 * 
	 * @return the largest value in the data set
	 */
	public double getLargest() {
		double max = dataSet.get(0); 
		
		for (int i = 1; i < dataSet.size(); i++) { 
            if (dataSet.get(i) > max) { 
                max = dataSet.get(i); 
            } 
        }
		return max;  // FIX ME
	}

	/**
	 * The range of values in the data set.
	 * 
	 * @return the range of values in the data set
	 */
	public double getRange() {
		return Math.abs(this.getLargest()) + Math.abs(this.getSmallest()); // FIX ME
	}

	/**
	 * Gets the total number of input values.
	 * 
	 * @return n the total number of inputs
	 */
	public int getCount() {
		return dataSet.size(); // FIX ME
	}
}
