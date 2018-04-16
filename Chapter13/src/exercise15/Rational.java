package exercise15;

import java.math.BigInteger;

public class Rational extends Number implements Comparable<Rational> {
	// Data fields for numerator and denominator
	private static final int NUMERATOR = 0;
	private static final int DENOMINATOR = 1;
	private BigInteger[] r = new BigInteger[2];
	
	/** Construct a rational with default properties */
	public Rational() {
		this(BigInteger.ZERO, BigInteger.ONE);
	}

	/** Construct a rational with specified numerator and denominator */
	public Rational(BigInteger numerator, BigInteger denominator) {
		BigInteger gcd = gcd(numerator, denominator);
		this.r[NUMERATOR] = numerator
												.multiply(new BigInteger((denominator.signum() > 0) ? "1" : "-1"))
												.divide(gcd);
										
		this.r[DENOMINATOR] = denominator
													.multiply(new BigInteger(Integer.toString(denominator.signum())))
													.divide(gcd);
			
	}

	/** Find GCD of two numbers */
	private static BigInteger gcd(BigInteger n, BigInteger d) {
		BigInteger n1 = n.multiply((new BigInteger(Integer.toString(n.signum())))); // abs
		BigInteger n2 = d.multiply((new BigInteger(Integer.toString(d.signum())))); //Math.abs(d);
		BigInteger gcd = BigInteger.ONE;

		for (BigInteger k = BigInteger.ONE; k.compareTo(n1) <= 0 && k.compareTo(n2) <= 0; k = k.add(BigInteger.ONE)) {
			if (n1.remainder(k).equals(BigInteger.ZERO) && n2.remainder(k).equals(BigInteger.ZERO))
				gcd = k;
		}

		return gcd;
	}

	/** Return numerator */
	public BigInteger getNumerator() {
		return r[NUMERATOR];
	}

	/** Return denominator */
	public BigInteger getDenominator() {
		return r[DENOMINATOR];
	}

	/** Add a rational number to this rational */
	public Rational add(Rational secondRational) {
		BigInteger n = r[NUMERATOR].multiply(secondRational.getDenominator())
				 					 .add(
				 					 r[DENOMINATOR].multiply(secondRational.getNumerator()));
	
				
		BigInteger d =  r[DENOMINATOR].multiply(secondRational.getDenominator());
		
		return new Rational(n, d);
	}

	/** Subtract a rational number from this rational */
	public Rational subtract(Rational secondRational) {
		BigInteger n = r[NUMERATOR].multiply(secondRational.getDenominator())
				.subtract( 
				r[DENOMINATOR].multiply(secondRational.getNumerator()));
		BigInteger d = r[DENOMINATOR].multiply(secondRational.getDenominator());
		return new Rational(n, d);
	}

	/** Multiply a rational number by this rational */
	public Rational multiply(Rational secondRational) {
		BigInteger n = r[NUMERATOR].multiply(secondRational.getNumerator());
		BigInteger d = r[DENOMINATOR].multiply(secondRational.getDenominator());
		return new Rational(n, d);
	}

	/** Divide a rational number by this rational */
	public Rational divide(Rational secondRational) {
		BigInteger n = r[NUMERATOR].multiply(secondRational.getDenominator());
		BigInteger d = r[DENOMINATOR].multiply(secondRational.getNumerator());
		return new Rational(n, d);
	}

	@Override
	public String toString() {
		if (r[DENOMINATOR].equals(BigInteger.ONE))
			return r[NUMERATOR] + "";
		else
			return r[NUMERATOR] + "/" + r[DENOMINATOR];
	}

	@Override // Override the equals method in the Object class
	public boolean equals(Object other) {
		if ((this.subtract((Rational)(other))).getNumerator().equals(BigInteger.ZERO))
			return true;
		else
			return false;
	}

	@Override // Implement the abstract intValue method in Number
	public int intValue() {
		return (int)doubleValue();
	}

	@Override // Implement the abstract floatValue method in Number
	public float floatValue() {
		return (float)doubleValue();
	}

	@Override // Implement the doubleValue method in Number
	public double doubleValue() {
		return r[NUMERATOR].multiply(BigInteger.ZERO).divide(r[DENOMINATOR]).doubleValue();
	}

	@Override // Implement the abstract longValue method in Number
	public long longValue() {
		return (long)doubleValue();
	}

	@Override // Implement the compareTo method in Comparable
	public int compareTo(Rational o) {
		return this.subtract(o).getNumerator().signum();
	}
}