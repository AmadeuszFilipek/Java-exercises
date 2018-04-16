package exercise5;
/** Circle2D UML
 * --------------------------------
 * -x: double
 * -y: double
 * -radius: double
 * -------------------------------
 * +Circle()
 * +Circle(x: double, y: double, radius: double)
 * +getX(): double
 * +getY(): double
 * +getRadius(): double
 * +getArea(): double
 * +getPerimeter(): double
 * +contains(x: double, y: double): boolean
 * +contains(circle: Circle2D): boolean
 * +overlaps(circle: Circle2D): boolean
 * -----------------------------------
 * 
 * 
 * @author Amadeusz
 *
 */
public class Circle2D extends SimpleGeometricObject {

	private double x;
	private double y;
	private double radius = 1;
	
	Circle2D() {}
	
	Circle2D(double x, double y, double radius) {
		this.x = x;
		this.y = y;
		if (radius >= 0)
			this.radius = radius;
	}

	public int compareTo(SimpleGeometricObject obj) {
		if (getArea() > obj.getArea())
			return 1;
		else if (getArea() == obj.getArea())
			return 0;
		else return -1;
	}
	
	
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getRadius() {
		return radius;
	}
	
	public double getArea() {
		return Math.PI * Math.pow(radius, 2);
	}
	
	public double getPerimeter() {
		return 2 * Math.PI * radius;
	}
	
	public boolean contains(double x, double y) {	
		double pointRadius = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
		
		return pointRadius < radius;	
	}
	
	public boolean contains(Circle2D circle) {
		
		double distanceOfCenters = 
				Math.sqrt(Math.pow(x - circle.getX(), 2) + Math.pow(y - circle.getY(), 2));
		
		return (distanceOfCenters + circle.getRadius()) <= radius;
	}
	
	public boolean overlaps(Circle2D circle) {
		double distanceOfCenters = 
				Math.sqrt(Math.pow(x - circle.getX(), 2) + Math.pow(y - circle.getY(), 2));
		
		return distanceOfCenters < circle.getRadius() + radius;		
	}
	
	public String toString() {
		return "\nCircle of radius " + radius + " with center at [" + x + "; " + y + "]\n" + super.toString();
	}
}
