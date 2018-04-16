package Exercises;

import java.util.Scanner;

public class Exercise21 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the number of cities: ");
		int numberOfCities = scanner.nextInt();
		System.out.println("Enter the coordinates of the cities: ");
		double[][] cities = readDoubleMatrix(scanner, numberOfCities, 2);
		
		getCentralCity(cities);
		
	}
	
	public static double[]	getCentralCity(double[][] cityCoordinates) {
		
		double[] centralCoordinate = cityCoordinates[0];
		double centralDistance = totalDistance(cityCoordinates, 0);
		
		for(int i = 0; i < cityCoordinates.length; i++) {
			double tempDistance = totalDistance(cityCoordinates, i);
	
			if(tempDistance < centralDistance) {
				centralDistance = tempDistance;
				centralCoordinate = cityCoordinates[i];
			}
		}
		
		System.out.println("The central city is at (" +
		centralCoordinate[0] + "; " + centralCoordinate[1] + ")" );
		System.out.println("Total distance to all other cities is " + centralDistance);	
		
		return centralCoordinate;
	}
	
	public static double totalDistance(double[][] cityCord, int city) {
		double distance = 0;
		
		for(int i = 0; i < cityCord.length; i++) 
			distance += Math.sqrt(Math.pow(cityCord[i][0] - cityCord[city][0], 2) +
					Math.pow(cityCord[i][1] - cityCord[city][1], 2));
			
		return distance;
	}
	
	public static double[][] readDoubleMatrix(Scanner scanner, int row, int column) {
		
		double[][] numbers = new double[row][column];
		int rowCount = 0;
		int columnCount = 0;
		while(true) {
			if (scanner.hasNextDouble()) {
				numbers[rowCount][columnCount] = scanner.nextDouble();
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
