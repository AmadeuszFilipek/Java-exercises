package exercise5;
/** 			Triangle UML  -----|>  SimpleGeometricObject
 * ------------------------------------------------------
 * -side1: double
 * -side2: double
 * -side3: double
 * ------------------------------------------------------
 * +Triangle()
 * +Triangle(side1: double, side2: double, side3: double)
 * +getSide1(): double
 * +getSide2(): double
 * +getSide3(): double
 * +getArea(): double
 * +getPerimeter(): double
 * +toString(): String
 * ------------------------------------------------------
 * 
 * 
 * @author Amadeusz
 *
 */
public class Triangle extends SimpleGeometricObject {

	private double side1 = 1;
	private double side2 = 1;
	private double side3 = 1;
	
	public Triangle() {}
	
	public Triangle(double side1, double side2, double side3)
		throws IllegalTriangleException {
		
		//check if any side is 0 or less
		if(side1 <= 0)
			throw new IllegalTriangleException("Invalid triangle: side1 less than or equal to 0.");
		if(side2 <= 0)
			throw new IllegalTriangleException("Invalid triangle: side2 less than or equal to 0.");
		if(side3 <= 0)
			throw new IllegalTriangleException("Invalid triangle: side3 less than or equal to 0.");
		
		//check if a triangle can be created from the three sides
		if(side1 + side2 <= side3)
			throw new IllegalTriangleException("Invalid triangle: side1 + side2 less than or equal to side3.");
		if(side2 + side3 <= side1)
			throw new IllegalTriangleException("Invalid triangle: side2 + side3 less than or equal to side1.");
		if(side3 + side1 <= side2)
			throw new IllegalTriangleException("Invlaid triangle: side1 + side3 less than or equal to side2.");
		
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}
	
	public double getSide1() {
		return side1;
	}
	
	public double getSide2() {
		return side2;
	}
	
	public double getSide3() {
		return side3;
	}

	public double getArea() {
		double s = (side1 + side2 + side3) / 2;
		return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
	}
	
	public double getPerimeter() {
		return side1 + side2 + side3;
	}
	
	public String toString() {
		if (isFilled())
			return getColor() + " filled triangle with sides ["
				+ side1 + "; " + side2 + "; " + side3 + "]\ncreated at " + getDateCreated();
		else
			return getColor() + " unfilled triangle with sides ["
			+ side1 + "; " + side2 + "; " + side3 + "]\ncreated at " + getDateCreated();
	}
	
	
	@SuppressWarnings("serial")
	private static class IllegalTriangleException extends Exception {
		
		public IllegalTriangleException(String message) {
			super(message);
		}
	}
}
