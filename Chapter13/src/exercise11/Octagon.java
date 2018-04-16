package exercise11;

 // NOTE: if you do not implement Cloneable super.clone() will throw CloneNotSupportedException !
 // however it will compile just fine and u can invoke it
public class Octagon extends SimpleGeometricObject implements Comparable<Octagon>, Cloneable {

	private double side = 1; 
	
	public Octagon() {}
	
	public Octagon(double side) {
		this.side = side;
	}
	
	public double getSide() {
		return side;
	}
	
	public double getArea() {
		return (2 + 4 / Math.sqrt(2)) * side * side;
	}
	
	public double getPerimeter() {
		return 8 * side;
	}
	
	public int compareTo(Octagon oct) {
		if(this.side > oct.getSide()) 
			return 1;
		else if (Math.abs(this.side - oct.getSide()) < Math.pow(10, -8))
			return 0;
		
		return -1;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		//we want a deep copy here, it's easy in this case, but if members are other references
		//you have to deep clone those references also...
		return super.clone();
	}
}
