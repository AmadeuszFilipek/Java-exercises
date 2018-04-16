package exercises;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class Exercise14 {

	public static void main(String[] args) {

		int[] list = new int[9000000];
		Random rng = new Random();
		for(int i = 0; i < list.length; i++)
			list[i] = rng.nextInt(10000);
		
		long startTime = System.currentTimeMillis();
		parallelQuickSort(list); //invoke parallel quick sort
		long endTime = System.currentTimeMillis();
		System.out.println("\nParallel quick sort time with "
				+ Runtime.getRuntime().availableProcessors() + 
				" processors is " + (endTime - startTime) + " milliseconds");
	
		for(int i = 0; i < list.length; i++)
			list[i] = rng.nextInt(10000);
		
//		startTime = System.currentTimeMillis();
//		quickSort(list);
//		endTime = System.currentTimeMillis();
//		System.out.println("Linear quick sort time is " + (endTime - startTime) + " miliseconds");


	}

	public static void quickSort(int[] list) {
		quickSort(list, 0, list.length - 1);	
	}

	public static void quickSort(int[] list, int first, int last){
		if (last > first){
			int pivotIndex = partition(list, first, last);
			quickSort(list, first, pivotIndex - 1);
			quickSort(list, pivotIndex + 1, last);	
		}
	}

	public static int partition(int[] list, int first, int last) {
		int pivot = list[first]; // first element as pivot
		int low = first + 1;
		int high = last;

		while (high > low) {
			while (low <= high && list[low] <= pivot) low++;	

			while(low <= high && list[high] > pivot) high--;

			if (high > low) {
				int temp = list[high];
				list[high] = list[low];
				list[low] = temp;
			}
		}

		while (high > first && list[high] >= pivot) high--;

		if (pivot > list[high]) {
			list[first] = list[high];
			list[high] = pivot;
			return high;
		}
		else
			return first;
	}

	public static void parallelQuickSort(int[] list) {

		QuickSortAction mainTask = new QuickSortAction(list);
		ForkJoinPool fork = new ForkJoinPool();
		fork.invoke(mainTask);

	}

	public static class QuickSortAction extends RecursiveAction {

		private int[] list;
		private int first;
		private int last;

		public QuickSortAction(int[] list) {
			this(list, 0, list.length - 1);
		}

		public QuickSortAction(int[] list, int first, int last) {
			this.list = list;
			this.first = first;
			this.last = last;
		}

		@Override
		protected void compute() {

			if (last > first) {
				int pivotIndex = partition(list, first, last);

				QuickSortAction left = new QuickSortAction(list, first, pivotIndex - 1);
				QuickSortAction right = new QuickSortAction(list, pivotIndex + 1, last);

				left.fork();
				right.fork();		
			}
		}

		private static int partition(int[] list, int first, int last) {
			int pivot = list[first]; // first element as pivot
			int low = first + 1;
			int high = last;

			while (high > low) {
				while (low <= high && list[low] <= pivot) low++;	

				while(low <= high && list[high] > pivot) high--;

				if (high > low) {
					int temp = list[high];
					list[high] = list[low];
					list[low] = temp;
				}
			}

			while (high > first && list[high] >= pivot) high--;

			if (pivot > list[high]) {
				list[first] = list[high];
				list[high] = pivot;
				return high;
			}
			else
				return first;
		}
	}
}
