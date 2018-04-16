package exercise17;

public class Complex implements Cloneable {

	private double real;
	private double imaginary;
	
	public Complex() {}
	
	public Complex(double a) { 
		this(a, 0);
		
	}
	
	public Complex(double a, double b) {
		real = a;
		imaginary = b;
	}
	
	/** Adds c to this number and returns this number. */
	public Complex add(Complex c) {
		
		double newReal = real + c.real;
		double newImaginary = imaginary + c.imaginary;
	  
	  Complex result = new Complex(newReal, newImaginary);
	  
	  return result;
	}
	
	public Complex substract(Complex c) {
		
		double newReal = real - c.real;
	  double newImaginary = imaginary - c.imaginary;
		
	  Complex result = new Complex(newReal, newImaginary);
	  
		return result;
	}
	
	public Complex multiply(Complex c) {
		
		double newReal = real * c.real - imaginary * c.imaginary;
		double newImaginary = imaginary * c.real + real * c.imaginary;
		
		Complex result = new Complex(newReal, newImaginary);
		
		return result;
	}
	
	public Complex divide(Complex c) {
	  double newReal = (real * c.real + imaginary * c.imaginary) / (c.real * c.real + c.imaginary * c.imaginary);
	  double newImaginary = (imaginary * c.real - real * c.imaginary) / (c.real * c.real + c.imaginary * c.imaginary);
	  
	  Complex result = new Complex(newReal, newImaginary);
	  
	  return result;
	}
	
	public static double abs(Complex c) {
		return Math.sqrt(c.real * c.real + c.imaginary + c.imaginary);
	}
	
	public double abs() {
		return Math.sqrt(real * real + imaginary * imaginary);
	}
	
	public double getReal() {
		return real;
	}
	
	public double getImaginary() {
		return imaginary;
	}

	//I could also just omit the whole declaration here
	public Object Clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	@Override
	public String toString() {
		if (Math.abs(imaginary) < Math.pow(10, -8))
			return Double.toString(real);
		else
			return "(" + real + " + " + imaginary + "i)";
	}
}

