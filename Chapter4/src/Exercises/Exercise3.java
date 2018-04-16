package Exercises;

public class Exercise3 {

	public static void main(String[] args) {
		
		double[] atlanta = {33.7444417,-84.3900311};
		double[] orlando = {28.5316465,-81.3817513};
		double[] savannah = {32.0763656,-81.1070931};
		double[] charlotte = {35.2244910,-80.8441079};
		
		for (int i = 0; i < 2; i ++) {
			atlanta[i] = Math.toRadians(atlanta[i]);
			orlando[i] = Math.toRadians(orlando[i]);
			savannah[i] = Math.toRadians(savannah[i]);
			charlotte[i] = Math.toRadians(charlotte[i]);
		}
		
		double atlantaOrlando = distance(atlanta, orlando);
		double orlandoSavannah = distance(atlanta, savannah);
		double savannahCharlotte = distance(savannah, charlotte);
		double charlotteAtlanta = distance(charlotte, atlanta);
		double atlantaSavannah = distance(atlanta, savannah);
		
		double area1 = triangleArea(atlantaOrlando, orlandoSavannah, atlantaSavannah);
		double area2 = triangleArea(savannahCharlotte, charlotteAtlanta, atlantaSavannah);
		
		System.out.println("The area of polygon created from cities:\nAtlanta, Orlando, "
				+ "Savannah and Charlotte is\n" + (area1 + area2) + " square km");
		
	}
	
	private static double triangleArea(double side1, double side2, double side3) {
		double s = (side1 + side2 + side3) / 2;
		return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
	}
	
	private static double distance(double[] point1, double[] point2) {
		
		final double RADIUS = 6371.01;
		return RADIUS * Math.acos(Math.sin(point1[0]) * Math.sin(point2[0]) +
				Math.cos(point1[0]) * Math.cos(point2[0]) * Math.cos(point1[1] - point2[1]));
	}
}
