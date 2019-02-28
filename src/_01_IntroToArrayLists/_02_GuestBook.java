package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_GuestBook implements ActionListener {
	// Create a GUI with two buttons. One button reads "Add Name" and the other button reads "View Names". 
	// When the add name button is clicked, display an input dialog that asks the user to enter a name. Add
	// that name to an ArrayList. When the "View Names" button is clicked, display a message dialog that displays
	// all the names added to the list. Format the list as follows:
	// Guest #1: Bob Banders
	// Guest #2: Sandy Summers
	// Guest #3: Greg Ganders
	// Guest #4: Donny Doners
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton add = new JButton("Add Name");
	JButton view = new JButton("View Names");
	String s;
	String names;
	ArrayList<String> namelist = new ArrayList<String>();
	public static void main(String[] args) {
		_02_GuestBook asdf = new _02_GuestBook();
		asdf.gui();
	}
	public void gui() {
		panel.add(add);
		panel.add(view);
		frame.add(panel);
		add.addActionListener(this);
		view.addActionListener(this);
		frame.setSize(360, 360);
		frame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == add) {
			s = JOptionPane.showInputDialog("Add Name");
			namelist.add(s);
		}
		if(e.getSource() == view) {
			names = "";
			for(int i = 0; i < namelist.size(); i++) {
				names = names + "Guest #" + (i+1) + ": " + namelist.get(i) + "\n";
			}
			JOptionPane.showMessageDialog(null, names);
		}
	}
}
