package Exercises;

import java.util.Scanner;

public class Exercise7 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		double radius;
		
		System.out.print("Enter the radius of the bounding circle: ");
		while(true) {
			if (scanner.hasNextDouble()) {
				radius = scanner.nextDouble();
				break;
			}
			else scanner.nextLine();
		}
		scanner.close();
		
		double[][] points = new double[5][2]; // five points of coordinates
		
		for (int i = 0; i < 5; i++) {
			points[i][0] = radius * Math.cos(Math.PI / 5 * i);
			points[i][1] = radius * Math.sin(Math.PI / 5 * i);
		}
		
		System.out.println("The coordinates of five points on the pentagon are:");
		for(int i = 0; i < 5; i++)
			System.out.printf("(%f; %f)\n", points[i][0], points[i][1]);
	
	}	
}
