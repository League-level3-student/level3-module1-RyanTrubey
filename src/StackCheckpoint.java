import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

public class StackCheckpoint {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		Random r = new Random();
		for(int i = 0; i < 10; i++) {
			stack.push(r.nextInt());
		}
		int sum = 0;
		for(int i = 0; i < 10; i++) {
			sum+=stack.pop();
		}
		JOptionPane.showMessageDialog(null, sum);
	}
}
