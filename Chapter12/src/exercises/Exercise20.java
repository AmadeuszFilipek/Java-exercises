package exercises;

import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.List;

public class Exercise20 {
	public static void main(String[] args) {
		
		if(args.length != 1) {
			System.out.println("Usage: srcRootDirectory");
			System.exit(1);
		}
		
		File root = new File(args[0]);
		
		if (root.exists() && root.isDirectory()) {
			try {
				//for each sub-directory chapter1-34, and for each file in sub-directory
				// copy file contents and delete the first line from it
				for (int i = 1; i <= 34; i++) {
					File chapterDirectory = new File(root.getAbsolutePath() + "\\chapter" + i);
					
					if (chapterDirectory.exists() && chapterDirectory.isDirectory()) {
						
						//Print a message that directory exists and is being looked through
						System.out.println("Parsing the directory: " + chapterDirectory.getAbsolutePath());
						
						File[] files = chapterDirectory.listFiles();
						
						// for each file in chapter directory remove the package statement
						for(int f = 0; f < files.length; f++) {
							if(files[f].isFile() && files[f].getName().matches("Exercise[0-9]+_[0-9]+.java")) {
								List<String> lines = Files.readAllLines(files[f].toPath());
								PrintWriter input = new PrintWriter(files[f]);
								
									//delete the statement in the first line
								for(String line : lines) {
									if (line.matches("package chapter" + i + ";.*"))
										continue;
									input.println(line);
								}
								
								input.close();
							}
						}	
					}
				}		
				
			} 
			catch(Exception e) {
				System.out.println(e);
			}
		}
		else {
			System.out.println("The path " + root.toPath() + " does not exist or is not a directory.");
			System.exit(1);
		}
	}
}
