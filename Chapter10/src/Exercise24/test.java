package Exercise24;

public class test {

	public static void main(String[] args) {
	
		MyCharacter c = new MyCharacter('q');
		
		System.out.println(MyCharacter.toUppercase('a'));
		
		System.out.println(MyCharacter.toLowercase('G'));
		
		System.out.println(MyCharacter.isDigit('6'));
		
		System.out.println(MyCharacter.isLetter('q'));
			
		System.out.println(c.compare('a'));
	}
}
