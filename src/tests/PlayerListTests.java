package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import exceptions.PlayerException;
import players.PlayerList;

/**
 * Class that uses JUnit testing to test the methods in PlayerList class.
 * 
 * @author Thomas Shortt
 *
 */
public class PlayerListTests {
	
	private PlayerList list;
	private String nameA = "Ragar Del'Tan";
	private String nameB = "Orik Axswingar";
	private String nameC = "David Strakus";
	private String nameD = "Black Dragon";
	private int scoreA = 20;
	private int scoreB = 14;
	private int scoreC = 14;
	private int scoreD = 21;
	
	@Before
	public void setupPlayers() throws PlayerException {
		list = new PlayerList();
	}
	
	@Test
	public void testAddPlayer() throws PlayerException {
		list.addPlayer(nameA, scoreA);
		assertEquals(list.getPlayerByIndex(0).getName(), nameA);
	}
	
	@Test
	public void testRemovePlayer() throws PlayerException {
		list.addPlayer(nameA, scoreA);
		list.addPlayer(nameB, scoreB);
		list.removePlayer(list.getPlayerByIndex(0));
		assertEquals(list.getPlayerByIndex(0).getName(), nameB);
	}
	
	@Test
	public void testGetPlayerByIndex() throws PlayerException {
		list.addPlayer(nameA, scoreA);
		list.addPlayer(nameB, scoreB);
		list.addPlayer(nameC, scoreC);
		list.addPlayer(nameD, scoreD);
		assertEquals(list.getPlayerByIndex(2).getName(), nameC);
	}
	
	@Test
	public void testGetNumberOfPlayers() {
		list.addPlayer(nameA, scoreA);
		list.addPlayer(nameB, scoreB);
		list.addPlayer(nameC, scoreC);
		list.addPlayer(nameD, scoreD);
		assertEquals(list.getNumberOfPlayers(), 4);
	}
	
	@Test
	public void testSortPlayersTopPlayer() throws PlayerException {
		list.addPlayer(nameA, scoreA);
		list.addPlayer(nameB, scoreB);
		list.addPlayer(nameC, scoreC);
		list.addPlayer(nameD, scoreD);
		list.sortPlayers();
		assertEquals(list.getPlayerByIndex(0).getName(), nameD);
	}
	
	@Test
	public void testSortPlayersBottomPlayer() throws PlayerException {
		list.addPlayer(nameA, scoreA);
		list.addPlayer(nameB, scoreB);
		list.addPlayer(nameC, scoreC);
		list.addPlayer(nameD, scoreD);
		list.sortPlayers();
		assertEquals(list.getPlayerByIndex(3).getName(), nameC);
	}
	
	@Test
	public void testClearPlayers() {
		list.addPlayer(nameA, scoreA);
		list.addPlayer(nameB, scoreB);
		list.addPlayer(nameC, scoreC);
		list.addPlayer(nameD, scoreD);
		list.clearPlayers();
		assertEquals(list.getNumberOfPlayers(), 0);
	}
	
	@Test (expected = PlayerException.class)
	public void invalidGetPlayerByIndexTooLow() throws PlayerException {
		list.addPlayer(nameA, scoreA);
		list.addPlayer(nameB, scoreB);
		list.addPlayer(nameC, scoreC);
		list.addPlayer(nameD, scoreD);
		assertEquals(list.getPlayerByIndex(-1).getName(), nameA);
	}
	
	@Test (expected = PlayerException.class)
	public void invalidGetPlayerByIndexTooHigh() throws PlayerException {
		list.addPlayer(nameA, scoreA);
		list.addPlayer(nameB, scoreB);
		list.addPlayer(nameC, scoreC);
		list.addPlayer(nameD, scoreD);
		assertEquals(list.getPlayerByIndex(4).getName(), nameD);
	}

}
