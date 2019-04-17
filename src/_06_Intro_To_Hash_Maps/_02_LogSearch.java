package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener {
	/*
	 * Crate a HashMap of Integers for the keys and Strings for the values. Create a
	 * GUI with three buttons.
	 * 
	 * Button 1: Add Entry When this button is clicked, use an input dialog to ask
	 * the user to enter an ID number. After an ID is entered, use another input
	 * dialog to ask the user to enter a name. Add this information as a new entry
	 * to your HashMap.
	 * 
	 * Button 2: Search by ID When this button is clicked, use an input dialog to
	 * ask the user to enter an ID number. If that ID exists, display that name to
	 * the user. Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List When this button is clicked, display the entire list in a
	 * message dialog in the following format: ID: 123 Name: Harry Howard ID: 245
	 * Name: Polly Powers ID: 433 Name: Oliver Ortega etc...
	 * 
	 * When this is complete, add a fourth button to your window. Button 4: Remove
	 * Entry When this button is clicked, prompt the user to enter an ID using an
	 * input dialog. If this ID exists in the HashMap, remove it. Otherwise, notify
	 * the user that the ID is not in the list.
	 *
	 */
	HashMap<Integer, String> idmap = new HashMap<Integer, String>();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton add = new JButton("Add Entry");
	JButton search = new JButton("Search by ID");
	JButton view = new JButton("View List");
	JButton remove = new JButton("Remove Entry");

	public static void main(String[] args) {
		new _02_LogSearch().creategui();
	}

	public void creategui() {
		frame.add(panel);
		panel.add(add);
		panel.add(search);
		panel.add(view);
		panel.add(remove);
		add.addActionListener(this);
		search.addActionListener(this);
		view.addActionListener(this);
		remove.addActionListener(this);
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == add) {
			String s = JOptionPane.showInputDialog("Enter an ID");
			String name = JOptionPane.showInputDialog("Enter a name");
			int ID = Integer.parseInt(s);
			idmap.put(ID, name);
		}
		if (e.getSource() == search) {
			String s = JOptionPane.showInputDialog("Enter ID number");
			int ID = Integer.parseInt(s);
			if (idmap.containsKey(ID)) {
				JOptionPane.showMessageDialog(null, "The name for this ID is " + idmap.get(ID));
			} else {
				JOptionPane.showMessageDialog(null, "This entry does not exist");
			}
		}
		if (e.getSource() == view) {
			String s = "";
			for (Integer i : idmap.keySet()) {
				s = s + "\nID: " + i + " Name: " + idmap.get(i);
			}
			JOptionPane.showMessageDialog(null, s);
		}
		if (e.getSource() == remove) {
			String s = JOptionPane.showInputDialog("Enter an ID to remove");
			int ID = Integer.parseInt(s);
			if (idmap.containsKey(ID)) {
				JOptionPane.showMessageDialog(null, "ID number " + ID + " has been removed");
				idmap.remove(ID);
			} else {
				JOptionPane.showMessageDialog(null, "This entry does not exist");
			}
		}
	}
}
