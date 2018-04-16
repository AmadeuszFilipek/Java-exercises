package Exercises;

public class Exercise26 {
	public static void main(String[] args) {
		// Check number of strings passed
		if (args.length < 1) {
			System.out.println(
					"Usage: java \"Calculator operand1 operator operand2\"");
			System.exit(0);
		}
		
		if(!args[0].matches("[\\s]*[\\d]+[\\s]*[+\\-*/][\\s]*[\\d]+[\\s]*")) {
			System.out.println(
					"Usage: java \"Calculator operand1 operator operand2\"");
			System.exit(0);
		}
		
		// The result of the operation
		int result = 0;
		String[] splited = split(args[0].trim(), "+-*/");
		splited[0] = splited[0].trim();
		splited[2] = splited[2].trim();
		int leftNumber = Integer.parseInt(splited[0]);
		int rightNumber = Integer.parseInt(splited[2]);
		// Determine the operator
		switch (splited[1].charAt(0)) {
		case '+': result = leftNumber + rightNumber;
		break;
		case '-': result = leftNumber - rightNumber;
		break;
		case '*': result = leftNumber * rightNumber;
		break;
		case '/': result = leftNumber / rightNumber;
		}

		// Display result
		System.out.println(leftNumber + " " + splited[1] + " " + rightNumber
				+ " = " + result);
	}
	
	/** [10.25] like a split but also hold the delimeters */
	public static String[] split(String s, String regex) {
		if (s == null || regex == null)
			return null;
		
		if (regex.length() == 0) {
			String[] result = new String[1];
			result[0] = s;
			return result;
		}
		
		//count the occurrences of regex symbols, needed to initialize the array
		int stringCount = 0;
		
		for(int i = 0; i < s.length(); i++) 
			for (int d = 0; d < regex.length(); d++) 
				if(s.charAt(i) == regex.charAt(d))
					stringCount++;
		
		//begin collecting the substrings, store them in stringbuilder
		String[] result = new String[stringCount * 2 + 1];
		stringCount = 0;
		StringBuilder temp = new StringBuilder();
		
		for(int i = 0; i < s.length(); i++) {
			temp.append(s.charAt(i));
			
			for (int d = 0; d < regex.length(); d++) {
				
				if(s.charAt(i) == regex.charAt(d)) {
					result[stringCount] = temp.substring(0, temp.length() - 1).toString();
					temp.delete(0, temp.length());
					stringCount++;
					result[stringCount] = regex.charAt(d) + "";
					stringCount++;
				}	
				
			}
		}
		
		//add the last segment after the last delimeter or perhaps first at all
		result[stringCount] = temp.toString();
		
		return result;
	}
}