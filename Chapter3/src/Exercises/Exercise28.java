package Exercises;

import java.util.Scanner;

public class Exercise28 {

	public static void main (String[] args)	{
		
		Scanner scanner = new Scanner(System.in);
		double x1, y1, width1, height1;
		double x2, y2, width2, height2;
		double[] temp;
		System.out.println("Enter r1's center x, y coordinates, width and height: ");
		temp = readRectangle(scanner);
		x1 = temp[0]; y1 = temp[1];
		width1 = temp[2]; height1 = temp[3];
		System.out.println("Enter r2's center x, y coordinates, width and height: ");
		temp = readRectangle(scanner);
		x2 = temp[0]; y2 = temp[1];
		width2 = temp[2]; height2 = temp[3];
		
		double leftWall1 = x1 - width1 / 2;
		double rightWall1 = x1 + width1 / 2;
		double ceil1 = y1 - height1 / 2;
		double roof1 = y1 + height1 / 2;
		double leftWall2 = x2 - width2 / 2;
		double rightWall2 = x2 + width2 / 2;
		double ceil2 = y2 - height2 / 2;
		double roof2 = y2 + height2 / 2;
		
		//does the second center is within the first ?
		if (x2 > leftWall1 && x2 < rightWall1 && y2 > ceil1 && y2 < roof1) {
			//if so, is the second rec inside the first?
			if (leftWall2 >= leftWall1 && rightWall2 <= rightWall1 
					&& ceil2 >= ceil1 && roof2 <= roof1)
				System.out.println("The second rectangle is within the first.");
			//or extends beyond it	
			else
				System.out.println("The second rectangle overlaps the first.");		
		}
		//the second center is not within the first
		else {
			//does it overlap ? is any of seconds sides between the first ?
			if ((leftWall2 > leftWall1 && leftWall2 < rightWall1) ||
					(rightWall2 > leftWall1 && rightWall2 < rightWall1) ||
					(ceil2 > ceil1 && ceil2 < roof1) ||
					(roof2 > ceil1 && roof2 < roof1))
				//rectangles overlap
				System.out.println("The second rectangle overlaps the first one.");
			else
				//rectangles do not overlap
				System.out.println("Rectangles do not overlap.");		
		}	
	}
	
	private static double[] readRectangle(Scanner scanner) {
		double[] tempo = new double[4];
		int i = 0;
		while(true) {
			if (scanner.hasNextDouble()){
				tempo[i] = scanner.nextDouble();
				i++;
			}
			else
				scanner.nextLine();
			if(i >= 4)
				break;	
		}
		return tempo;
	}
}
