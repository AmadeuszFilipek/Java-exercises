package Exercises;

import java.util.Scanner;

public class Exercise17 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter number of students: ");
		int numberOfStudents = scanner.nextInt();
		
		System.out.println("Enter students names: ");
		String[] studentNames = readStrings(scanner, numberOfStudents);
		System.out.println("Enter studens scores: ");
		double[] studentScores = readDoubles(scanner, numberOfStudents);

		sortStudents(studentScores, studentNames);
		System.out.println("Sorted student names and their scores: \n");
		for (int i = 0; i < numberOfStudents; i++) {
			System.out.println(studentNames[i] + ": " + studentScores[i]);
		}
	
	}
	public static void sortStudents(double[] scores, String[] names) {
		if (scores.length != names.length)
			return;
		
		double temp;
		String temporary;
		
		for(int i = 0; i < scores.length; i++) {

			for(int j = i; j < scores.length; j++) {
				if (scores[i] < scores[j]) {
					temp = scores[i];
					scores[i]	= scores[j];
					scores[j] = temp;
					temporary = names[i];
					names[i] = names[j];
					names[j] = temporary;
				}
			}		
		}	
	}
	
	public static String[] readStrings(Scanner scanner, int numberOfReads) {
		String[] numbers = new String[numberOfReads];
		int count = 0;
		
		while(true) {
			numbers[count] = scanner.next();
			count++;
			if (count >= numberOfReads) 
				break;
		}
		
		return numbers;	
	}
	
	public static double[] readDoubles(Scanner scanner, int numberOfReads) {
		double[] numbers = new double[numberOfReads];
		int count = 0;
		
		while(true) {
			if (scanner.hasNextDouble()) {
				numbers[count] = scanner.nextDouble();
				count++;
				if (count >= numberOfReads) 
					break;
				
			}
			else scanner.next();
		}
		
		return numbers;	
	}
}
