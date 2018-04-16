package Exercises;

import java.util.Scanner;

public class Exercise17 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);	
		System.out.print("Enter the number of banks and limit of assets to consider a bank safe: ");
		int numberOfBanks = scanner.nextInt();
		int limit = scanner.nextInt();
		int[] balance = new int[numberOfBanks];
		double[][] borrowers = new double[numberOfBanks][numberOfBanks];
		
		for(int i = 0; i < numberOfBanks; i++) {
			balance[i] = scanner.nextInt();
			int numberOfBorrowers = scanner.nextInt();
			for (int j = 0; j < numberOfBorrowers; j++) {
				int borrowerId = scanner.nextInt();
				borrowers[i][borrowerId] = scanner.nextDouble();
			}	
		}
		scanner.close();
	
		checkBanksSafety(borrowers, balance, limit);
	}
	
	public static void checkBanksSafety(double[][] borrowers, int[] balance, int limit) {
		
		double [] assets = new double[balance.length];
		boolean [] isUnsafe = new boolean[balance.length];
		boolean statusHasChanged = true;
		
		// iterate till no changes in bank status occurs
		while(statusHasChanged) {
			//calculate the balance and check total asset
			statusHasChanged = false;
			for(int i = 0; i < balance.length; i++) {
				assets[i] = balance[i];

				for(int j = 0; j < borrowers[i].length; j++) {
					assets[i] += borrowers[i][j];			
				}	
				
				boolean temp = isUnsafe[i];
				isUnsafe[i] = (assets[i] < limit);	
				
				if (temp != isUnsafe[i]) {
					statusHasChanged = true;
				// if status has changed, update all borrowers who lent this bank money	
					for(int j = 0; j < borrowers[i].length; j++) {
						borrowers[j][i] = 0;		
					}	
				}		
			}
		}	
		
		System.out.println("Unsafe banks are ");
		for(int i = 0; i < isUnsafe.length; i++) {
			if(isUnsafe[i]) System.out.print(i + " ");
		}
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
