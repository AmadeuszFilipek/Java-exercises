package exercises;

import exercise5.SimpleGeometricObject;
import exercise5.Circle2D;

public class Exercise12 {

	public static void main(String[] args) {
		
	}
	
	public static double sumArea(SimpleGeometricObject[] a) {
		double sum = 0;
		
		for(int i = 0; i < a.length; i++) {
			if (a[i] instanceof Circle2D)
				sum += ((Circle2D)a[i]).getArea();
		}
		
		return sum;
	}
}
