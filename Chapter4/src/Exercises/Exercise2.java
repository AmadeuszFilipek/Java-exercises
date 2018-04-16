package Exercises;

import java.util.Scanner;

public class Exercise2 {

	public static void main (String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		double[] point1 = new double[2];
		double[] point2 = new double[2];
		
		System.out.print("Enter point 1 (latitude and longitude) in degrees: ");
		point1 = readPoint(scanner);
		System.out.print("Enter point 2 (latitude and longitude) in degrees: ");
		point2 = readPoint(scanner);
		
		for (int i = 0; i < 2; i ++) {
			point1[i] = Math.toRadians(point1[i]);
			point2[i] = Math.toRadians(point2[i]);
		}
		
		final double RADIUS = 6371.01;
		double distance = RADIUS * Math.acos(Math.sin(point1[0]) * Math.sin(point2[0]) +
				Math.cos(point1[0]) * Math.cos(point2[0]) * Math.cos(point1[1] - point2[1]));
		
		System.out.println("The distance between the two points is " + distance + " km");
	}
	
	private static double[]	readPoint (Scanner scanner) {
		double[] result = new double[2];
		
		while(true) {
			if (scanner.hasNextDouble()){
				result[0] = scanner.nextDouble();
				if (scanner.hasNextDouble()){
					result[1] = scanner.nextDouble();
					break;
				}
			}
			else scanner.nextLine();
		}
		return result;	
	}
}
