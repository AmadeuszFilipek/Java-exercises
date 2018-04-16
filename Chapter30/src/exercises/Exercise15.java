package exercises;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Exercise15 {

	public static void main(String[] args) {

		double[] list = new double[9000000];
		Random rng = new Random();
		for(int i = 0; i < list.length; i++)
			list[i] = rng.nextDouble();
		
		long startTime = System.currentTimeMillis();
		Double sum = parallelSum(list); //invoke parallel quick sort
		long endTime = System.currentTimeMillis();
		System.out.println("\nParallel sum time with "
				+ Runtime.getRuntime().availableProcessors() + 
				" processors is " + (endTime - startTime) + " milliseconds");
		System.out.println("The sum is " + sum);
	}

	public static double parallelSum(double[] list) {
		SumTask mainTask = new SumTask(list);
		ForkJoinPool pool = new ForkJoinPool();
		return pool.invoke(mainTask);
	}

	public static class SumTask extends RecursiveTask<Double> {

		private static final int THRESHOLD = 1000;
		private double[] list;
		
		public SumTask(double[] list) {
			this.list = list;
		}
		
		@Override
		protected Double compute() {
			
			//conquer
			if (list.length < THRESHOLD) {
				double sum = 0;
				for(int i = 0; i < list.length; i++)
					sum += list[i];
				
				return sum;
			}
			//divide
			else {
				int mid = list.length / 2;
				double[] left = new double[mid];
				System.arraycopy(list, 0, left, 0, mid);
				
				int top = list.length - mid;
				double[] right = new double[top];
				System.arraycopy(list, mid, right, 0, top);
				
				SumTask leftSum = new SumTask(left);
				SumTask rightSum = new SumTask(right);
				
				leftSum.fork();
				rightSum.fork();
				
				return leftSum.join() + rightSum.join();	
			}
		}
	}
}
