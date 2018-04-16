package Exercises;

public class Exercise8 {

	public static void main(String[] args) {
		
		System.out.println("Celsius\tFahrenheit\t|\tFahrenheit\tCelsius");
		System.out.println("_______________________________________________________________");
		
		for(int i = 0; i < 10; i++) {
			System.out.printf("%d\t%.1f\t\t|\t%d\t\t%.2f\n",
				  40 - i, celsiusToFahrenheit(40 - i),
					120 - (i * 10), fahrenheitToCelsius(120 - (i * 10)));
		}
		
	}
	
	public static double celsiusToFahrenheit(double celsius) {
		
		return (9.0 / 5) * celsius + 32;
		
	}
	
	public static double fahrenheitToCelsius(double fahrenheit) {
		
		return (5.0 / 9) * (fahrenheit - 32);
		
	}
}
