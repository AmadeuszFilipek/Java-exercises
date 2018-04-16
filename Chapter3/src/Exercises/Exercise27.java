package Exercises;

import java.util.Scanner;

public class Exercise27 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		double x, y;
		
		System.out.print("Enter a point with two coordinates: ");
		while(true){
			if (scanner.hasNextDouble()) {
				x = scanner.nextDouble();
				if (scanner.hasNextDouble()){
					y = scanner.nextDouble();
					break;
				}
			}
			else
				scanner.nextLine();
		}
		scanner.close();
		
		double x1 = 0, y1 = 0;
		double x2 = 200, y2 = 0;
		double x3 = 0, y3 = 100;
		// f(x) = y = ax + b // x = y/a-b/a
		double a = (y3 - y2) / (x3 - x2);
		double b = y2 - a * x2;
		
		if (x > x1 && (x < (y / a - b / a)) && y > y1 && (y < (a * x + b))) {
			System.out.println("The point is in the triangle");
		}
		else {
			System.out.println("The point is not in a triangle");
		}
	}
}
