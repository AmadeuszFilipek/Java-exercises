package Exercises;

import java.util.Scanner;

public class Exercise7 {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of points: ");
		int numberOfPoints = input.nextInt();

		// Create an array to store points
		double[][] points = new double[numberOfPoints][3];
		System.out.print("Enter " + numberOfPoints + " points: ");
		for (int i = 0; i < points.length; i++) {
			points[i][0] = input.nextDouble();
			points[i][1] = input.nextDouble();
			points[i][2] = input.nextDouble();
		}
		input.close();
		
		// p1 and p2 are the indices in the points' array
		int p1 = 0, p2 = 1; // Initial two points
		double shortestDistance = distance(points[p1][0], points[p1][1], points[p1][2],
				points[p2][0], points[p2][1], points[p2][2]); // Initialize shortestDistance

		// Compute distance for every two points
		for (int i = 0; i < points.length; i++) {
			for (int j = i + 1; j < points.length; j++) {
				double distance = distance(points[i][0], points[i][1], points[i][2],
						points[j][0], points[j][1], points[j][2]); // Find distance

				if (shortestDistance > distance) {
					p1 = i; // Update p1
					p2 = j; // Update p2
					shortestDistance = distance; // Update shortestDistance
				}
			}
		}

		// Display result
		System.out.println("The closest two points are " +
				"(" + points[p1][0] + ", " + points[p1][1] + "," + points[p1][2] + ") and (" +
				points[p2][0] + ", " + points[p2][1] + ", " + points[p2][2] + ")");
	}

	/** Compute the distance between two points (x1, y1, z1) and (x2, y2, z1)*/
	public static double distance(
			double x1, double y1, double z1, double x2, double y2, double z2) {
		return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1) + (z2 - z1) * (z2 - z1));
	}
}