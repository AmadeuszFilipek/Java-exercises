package exercises;

import java.util.ArrayList;
import java.util.Scanner;

public class exercise7 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		ArrayList<Integer> array = new ArrayList<>();
		
		System.out.println("Enter integer numbers(0 ends the input): ");
		while(true){
			if (scanner.hasNextInt()) {
				int temp = scanner.nextInt();
				array.add(temp);
				if (temp == 0)
					break;
			}
			else scanner.next();
		}
		scanner.close();
		
		shuffle(array);
		
		System.out.println(array.toString());
		
		
	}
	
	public static void shuffle(ArrayList<Integer> array) {
		
		int position;
		boolean[] positionFilled = new boolean[array.size()];
		Integer[] holdArray = new Integer[array.size()];
		holdArray = array.toArray(holdArray);
		//for each row, generate it's new position
		for(int i = 0; i < array.size(); i++) {

			// generate new position until you find an empty one
			while(true) {
				position = (int)Math.floor(Math.random() * array.size());
				//if its empty - take it and stop searching for position
				if(!positionFilled[position]) {
					positionFilled[position] = true;
					break;
				}
			}
				
			array.set(position, holdArray[i]);
		}		
	}
}
