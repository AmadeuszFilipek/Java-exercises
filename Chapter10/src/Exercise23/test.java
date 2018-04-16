package Exercise23;

import java.util.Arrays;

public class test {

	public static void main(String[] args) {
	// TODO Auto-generated method stub

		MyString2 str = new MyString2("Ania zbiera ró¿owe ró¿e na ró¿aniec.");
		
		char[] array = str.toChars();
		
		System.out.println(Arrays.toString(array));

		array = str.substring(5).toChars();
		
		System.out.println(Arrays.toString(array));
		
		array = MyString2.valueOf(true).toChars();
		
		System.out.println(Arrays.toString(array));
		
	}

}
