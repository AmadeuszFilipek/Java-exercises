package Exercises;

import java.util.Arrays;

public class Exercise16 {

	public static void main(String[] args) {
		
		int N = 10000000;
		int[] array = new int[N];
		int key = (int)Math.round(Integer.MAX_VALUE * (Math.random() - 0.5));
		
		for(int i = 0; i < array.length; i++) {
			array[i] = (int)Math.round(Integer.MAX_VALUE * (Math.random() - 0.5));
		}
		
		long startTime = System.currentTimeMillis();
		int linearSearchResult = linearSearch(array, key);
		long endTime = System.currentTimeMillis();
		long linearSearchExecutionTime = endTime - startTime;
		
		Arrays.sort(array);
		
		startTime = System.currentTimeMillis();
		int binarySearchResult = binarySearch(array, key);
		endTime = System.currentTimeMillis();
		long binarySearchExecutionTIme = endTime - startTime;
		
		System.out.println("The linear search result is " + 
		linearSearchResult + " and it's execution time is " + linearSearchExecutionTime);
	
		System.out.println("The binary search result is " + 
				binarySearchResult + " and it's execution time is " + binarySearchExecutionTIme);
			
	}

	public static int linearSearch(int[] list, int key) {
		for (int i = 0; i < list.length; i++) {
			if (key == list[i])
				return i;
		}
		return -1;
	}

	public static int binarySearch(int[] list, int key) {
		int low = 0;
		int high = list.length - 1;

		while (high >= low) {
			int mid = (low + high) / 2;
			if (key < list[mid])
				high = mid - 1;
			else if (key == list[mid])
				return mid;
			else
				low = mid + 1;
		}

		return -low - 1; // Now high < low, key not found
	}
}
