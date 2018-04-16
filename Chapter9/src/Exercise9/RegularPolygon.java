package Exercise9;
/** RegularPolygon UML
 * ------------------------------
 * -n: int
 * -side: double
 * -x: double
 * -y: double
 * ------------------------------
 * +RegularPolygon()
 * +RegularPolygon(n: int, side: double)
 * +RegularPolygon(n: int, side: double, x: double, y: double)
 * +getN(): int
 * +getSide(): double
 * +getX(): double
 * +getY(): double
 * +setN(newN: int): void
 * +setSide(newSide: double): void
 * +setX(newX: double): void
 * +setY(newY: double): void
 * +getPerimeter(): double
 * +getArea(): double
 * ---------------------------------
 * 
 * @author Amadeusz
 *
 */
public class RegularPolygon {

	private int n = 3;
	private double side = 1;
	private double x;
	private double y;
	
	RegularPolygon() {}
	
	RegularPolygon(int n, double side) {
		if (n > 2)
			this.n = n;
		this.side = side;
	}
	
	RegularPolygon(int n, double side, double x, double y) {
		if (n > 2)
			this.n = n;
		
		this.side = side;		
		this.x = x;
		this.y = y;
	}

	public int getN() {
		return n;
	}
	/** n of polygon has to be greater than 2 */
	public void setN(int n) {
		if (n > 2)
			this.n = n;
	}

	public double getSide() {
		return side;
	}

	public void setSide(double side) {
		if (side > 0)
			this.side = side;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public double getPerimeter() {
		return side * n;
	}
	
	public double getArea() {
		return n * side * side / (4 * Math.tan(Math.PI / n));
	}
}
