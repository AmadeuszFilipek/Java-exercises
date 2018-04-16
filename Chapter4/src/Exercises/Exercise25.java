package Exercises;

public class Exercise25 {

	public static void main(String[] args) {
		
		//vehicle plate number 3 uppercase + four digits
		
		StringBuilder plateNumber = new StringBuilder("");
		for(int i = 0; i < 3; i++)
			plateNumber.append((char)(Math.round(Math.random() * 25) + 65));
		
		for(int i = 0; i < 4; i++)
			plateNumber.append(Math.round(Math.random() * 9));
		
		System.out.println("The vehicle plate number is: " + plateNumber);
		
	}
}
