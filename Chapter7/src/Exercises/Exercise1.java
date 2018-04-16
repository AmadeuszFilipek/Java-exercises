package Exercises;

import java.util.Scanner;

public class Exercise1 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter the number of students: ");
		int numberOfStudents = scanner.nextInt();
		int[] studentGrades = new int[numberOfStudents];
		
		System.out.println("Enter " + numberOfStudents + " scores: ");
		
		for(int i = 0; i < numberOfStudents; i++) {
			studentGrades[i] = scanner.nextInt();
		}
		scanner.close();
		
		char[] scoreTable = scores(studentGrades);

		for (int i = 0; i < numberOfStudents; i++) {
			System.out.println("Student " + i + " score is " + 
		studentGrades[i] + " and grade is " + scoreTable[i]);
		}	
	}
	
	public static char[] scores(int[] studentGrades) {
		char[]	scores = new char[studentGrades.length];
		int bestScore = 0;
		
		for (int i = 0; i < studentGrades.length; i++) {
			if (studentGrades[i] > bestScore)
				bestScore = studentGrades[i];
		}
		
		for (int i = 0; i < studentGrades.length; i++) {
			if (studentGrades[i] < bestScore - 30)
				scores[i] = 'D';
			else if(studentGrades[i] < bestScore - 20)
				scores[i] = 'C';
			else if(studentGrades[i] < bestScore - 10)
				scores[i] = 'B';
			else
				scores[i] = 'A';
		}
		
		return scores;	
	}
	
}
