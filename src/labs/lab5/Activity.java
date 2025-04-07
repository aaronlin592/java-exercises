package labs.lab5;

public class Activity extends GameElement implements Doable {
	
	// ADD YOUR INSTANCE VARIABLES EHRE
	private int duration;
	/**
	 * 
	 * @param name
	 * @param healthScore
	 * @param duration	in hours
	 */
	public Activity(String name, double healthScore, int duration) {
		super(name, healthScore);
		// FILL IN
		this.duration = duration;
	}
	
	
	/**
	 * For every this.healthScore point above 5, adds 0.05 to the player's health.
	 * For every this.healthScore point below 5, subtracts 0.05 from the player's health.
	 * If this.healthScore == 5, makes no change to the player's health
	 */
	@Override
	public String doIt(Player player) {
		if (this.getHealthScore() != 5) {
			player.setHealth(player.getHealth() + ((this.getHealthScore() - 5) * 0.05));
		}
		return player.getName() + " is doing " + this.getName() + " for " + duration + " hours";
	}
}