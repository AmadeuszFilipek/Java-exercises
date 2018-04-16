package Exercise23;

public class MyString2 {

	private char[] content;
	private int length;
	
	public MyString2(String s) {
		content = s.toCharArray();
		length = s.length();
	}
	
	public int compare(String s) {
		
		int minLength = s.length() > content.length ? content.length : s.length();
		int i = 0;
		
		while(i < minLength) {
			if (s.charAt(i) == content[i]) {
				i++;
				continue;
			}
			else if (s.charAt(i) > content[i])
				return -1;
			else
				return 1;	
		}
		
		return 0;
	}
	
	public MyString2 substring(int begin) {
		if (begin >= length || begin < 0)
			return null;
		
		char[] temp = new char[length - begin];
		
		for(int i = begin; i < length; i++)
			temp[i - begin] = content[i];
		
		return new MyString2(new String(temp));	
	}
	
	public MyString2 toLowerCase() {
		char[] temp = new char[length];
		for(int i = 0; i < length; i++)
			temp[i] = Character.toUpperCase(content[i]);
		
		return new MyString2(new String(temp));
	}
	
	public char[] toChars() {
		char[] result = new char[length];
		System.arraycopy(content, 0, result, 0, length);
		return result;
	}
	
	public static MyString2 valueOf(boolean b) {
		if (b)
			return new MyString2("true");
		else
			return new MyString2("false");
	}
}
