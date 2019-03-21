package _04_HangMan;

import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	Stack<String> words = new Stack<String>();
	public static void main(String[] args) {
		HangMan hm = new HangMan();
		hm.setup();
	}
	public void setup() {
		String s = JOptionPane.showInputDialog("Enter number of words from 1 to 266");
		int numwords = Integer.parseInt(s);
		for(int i = 0; i < numwords; i++) {
			words.push(Utilities.readRandomLineFromFile("dictionary.txt"));
		}
		System.out.println(words);
		frame.add(panel);
		frame.setSize(1280, 800);
		frame.setVisible(true);
		panel.add(label);
	}
}
