package exercises;

import java.io.File;
import java.util.Scanner;

public class Exercise26 {

	public static void main(String[] args) {


		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a new directory name: ");
		String dirName = scanner.next();
		scanner.close();
		
		File dir = new File(dirName);
		
		if(dir.exists()) {
			if (dir.isDirectory())
				System.out.println("The directory already exits.");
			else
				System.out.println("A file with a given name already exists in the parent directory.");
				
				System.exit(1);
		}
		else {
			if (dir.mkdir())
				System.out.println("Directory created successfully.");
			else
				System.out.println("Failed to create a new directory.");
		}
		
	}

}
