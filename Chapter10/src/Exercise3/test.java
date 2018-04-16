package Exercise3;

public class test {

	public static void main(String[] args) {
		
		MyInteger number = new MyInteger(12495);
		System.out.println(number.getValue() + " is even " + number.isEven());

		System.out.println(number.getValue() + " is odd " + number.isOdd());
		

		System.out.println(number.getValue() + " is prime " + number.isPrime());
		
		System.out.println(MyInteger.parseInt("-12345"));
		char[] text = {'-', '2', '3', '4', '5'};
		
		System.out.println(MyInteger.parseInt(text));
		
		
	}
}
