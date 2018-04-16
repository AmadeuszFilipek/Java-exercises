package Exercises;

import java.util.Scanner;

public class Exercise14 {
	
	public static void main(String[] args ) {
		
		
		Scanner scanner = new Scanner(System.in);
		int n1, n2;
		
		System.out.print("Enter n1 and n2: ");
		while(true) {
			if (scanner.hasNextInt()) {
				n1 = scanner.nextInt();
				if (scanner.hasNextInt()) {
					n2 = scanner.nextInt();
					break;
				}
			}
			else scanner.next();		
		}
		scanner.close();
		
		int d = Math.min(n1, n2);
		int greatestCommonDivisor = 1;
		
		for(int i = d; i > 0; i--) {
			if (n1 % i == 0 && n2 % i == 0) {
				greatestCommonDivisor = i;
				break;
			}
		}
		
		System.out.println("The greatest common divisor of numbers "
			 + n1 + " " + n2 + " is : " + greatestCommonDivisor);
		
		
	}
}
