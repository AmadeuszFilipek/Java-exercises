package Exercises;

import java.util.Scanner;

public class Exercise29 {

	public static void main (String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		double x1, y1, radius1;
		double x2, y2, radius2;
		double[] temp;
		System.out.println("Enter circle1's center x, y coordinates and radius:");
		temp = readCircle(scanner);
		x1 = temp[0]; y1 = temp[1]; radius1 = temp[2];
		System.out.println("Enter circle2's center x, y coordinates and radius:");
		temp = readCircle(scanner);
		x2 = temp[0]; y2 = temp[1]; radius2	= temp[2];
		
		double centerDistance = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));

		if (centerDistance < Math.abs(radius1 - radius2)) {
			System.out.println("Circle2 is inside circle1.");
			
		}
		else if(centerDistance < radius1 + radius2)
			System.out.println("Circle2 overlaps circle1");
		else 
			System.out.println("Circle2 does not overlap circle1.");		
	}
	
	private static double[] readCircle(Scanner scanner) {
		double[] tempo = new double[3];
		int i = 0;
		while(true) {
			if (scanner.hasNextDouble()){
				tempo[i] = scanner.nextDouble();
				i++;
			}
			else
				scanner.nextLine();
			if(i >= 3)
				break;	
		}
		return tempo;
	}
}
