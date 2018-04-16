package exercises;
/** MyPoint UML
 * -------------------
 * -x: double
 * -y: double
 * ------------------
 * +MyPoint()
 * +MyPoint(x: double, y: double)
 * +getX(): double
 * +getY(): double
 * +distance(point MyPoint): double
 * +distance(x: double, y: double): double
 * +toString(): String
 * -----------------------
 * 
 * @author Amadeusz
 *
 */
public class MyPoint {

	private double x;
	private double y;
	
	public MyPoint() {}
	
	public MyPoint(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
	public double distance(double x, double y) {
		return Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2));
	}
	
	public double distance(MyPoint point) {
		return distance(point.getX(), point.getY());
	}
	
	public String toString() {
		return "[" + x + "; " + y + "]";
	}
	
}
