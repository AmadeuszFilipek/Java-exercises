package Exercise12;

import Exercise4.MyPoint;

public class test {

	public static void main(String[] args) {
		
		Triangle2D t = new Triangle2D(
				new MyPoint(0, 0), new MyPoint(2, 0), new MyPoint(0, 2));
		
		System.out.println("The area of triangle: " + t.getArea());
		System.out.println("The perimeter of triangle: " + t.getPerimeter());
		
		System.out.println(t.contains(new MyPoint(0.5, 3)));
		System.out.println(t.contains(
				new Triangle2D(new MyPoint(0.1, 0.1), new MyPoint(0.1, 1.5), new MyPoint(2.5, 0.1))));
		
		System.out.println(t.overlaps(
				new Triangle2D(new MyPoint(1, 1), new MyPoint(4, 7), new MyPoint(8, 14))));
	}
}
