package labs.lab8;


/**
 * A class for executing selection sorting on an array.
 */
public class SelectionSorter<T extends Comparable<T>> {

	private T[] a;

	/**
	 * Constructs a SelectionSorter.
	 * 
	 * @param anArray a sorted array
	 */
	public SelectionSorter(T[] anArray) {
		a = anArray;
	}


	/**
	 * Sorts the array using a selection sort algorithm.
	 * 
	 * @return The sorted list.
	 */
	public void sort() {
		int position;
		int minimum;
		for (position = 0; position < a.length; position++) {
			minimum = position;
			for (int i = position + 1; i < a.length; i++) {
				if (a[i].compareTo(a[minimum]) < 0) {
					minimum = i;
				}
			}
			if (minimum != position) {
				T swap = a[position];
				a[position] = a[minimum];
				a[minimum] = swap;
			}
		}
	}
	
}
