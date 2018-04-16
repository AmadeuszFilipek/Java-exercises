package exercise7;
/** 					MyRectangle2D UML
 * ---------------------------------------------
 * -x: double
 * -y: double
 * -width: double
 * -height: double
 * ---------------------------------------------
 * +MyRectangle2D()
 * +MyRectangle2D(x: double, y: double, width: double, height: double)
 * +getX(): double
 * +getY(): double
 * +getWidth(): double
 * +getHeight(): double
 * +setX(x: double): void
 * +setY(y: double): void
 * +setWidth(width: double): void
 * +setHeight(height: double): void
 * +getArea(): double
 * +getPerimeter(): double
 * +contains(x: double, y: double): boolean
 * +contains(r: MyRectangle2D): boolean
 * +overlaps(r: MyRectangle2D): boolean
 * ---------------------------------------------
 * 
 * 
 * @author Amadeusz
 *
 */
public class MyRectangle2D implements Colorable {

	private double x;
	private double y;
	
	private double width = 1;
	private double height = 1;
	
	public MyRectangle2D() {}
	
	public MyRectangle2D(double x, double y, double width, double height) {
		this.x = x;
		this.y = y;
		if (width > 0)
			this.width = width;
		if (height > 0)
			this.height = height;
	}

	public void howToColor() {
		System.out.println("Color all four sides.");
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

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		if (width > 0)
			this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		if(height > 0)
			this.height = height;
	}

	public double getArea() {
		return width * height;
	}
	
	public double getPerimeter() {
		return width * 2 + height * 2;
	}
	
	public boolean contains(double x, double y) {
		//check x coordinate
		if (x < this.x - width / 2 || x > this.x + width / 2)
			return false;
		// check y coordinate
		if (y < this.y - height / 2 || y > this.y + height / 2)
			return false;
		
		
		return true;
	}
	
	public boolean contains(MyRectangle2D r) {
		//rectangle is inside if all its corner points are inside the rectangle
		if (!contains(r.getX() + r.getWidth() / 2, r.getY() + r.getHeight() / 2) ||
				!contains(r.getX() - r.getWidth() / 2, r.getY() + r.getHeight() / 2) ||
				!contains(r.getX() + r.getWidth() / 2, r.getY() - r.getHeight() / 2) ||
				!contains(r.getX() - r.getWidth() / 2, r.getY() - r.getHeight() / 2)
				)
			return false;
		
		return true;
	}
	
	public boolean overlaps(MyRectangle2D r) {
		//rectangle overlaps if coordinate distances of their centers are less than
		//sum of their widths and heights divided by two    
		double distanceX = Math.abs(this.x - r.getX());
		double distanceY = Math.abs(this.y - r.getY());
		
		if (distanceX < (this.width + r.getWidth()) / 2 &&
				distanceY < (this.height + r.getHeight()) / 2)
			return true;
		
		return false;
	}
}
