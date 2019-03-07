package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


//Copyright The League of Amazing Programmers, 2015

public class _06_IPodShuffle implements ActionListener{
	JButton button = new JButton("Surprise Me");
	JTextField input = new JTextField("Song Number");
	JButton playbtn = new JButton("Play");
	ArrayList<Song> songs = new ArrayList<Song>();
	public _06_IPodShuffle() {
		// 1. Use the Song class the play the demo.mp3 file.
				
		/**
		 * 2. Congratulations on completing the sound check! * Now we want to make an
		 * iPod Shuffle that plays random music. * Create an ArrayList of Songs and a
		 * "Surprise Me!" button that will play a random song when it is clicked. * If
		 * you're really cool, you can stop all the songs, before playing a new one on
		 * subsequent button clicks.
		 */
		
		songs.add(new Song("Megalovania.mp3"));
		songs.add(new Song("Minecraft.mp3"));
		songs.add(new Song("Wii Music.mp3"));
		JPanel panel = new JPanel();
		JFrame frame = new JFrame();
		panel.add(button);
		button.addActionListener(this);
		panel.add(input);
		playbtn.addActionListener(this);
		panel.add(playbtn);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new _06_IPodShuffle();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == button) {
			for(int i = 0; i < songs.size(); i++) {
				songs.get(i).stop();
			}
			Random r = new Random();
			songs.get(r.nextInt(songs.size())).play();
		} else if(e.getSource() == playbtn) {
			for(int i = 0; i < songs.size(); i++) {
				songs.get(i).stop();
			}
			int ree = Integer.parseInt(input.getText());
			songs.get(ree-1).play();
		}
	}
}