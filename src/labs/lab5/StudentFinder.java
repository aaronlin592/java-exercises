package labs.lab5;

import java.util.Arrays;

/**
 * Test class for Comparable Student objects.
 */
public class StudentFinder {

	/**
	 * Determines first student in a non-empty array of Student objects.
	 * 
	 * @param students array of Student objects
	 * @return first Student
	 */
	public static Student firstStudent(Student[] students) {
		Student[] copy = Arrays.copyOf(students, students.length);
		Arrays.sort(copy);
		return copy[0]; // FIX ME
	}


	/**
	 * Determines last student in a non-empty array of Student objects.
	 * 
	 * @param students array of Student objects
	 * @return last Student
	 */
	public static Student lastStudent(Student[] students) {
		Student[] copy = Arrays.copyOf(students, students.length);
		Arrays.sort(copy);
		return copy[copy.length - 1];
	}

}
