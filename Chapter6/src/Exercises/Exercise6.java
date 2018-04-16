package Exercises;

public class Exercise6 {

	public static void main(String[] args) {
		
		displayPattern(140);
		
		
	}
		
	public static void displayPattern(int n) {
		
		StringBuilder lastLine = new StringBuilder();
		StringBuilder line = new StringBuilder();
		StringBuilder blanks = new StringBuilder();
		
		for(int i = n; i > 0; i--) {
			lastLine.append(i).append(" ");
		}
		
		for(int i = 1; i <= n; i++) {
					
			for(int j = i; j >= 1; j--) 
				line.append(j).append(" ");

			for(int j = 0; j < lastLine.length() - line.length(); j++)
				blanks.append(" ");
			
			System.out.println(blanks.toString() + line.toString());
			blanks.delete(0, blanks.length());
			line.delete(0, line.length());
		}
		
	}
}
