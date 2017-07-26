package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import exceptions.PlayerException;
import players.PlayerList;

/**
 * The graphical user interface. Extends JFrame and implements Runnable and ActionListener.
 * 
 * @author Thomas Shortt
 *
 */
public class ListGUI extends javax.swing.JFrame implements Runnable, ActionListener {
	
	private PlayerList list;
	private int maxWidth = 1000;
	private int headerHeight = 50;
	private int tableWidth = 650;
	private int tableHeight = 850;
	private int sideWidth = 350;
	private int fieldWidth = 245;
	private int fieldHeight = 25;
	private int labelWidth = 95;
	private int buttonWidth = 100;
	private int buttonHeight = 40;
	
	private JTable table;
	private DefaultTableModel tableModel;
	private JTextField setName;
	private JTextField setScore;
	private JButton addButton;
	private JButton clearButton;
	private JLabel error;
	
	/**
	 * Creates the GUI with the specified title.
	 * 
	 * @param title - The title of the GUI
	 */
	public ListGUI(String title) {
		JFrame frame = new JFrame(title);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.WHITE);
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		frame.getContentPane().add(createHeader(), BorderLayout.NORTH);
		frame.getContentPane().add(createTable(), BorderLayout.WEST);
		frame.getContentPane().add(createSidePanel(), BorderLayout.EAST);
		
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void run() {
		list = new PlayerList();
		
		addButtonAction();
		removePlayerAction();
		clearButtonAction();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Creates the header in the GUI.
	 * 
	 * @return a JPanel containing the title of the GUI
	 */
	private JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new FlowLayout());
		header.setBackground(Color.WHITE);
		header.setPreferredSize(new Dimension(maxWidth, headerHeight));
		JLabel label = new JLabel("D&D Initiative List");
		header.add(label, BorderLayout.CENTER);
		return header;
	}
	
	/**
	 * Creates the table in the GUI.
	 * 
	 * @return a JPanel containing the table that lists the names and initiative rolls of all players or creatures
	 */
	private JPanel createTable() {
		JPanel tablePanel = new JPanel();
		tablePanel.setLayout(new BoxLayout(tablePanel, BoxLayout.Y_AXIS));
		String [] columnNames = {"Name", "Initiative Roll"};
		tableModel = new DefaultTableModel(columnNames, 0);
		table = new JTable(tableModel);
		tableModel.setRowCount(0);
		JScrollPane scroller = new JScrollPane(table);
		scroller.setPreferredSize(new Dimension(tableWidth, tableHeight));
		tablePanel.add(scroller, BorderLayout.CENTER);
		return tablePanel;
	}
	
	/**
	 * Creates the buttons and text fields in the GUI.
	 * 
	 * @return a JPanel containing the buttons and text fields that add or remove players or clears the table
	 */
	private JPanel createSidePanel() {
		JPanel sidePanel = new JPanel();
		sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));
		sidePanel.setBackground(Color.WHITE);
		sidePanel.setPreferredSize(new Dimension(sideWidth, tableHeight));
		sidePanel.add(createTextField("Name"), 0);
		sidePanel.add(createTextField("Roll"), 1);
		sidePanel.add(createButtons(), 2);
		sidePanel.add(createErrorMessage(), 3);
		return sidePanel;
	}
	
	/**
	 * Creates the text fields used in the side panel.
	 * 
	 * @param name - The name of the text field
	 * @return a JPanel containing the text field with the specified name
	 */
	private JPanel createTextField(String name) {
		JPanel textPanel = new JPanel();
		textPanel.setLayout(new FlowLayout());
		textPanel.setBackground(Color.WHITE);
		JLabel label;
		if (name.equals("Name")) {
			label = new JLabel("Name");
			label.setPreferredSize(new Dimension(labelWidth, fieldHeight));
			textPanel.add(label, BorderLayout.WEST);
			setName = new JTextField();
			setName.setPreferredSize(new Dimension(fieldWidth, fieldHeight));
			setName.setEditable(true);
			setName.setHorizontalAlignment(SwingConstants.RIGHT);
			textPanel.add(setName, BorderLayout.EAST);
		} else if (name.equals("Roll")) {
			label = new JLabel("Roll");
			label.setPreferredSize(new Dimension(labelWidth, fieldHeight));
			textPanel.add(label, BorderLayout.WEST);
			setScore = new JTextField();
			setScore.setPreferredSize(new Dimension(fieldWidth, fieldHeight));
			setScore.setEditable(true);
			setScore.setHorizontalAlignment(SwingConstants.RIGHT);
			textPanel.add(setScore, BorderLayout.EAST);
		}
		return textPanel;
	}
	
	/**
	 * Creates the buttons used in the side panel
	 * 
	 * @return a JPanel containing the buttons
	 */
	private JPanel createButtons() {
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.setBackground(Color.WHITE);
		addButton = new JButton("Add");
		addButton.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
		addButton.setEnabled(true);
		buttonPanel.add(addButton, BorderLayout.NORTH);
		clearButton = new JButton("Clear");
		clearButton.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
		clearButton.setEnabled(false);
		buttonPanel.add(clearButton, BorderLayout.NORTH);
		return buttonPanel;
	}
	
	/**
	 * Creates the error message that will be displayed if an error occurs while using the GUI.
	 * 
	 * @return a JPanel containing the error message
	 */
	private JPanel createErrorMessage() {
		JPanel errorPanel = new JPanel();
		errorPanel.setLayout(new FlowLayout());
		errorPanel.setBackground(Color.WHITE);
		error = new JLabel();
		errorPanel.add(error, BorderLayout.CENTER);
		return errorPanel;
	}
	
	/**
	 * Event handler that adds a player or creature to the table when the "Add" button is pressed.
	 */
	private void addButtonAction() {
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object [] playerRow = new Object[2];
				tableModel.setRowCount(0);
				list.addPlayer(setName.getText(), Integer.parseInt(setScore.getText()));
				list.sortPlayers();
				for (int i = 0; i < list.getNumberOfPlayers(); i++) {
					try {
						playerRow[0] = list.getPlayerByIndex(i).getName();
						playerRow[1] = list.getPlayerByIndex(i).getScore();
						tableModel.addRow(playerRow);
						error.setText("");
					} catch (PlayerException e1) {
						error.setText(e1.getMessage());
						e1.printStackTrace();
					}
				}
				setName.setText("");
				setScore.setText("");
				clearButton.setEnabled(true);
			}
		});
	}
	
	/**
	 * Event handler that removes a player or creature from the table when the table row is clicked.
	 */
	private void removePlayerAction() {
		ListSelectionModel model = table.getSelectionModel();
		model.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (model.isSelectionEmpty() == false) {
					int selectedRow = model.getMinSelectionIndex();
					Object [] playerRow = new Object[2];
					try {
						list.removePlayer(list.getPlayerByIndex(selectedRow));
						tableModel.setRowCount(0);
						list.sortPlayers();
						for (int i = 0; i < list.getNumberOfPlayers(); i++) {
							playerRow[0] = list.getPlayerByIndex(i).getName();
							playerRow[1] = list.getPlayerByIndex(i).getScore();
							tableModel.addRow(playerRow);
						}
						error.setText("");
					} catch (PlayerException e1) {
						error.setText(e1.getMessage());
						e1.printStackTrace();
					}
				}
			}
		});
	}
	
	/**
	 * Event handler that clears the table when the "Clear" button is pressed.
	 */
	private void clearButtonAction() {
		clearButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tableModel.setRowCount(0);
				list.clearPlayers();
				clearButton.setEnabled(false);
				setName.setText("");
				setScore.setText("");
				error.setText("");
			}
		});
	}

}
