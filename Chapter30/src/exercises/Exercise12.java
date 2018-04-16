package exercises;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class Exercise12 {

	public static void main(String[] args) {
		
		double[] list = new double[9000000];
						
		long startTime = System.currentTimeMillis();
		parallelAssignValues(list);
		long endTime = System.currentTimeMillis();
		
		System.out.println("The number of processors is " +
				Runtime.getRuntime().availableProcessors());
		System.out.println("Time of parallel function execution is " + (endTime - startTime) + " miliseconds");
		
		startTime = System.currentTimeMillis();
		linearAssignValues(list);
		endTime = System.currentTimeMillis();
		System.out.println("Time of linear function execution is " + (endTime - startTime) + " miliseconds");
	}
	
	public static void linearAssignValues(double[] list) {
		Random rng = new Random();
		
		for(int i = 0; i < list.length; i++) {
			list[i] = rng.nextDouble();
		}
	}
	
	public static void parallelAssignValues(double[] list) {
		
		RecursiveAction mainTask = new AssignValuesTask(list, 0, list.length);
		ForkJoinPool pool = new ForkJoinPool();
		pool.invoke(mainTask);
		
	}
	
	@SuppressWarnings("serial")
	private static class AssignValuesTask extends RecursiveAction {
		
		private static final int THRESHOLD = 1000;
		private Random rng = new Random();
		private double[] list;
		private int low;
		private int high;
		
		AssignValuesTask(double[] list, int low, int high) {
			this.list = list;
			this.low = low;
			this.high = high;
		}
		
		@Override
		protected void compute() {
			
			// if problem is small, conquer it
			// else divide the problem to subproblems
			if (high - low < THRESHOLD) {
				for(int i = low; i < high; i++)
					list[i] = rng.nextDouble();
		
			}
			else {
				int mid = (low + high) / 2;
				AssignValuesTask left = new AssignValuesTask(list, low, mid);
				AssignValuesTask right = new AssignValuesTask(list, mid, high);
				
				left.fork();
				right.fork();
			}
			
		}
		
		
		
	}
}
