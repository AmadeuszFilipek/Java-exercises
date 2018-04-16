package exercises;

import java.util.ArrayList;
import java.util.Scanner;

public class exercise14 {

	public static void main(String[] args) {	
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter five integers for list1: ");
		ArrayList<Integer> list1 = readIntegers(scanner, 5);

		System.out.println("Enter five integers for list1: ");
		ArrayList<Integer> list2 = readIntegers(scanner, 5);
	
		scanner.close();
		
		
		System.out.println("The union " + union(list1, list2));
		
	
	}
	
	public static ArrayList<Integer> union(ArrayList<Integer> list1, ArrayList<Integer> list2) {
		
		ArrayList<Integer> result = new ArrayList<>();
		
		for(Integer a: list1)
			result.add(a);
		
		for(Integer a: list2)
			result.add(a);
		
		return result;
	}
	
	public static ArrayList<Integer> readIntegers(Scanner scanner, int size) {
		ArrayList<Integer> result = new ArrayList<>();

		while(true) {
			if (scanner.hasNextInt()) {
				result.add(scanner.nextInt());
				if (result.size() >= size)
					break;
			}
			else scanner.next();
		}
		
		return result;
	}
}
