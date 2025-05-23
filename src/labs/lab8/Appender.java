package labs.lab8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A utility class for appending lists/arrays
 *
 */
public class Appender {

	/**
	 * Appends two lists together.
	 * 
	 * Leaves the parameter lists unchanged, and returns a new list that contains
	 * the elements of a and b appended
	 * 
	 * @param <T> the type contained in the lists
	 * @param a   list 1
	 * @param b   list 2
	 * 
	 * @return a new list containing the elements of a and b appended
	 */
	// WRITE METHOD HERE
	public static <T> List<T> append(List<T> a, List<T> b) {
		List<T> newList = new ArrayList<>();
		for (T elementA : a) {
			newList.add(elementA);
		}
		for (T elementB : b) {
			newList.add(elementB);
		}
		return newList;
	}


	/**
	 * Appends two arrays together.
	 * 
	 * Leaves the parameter arrays unchanged, and returns a new arrays that contains
	 * the elements of a and b appended
	 * 
	 * @param <T> the type contained in the arrays
	 * @param a   array 1
	 * @param b   array 2
	 * 
	 * @return a new array containing the elements of a and b appended
	 */
	// WRITE METHOD HERE
	public static <T> T[] append(T[] a, T[] b) {
		T[] list = Arrays.copyOf(a, a.length + b.length);

	    for (int i = 0; i < b.length; i++) {
	        list[a.length + i] = b[i];
	    }
		return list;
	}

}