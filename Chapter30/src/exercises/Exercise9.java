package exercises;

import java.util.Random;
import java.util.Set;

public class Exercise9 {

	public static void main(String[] args) {

		Set<Number> set = new java.util.HashSet<>();
		set.add(new Integer(0));
		set.add(new Integer(1));
		set.add(new Integer(2));
		set.add(new Integer(3));

		Thread iteratorThread = new Thread(() -> {

			try {
				while(true) {
					for(Number i : set) {
						System.out.println(i);
					}
					Thread.sleep(1000);
				}
			} catch(InterruptedException ex) {
				System.out.println(ex.getMessage());
			}
		});
		iteratorThread.setDaemon(true);
		iteratorThread.start();

		Random rng = new Random();

		while(true) {
			try {
				set.add(rng.nextInt(100));
				Thread.sleep(1000);
			} catch(InterruptedException ex) {
				System.out.println(ex.getMessage());
				System.exit(1);
			}
		}
	}
}
