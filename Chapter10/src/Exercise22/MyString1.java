package Exercise22;

public class MyString1 {

	private char[] content;
	private int length;
	
	public MyString1(char[] chars) {
		length = chars.length;
		content = new char[length];
		System.arraycopy(chars, 0, content, 0, length);
	}
	
	public char charAt(int index) {
			return content[index]; // indexOutOfBondsError if index is outside
	}
	
	public int length() {
		return length;
	}
	/** pad with whitespace if end is > this.length() */
	public MyString1 subString(int begin, int end) {
		if (begin >= length || begin < 0 || end < 0 || end < begin)
			return null;
		
		char[] temp = new char[end - begin];
		
		if(end < length) {
			for(int i = begin; i < end; i++)
				temp[i - begin] = content[i];
		}
		else {
			for(int i = begin; i < length; i++)
				temp[i - begin] = content[i];
			for(int i = length; i < temp.length; i++)
				temp[i] = ' ';
		}
		
		return new MyString1(temp);
	}
	
	public MyString1 toLowerCase() {
		char[] temp = new char[length];
		for(int i = 0; i < length; i++)
			temp[i] = Character.toLowerCase(content[i]);
		
		return new MyString1(temp);
	}
	
	public boolean equals(MyString1 s) {
		if(length != s.length)
			return false;
		
		for(int i = 0; i < length; i++) {
			if(content[i] != s.charAt(i))
				return false;
		}
		
		return true;
	}
	
	public static MyString1 valueOf(int i) {
		//find the needed length for the char array
		int decimals = 0;
		int temp = i;
		while(temp > 0) {
			temp = temp / 10;
			decimals++;
		}
		
		// case of i = 0
		if (decimals == 0)
			decimals = 1;
		
		//get each digit
		char[] result = new char[decimals];
		for(int j = decimals - 1; j >= 0; j--){
			result[j] = (char)('0' + i % 10);
			i = i / 10;
		}
		
		return new MyString1(result);
	}
}
