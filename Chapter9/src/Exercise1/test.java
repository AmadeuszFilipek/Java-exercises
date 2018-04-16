package Exercise1;

public class test {

	public static void main(String[] args) {

		Rectangle rec1 = new Rectangle(4, 40);
		Rectangle rec2 = new Rectangle(3.5, 39.5);
		
		System.out.println("Rectangle 1 :");
		System.out.println("Width: " + rec1.width + " Height: " +
				rec1.height + " area: " + rec1.getArea() +  " perimeter " + rec1.getPerimeter());
		
		System.out.println("Rectangle 2 : ");
		System.out.println("Width: " + rec2.width + " Height: " +
				rec2.height + " area: " + rec2.getArea() +  " perimeter " + rec2.getPerimeter());
		
	}

}
