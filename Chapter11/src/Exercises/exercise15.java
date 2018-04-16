package exercises;

import java.util.ArrayList;
import java.util.Scanner;

public class exercise15 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of the points: ");
		int n = scanner.nextInt();
		System.out.println("Enter the coordinates of the points:");
		double[][] array = readDoubleMatrix(scanner, n, 2);
		ArrayList<MyPoint> points = new ArrayList<>();
		
		for(int i = 0; i < array.length; i++){
			points.add(new MyPoint(array[i][0], array[i][1]));
		}
		
		double area = convexPolygonArea(points);
		
		System.out.println("The area of convex polygon is: " + area );
	}
	
	public static double convexPolygonArea(ArrayList<MyPoint> points) {
		double sum = 0;
		
		for(int i = 1; i  < points.size() - 1; i++) {
			Triangle2D triangle = new Triangle2D(points.get(0), points.get(i), points.get(i + 1));
			sum += triangle.getArea();
		}
		
		return sum;
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
