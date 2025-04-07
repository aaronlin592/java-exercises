package labs.lab5;

public abstract class Person implements Comparable {

	// ADD INSTANCE VARIABLES HERE

	private String name;
	private int age;
	/**
	 * 
	 * @param name no validity checks necessary -- assume all valid input
	 * @param age  no validity checks necessary -- assume all valid input
	 */
	public Person(String name, int age) {
		// FILL IN
		this.name = name;
		this.age = age;
	}


	public String getName() {
		return name; // FIX ME
	}


	public int getAge() {
		return age; // FIX ME
	}


	/**
	 * compares first by name (use String.compareTo), then by age
	 */
	@Override
	public int compareTo(Object otherPerson) {
		Person other = (Person) otherPerson;
		if (name.compareTo(other.name) != 0) {
			return name.compareTo(other.name);
		}
		else {
			if (age < other.age) { return -1; }
			if (age > other.age) { return 1; }
			return 0;
		}
	}


	@Override
	public String toString() {
		return "Name: " + name + ", Age: " + age; // FIX ME
	}

}