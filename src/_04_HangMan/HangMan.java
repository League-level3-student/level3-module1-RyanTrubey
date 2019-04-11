package _04_HangMan;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan implements KeyListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	JLabel lifelabel = new JLabel();
	JLabel scorelabel = new JLabel();
	String text = "";
	int numwords = 0;
	int wordnumber = 0;
	Stack<String> words = new Stack<String>();
	int lives = 6;
	int score = 0;
	String word;

	public static void main(String[] args) {
		HangMan hm = new HangMan();
		hm.setup();
	}

	public void setup() {
		String s = JOptionPane.showInputDialog("Enter number of words from 1 to 266");
		numwords = Integer.parseInt(s);
		String w;
		for (int i = 0; i < numwords; i++) {
			w = Utilities.readRandomLineFromFile("dictionary.txt");
			if (words.contains(w)) {
				w = Utilities.readRandomLineFromFile("dictionary.txt");
			}
			words.push(w);
		}
		System.out.println(words);
		frame.add(panel);
		frame.setSize(1280, 800);
		frame.setVisible(true);
		frame.addKeyListener(this);
		panel.add(label);
		word = words.pop();
		for (int i = 0; i < word.length(); i++) {
			text = text + "_";
		}
		label.setText(text);
		lifelabel.setText("Lives: " + lives);
		scorelabel.setText("Score: " + score);
		panel.add(lifelabel);
		panel.add(scorelabel);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		char[] chars = text.toCharArray();
		text = "";
		int a = 0;
		for (int i = 0; i < word.length(); i++) {
			if (e.getKeyChar() == word.charAt(i)) {
				chars[i] = e.getKeyChar();
			} else {
				a++;
			}
			text = text + Character.toString(chars[i]);
		}
		if (a == word.length()) {
			if (lives <= 0) {
				int playagain = JOptionPane.showConfirmDialog(null, "You Lost. Do you want to play again?");
				if (playagain == 0) {
					reset();
				} else {
					System.exit(0);
				}
			} else {
				lives--;
				lifelabel.setText("Lives: " + lives);
			}
		}
		System.out.println(lives);
		label.setText(text);
		if (text.equals(word) && !words.isEmpty()) {
			wordnumber++;
			lives = 5;
			lifelabel.setText("Lives: " + lives);
			score += 1;
			scorelabel.setText("Score: " + score);
			text = "";
			word = words.pop();
			for (int i = 0; i < word.length(); i++) {
				text = text + "_";
			}
			chars = text.toCharArray();
			label.setText(text);
		} else if (text.equals(word) && words.isEmpty()) {
			int playagain = JOptionPane.showConfirmDialog(null, "Do you want to play again?");
			if (playagain == 0) {
				reset();
			} else {
				System.exit(0);
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void reset() {
		frame.dispose();
		frame = new JFrame();
		panel = new JPanel();
		label = new JLabel();
		lifelabel = new JLabel();
		scorelabel = new JLabel();
		text = "";
		numwords = 0;
		wordnumber = 0;
		words = new Stack<String>();
		lives = 6;
		score = 0;
		word = "";
		setup();
	}
}
