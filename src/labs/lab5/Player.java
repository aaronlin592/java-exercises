package labs.lab5;

public class Player {
	
	// ADD YOUR INSTANCE VARIABLES EHRE
	
	private String name;
	private double health;
	/**
	 * 
	 * Creates a new Player with the given name and health=0.5
	 */
	public Player(String name) {
		// FILL IN
		this.name = name;
		this.health = 0.5;
	}
	
	
	public String getName() {
		return name; // FIX ME
	}
	
	
	public void setName(String s) {
		// FILL IN
		name = s;
	}
	
	
	/**
	 * 
	 * @return	the health, which is always a number from 0 (least healthy) to 1 (most healthy)
	 */
	public double getHealth() {
		return health; // FIX ME
	}
	
	
	/**
	 * 
	 * Sets the health to the new value, as long as it's within the bounds
	 * (If below 0, sets it to 0; if above 1, sets it to 1)
	 * 
	 * If health == 0, print out a message "[this.name] died!"
	 */
	public void setHealth(double d) {
		// FILL IN
		if (d > 1) {
			health = 1;
		}
		else if (d < 0) {
			health = 0;
		}
		else {
			health = d;
		}
		
		if (health == 0) {
			System.out.print(this.name + " died!");
		}
	}
}