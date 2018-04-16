package exercises;

import java.util.ArrayList;
import java.util.Date;

public class exercise6 {

	public static void main(String[] args) {
		
		ArrayList<Object> array = new ArrayList<>();
		
		array.add(new Date());
		array.add(new Loan());
		
		System.out.println(array);
		
	}
}
