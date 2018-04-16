package Exercise8;

public class test {

	public static void main(String[] args) {
		
		Tax tax = new Tax();
		
		double[] temp = new double[4];
		System.out.println("Income\tSingle filers\tMarried filing jointly\tMarried filing");
		System.out.println("\t\tor qualifying widowe(er)\tseparately\tHead of household");
		System.out.println("____________________________________________________________________");
		for(int i = 50000; i < 60000; i += 1000) {
			
			tax.setTaxableIncome(i);
			tax.setFilingStatus(Tax.SINGLE_FILER);
			temp[0] = tax.getTax();
			
			tax.setFilingStatus(Tax.MARRIED_JOINTLY_OR_QUALIFYING_WIDOWER);
			temp[1] = tax.getTax();
			
			tax.setFilingStatus(Tax.MARRIED_SEPARATELY);
			temp[2] = tax.getTax();
			
			tax.setFilingStatus(Tax.HEAD_OF_HOUSEHOLD);
			temp[3] = tax.getTax();
			
			System.out.printf("%d\t%10.2f\t%10.2f\t%10.2f\t%10.2f\n",
					i, temp[0], temp[1], temp[2], temp[3]);
		}
	}
}
