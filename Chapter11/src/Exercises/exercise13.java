package exercises;

import java.util.ArrayList;
import java.util.Scanner;

public class exercise13 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter ten integers: ");
		ArrayList<Integer> array = new ArrayList<>();
		
		while(true) {
			if (scanner.hasNextInt()) {
				array.add(scanner.nextInt());
				if (array.size() >= 10)
					break;
			}
			else scanner.next();
		}
		scanner.close();
		
		removeDuplicate(array);
		System.out.println("The distinct integers are " + array);
		
	}

	public static void removeDuplicate(ArrayList<Integer> list) {
		
		for(int i = 0; i < list.size(); i++) {
			int temp = list.get(i);	
			
			for(int j = i + 1; j < list.size(); j++) {
				if(list.get(j) == temp) {
					list.remove(j);			
					j--; // because list.size() shortens
				}
			}
		}
	}
}
