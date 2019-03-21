package _03_IntroToStacks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _02_TextUndoRedo implements KeyListener {
	/* 
	 * Create a JFrame with a JPanel and a JLabel.
	 * 
	 * Every time a key is pressed, add that character to the JLabel. It should look like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character is erased from the JLabel.
	 * Save that deleted character onto a Stack of Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed, the top Character is popped 
	 * off the Stack and added back to the JLabel.
	 * 
	 * */
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	String s = "";
	Stack<Character> text = new Stack<Character>();
	public static void main(String[] args) {
		_02_TextUndoRedo txt = new _02_TextUndoRedo();
		txt.setup();
	}
	public void setup() {
		frame.add(panel);
		panel.add(label);
		frame.setSize(500, 500);
		frame.addKeyListener(this);
		frame.setVisible(true);
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			char[] chars = s.toCharArray();
			text.push(chars[chars.length-1]);
			System.out.println(text);
			String a = "";
			for(int i = 0; i < chars.length-1; i++) {
				a = a+chars[i];
			}
			s = a;
		} else if(e.getKeyCode() == KeyEvent.VK_BACK_SLASH) {
			s = s+text.pop();
			System.out.println(text);
		} else {
			s = s+e.getKeyChar();
			text.clear();
		}
		label.setText(s);
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	
}
