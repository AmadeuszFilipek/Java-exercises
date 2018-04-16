package Exercise22;

public class test {

	public static void main(String[] args) {
	// TODO Auto-generated method stub

		char[] array = {'a', 'b', 'c', 'd', 'b', 'c', 'd', 'b', 'c', 'd', 'b', 'c', 'd'};
		MyString1 str = new MyString1(array);
		
		for(int i = 0; i < str.length(); i++)
			System.out.print(str.charAt(i));
		
		str = str.subString(0, 1);
		
		System.out.println();
		for(int i = 0; i < str.length(); i++)
			System.out.print(str.charAt(i));
		
		System.out.println();
		char[] array2 = {'a'};
		System.out.println(str.equals(new MyString1(array2)));
		
		str = MyString1.valueOf(123456789);
		System.out.println();
		for(int i = 0; i < str.length(); i++)
			System.out.print(str.charAt(i));
		
	}

}
