package Exercise8;
/** 									Tax UML
 * ---------------------------------------------------
 * -filingStatus: int
 * -brackets: int[][]
 * -rates: double[]
 * -taxableIncome: double
 * +_SINGLE_FILER: int
 * +_MARRIED_JOINTLY_OR_QUALIFYING_WIDOWER: int
 * +_MARRIED_SEPARATELY: int
 * +_HEAD_OF_HOUSEHOLD: int
 * ----------------------------------------------------
 * +Tax()
 * +Tax(filingStatus: int, brackets: int[][], rates: double[], taxableIncome: double)
 * +getFilingStatus(): int
 * +getBrackets(): int[][]
 * +getRates(): double[]
 * +getTaxableIncome(): double
 * +setFilingStatus(newStatus: int): void
 * +setBrackets(newBrackets: int[][]): void
 * +setRates(newRates: double[]): void
 * +setTaxableIncome(newIncome: double): void
 * +getTax(): double
 * ------------------------------------------------------
 * 
 * @author Amadeusz
 *
 */
public class Tax {

	private int filingStatus;
	private int[][] brackets;
	private double[] rates;
	private double taxableIncome;
	
	public static final int SINGLE_FILER = 0;
	public static final int MARRIED_JOINTLY_OR_QUALIFYING_WIDOWER = 1;
	public static final int MARRIED_SEPARATELY = 2;
	public static final int HEAD_OF_HOUSEHOLD = 3;
	
	public Tax() {
		
		double[] defaultRates = {0.10, 0.15, 0.25, 0.28, 0.33, 0.35};
		int[][] defaultBrackets = {
				{8350, 33950, 82250, 171550, 372950}, // Single filer
				{16700, 67900, 137050, 20885, 372950}, // Married jointly -or qualifying widow(er)
				{8350, 33950, 68525, 104425, 186475}, // Married separately
				{11950, 45500, 117450, 190200, 372950} // Head of household
				};

		rates = defaultRates;
		brackets = defaultBrackets;
		filingStatus = SINGLE_FILER;
		taxableIncome = 0;
	}
	
	/** use with static filing statuses Tax.SINGLE_FILER etc. */
	public Tax(int filingStatus, int[][] brackets, double[] rates, double taxableIncome) {
		if (filingStatus >= 0 && filingStatus < 4)
			this.filingStatus = filingStatus;
		
		this.brackets = brackets;
		this.rates = rates;
		this.taxableIncome = taxableIncome;
	}

	public int getFilingStatus() {
		return filingStatus;
	}

	public void setFilingStatus(int filingStatus) {
		if (filingStatus >= 0 && filingStatus < 4)
			this.filingStatus = filingStatus;
	}

	public int[][] getBrackets() {
		return brackets;
	}

	public void setBrackets(int[][] brackets) {
		this.brackets = brackets;
	}

	public double[] getRates() {
		return rates;
	}

	public void setRates(double[] rates) {
		this.rates = rates;
	}

	public double getTaxableIncome() {
		return taxableIncome;
	}

	public void setTaxableIncome(double taxableIncome) {
		this.taxableIncome = taxableIncome;
	}

	public double getTax() {

		double tax = 0;
		int i = filingStatus;

		if (taxableIncome <= brackets[i][0])
			tax = taxableIncome * rates[0];
		else if (taxableIncome <= brackets[i][1])
			tax = brackets[i][0] * rates[0] + (taxableIncome - brackets[i][0]) * rates[1];
		else if (taxableIncome <= brackets[i][2])
			tax = brackets[i][0] * rates[0] + (brackets[i][1] - brackets[i][0]) * rates[1] +
			(taxableIncome - brackets[i][1]) * rates[2];
		else if (taxableIncome <= brackets[i][3])
			tax = brackets[i][0] * rates[0] + (brackets[i][1] - brackets[i][0]) * rates[1] +
			(brackets[i][2] - brackets[i][1]) * rates[2] + (taxableIncome - brackets[i][2]) * rates[3];
		else if (taxableIncome <= brackets[i][4])
			tax = brackets[i][0] * rates[0] + (brackets[i][1] - brackets[i][1]) * rates[1] +
			(brackets[i][2] - brackets[i][1]) * rates[2] + (brackets[i][3] - brackets[i][2]) * rates[3] +
			(taxableIncome - brackets[i][3]) * rates[4];
		else
			tax = brackets[i][0] * rates[0] +
			(brackets[i][1] - brackets[i][0]) * rates[1] +
			(brackets[i][2] - brackets[i][1]) * rates[2] +
			(brackets[i][3] - brackets[i][2]) * rates[3] +
			(brackets[i][4] - brackets[i][3]) * rates[4] +
			(taxableIncome - brackets[i][4]) * rates[5];					

		return tax;
	}	
}
