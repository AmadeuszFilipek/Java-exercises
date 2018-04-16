package exercise1;

public class test {

	public static void main(String[] args) {
	
		
		Triangle triangle = new Triangle(3, 3, 3);
		triangle.setColor("Aquamarine");
		triangle.setFilled(true);
		System.out.println(triangle.getArea());
		System.out.println(triangle.getPerimeter());
		System.out.println(triangle);
	}

}
