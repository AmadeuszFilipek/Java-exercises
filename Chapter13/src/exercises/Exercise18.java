package exercises;

import java.math.BigInteger;

import exercise15.Rational;

public class Exercise18 {

	public static void main(String[] args) {
		
		Rational sum = new Rational();
		Rational increment = new Rational(BigInteger.ZERO, BigInteger.ONE);
		
		for(int i = 1; i <= 99; i++) {
			increment = new Rational(increment.getNumerator().add(BigInteger.ONE),
																increment.getDenominator().add(BigInteger.ONE));
			System.out.println(sum);
			sum = sum.add(increment);
		}
		
		System.out.println(sum);
	}
}
