package Exercises;

import java.util.Scanner;

public class Exercise9 {

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
		String secondBestStudent = "";
		double bestScore = 0;
		double secondBestScore = 0;
		
		if(numberOfStudents > 0) {
			bestStudent = studentName[0];
			bestScore = score[0];
		}
		
		// in case there are 2 students and initial condition is the answer
		if (numberOfStudents > 1) {
			secondBestStudent = studentName[1];
			secondBestScore = score[1];
		}
		
		for (int i = 0; i < numberOfStudents; i++) {
			if (bestScore < score[i]) {
				secondBestScore = bestScore;
				bestScore = score[i];
				
				secondBestStudent = bestStudent;
				bestStudent = studentName[i];
			}			
		}
		
		System.out.println("The best student is " +
				bestStudent + " with a score of " + bestScore);
		
		if (numberOfStudents > 1) {
			System.out.println("The second best student is " +
					secondBestStudent + " with a score of " + secondBestScore);
		}
		
		scanner.close();
	}
}
