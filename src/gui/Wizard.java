package gui;

import javax.swing.SwingUtilities;

/**
 * Class that runs the GUI.
 * 
 * @author Thomas Shortt
 *
 */
public class Wizard {
	
	/**
	 * Creates the instance of Wizard.
	 */
	public Wizard() {
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new ListGUI("D&D Initiative List"));

	}

}
