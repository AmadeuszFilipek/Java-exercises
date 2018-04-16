package exercises;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise19 extends Application {

	private static Histogram selectionPane;
	private static Histogram insertionPane;
	private static Histogram bubblePane;

	public void start(Stage primaryStage) {

		HBox mainPane = new HBox(20);
		mainPane.setPadding(new Insets(20));

		double[] array1 = new double[50];
		double[] array2 = new double[50];
		double[] array3 = new double[50];
		for(int i = 0; i < array1.length; i++) {
			array1[i] = i + 1;
			array2[i] = i + 1;
			array3[i] = i + 1;
		}
		
		shuffle(array1);
		shuffle(array2);
		shuffle(array3);

		selectionPane = new Histogram(array1);
		insertionPane = new Histogram(array2);
		bubblePane = new Histogram(array3);

		Label lblSelection = new Label("Selection sort", selectionPane);
		lblSelection.setContentDisplay(ContentDisplay.BOTTOM);
		lblSelection.setFont(Font.font(30));

		Label lblInsertion = new Label("Insertion sort", insertionPane);
		lblInsertion.setContentDisplay(ContentDisplay.BOTTOM);
		lblInsertion.setFont(Font.font(30));

		Label lblBubble = new Label("Bubble sort", bubblePane);
		lblBubble.setContentDisplay(ContentDisplay.BOTTOM);
		lblBubble.setFont(Font.font(30));

		mainPane.getChildren().addAll(lblSelection, lblInsertion, lblBubble);

		Scene scene = new Scene(mainPane);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Exercise30_19");
		primaryStage.show();

		//using threads
		// i could also use Timeline class
		ExecutorService service = Executors.newCachedThreadPool();
		Thread thread1 = new Thread(() -> selectionSort(array1));
		thread1.setDaemon(true);
		service.execute(thread1);
		Thread thread2 = new Thread(() -> insertionSort(array2));
		thread1.setDaemon(true);
		service.execute(thread2);
		Thread thread3 = new Thread(() -> bubbleSort(array3));
		thread3.setDaemon(true);
		service.execute(thread3);

		service.shutdown();
	}

	public static void selectionSort(double[] list) {
		try {
			for (int i = 0; i < list.length - 1; i++) {
				// Find the minimum in the list[i..list.length-1]
				double currentMin = list[i];
				int currentMinIndex = i;

				for (int j = i + 1; j < list.length; j++) {
					if (currentMin > list[j]) {
						currentMin = list[j];
						currentMinIndex = j;
					}
				}

				// Swap list[i] with list[currentMinIndex] if necessary
				if (currentMinIndex != i) {
					list[currentMinIndex] = list[i];
					list[i] = currentMin;
				}

				selectionPane.setCounts(list);
				selectionPane.redraw();
				selectionPane.lastBar(i);
				Thread.sleep(500);
			}
		} catch(InterruptedException ex) {}
	}

	public static void shuffle(double[] array) {
		int index;
		double temp;
		Random random = new Random();
		for (int i = array.length - 1; i > 0; i--) {
			index = random.nextInt(i + 1);
			temp = array[index];
			array[index] = array[i];
			array[i] = temp;
		}
	}

	public static void insertionSort(double[] list) {
		try {
			for (int i = 1; i < list.length; i++) {

				double currentElement = list[i];
				int k;
				for(k = i - 1; k >= 0 && list[k] > currentElement; k--) {
					list[k + 1] = list[k];	
				}			
				list[k + 1] = currentElement;		

				insertionPane.setCounts(list);
				insertionPane.redraw();
				insertionPane.lastBar(i);
				Thread.sleep(500);
			}	
		} catch(InterruptedException ex) {}
	}

	public static void bubbleSort(double[] list) {
		try {
			boolean needNextPass = true;

			for(int k = 1; k < list.length && needNextPass; k++) {

				needNextPass = false;
				for (int i = 0; i < list.length -k; i++){
					if (list[i] > list[i + 1]){
						double temp = list[i];
						list[i] = list[i + 1];
						list[i + 1] = temp;		
						needNextPass = true;
					}
				}

				bubblePane.setCounts(list);
				bubblePane.redraw();
				bubblePane.lastBar(k);
				Thread.sleep(500);
			}
		} catch(InterruptedException ex) {}
	}

	public class Histogram extends Pane {

		private double[] counts;
		private ArrayList<Rectangle> columns = new ArrayList<>();

		public Histogram(double[] array) {
			setPrefWidth(400);
			setPrefHeight(400);
			setCounts(array);
			inicializeRectangles();

		}

		public void setCounts(double[] counts) {
			this.counts = counts;
		}

		private void normalize() {
			double sum = 0;
			for(int i = 0; i < counts.length; i++)
				sum += counts[i];

			if (sum != 0)
				for(int i = 0; i < counts.length; i++)
					counts[i] = counts[i] / sum;
		}

		private void inicializeRectangles() {
			normalize();
			int width = 7;
			int x = 10;
			double scale = 20;

			for(int i = 0; i < counts.length; i++) {
				columns.add(new Rectangle(width, scale * getHeight() * counts[i]));
				columns.get(i).setX(x);
				columns.get(i).setY(getHeight() - columns.get(i).getHeight() - 30); 
				columns.get(i).setFill(Color.WHITE);
				columns.get(i).setStroke(Color.BLACK);

				getChildren().add(columns.get(i));
				x += width;
			}
		}

		public void redraw() {
			normalize();

			double scale = 20;

			for(int i = 0; i < counts.length; i++) {
				columns.get(i).setHeight(scale * getHeight() * counts[i]);
				columns.get(i).setY(getHeight() - columns.get(i).getHeight() - 30);
				columns.get(i).setFill(Color.WHITE);
				columns.get(i).setStroke(Color.BLACK);
			}
		}

		public void lastBar(int i) {
			columns.get(i).setFill(Color.DARKMAGENTA);
			columns.get(i).setStroke(Color.DARKMAGENTA);
		}
	}
}
