package Exercises;

import java.util.Scanner;

public class Exercise8 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int numberOfStudents = 0;
		
		System.out.print("Enter number of students: ");
		while(true) {
			if (scanner.hasNextInt()) {
				numberOfStudents = scanner.nextInt();
				break;
			}
			else scanner.next();
		}
		
		String[] studentName = new String[numberOfStudents];
		double[] score = new double[numberOfStudents];
		
		for (int i = 0; i < numberOfStudents; i++) {
			System.out.print("Enter the name of student " + (i+1) + ": ");
			if (scanner.hasNext())
				studentName[i] = scanner.next();
			System.out.print("Enter the score of student " + (i+1) + ": ");
			if (scanner.hasNextInt())
				score[i] = scanner.nextInt();
		}

		String bestStudent = "";
		double bestScore = 0;
		
		if(numberOfStudents > 0) {
			bestStudent = studentName[0];
			bestScore = score[0];
		}
		
		for (int i = 0; i < numberOfStudents; i++) {
			if (bestScore < score[i]) {
				bestScore = score[i];
				bestStudent = studentName[i];
			}			
		}
		
		System.out.println("The best student is " +
				bestStudent + " with a score of " + bestScore);
		
		scanner.close();
	}
}
