package exercise7;
/** SimpleGoemetricObject UML
 * -------------------------------------
 * -color: String  	+s +g
 * -filled: boolean +s +g
 * -dateCreated: Date  +g
 * -------------------------------------
 * +SimpleGeoMetricObject()
 * +SimpleGoometricObject(color: String, filled: boolean)
 * +toString(): String
 * -------------------------------------
 * 
 * @author Amadeusz
 *
 */
public abstract class SimpleGeometricObject implements Comparable<SimpleGeometricObject> {
	private String color = "white";
	private boolean filled;
	private java.util.Date dateCreated;

	/** Construct a default geometric object */
	public SimpleGeometricObject() {
		dateCreated = new java.util.Date();
	}
	/** Construct a geometric object with the specified color
	 * and filled value */
	public SimpleGeometricObject(String color, boolean filled) {
		dateCreated = new java.util.Date();
		this.color = color;
		this.filled = filled;
	}
	
	public static SimpleGeometricObject max(SimpleGeometricObject obj1, SimpleGeometricObject obj2) {
		if (obj1.compareTo(obj2) >= 0)
			return obj1;
		else 
			return obj2;
	}
	
	public abstract double getArea();
	
	/** Return color */
	public String getColor() {
		return color;
	}

	/** Set a new color */
	public void setColor(String color) {
		this.color = color;
	}

	/** Return filled. Since filled is boolean,
 its getter method is named isFilled */
	public boolean isFilled() {
		return filled;
	}

	/** Set a new filled */
	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	/** Get dateCreated */
	public java.util.Date getDateCreated() {
		return dateCreated;
	}

	/** Return a string representation of this object */
	public String toString() {
		return "created on " + dateCreated + "\ncolor: " + color +
				" and filled: " + filled;
	}
}