package exercise14;

public class Rational extends Number implements Comparable<Rational> {
	// Data fields for numerator and denominator
	private static final int NUMERATOR = 0;
	private static final int DENOMINATOR = 1;
	private long[] r = new long[2];
	
	/** Construct a rational with default properties */
	public Rational() {
		this(0, 1);
	}

	/** Construct a rational with specified numerator and denominator */
	public Rational(long numerator, long denominator) {
		long gcd = gcd(numerator, denominator);
		this.r[NUMERATOR] = ((denominator > 0) ? 1 : -1) * numerator / gcd;
		this.r[DENOMINATOR] = Math.abs(denominator) / gcd;
	}

	/** Find GCD of two numbers */
	private static long gcd(long n, long d) {
		long n1 = Math.abs(n);
		long n2 = Math.abs(d);
		int gcd = 1;

		for (int k = 1; k <= n1 && k <= n2; k++) {
			if (n1 % k == 0 && n2 % k == 0)
				gcd = k;
		}

		return gcd;
	}

	/** Return numerator */
	public long getNumerator() {
		return r[NUMERATOR];
	}

	/** Return denominator */
	public long getDenominator() {
		return r[DENOMINATOR];
	}

	/** Add a rational number to this rational */
	public Rational add(Rational secondRational) {
		long n = r[NUMERATOR] * secondRational.getDenominator() +
				r[DENOMINATOR] * secondRational.getNumerator();
		long d = r[DENOMINATOR] * secondRational.getDenominator();
		return new Rational(n, d);
	}

	/** Subtract a rational number from this rational */
	public Rational subtract(Rational secondRational) {
		long n = r[NUMERATOR] * secondRational.getDenominator()
				- r[DENOMINATOR] * secondRational.getNumerator();
		long d = r[DENOMINATOR] * secondRational.getDenominator();
		return new Rational(n, d);
	}

	/** Multiply a rational number by this rational */
	public Rational multiply(Rational secondRational) {
		long n = r[NUMERATOR] * secondRational.getNumerator();
		long d = r[DENOMINATOR] * secondRational.getDenominator();
		return new Rational(n, d);
	}

	/** Divide a rational number by this rational */
	public Rational divide(Rational secondRational) {
		long n = r[NUMERATOR] * secondRational.getDenominator();
		long d = r[DENOMINATOR] * secondRational.getNumerator();
		return new Rational(n, d);
	}

	@Override
	public String toString() {
		if (r[DENOMINATOR] == 1)
			return r[NUMERATOR] + "";
		else
			return r[NUMERATOR] + "/" + r[DENOMINATOR];
	}

	@Override // Override the equals method in the Object class
	public boolean equals(Object other) {
		if ((this.subtract((Rational)(other))).getNumerator() == 0)
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
		return r[NUMERATOR] * 1.0 / r[DENOMINATOR];
	}

	@Override // Implement the abstract longValue method in Number
	public long longValue() {
		return (long)doubleValue();
	}

	@Override // Implement the compareTo method in Comparable
	public int compareTo(Rational o) {
		if (this.subtract(o).getNumerator() > 0)
			return 1;
		else if (this.subtract(o).getNumerator() < 0)
			return -1;
		else
			return 0;
	}
}
