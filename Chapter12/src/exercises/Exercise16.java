package exercises;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.List;

public class Exercise16 {
	public static void main(String[] args) {
		// Check command line parameter usage
		if (args.length != 3) {
			System.out.println(
					"Usage: java ReplaceText file oldStr newStr");
			System.exit(1);
		}

		// Check if file exists
		File file = new File(args[0]);
		if (!file.exists()) {
			System.out.println("Source file " + args[0] + " does not exist");
			System.exit(2);
		}

		try {
			//read the whole file		
			List<String> content = Files.readAllLines(file.toPath());

			//write modified content to the file
			PrintWriter output = new PrintWriter(file);
			for(String line: content) 
				output.println(line.replaceAll(args[1], args[2]));
			
			
			output.close(); //perhaps i should write a nested try for this
		}
		catch(FileNotFoundException e) {
			System.out.println(e);
		}
		catch (IOException e) {
			System.out.println("Input/output error: cannot read the file." + file.getName());
			System.exit(3);
		}
	}
}










