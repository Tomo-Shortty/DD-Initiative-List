package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import exceptions.PlayerException;
import players.Player;

/**
 * Class that uses JUnit testing to test the methods in Player class.
 * 
 * @author Thomas Shortt
 *
 */
public class PlayerTests {
	
	private Player A;
	private Player B;
	private Player C;
	private String nameA = "Ragar Del'Tan";
	private String nameB = "Orik Axswingar";
	private String nameC = "David Strakus";
	private int scoreA = 20;
	private int scoreB = 14;
	private int scoreC = 14;
	
	@Before
	public void setupPlayers() throws PlayerException {
		A = new Player(nameA, scoreA);
		B = new Player(nameB, scoreB);
		C = new Player(nameC, scoreC);
	}
	
	@Test
	public void testGetName() {
		assertEquals(nameA, A.getName());
	}
	
	@Test
	public void testGetScore() {
		assertEquals(scoreA, A.getScore());
	}
	
	@Test
	public void testCompareToPositive() {
		assertEquals(scoreA - scoreB, B.compareTo(A));
	}
	
	@Test
	public void testCompareToNegative() {
		assertEquals(scoreC - scoreA, A.compareTo(C));
	}
	
	@Test
	public void testCompareToZero() {
		assertEquals(scoreB - scoreC, C.compareTo(B));
	}
	
	@Test (expected = PlayerException.class)
	public void invalidName() throws PlayerException {
		A = new Player("", scoreA);
		assertEquals(nameA, A.getName());
	}
	
	@Test (expected = PlayerException.class)
	public void invalidScoreTooLow() throws PlayerException {
		A = new Player(nameA, -6);
		assertEquals(scoreA, A.getScore());
	}
	
	@Test (expected = PlayerException.class)
	public void invalidScoreTooHigh() throws PlayerException {
		A = new Player(nameA, 31);
		assertEquals(scoreA, A.getScore());
	}

}
