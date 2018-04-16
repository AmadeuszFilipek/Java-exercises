package exercises;

/** 							Triangle2D UML
 * ---------------------------------------------
 * -p1: MyPoint
 * -p2: MyPoint
 * -p3: MyPoint
 * ---------------------------------------------
 * +Triangle2D()
 * +Triangle2D(p1: MyPoint, p2: MyPoint, p3: MyPoint)
 * +getP1(): MyPoint
 * +getP2(): MyPoint
 * +getP3(): MyPoint
 * +setP1(p: MyPoint): void
 * +setP2(p: MyPoint): void
 * +setP3(p: MyPoint): void
 * +getArea(): double
 * +getPerimeter(): double
 * +contains(p: MyPoint): boolean
 * +contains(t: Triangle2D): boolean
 * +overlaps(t: Triangle2D): boolean
 * -_side(p1 MyPoint, p2 MyPoint): double
 * -_isInsideTheSegment(seg1: MyPoint, seg2: MyPoint, p: MyPoint): boolean
 * ---------------------------------------------
 * 
 * @author Amadeusz
 *
 */
public class Triangle2D {

	private MyPoint p1;
	private MyPoint p2;
	private MyPoint p3;
	
	public Triangle2D() {
		p1 = new MyPoint(0, 0);
		p2 = new MyPoint(1, 1);
		p3 = new MyPoint(2, 5);
	}
	
	public Triangle2D(MyPoint p1, MyPoint p2, MyPoint p3) {
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	}

	public MyPoint getP1() {
		return p1;
	}

	public void setP1(MyPoint p1) {
		this.p1 = p1;
	}

	public MyPoint getP2() {
		return p2;
	}

	public void setP2(MyPoint p2) {
		this.p2 = p2;
	}

	public MyPoint getP3() {
		return p3;
	}

	public void setP3(MyPoint p3) {
		this.p3 = p3;
	}
	
	public double getArea() {
		
		double side1 = side(p1, p2);
		double side2 = side(p2, p3);
		double side3 = side(p3, p1);
		double s = (side1 + side2 + side3) / 2;
		
		return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
	}
	
	public double getPerimeter() {
		return side(p1, p2) + side(p2, p3) + side(p3, p1);
	}
	
	private static double side(MyPoint p1, MyPoint p2) {
		return Math.sqrt(Math.pow(p1.getX() - p2.getX(), 2) +
				Math.pow(p1.getY() - p2.getY(), 2));
	}
	
	public boolean contains(MyPoint p) {
		//for each corner get the intersection point of line p to corner
		//and opposite triangle side and then check if the intersection point
		// lies on the line segment p to corner
		
		MyPoint[] pts = {p1, p2, p3};
		double a, b, c, d, e, f;
		
		for(int i = 0 ; i < 3; i++) {
					
			a = pts[i].getY() - pts[(i + 1) % 3].getY();
			b = -(pts[i].getX() - pts[(i + 1) % 3].getX());
			e = a * pts[i].getX() + b * pts[i].getY();

			c = pts[(i + 2) % 3].getY() - p.getY();
			d = -(pts[(i + 2) % 3].getX() - p.getX());
			f = c * pts[(i + 2) % 3].getX() + d * pts[(i + 2) % 3].getY();

			//get intersection point
			LinearEquation eq = new LinearEquation(a, b, c, d, e, f);
			MyPoint intersection;
			
			//if no intersection point, that means lines are parallel, that should be not possible
			if (eq.isSolvable())
				intersection = new MyPoint(eq.getX(), eq.getY());
			else 
				return false;
			
			//check if intersection is inside the line segment from corner to 
			if (isInsideTheSegment(pts[(i + 2) % 3], p, intersection))
				return false;

		}	
		return true;
	}
	
	/** Checks if the point is on the line segment from seg1 to seg2. */
	private static boolean isInsideTheSegment(MyPoint seg1, MyPoint seg2, MyPoint p) {
		
		double verifyFunction = (seg2.getX() - seg1.getX()) * (p.getY() - seg1.getY())
				- (p.getX() - seg1.getX()) * (seg2.getY() - seg1.getY());


		boolean isHorizontalInside = false;
		boolean isVerticalInside = false;

		if(Math.abs(verifyFunction) < Math.pow(10, -8)) {
			// is on the line, but is it inside the segment ?
			if (seg1.getX() < seg2.getX()) {
				if (p.getX() >= seg1.getX() && p.getX() <= seg2.getX())
					isHorizontalInside = true;
				else
					isHorizontalInside = false;
			}
			else {
				if (p.getX() >= seg2.getX() && p.getX() <= seg1.getX())
					isHorizontalInside = true;
				else
					isHorizontalInside = false;
			}
			if (seg1.getY() < seg2.getY()) {
				if (p.getY() >= seg1.getY() && p.getY() <= seg2.getY())
					isVerticalInside = true;
				else
					isVerticalInside = false;		
			}
			else {
				if (p.getY() >= seg2.getY() && p.getY() <= seg1.getY())
					isVerticalInside = true;
				else
					isVerticalInside = false;	
			}

			return isHorizontalInside && isVerticalInside;
		}
		//p is not even on the line
		else 
			return false;	
	}
	
	public boolean contains(Triangle2D t) {
		//check if each point of t is inside the triangle
		if (contains(t.getP1()) && 
				contains(t.getP2()) && 
				contains(t.getP3()))
			return true;
		
		return false;
	}
	
	public boolean overlaps(Triangle2D t) {
		//for each side of t check if it intersects with any of the side of this triangle
		MyPoint[] tPts = {t.getP1(), t.getP2(), t.getP3()};
		MyPoint[] thisPts = {p1, p2, p3};
		double a, b, c, d, e, f;
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {

				a = tPts[i].getY() - tPts[(i + 1) % 3].getY();
				b = -(tPts[i].getX() - tPts[(i + 1) % 3].getX());
				e = a * tPts[i].getX() + b * tPts[i].getY();

				c = thisPts[(j + 1) % 3].getY() - thisPts[j].getY();
				d = -(thisPts[(j + 1) % 3].getX() - thisPts[j].getX());
				f = c * thisPts[(j + 1) % 3].getX() + d * thisPts[(j + 1) % 3].getY();

				LinearEquation eq = new LinearEquation(a, b, c, d, e, f);
				MyPoint intersection;
				
				if (eq.isSolvable())
					intersection = new MyPoint(eq.getX(), eq.getY());
				else continue;

				//check if the intersection point belongs to the side segment 
				if (isInsideTheSegment(tPts[i], tPts[(i + 1) % 3], intersection))
					return true;
			}
		}
			
		return false;
	}
}
