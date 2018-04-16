package exercises;

import java.util.ArrayList;

public class Exercise2 {

	public static void main(String[] args) {

		ArrayList<Number> list = new ArrayList<>();

		for (int i = 0; i < 100; i++) {
			list.add(Math.random() * 100);
		}
		System.out.println(list);
		shuffle(list);
		System.out.println(list);
	}
	
	public static void shuffle(ArrayList<Number> array) {
		int position;
		boolean[] positionFilled = new boolean[array.size()];
		Number[] holdArray = new Number[array.size()];
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
