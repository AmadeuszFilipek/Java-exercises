package exercise15;

import java.math.BigInteger;

public class test {

	public static void main(String[] args) {
	// TODO Auto-generated method stub

		
		Rational a = new Rational(new BigInteger("123"), new BigInteger("543"));
		Rational b = new Rational(new BigInteger("563"), new BigInteger("542"));
	
		System.out.println(a);
		System.out.println(b);
		
		System.out.println(a.add(b));
		System.out.println(a.subtract(b));
		System.out.println(a.multiply(b));
		System.out.println(a.divide(b));
		
	}

}
