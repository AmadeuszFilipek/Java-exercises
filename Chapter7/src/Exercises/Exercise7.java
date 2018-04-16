package Exercises;

public class Exercise7 {

	public static void main(String[] args) {
	
		int[] samples = new int[100];
		
		for (int i = 0; i < samples.length; i++) {
			samples[i] = randomInteger();
		}
		
		int[] histogram = countBins(samples);
		
		System.out.println("counts of each value occurance in 100 random integers :");
		for (int i = 0; i < histogram.length; i++) {
			System.out.print(histogram[i] + " ");
		}

	}

	public static int randomInteger() {
		return (int)Math.floor(Math.random() * 10);
	}
	public static int[] countBins(int[] samples) {
		
		int[] counts = new int[10];
		for(int i = 0; i < samples.length; i++) {
			for(int bin = 0; bin < counts.length; bin++) {
				
				if ( samples[i] == bin) {
					counts[bin]++;
				}
				
			}
		}
		return counts;
	}
}
