package exercise1;

public class CalculatorWithoutException {

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
			
			//no need to use exception handling here as it can be done with if block
			if(args[0].matches("[0-9]*")) {
				leftNumber = Integer.parseInt(args[0]);
			}
			else {
				System.out.println("Wrong input: " + args[0]);
				System.exit(0);
			}
			
			if(args[2].matches("[0-9]*")) {
				rightNumber = Integer.parseInt(args[2]);
			}
			else {
				System.out.println("Wrong input: " + args[2]);
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
