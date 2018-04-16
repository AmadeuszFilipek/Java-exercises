package Exercises;

public class Exercise6 {

	public static void main(String[] args) {
		double angle1 = Math.random() * 2 * Math.PI; //in radians
		double angle2 = Math.random() * 2 * Math.PI;
		double angle3 = Math.random() * 2 * Math.PI;
		final double RADIUS = 40;

		double[] point1 = {RADIUS * Math.cos(angle1), RADIUS * Math.sin(angle1)};
		double[] point2 = {RADIUS * Math.cos(angle2), RADIUS * Math.sin(angle2)};
		double[] point3 = {RADIUS * Math.cos(angle3), RADIUS * Math.sin(angle3)};

		double a = distance(point1, point2);
		double b = distance(point2, point3);
		double c = distance(point3, point1);

		double alpha = Math.toDegrees(Math.acos(
				(Math.pow(b, 2) + Math.pow(c, 2) - Math.pow(a, 2)) / 2 / c / b ));
		double beta = Math.toDegrees(Math.acos(
				(Math.pow(a, 2) + Math.pow(c, 2) - Math.pow(b, 2)) / 2 / a / c ));
		double gamma = Math.toDegrees(Math.acos(
				(Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2)) / 2 / a / b ));
		
		double triangleAngleSum = alpha + beta + gamma;
		
		System.out.printf("Generated triangle has following angles:\n" +
				"%f %f %f\nSum of the angles: %f", 
				alpha, beta, gamma, triangleAngleSum);
	}
	private static double distance(double[] point1, double[] point2) {
		return Math.sqrt(Math.pow(point1[0] - point2[0], 2) +
				Math.pow(point1[1] - point2[1], 2));
	}
}
