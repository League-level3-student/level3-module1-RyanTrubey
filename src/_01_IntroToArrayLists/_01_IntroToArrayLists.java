package _01_IntroToArrayLists;

import java.util.ArrayList;

public class _01_IntroToArrayLists {
	public static void main(String[] args) {
		//1. Create an array list of Strings
		//   Don't forget to import the ArrayList class
		ArrayList<String> slist = new ArrayList<String>();
		//2. Add five Strings to your list
		slist.add("a");
		slist.add("s");
		slist.add("f for respecs");
		slist.add("f chat");
		slist.add("f in chat ree");
		//3. Print all the Strings using a standard for-loop
		for(int i = 0; i < slist.size(); i++) {
			System.out.println(slist.get(i));
		}
		
		//4. Print all the Strings using a for-each loop
		for(String s : slist) {
			System.out.println(s);
		}
		//5. Print only the even numbered elements in the list.
		for(int i = 0; i < slist.size(); i+=2) {
			System.out.println(slist.get(i));
		}
		//6. Print all the Strings in reverse order.
		for(int i = slist.size()-1; i >= 0; i--) {
			System.out.println(slist.get(i));
		}
		//7. Print only the Strings that have the letter 'e' in them.
		for(int i = 0; i < slist.size(); i++) {
			for(int a = 0; a < slist.get(i).length(); a++) {
				if(slist.get(i).charAt(a) == 'e') {
					System.out.println(slist.get(i));
					break;
				}
			}
		}
	}
}
