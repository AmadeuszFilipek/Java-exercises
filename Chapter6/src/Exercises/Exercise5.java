package Exercises;

import java.util.Scanner;

public class Exercise5 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		double[] input = new double[3];
		System.out.print("Enter three integers : ");
		int i = 0;
		
		while(true) {
			if (scanner.hasNextDouble()) {
				input[i] = scanner.nextDouble();
				i++;
				if (i >= 3)
					break;
			}
			else scanner.next();
		}
		scanner.close();
	
		displaySortedNumbers(input[0], input[1], input[2]);
		
		
	}
	
	public static void displaySortedNumbers(double num1, double num2, double num3) {
		
		double[] list = {num1, num2, num3};
		double temp;
		for (int j = 0; j < list.length - 1; j++)
			for (int i = 0; i < list.length - 1; i++) {
				if (list[i] > list[i + 1]) {
					temp = list[i];
					list[i] = list[i + 1];
					list[i + 1] = temp;
				}
		}
		System.out.println("[" + list[0] + ", " + list[1] + ", " + list[2] + "]");
	}
}
