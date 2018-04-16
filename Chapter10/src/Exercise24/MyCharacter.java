package Exercise24;
// exercise is pretty much ambiguous, so i just created what i guessed
public class MyCharacter {

	private char c;
	public static final int BYTES = 8;
	public static final int MAX_LENGTH = 1 << 7;
	
	public MyCharacter(char c) {
		this.c = c; 
	}
	
	public MyCharacter(int i) {
		this.c = (char)i;
	}
	
	public char getChar(){
		return c;
	}
	
	public static boolean isLetter(char c) {
		if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))
			return true;
		
		return false;
	}
	
	public static boolean isDigit(char c) {
		if (c >= '0' && c <= '9')
			return true;
		
		return false;
	}
	
	public static boolean isLetterOrDigit(char c) {
		return isLetter(c) || isDigit(c);
	}
	
	public static char toUppercase(char c) {
		if ((c >= 'A' && c <= 'Z') ||
				c < 'a' || c > 'z')
			return c;
	
		int temp = (int)c - ((int)'a' - (int)'A');
			 
		return (char)temp;
	}
	
	public static char toLowercase(char c) {
		if ((c >= 'a' && c <= 'z') ||
				c < 'A' || c > 'Z')
			return c;
		
		int temp = (int)c + ((int)'a' - (int)'A');
		
		return (char)temp;
	}
	
	/** lexicographically compare two characters*/
	public int compare(char c) {
		if (this.c == c)
			return 0;
		else if (this.c > c)
			return -1;
		else
			return 1;
	}
	
	public int compare(MyCharacter c) {
		return compare(c.getChar());
	}
	
	public boolean equals(char c){
		return this.c == c;
	}
	
	public boolean equals(MyCharacter c) {
		return equals(c.getChar());
	}
	
	public String toString() {
		return c + "";
	}
}
