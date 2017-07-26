package players;

import exceptions.PlayerException;

/**
 * Class that creates a player or creature. Keeps track of the player or creature's name and initiative score.
 * 
 * @author Thomas Shortt
 *
 */
public class Player implements Comparable<Player> {
	
	private String name;
	private int score;
	
	/**
	 * Constructor that creates the player object.
	 * 
	 * @param name - The name of the player or creature
	 * @param score - The initiative score of the player or creature
	 * @throws PlayerException if name is empty or score is less than 0 or greater than 30
	 */
	public Player(String name, int score) throws PlayerException {
		if (name.isEmpty() == true) {
			throw new PlayerException("A name has not been provided!");
		} else if (score < 0 || score > 30) {
			throw new PlayerException("Invalid score!");
		} else {
			this.name = name;
			this.score = score;
		}
	}
	
	/**
	 * Simple getter method that returns the name of the player or creature.
	 * 
	 * @return the name of the player or creature
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Simpler getter method that returns the initiative score of the player or creature.
	 * 
	 * @return the score of the player or creature
	 */
	public int getScore() {
		return this.score;
	}
	
	/**
	 * Compares one player to another.
	 * Returns a positive number if the other team has a higher score.
	 * Returns a negative number if the other team has a lower score.
	 * Returns zero if both teams have the same score.
	 * 
	 * @param other - The other player being compared
	 * @return a positive number, a negative number or zero
	 */
	public int compareTo(Player other) {
		return other.score - this.score;
	}

}
