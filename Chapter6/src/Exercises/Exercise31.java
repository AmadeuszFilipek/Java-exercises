package Exercises;

import java.util.Scanner;

public class Exercise31 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		long number = 0;
		System.out.print("Enter a credit card number as a long integer: ");
		while(true) {
			if (scanner.hasNextLong()) {
				number = scanner.nextLong();
				break;
			}
			else scanner.next();
		}
		scanner.close();
		if (isValid(number))
			System.out.println(number + " is valid");
		else
			System.out.println(number + " is invalid");
	}
	
	public static boolean isValid(long number) {
		
		StringBuilder temp = new StringBuilder();
		temp.append(number);
		
		if (temp.length() < 13 || temp.length() > 16)
			return false;
		
		if (temp.charAt(0) == '4' || temp.charAt(0) == '5' || 
				temp.charAt(0) == '6' || temp.charAt(0) == '3') {
			if (temp.charAt(0) == '3') {
				if (temp.charAt(1) != '7')
					return false;
			}
		}
		else 
			return false;
		
		
		int stepTwo = sumOfDoubleEvenPlace(number);
		int stepThree = sumOfOddPlace(number);
		
		if ((stepTwo + stepThree) % 10 == 0)
			return true;
		else
			return false;
	}
	
	public static int sumOfDoubleEvenPlace(long number) {
		
		StringBuilder temp = new StringBuilder();
		temp.append(number);
		temp.reverse();
		
		int sum = 0;
		for(int i = 1; i < temp.length(); i += 2) {
			sum += getDigit( 2 * (temp.charAt(i) - '0'));
		}
		
		return sum;
	}
	
	public static int getDigit(int number) {
		
		StringBuilder temp = new StringBuilder();
		temp.append(number);
		temp.reverse();
		
		if (temp.length() == 1)
			return temp.charAt(0) - '0';

		return temp.charAt(0) - '0' + temp.charAt(1) - '0';
	}
	
	public static int sumOfOddPlace(long number) {
		
		StringBuilder temp = new StringBuilder();
		temp.append(number);
		temp.reverse();
		int sum = 0;
		
		for(int i = 0; i < temp.length(); i += 2) {
			sum += temp.charAt(i) - '0';
		}
	
		return sum;
		
	}
	
	public static boolean prefixMatched(long number, int d) {
		
		if (getPrefix(number, getSize(d)) == d)
			return true;
		else 
			return false;
	}

	public static int getSize(long d) {
		
		StringBuilder temp = new StringBuilder();
		temp.append(d);
		temp.reverse();
		
		return temp.length();
	}
	
	public static long getPrefix(long number, int k) {
		
		StringBuilder temp = new StringBuilder();
		temp.append(number);
		temp.reverse();
		
		if (k >= temp.length())
			return Integer.parseInt(temp.toString());

		return Integer.parseInt(temp.substring(temp.length() - k, temp.length()));

	}
}
