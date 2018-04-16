package Exercise2;

public class test {

	public static void main(String[] args) {
		
		Stock oracle = new Stock("ORCL", "Oracle Corporation");
		oracle.previousClosingPrice = 34.5;
		oracle.currentPrice = 34.35;
		
		System.out.println("Price change percent is " + oracle.getChangePercent() + "%");
	}
}
