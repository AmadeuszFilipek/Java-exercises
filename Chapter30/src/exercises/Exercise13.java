package exercises;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class Exercise13 {

	public static void main(String[] args) {
		final int SIZE = 7000000;
		Integer[] list1 = new Integer[SIZE];
		Integer[] list2 = new Integer[SIZE];

		for (int i = 0; i < list1.length; i++) {
			list1[i] = list2[i] = (int)(Math.random() * 10000000);
		}

		long startTime = System.currentTimeMillis();
		parallelMergeSort(list1); //invoke parallel merge sort
		long endTime = System.currentTimeMillis();
		System.out.println("\nParallel time with "
				+ Runtime.getRuntime().availableProcessors() + 
				" processors is " + (endTime - startTime) + " milliseconds");
		}

	public static <E extends Comparable<E>> void parallelMergeSort(E[] list) {
		SortTask<E> mainTask = new SortTask<>(list);
		ForkJoinPool pool = new ForkJoinPool();
		pool.invoke(mainTask);		
	}

	@SuppressWarnings("serial")
	private static class SortTask <E extends Comparable<E>> extends RecursiveAction {
		private final int THRESHOLD = 500;
		private E[] list;

		SortTask(E[] list) {
			this.list = list;
		}

		// the compute() method is overridden to implement a recursive merge sort 
		@Override
		protected void compute() {
			if (list.length < THRESHOLD)
				java.util.Arrays.sort(list);
			else {
				//obtain first half
				E[] firstHalf = (E[]) new Comparable[list.length / 2];
				System.arraycopy(list, 0, firstHalf, 0, list.length / 2);

				//obtain second half
				int secondHalfLength = list.length - list.length / 2;
				E[] secondHalf = (E[]) new Comparable[secondHalfLength];
				System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalfLength);
				
				// recursively sort the two halves
				invokeAll(new SortTask<E>(firstHalf), new SortTask<E>(secondHalf));

				// merge the halves into the list, merge was implemented in chapter23
				merge(firstHalf, secondHalf, list);
			}
		}		
	}	
	
	public static <E extends Comparable<E>> void merge(E[] list1, E[] list2, E[] temp) {
		int current1 = 0;
		int current2 = 0;
		int current3 = 0;
		
		while (current1 < list1.length && current2 < list2.length) {
													
			if (list1[current1].compareTo(list2[current2]) < 0)
				temp[current3++] = list1[current1++];
			else
				temp[current3++] = list2[current2++];
		}
			
		while (current1 < list1.length)
			temp[current3++] = list1[current1++];
		
		while(current2 < list2.length)
			temp[current3++] = list2[current2++];	
	}
}
