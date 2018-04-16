package exercise4;

public class Loan {
	private double annualInterestRate;
	private int numberOfYears;
	private double loanAmount;
	private java.util.Date loanDate;

	/** Default constructor */
	public Loan() {
		this(2.5, 1, 1000);
	}

	/** Construct a loan with specified annual interest rate,
 number of years, and loan amount
	 */
	public Loan(double annualInterestRate, int numberOfYears,
			double loanAmount) throws IllegalArgumentException {
		
		// parse the input, throw exception if necessary
		if(annualInterestRate <= 0)
			throw new IllegalArgumentException(
					"Wrong input: annualInterestRate less than or equal to zero: " + annualInterestRate);				
		if(numberOfYears <= 0)
			throw new IllegalArgumentException(
					"Wrong input: numberOfYears less than or equal to zero: " + numberOfYears);
		if(loanAmount <= 0)
			throw new IllegalArgumentException(
					"Wrong input: loanAmount less than or equal to zero: " + loanAmount);
			
		this.annualInterestRate = annualInterestRate;
		this.numberOfYears = numberOfYears;
		this.loanAmount = loanAmount;
		loanDate = new java.util.Date();
	}

	/** Return annualInterestRate */
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	/** Set a new annualInterestRate */
	public void setAnnualInterestRate(double annualInterestRate)
			throws IllegalArgumentException {
		
		//parse the input
		if(annualInterestRate <= 0)
			throw new IllegalArgumentException(
					"Wrong input: annualInterestRate less than or equal to zero: " + annualInterestRate);				
		
		this.annualInterestRate = annualInterestRate;
	}

	/** Return numberOfYears */
	public int getNumberOfYears() {
		return numberOfYears;
	}

	/** Set a new numberOfYears */
	public void setNumberOfYears(int numberOfYears)
			throws IllegalArgumentException {
		
		//parse the input
		if(numberOfYears <= 0)
			throw new IllegalArgumentException(
					"Wrong input: numberOfYears less than or equal to zero: " + numberOfYears);
			
		this.numberOfYears = numberOfYears;
	}

	/** Return loanAmount */
	public double getLoanAmount() {
		return loanAmount;
	}

	/** Set a new loanAmount */
	public void setLoanAmount(double loanAmount) throws IllegalArgumentException {
		
		if(loanAmount <= 0)
			throw new IllegalArgumentException(
					"Wrong input: loanAmount less than or equal to zero: " + loanAmount);
		
		this.loanAmount = loanAmount;
	}

	/** Find monthly payment */
	public double getMonthlyPayment() {
		double monthlyInterestRate = annualInterestRate / 1200;
		double monthlyPayment = loanAmount * monthlyInterestRate / (1 -
				(1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
		return monthlyPayment;
	}

	/** Find total payment */
	public double getTotalPayment() {
		double totalPayment = getMonthlyPayment() * numberOfYears * 12;
		return totalPayment;
	}

	/** Return loan date */
	public java.util.Date getLoanDate() {
		return loanDate;
	}
}