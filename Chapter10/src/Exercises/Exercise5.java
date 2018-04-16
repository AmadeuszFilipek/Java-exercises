package Exercises;

import java.util.Scanner;

public class Exercise5 {

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a positive integer: ");
		int number = scanner.nextInt();
		scanner.close();
		
		StackOfIntegers stack = new StackOfIntegers();
		
		int temp = number, i = 2;
		while (temp > 1) {
			if ( temp % i == 0) {
				stack.push(i);
				temp /= i;
			}
			else i++;
		}
		
		while(!stack.empty()) {
			System.out.println(stack.pop());
		}
	}
}
