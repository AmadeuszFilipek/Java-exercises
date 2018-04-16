package Exercises;

public class Exercise13 {

	public static void main(String[] args) {
		
		double x = 0;
		double y = 0;
		
		double a = 3.4, b = 50.2, e = 44.5;
		double c = 2.1, d = .55, f = 5.9;
		
		double W = a * d - b * c;
		double Wx = e * d - b * f;
		double Wy = a * f - e * c;
		
		if (W != 0) {
			x = Wx / W;
			y = Wy / W;
			System.out.println("Solution x: " + x);
			System.out.println("Solution y: " + y);
		}
		else if (Wx == 0 && Wy == 0)
			System.out.println("There is no soultion, problem undefined.");
		else 
			System.out.println("Solution has one parameter "
				+ "and thus is linear.");
	}
}
