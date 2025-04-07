package labs.lab1;


/**
 * The class represents an ant population that may breed and that may be
 * controlled by insecticide.
 */
public class AntPopulation {
	private int population;
	
	/**
	 * Create an initial ant population with given size.
	 * 
	 * @param size initial population
	 */
	public AntPopulation(int size) {
		population = size;// FILL IN
	}

	/**
	 * Simulates a breeding period increasing the population.
	 */
	public void breed() {
		population = population * 2;// FILL IN
	}

	/**
	 * Spray the population with insecticide.
	 * 
	 * Rounds number of ants eradicated to the nearest int before subtracting
	 * them from the population.
	 * 
	 * @param percent percent of population eradicated
	 */
	public void spray(double percent) {
		double perToDec = percent / 100.0;
		int eradicated = (int) Math.round(population * perToDec);
		population = population - (eradicated);
		// FILL IN
	}

	/**
	 * Returns the current population size.
	 * 
	 * @return current population size
	 */
	public int getAnts() {
		return population; // FIX ME
	}
}
