package exercises;

import java.util.ArrayList;
import java.util.Scanner;

public class exercise17 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter an integer m: ");
		int m = scanner.nextInt();
		int n = missingToPeferctSquare(m);
		scanner.close();
		
		System.out.println("The smallest number n for n * m to be a perfect square is " + n);
		System.out.println("m * n = " + n * m);
		
	}
	
	/** Computes the number @n has to be multiplied in order to become smallest perfect square.
	 *  For example. 90 = 2 * 5 * 9 so result is 2 * 5 = 10. 900 is perfect square. sqrt(900) = 30.
	 * @param n
	 * @return - value to be multiplied for n to become perfect square.
	 */
	public static int missingToPeferctSquare(int n) {
		if (n < 0)
			n *= -1;
		if (n <= 1)
			return 1;
		
		ArrayList<Integer> factors = new ArrayList<>();
		int temp = n, i = 2;
		
		while (temp != 1) {
			if (temp % i == 0) {
				temp /= i;
				factors.add(i);
				System.out.println(temp);
			}
			else i++;
		}
	
		removeOdd(factors);
		removeDuplicate(factors);
		
		int result = 1;
		
		for(Integer j: factors)
			result *= j;
		
		return result;
	}
	
	/** [11.13]  */
	public static void removeOdd(ArrayList<Integer> list) {
		ArrayList<Integer> toRemove = new ArrayList<>();
		
		//find the numbers that appear even number of times
		for(int i = 0; i < list.size(); i++) {
			int temp = list.get(i);
			int count = 0;
			for(int j = 0; j < list.size(); j++) {
				if(list.get(j) == temp)
					count++;			
			}
			
			if (count % 2 == 0) // is even
				toRemove.add(temp);
		}
		
		//now delete the numbers
		for(int i = 0; i < toRemove.size(); i++) {
			for(int j = 0; j < list.size(); j++) {
				if (list.get(j) == toRemove.get(i))
					list.remove(j);
			}	
		}	
	}
	
	public static void removeDuplicate(ArrayList<Integer> list) {
		
		for(int i = 0; i < list.size(); i++) {
			int temp = list.get(i);	
			
			for(int j = i + 1; j < list.size(); j++) {
				if(list.get(j) == temp) {
					list.remove(j);			
					j--; // because of list.size() changes
				}
			}
		}
	}
}
