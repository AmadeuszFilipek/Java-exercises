package Exercise9;

public class test {

	public static void main(String[] args) {
		
		RegularPolygon poly1 = new RegularPolygon();
		RegularPolygon poly2 = new RegularPolygon(6, 4);
		RegularPolygon poly3 = new RegularPolygon(10, 4, 5.6, 7.8);
		
		System.out.println("Poly1: Perimeter " + poly1.getPerimeter() + " Area " + poly1.getArea());
	
		System.out.println("Poly1: Perimeter " + poly2.getPerimeter() + " Area " + poly2.getArea());

		System.out.println("Poly1: Perimeter " + poly3.getPerimeter() + " Area " + poly3.getArea());
	
	}
}
