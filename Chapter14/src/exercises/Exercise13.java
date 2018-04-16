package exercises;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.stage.Stage;

public class Exercise13 extends Application {

	public void start(Stage primaryStage) {
		
		PieChart chart = new PieChart();
		chart.getData().add(new Data("Project", 20));
		chart.getData().add(new Data("Quiz", 10));
		chart.getData().add(new Data("Midterm", 30));
		chart.getData().add(new Data("Final", 40));		
		
		Scene scene = new Scene(chart);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Exercise14_13");
		primaryStage.show();
	
		
	}
}
