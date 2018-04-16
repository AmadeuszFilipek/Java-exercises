package exercises;

import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.Scanner;

public class Exercise11 {

	/** uses arguments from commands line */
	public static void main(String[] args) {

		if (args.length != 2) {
			System.out.println("Usage: textToDelate filename");
			System.exit(1);
		}

		File file = new File(args[1]);
		File newFile = new File("temporary.txt");
		
		if(!file.exists()) {
			System.out.println("The file " + args[1] + " does not exist.");
			System.exit(2);
		}
		
		//copy the desired content from old file to a new one
		try (
				Scanner fileContent = new Scanner(file);
				PrintWriter output = new PrintWriter(newFile);
				) {
			while(fileContent.hasNext()) {
				String temp = fileContent.nextLine();
				temp = temp.replaceAll(args[0], "");
				output.println(temp);
			}
		} catch(Exception e){
			System.out.println(e);
			System.exit(3);
		}
		
		// delete the old file and rename the new one
		try {
			Files.delete(file.toPath());
			newFile.renameTo(file);
			
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}
