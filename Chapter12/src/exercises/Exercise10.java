package exercises;

import java.util.ArrayList;

public class Exercise10 {

	public static void main(String[] args) {
			
		ArrayList<Integer> array = new ArrayList<>();
		
		try {
			while(true) {
				array.add(1);
			}
		} catch(OutOfMemoryError e) {
			System.out.println(e);
		}
	}
}
