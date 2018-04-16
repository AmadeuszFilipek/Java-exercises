package exercises;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Exercise1 extends Application {

	private static TextArea tfOutput = new TextArea();
	
	// using a buffer guarantees that the resource is thread safe while building the string
	// another thread is created to check the running threads until they are finished
	// and then updates the text area
	private static StringBuffer buffer = new StringBuffer();

	public void start(Stage primaryStage) {

		Runnable printA = new PrintChar('a', 100);
		Runnable printB = new PrintChar('b', 100);
		Runnable print100 = new PrintNum(100);

		ArrayList<Thread> threadArray = new ArrayList<>();
		threadArray.add(new Thread(printA));
		threadArray.get(0).setPriority(10);
		threadArray.add(new Thread(printB));
		threadArray.add(new Thread(print100));

		tfOutput.setWrapText(true);
		tfOutput.setEditable(false);
		StackPane pane = new StackPane(tfOutput);

		Scene scene = new Scene(pane, 500, 300);
		primaryStage.setTitle("Exercise30_1");
		primaryStage.setScene(scene);
		primaryStage.show();

		for (Thread thread : threadArray) {
			thread.start();
		}

		Thread thread = new Thread(() -> {
			boolean running = true;
			while(running) {
				running = false;

				for (Thread tr : threadArray) {
					if (tr.isAlive()) {
						running = true;
						break;
					}
				}
			}
			tfOutput.setText(buffer.toString());
		});
		
		thread.start();
	}

	public class PrintChar implements Runnable {

		private char charToPrint; 
		private int times;

		public PrintChar(char c, int t) {
			charToPrint = c;
			times = t;
		}

		public void run() {

			for (int i = 0; i < times; i++) {
				buffer.append(charToPrint).append(" ");
			}
		}
	}

	public class PrintNum implements Runnable {

		private int lastNum;

		public PrintNum(int n) {
			lastNum = n;
		}

		public void run() {

			for (int i = 0; i <= lastNum; i++) {
				buffer.append(" ").append(i);

			}
		}
	}
}