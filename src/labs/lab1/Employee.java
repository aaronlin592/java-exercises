package labs.lab1;

/**
 * An employee with a name and salary.
 */
public class Employee {
	private String name;
	private double salary;

	/**
	 * Constructs an employee.
	 * 
	 * @param employeeName  the employee name
	 * @param currentSalary the employee salary
	 */
	public Employee(String employeeName, double currentSalary) {
		name = employeeName;
		salary = currentSalary;
		// WRITE YOUR CODE HERE 
	}

	/**
	 * Gets the employee name.
	 * 
	 * @return the name
	 */
	public String getName() {
		// WRITE YOUR CODE HERE 
		return name; // FIX ME
	}

	/**
	 * Gets the employee salary.
	 * 
	 * @return the salary
	 */
	public double getSalary() {
		// WRITE YOUR CODE HERE 
		return salary; // FIX ME
	}

	/**
	 * Raises the salary by a given percentage.
	 * 
	 * @param percent the percentage of the raise
	 */
	public void raiseSalary(double percent) {
		double percentToDecimal = percent / 100.0;
		salary = salary + (salary * percentToDecimal);
		// WRITE YOUR CODE HERE 
	}
}
