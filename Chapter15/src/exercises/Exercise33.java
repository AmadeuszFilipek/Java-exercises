package exercises;

import java.util.ArrayList;

import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise33 extends Application {

public void start(Stage primaryStage) {
			
		BeanMachinePane pane = new BeanMachinePane();
	
		Timeline beanAddition = new Timeline(new KeyFrame(Duration.millis(1000), e -> {pane.addBean();}));
		beanAddition.setCycleCount(10);
		beanAddition.play();
		
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Exercise15_33");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static class BeanMachinePane extends Pane {
		
		private Polyline container;
		private ArrayList<Circle> circles;
		private ArrayList<Circle> beans;
		private int[] beanHistogram = new int[8];
		
		private PathTransition animation;
		
		public BeanMachinePane() {
			
			setPadding(new Insets(20));
			
			//Initialize bean array
			beans = new ArrayList<>();
			
			//draw a box for the bean machine
			container = new Polyline();
			ObservableList<Double> list = container.getPoints();
			list.add(160.); list.add(50.);
			list.add(160.); list.add(80.);
			list.add(20.); list.add(300.);
			list.add(20.); list.add(350.);
			list.add(320.); list.add(350.);
			list.add(320.); list.add(300.);
			list.add(180.); list.add(80.);
			list.add(180.); list.add(50.);
			
			//draw circles inside
			circles = new ArrayList<>();
			for(int i = 1; i <= 7; i++) 
				for(int j = 1; j <= i ; j++) {
					circles.add(new Circle(150 + j * 40 - i * 20, 80 + 30 * i, 5.));
				}
			
			//draw lines for the bean collectors
			ArrayList<Line> drawers = new ArrayList<>();
			for(int i = circles.size() - 1; i >= circles.size() - 7; i--) {
				drawers.add(new Line(circles.get(i).getCenterX(), circles.get(i).getCenterY(),
														 circles.get(i).getCenterX(), 350));
			}
			
			getChildren().add(container);
			getChildren().addAll(circles);
			getChildren().addAll(drawers);
		}
		
		public void addBean() {
			Circle bean = new Circle(5);
			bean.setFill(Color.OLIVE);
			beans.add(bean);
			getChildren().add(bean);
			
			//generate a random polyline path for the bean
			Polyline path = generatePath();
	
			animation = new PathTransition();
			animation.setAutoReverse(false);
			animation.setDuration(Duration.millis(4000));
			animation.setPath(path);
			animation.setNode(bean);
			animation.play();
		}
		
		public Polyline generatePath() {
			
			Polyline path = new Polyline();			
			ObservableList<Double> points = path.getPoints();
			
			//add the initial points
			points.add(170.); points.add(50.);
			points.add(170.); points.add(110. - 10);
			
			//generate the path
			double x = 0;
			int bin = 0;
			for(int i = 1; i <= 7; i++) {
				if (Math.random() < 0.5) {
					x -= 20; 
					bin++;
				}
				else
					x += 20;
				
				points.add(170 + x); points.add(110 - 10 + i * 30.);
			}
			
			//add the last points according to the number of beans collected
			beanHistogram[bin]++;
			points.add(170 + x);
			points.add(350. - beanHistogram[bin] * 10);

			return path;
		}
		
	}
}
