import java.util.Random;

import javax.swing.JOptionPane;

public class Quiz {
	public static void main(String[] args) {
		String input = JOptionPane.showInputDialog("Enter a number");
		int num = Integer.parseInt(input);
		int[] numbers = new int[num];
		for(int i = 0; i < num; i++) {
			numbers[i] = new Random().nextInt();
		}
		int largestnum = 0;
		for(int i = 0; i < num; i++) {
			if(numbers[i] > largestnum) {
				largestnum = numbers[i];
			}
		}
		System.out.println("Largest Number: " + largestnum);
		int smallestnum = largestnum;
		for(int i = 0; i < num; i++) {
			if(numbers[i] < smallestnum) {
				smallestnum = numbers[i];
			}
		}
		System.out.println("Smallest Number: " + smallestnum);
		int sum = 0;
		int average = 0;
		for(int i = 0; i < num; i++) {
			sum+=numbers[i];
		}
		average = sum/num;
		System.out.println("Average: " + average);
	}
}
