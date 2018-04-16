package Exercises;
/** LinearEquation UML
 * -------------------------
 * -a: double
 * -b: double
 * -c: double
 * -d: double
 * -e: double
 * -f: double
 * ------------------------
 * +LinearEquation(a: double, b: double, c: double, d: double, e: double, f: double)
 * +getA(): double
 * +getB(): double
 * +getC(): double
 * +getD(): double
 * +getE(): double
 * +getF(): double
 * +isSolvable(): boolean
 * +getX(): double
 * +getY(): double
 * ------------------------
 * 
 * @author Amadeusz
 *
 */
public class LinearEquation {

	private double a;
	private double b;
	private double c;
	private double d;
	private double e;
	private double f;
	
	public LinearEquation(double a, double b, double c, double d, double e, double f) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.e = e;
		this.f = f;
	}
	
	public boolean isSolvable() {
		if (Math.abs((a * d - b * c)) < Math.pow(10, -8))
			return false;
		return true;
	}
	
	public double getX() {
		return (e * d - b * f) / (a * d - b * c);
	}
	
	public double getY() {
		return (a * f - e * c) / (a * d - b * c);
	}
}
