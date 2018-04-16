package Exercises;

public class Exercise25 {

	public static void main(String[] args) {
		
		String[] strings = split("ab#12#45", "#");
		
		for(int i = 0; i < strings.length; i++)
			System.out.println(strings[i]);
		
		strings = split("fgdfga?dsadasb?gsdaasdf#eads", "[?#]");
		
		for(int i = 0; i < strings.length; i++)
			System.out.println(strings[i]);
		
		
	}
	
	/** splits a string into an array of strings, but adds delimeters into result */
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
