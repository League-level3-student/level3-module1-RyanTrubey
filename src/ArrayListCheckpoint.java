import java.util.ArrayList;
import java.util.Random;

public class ArrayListCheckpoint {
	public static void main(String[] args) {
		ArrayList<Cow> cowlist = new ArrayList<Cow>();
		Random r = new Random();
		for(int i = 0; i < r.nextInt(); i++) {
			cowlist.add(new Cow());
			cowlist.get(i).feed();
		}
	}
}
