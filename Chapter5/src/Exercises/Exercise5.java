package Exercises;

public class Exercise5 {

	public static void main(String[] args) {
		
		double kiloToPounds = 2.2;
		final int N = 200;
		int j = 0;
		System.out.println("Kilograms\tPounds\t|\tPounds\tKilograms");
		for(int i = 1; i <= N; i += 2) {
			System.out.printf("%-8d\t%6.1f", i, i * kiloToPounds);
			System.out.printf("\t|\t%-6d\t%9.2f\n", j * 5 + 20, (j * 5 + 20)/kiloToPounds);
			j++;
		}	
		
	}
}
