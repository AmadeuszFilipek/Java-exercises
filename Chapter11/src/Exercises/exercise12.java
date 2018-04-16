package exercises;

import java.util.ArrayList;
import java.util.Scanner;

public class exercise12 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter 5 numbers: ");
		ArrayList<Double> array = new ArrayList<>();
		
		while(true) {
			if (scanner.hasNextDouble()) {
				array.add(scanner.nextDouble());
				if (array.size() >= 5)
					break;
			}
			else scanner.next();
		}
		scanner.close();
		
		System.out.println("Sum: " + sum(array));

	}
	
	public static double sum(ArrayList<Double> list) {
		double sum = 0;
		
		for(Double i: list) 
			sum += i;
		
		return sum;
	}
}
