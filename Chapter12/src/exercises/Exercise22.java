package exercises;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

public class Exercise22 {

	public static void main(String[] args) {
		// Check command line parameter usage
		if (args.length != 3) {
			System.out.println(
					"Usage: java dir oldString newString");
			System.exit(1);
		}

		// Check if the directory exists
		File dir = new File(args[0]);
		if (!dir.exists()) {
			System.out.println("Source file " + args[0] + " does not exist");
			System.exit(2);
		}

		if(!dir.isDirectory()) {
			System.out.println(dir.getAbsolutePath() + " is not a directory.");
			System.exit(3);
		}

		File[] files = dir.listFiles();

		//for each file in the directory
		for(int i = 0; i < files.length; i++) {

			if(files[i].isFile() && files[i].canRead() && files[i].canWrite()) {

				try {
					//open the file, read it, save the content to list and close it
					List<String> content = Files.readAllLines(files[i].toPath(), Charset.defaultCharset());

					//write modified content to the file
					try (PrintWriter output = new PrintWriter(files[i])) {

						//print some info about the current progress
						System.out.println("Parsing the file " + files[i].getName());

						//replace the strings
						for(String line: content) 
							output.println(line.replaceAll(args[1], args[2]));

					} //end try
					catch(FileNotFoundException e) {
						System.out.println("File not found " + files[i].getName());
					}
				} // end try
				catch(IOException e) { // thrown by line 42
					System.out.println("Input/output error: cannot read the file " + files[i].getName());
					continue;
				}
			}
		}
	}
}