package exercise5;

public class test {

	public static void main(String[] args) {
		
		Triangle tr = new Triangle(1, 1, 1);
		Circle2D crc = new Circle2D();
		
		
		System.out.println(SimpleGeometricObject.max(tr, crc));
		
	}
}
