package Exercise3;
/** 					MyInteger UML
 * --------------------------------------
 * -value: int
 * --------------------------------------
 * +MyInteger(value: int)
 * +getValue(): int
 * +isEven(): boolean
 * +isOdd(): boolean
 * +isPrime(): boolean
 * +_isEven(value: int): boolean
 * +_isOdd(value: int): boolean
 * +_isPrime(value: int): boolean
 * +equals(value: int) : boolean
 * +equals(value: MyInteger): boolean
 * +_parseInt(text: char[]): int
 * +_parseInt(text: String): int
 * --------------------------------------
 * 
 * @author Amadeusz
 *
 */
public class MyInteger {

	private int value;
	
	public MyInteger(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public boolean isEven() {
		return value % 2 == 0;
	}
	
	public boolean isOdd() {
		return value % 2 == 1;
	}
	
	public boolean isPrime() {

		for (int divisor = 2; divisor <= value / 2; divisor++) {
			if (value % divisor == 0) { // If true, number is not prime
				return false;
			}
		}

		return true; // Number is prime
	}
	
	public static boolean isEven(int value) {
		return value % 2 == 0;
	}
	
	public static boolean isOdd(int value) {
		return value % 2 == 1;
	}
	
	public static boolean isPrime(int value) {

		for (int divisor = 2; divisor <= value / 2; divisor++) {
			if (value % divisor == 0) { // If true, number is not prime
				return false;
			}
		}

		return true;
	}

	public boolean equals(int value) {
		return this.value == value;
	}
	
	public boolean equals(MyInteger value) {
		return this.value == value.value;
	}
	
	public static int parseInt(char[] text) {
		int value = 0;
		int decimalPlace = 1;
		
		// it should throw an error if its not just a number
		for (int i = text.length - 1; i >= 1; i--) {
			if (text[i] >= '0' && text[i] <= '9') {
				value += ((int)text[i] - (int)'0') * decimalPlace;	
			}
			decimalPlace *= 10;
		}
		
		//parse the last character, it may be a minus sign
		if (text[0] == '-')
			value *= -1;
		else if(text[0] >= '0' && text[0] <= '9')
			value += ((int)text[0] - (int)'0') * decimalPlace;
			
		return value;
	}
	
	public static int parseInt(String text) {
		return parseInt(text.toCharArray());
	}
}
