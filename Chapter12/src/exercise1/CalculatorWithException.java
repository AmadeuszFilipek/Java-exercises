package exercise1;

public class CalculatorWithException {
	/** Main method */
	public static void main(String[] args) {
		// Check number of strings passed
		if (args.length != 3) {
			System.out.println(
					"Usage: java Calculator operand1 operator operand2");
			System.exit(0);
		}

		// The result of the operation
		int result = 0;
		int leftNumber = 0;
		int rightNumber = 0;
		
		try {
			
			leftNumber = Integer.parseInt(args[0]);
			rightNumber = Integer.parseInt(args[2]);
			
		} catch (NumberFormatException e) {
			System.out.println("Wrong input: " + e.getMessage());
			System.exit(0);
		}
		
		if (args[1].charAt(0) == '/' && rightNumber == 0) {
			System.out.println("Cannot divide by 0");
			System.exit(0);
		}
		
		// Determine the operator
		switch (args[1].charAt(0)) {
		case '+': result = leftNumber + rightNumber;
		break;
		case '-': result = leftNumber - rightNumber;
		break;
		case '.': result = leftNumber * rightNumber;
		break;
		case '/': result = leftNumber / rightNumber;
		}

		// Display result
		System.out.println(args[0] + ' ' + args[1] + ' ' + args[2]
				+ " = " + result);
	}
}
