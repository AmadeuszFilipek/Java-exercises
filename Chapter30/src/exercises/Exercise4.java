package exercises;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Exercise4 {

	public static Value sum = new Value();
	
//	public static Integer sum = new Integer(0);

	public static void main(String[] args) {

		ExecutorService executor = Executors.newCachedThreadPool();

		for(int i = 0; i < 1000; i++) {
			Thread newThread = new Thread(new Incrementor());
			newThread.setDaemon(true);
			executor.execute(newThread);
		}

		try {
			executor.shutdown();
			while(!executor.awaitTermination(Long.MAX_VALUE, TimeUnit.MINUTES));
			System.out.println(executor);
			System.out.println(sum.get());
		}
		catch(InterruptedException ex) {
			System.out.println(ex);
		}
	}

	public static class Value {
		public Integer sum = 0;
		
		public void inc() {
			sum += 1;
		}
		
		public int get() {
			return sum;
		}
	}
	
	public static class Incrementor implements Runnable {

		public void run() {
			synchronized(sum) {
				sum.inc();
			}
		}
	}
}
