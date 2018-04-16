package exercises;

import java.util.ArrayList;
import java.util.Scanner;

public class exercise4 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		ArrayList<Integer> array = new ArrayList<>();
		
		System.out.println("Enter integer numbers(0 ends the input): ");
		while(true){
			if (scanner.hasNextInt()) {
				int temp = scanner.nextInt();
				array.add(temp);
				if (temp == 0)
					break;
			}
			else scanner.next();
		}
		scanner.close();
		
		System.out.println("The max value is " + max(array));
	}
	
	public static Integer max(ArrayList<Integer> list) {
		if (list.size() == 0)
			return null;
		
		Integer max = list.get(0);
		
		for(Integer i : list) {
			if (i.compareTo(max) > 0)
				max = i;
		}
		
		return max;
	}
}
