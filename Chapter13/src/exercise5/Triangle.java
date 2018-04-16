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
	
	public Triangle(double side1, double side2, double side3) {
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}
	
	@Override
	public int compareTo(SimpleGeometricObject obj) {
		if (getArea() > obj.getArea())
			return 1;
		else if (getArea() == obj.getArea())
			return 0;
		else return -1;
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
}
