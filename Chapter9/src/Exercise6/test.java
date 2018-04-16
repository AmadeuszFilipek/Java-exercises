package Exercise6;

import java.util.Arrays;
import java.util.Random;

public class test {

	public static void main(String[] args) {
		
		Random rnd = new Random();
		
		int[] numbers = new int[100000];
		for(int i = 0; i < numbers.length; i++)
				numbers[i] = rnd.nextInt(1000);
		
		StopWatch watch = new StopWatch();
		watch.start();
		Arrays.sort(numbers);
		watch.stop();
		System.out.println(watch.getElapsedTime() + " ns");
	}
}
