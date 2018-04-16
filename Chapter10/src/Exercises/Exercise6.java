package Exercises;

import Exercise3.MyInteger;

public class Exercise6 {

	public static void main(String[] args) {
		StackOfIntegers stack = new StackOfIntegers();
		
		for(int i = 2; i < 120; i++)
			if(MyInteger.isPrime(i))
				stack.push(i);
		
		while(!stack.empty())
			System.out.println(stack.pop());
	}
}
