package exercise6;

/** ComparableCircle extends Circle2D
 * ------------------------------------------------------------
 * +ComparableCircle()
 * +ComparableCircle(x: double, y: double, radius: double)
 * +compareTo(obj: ComparableCircle): int
 * ------------------------------------------------------------
 * 
 * @author Amadeusz
 *
 */
public class ComparableCircle extends Circle2D implements Comparable<ComparableCircle> {

	public ComparableCircle() {} // super();


	public ComparableCircle(double x, double y, double radius) {
		super(x, y, radius);
	}
	
	public int compareTo(ComparableCircle obj) {
		if (this.getArea() > obj.getArea())
			return 1;
		else if(this.getArea() == obj.getArea())
			return 0;
		
		return -1;
	}
}

