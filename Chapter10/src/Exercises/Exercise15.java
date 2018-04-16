package Exercises;

import java.util.Scanner;

import Exercise13.MyRectangle2D;

public class Exercise15 {

	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter five points: ");
		double[][] points = readdoubleMatrix(scanner, 5, 2);
		scanner.close();
		
		MyRectangle2D rec = getRectangle(points);
				
		System.out.println("The bounding rectangle's center [" +
		rec.getX() + "; " + rec.getY() + "], width " + rec.getWidth() + ", height " + rec.getHeight());
		
		
	}
	/** find the smallest rectangle that is enclosing all the points inside */
	public static MyRectangle2D getRectangle(double[][] points) {
		
		// i need to find four points that stand out the most in each of directions
		double minX = points[0][0];
		double maxX = points[0][0];
		double minY = points[0][1];
		double maxY = points[0][1];
				
		for(int i = 0; i < points.length; i++) {
			if (points[i][0] < minX)
				minX = points[i][0];
			
			if(points[i][0] > maxX)
				maxX = points[i][0];
			
			if(points[i][1] < minY)
				minY = points[i][1];
			
			if(points[i][1] > maxY)
				maxY = points[i][1];			
		}
		
		double width = Math.abs(maxX - minX);
		double height = Math.abs(maxY - minY);
		
		return new MyRectangle2D(maxX - width / 2, maxY - height / 2, width, height);
	}
	
	public static double[][] readdoubleMatrix(Scanner scanner, int row, int column) {
		
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
