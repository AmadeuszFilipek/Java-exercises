package Exercises;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

public class Exercise20 {

	public static void main(String[] args) {
		
		for(int i = 100; i <= 1000; i += 100) {
			System.out.println(i + "  " + e(i));
		}		
		
	}
	
	public static BigDecimal e(int n) {
		BigDecimal result = BigDecimal.ONE;
		for(int i = n; i >= 1; i--) {
			result = result.add(
							 BigDecimal.ONE.divide(
								 new BigDecimal(factorial(i)),
								 new MathContext(50, RoundingMode.HALF_EVEN)),
							 new MathContext(50, RoundingMode.HALF_EVEN));
		}
		
		return result;
	}
	public static BigInteger factorial(long n) {
		BigInteger result = BigInteger.ONE;
		for(long i = 2; i <= n; i++)
			result = result.multiply(new BigInteger(i + ""));
		
		return result;
	}
}

