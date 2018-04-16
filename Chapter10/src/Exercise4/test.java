package Exercise4;

public class test {

	public static void main(String[] args) {
		
		MyPoint p1 = new MyPoint();
		MyPoint p2 = new MyPoint(1, 1);
		
		System.out.println("Distance is " + p1.distance(p2));
		
	}
}
