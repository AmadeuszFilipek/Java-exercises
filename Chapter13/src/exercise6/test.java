package exercise6;

public class test {

	public static void main(String[] args) {
		
		ComparableCircle circle = new ComparableCircle();
		ComparableCircle circle2 = new ComparableCircle();
		
		System.out.println(circle2.compareTo(circle));
	}
}
