package exercise9;

public class Circle extends SimpleGeometricObject implements Comparable<Circle> {
	
	private double radius;

	public Circle() {
	}

	public Circle(double radius) {
		this.radius = radius;
	}

	public Circle(double radius,
			String color, boolean filled) {
		this.radius = radius;
		setColor(color);
		setFilled(filled);
	}

	public int compareTo(Circle c) {
		if(this.radius > c.getRadius()) 
			return 1;
		else if (Math.abs(this.radius - c.getRadius()) < Math.pow(10, -8))
			return 0;
		
		return -1;
	}
	
	@Override
	public boolean equals(Object c) {
		if (c instanceof Circle) {
			return Math.abs(this.radius - ((Circle)c).getRadius()) < Math.pow(10, -8);
		}
		else
			return false;
	}
	
	/** Return radius */
	public double getRadius() {
		return radius;
	}

	/** Set a new radius */
	public void setRadius(double radius) {
		this.radius = radius;
	}

	/** Return area */
	public double getArea() {
		return radius * radius * Math.PI;
	}

	/** Return diameter */
	public double getDiameter() {
		return 2 * radius;
	}

	/** Return perimeter */
	public double getPerimeter() {
		return 2 * radius * Math.PI;
	}

	/** Print the circle info */
	public void printCircle() {
		System.out.println("The circle is created " + getDateCreated() +
				" and the radius is " + radius);
	}
}
