package exercises;

import java.util.ArrayList;
import java.util.Random;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise36 extends Application {

	public void start (Stage primaryStage) {
		
		final int N = 10000;
		for(int size = 10; size <= 80; size ++) {
			double count = 0;
			for(int i = 0; i < N; i++) {
				RandomWalkPane pane = new RandomWalkPane(size);
				if (pane.isDeadEnd())
					count++;	
			}
			
			System.out.printf("For a lattice of size %d, the probability of dead-end paths is %.1f%%\n", size, count / N * 100);
			
		}
		System.exit(0);
	}
	
	public static class RandomWalkPane extends Pane {

		private ArrayList<Point2D> points;
		private int lattice;
		private double cellWidth = 20;
		private double cellHeight = 20;
		private boolean isDeadEnd = false;

		private Timeline animation;
		private int animationFrame = 0;
		
		public RandomWalkPane(int size) {

			this.lattice = size;
			setPrefHeight(cellHeight * lattice);
			setPrefWidth(cellWidth * lattice);

			points = new ArrayList<>();

			//initialize the walk
			initializeWalk();
			
			//initialize the animation
			animation = new Timeline(new KeyFrame(Duration.millis(500), e ->{animate();}));
			animation.setCycleCount(points.size());
			
		}

		public void play() {
			animation.play();
		}
		
		public void animate() {
			redraw(animationFrame);
			animationFrame++;
			if (animationFrame >= points.size())
				animationFrame = 0;
		}
		
		public void redraw() {
			redraw(points.size() - 1);
		}
		
		public void redraw(int length) {
			if (length >= points.size())
				return;
			
			setCellWidth(getWidth() / lattice);
			setCellHeight(getHeight() / lattice);
			//draw background lines
			setBackground(new Background(new BackgroundFill(Color.BISQUE, CornerRadii.EMPTY, Insets.EMPTY)));

			getChildren().clear();

			for(int i = 0; i <= lattice; i++) {
				Line lnHorizontal = new Line(0, getHeight() / lattice * i, getWidth(), getHeight() / lattice * i);
				lnHorizontal.setOpacity(0.3);
				Line lnVertical = new Line(getWidth() / lattice * i, 0, getWidth() / lattice * i, getHeight());
				lnVertical.setOpacity(0.3);
				getChildren().addAll(lnHorizontal, lnVertical);
			}

			Polyline path = new Polyline();

			for(int i = 0; i <= length; i++) 
				path.getPoints().addAll(points.get(i).getX() * cellWidth, points.get(i).getY() * cellHeight);

			getChildren().add(path);
		}

		public double getCellWidth() {
			return cellWidth;
		}

		public void setCellWidth(double cellWidth) {
			this.cellWidth = cellWidth;
		}

		public double getCellHeight() {
			return cellHeight;
		}

		public void setCellHeight(double cellHeight) {
			this.cellHeight = cellHeight;
		}

		public boolean isDeadEnd() {
			return isDeadEnd;
		}
		
		private boolean checkDeadEnd(Point2D currentPoint) {
			int placesTaken = 0;
			
			double stepX = 0, stepY = 1;
			for(Point2D point : points)
				if (point.distance(currentPoint.add(stepX, stepY)) < Math.pow(10, -8))
				placesTaken++;
			
			stepX = 0; stepY = -1;
			for(Point2D point : points)
				if (point.distance(currentPoint.add(stepX, stepY)) < Math.pow(10, -8))
				placesTaken++;
			
			stepX = 1; stepY = 0;
			for(Point2D point : points)
				if (point.distance(currentPoint.add(stepX, stepY)) < Math.pow(10, -8))
				placesTaken++;
			
			stepX = -1; stepY = 0;
			for(Point2D point : points)
				if (point.distance(currentPoint.add(stepX, stepY)) < Math.pow(10, -8))
				placesTaken++;
			
			if (placesTaken >= 4)
				isDeadEnd = true;
			
			return isDeadEnd;
		}
		
		private void initializeWalk() {
			
			Random rng = new Random();
			double x = lattice / 2;
			double y = lattice / 2;
			points.add(new Point2D(x, y));
			int stepX = 1;
			int stepY = 1;
			switch (rng.nextInt(4)) {
			case 0 : stepX = 0; stepY = -1; break;
			case 1 : stepX = 1; stepY = 0; break;
			case 2 : stepX = 0; stepY = 1; break;
			case 3 : stepX = -1; stepY = 0; break;
			default : break;
			}
			x += stepX;
			y += stepY;
			points.add(new Point2D(x, y));
			boolean isRunning = true;

			while(isRunning) {

				Point2D currentPoint = points.get(points.size() - 1);
				Point2D lastPoint = points.get(points.size() - 2);

				//check if this is not a dead dead end
				if (checkDeadEnd(currentPoint))
					break;

				//generate a new point, assuming it's not a dead end
				boolean isValidPoint = false;
				while(!isValidPoint) {
					switch (rng.nextInt(4)) {
					case 0 : stepX = 0; stepY = -1; break;
					case 1 : stepX = 1; stepY = 0; break;
					case 2 : stepX = 0; stepY = 1; break;
					case 3 : stepX = -1; stepY = 0; break;
					default : break;
					}

					//check if the step is not going backwards
					if(lastPoint.distance(currentPoint.add(stepX, stepY)) < Math.pow(10, -8))
						continue;

					//check if the next step is valid
					isValidPoint = true;

					for(Point2D point : points)
						if (point.distance(currentPoint.add(stepX, stepY)) < Math.pow(10, -8)) {
							isValidPoint = false;
							break;
						}
				}

				//check if the next step is the last
				if (x + stepX <= 0 || x + stepX >= lattice || y + stepY <= 0 || y + stepY >= lattice)
					isRunning = false;

				x += stepX;
				y += stepY;
				points.add(currentPoint.add(stepX, stepY));
			}
		}
	}
}
