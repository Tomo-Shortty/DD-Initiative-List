package players;

import java.util.ArrayList;
import java.util.Collections;

import exceptions.PlayerException;

/**
 * Class that creates the list of players to be displayed in the GUI.
 * 
 * @author Thomas Shortt
 *
 */
public class PlayerList {
	
	private ArrayList<Player> players;
	
	/**
	 * Constructor that creates the PlayerList object.
	 */
	public PlayerList() {
		this.players = new ArrayList<Player>();
	}
	
	/**
	 * Adds a player to the list.
	 * 
	 * @param name - The name of the player
	 * @param score - The initiative roll of the player
	 */
	public void addPlayer(String name, int score) {
		try {
			this.players.add(new Player(name, score));
		} catch (PlayerException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	/**
	 * Removes a player from the list.
	 * 
	 * @param player - The player to be removed
	 */
	public void removePlayer(Player player) {
		this.players.remove(player);
	}
	
	/**
	 * Returns a player from a provided index. Throws a PlayerException if the provided index is invalid.
	 * 
	 * @param index - The position of the player in the list
	 * @return the player at the specified index
	 * @throws PlayerException if index is less than 0 or is greater than the size of the list
	 */
	public Player getPlayerByIndex(int index) throws PlayerException {
		if (index < 0 || index >= this.getNumberOfPlayers()) {
			throw new PlayerException("Index is invalid!");
		} else {
			return this.players.get(index);
		}
	}
	
	/**
	 * Simple getter method that returns the size of the list.
	 * 
	 * @return the size of the list
	 */
	public int getNumberOfPlayers() {
		return this.players.size();
	}
	
	/**
	 * Sorts the list so it is ordered.
	 */
	public void sortPlayers() {
		Collections.sort(this.players);
	}
	
	/**
	 * Clears the list completely so there are no players in the list.
	 */
	public void clearPlayers() {
		this.players.clear();
	}

}
