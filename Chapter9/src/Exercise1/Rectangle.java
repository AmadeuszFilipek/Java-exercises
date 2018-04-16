package Exercise1;
/** Rectangle
 * --------------------------
 * +width: double
 * +height: double
 * --------------------------
 * Rectangle(): Rectangle
 * Rectangle(width, height): Rectangle
 * +getArea(): double
 * +getPerimeter(): double
 * --------------------------
 * 
 * @author Amadeusz
 * 
 */
public class Rectangle {

	public double width = 1;
	public double height = 1;
	
	Rectangle() {}
	
	Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	public double getArea() {
		return width * height;
	}
	
	public double getPerimeter() {
		return 2 * width + 2 * height;	
	}
}
