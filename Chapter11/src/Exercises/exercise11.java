package exercises;

import java.util.ArrayList;
import java.util.Scanner;

public class exercise11 {

	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter 5 numbers: ");
		ArrayList<Integer> array = new ArrayList<>();
		
		while(true) {
			if (scanner.hasNextInt()) {
				array.add(scanner.nextInt());
				if (array.size() >= 5)
					break;
			}
			else scanner.next();
		}
		scanner.close();
		
		sort(array);
		System.out.println("After sort: ");
		System.out.println(array);
		
	}
	
	public static void sort(ArrayList<Integer> list) {
		
		for(int j = 0; j < list.size(); j++)
			for(int i = 0; i < list.size() - 1; i++) 
				if(list.get(i) > list.get(i + 1)) {
					int temp = list.get(i);
					list.set(i, list.get(i + 1));
					list.set(i + 1, temp);
				}		
	}
}
