package labs.lab5;

/**
 * This class represents a student with a name and ID.
 */
public class Student implements Comparable {

	// ADD YOUR INSTANCE VARIABLES HERE

	private String name;
	private int id;
	/**
	 * Constructs a student object
	 * 
	 * @param name the student's name
	 * @param id   the student's id
	 */
	public Student(String name, int id) {
		// FILL IN
		this.name = name;
		this.id = id;
	}


	/**
	 * Gets the student's name
	 * 
	 * @return the name
	 */
	public String getName() {
		return name; // FIX ME
	}


	/**
	 * Gets the student's id
	 * 
	 * @return the name
	 */
	public int getId() {
		return id; // FIX ME
	}


	@Override
	public String toString() {
		return name + ", " + id; // FIX ME
	}


	@Override
	public boolean equals(Object otherObject) {
		Student other = (Student) otherObject;
		return (name.equals(other.name) && id == other.id); // FIX ME
	}


	/**
	 * Compares student objects first by name, then by id
	 * 
	 * @param other Other student against which to compare
	 * @return negative int if this students comes before, 0 if equal, positive int
	 *         if this student comes after
	 */
	public int compareTo(Object other) {
		Student otherStudent = (Student) other;
		if (name.compareTo(otherStudent.name) != 0) {
			return name.compareTo(otherStudent.name);
		}
		else {
			if (id < otherStudent.id) { return -1; }
			else if (id > otherStudent.id) { return 1; }
			return 0;
		}
	}

}
