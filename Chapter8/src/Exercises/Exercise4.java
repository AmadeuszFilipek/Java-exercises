package Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise4 {
	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the seven-day work schedule (row by row) for 8 employees:");
		int[][] schedule = readIntegerMatrix(scanner, 8, 7);
		
		int[] order = orderSchedule(schedule);
		
		displaySchedule(schedule, order);
		
	}
	
	public static void displaySchedule(int[][] schedule, int[] order) {
		
			System.out.println("\t\tSu\tM\tT\tW\tTh\tF\tSa");
		for (int i = 0; i < order.length; i ++) {
			
			System.out.print("Employee " + order[i] + "\t");
			for(int j = 0; j < schedule[order[i]].length; j++) {
				System.out.print(schedule[order[i]][j] + "\t");
			}
			
			System.out.println();
		}
	}
	
	public static int[] orderSchedule (int[][] schedule) {
		
		int[]	totalHours = new int[schedule.length];
		int[] order = new int[schedule.length];
		Arrays.fill(totalHours, 0);
		
		for(int i = 0; i < schedule.length; i++) {
			for (int j = 0; j < schedule[i].length; j++) {
				totalHours[i] += schedule[i][j];
			}
			order[i] = i;
		}
		
		int temp = 0;
		for(int i = 0; i < schedule.length; i++) {
			for (int j = 0; j < schedule.length - 1; j++) {
				if (totalHours[j] > totalHours[j + 1]) {
					temp = totalHours[j];
					totalHours[j] = totalHours[j + 1];
					totalHours[j + 1] = temp;
					
					temp = order[j];
					order[j] = order[j + 1];
					order[j + 1] = temp;
				}
			}	
		}
		return order;
	}
	
	
	public static int[][] readIntegerMatrix(Scanner scanner, int row, int column) {
		
		int[][] numbers = new int[row][column];
		int rowCount = 0;
		int columnCount = 0;
		while(true) {
			if (scanner.hasNextInt()) {
				numbers[rowCount][columnCount] = scanner.nextInt();
				columnCount++;
				if (columnCount >= column) { 
					rowCount++;
					columnCount = 0;
					if (rowCount >= row)
						break;
				}
			}
			else scanner.next();
		}
		
		return numbers;	
	}
	
}
