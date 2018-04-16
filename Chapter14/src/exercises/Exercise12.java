package exercises;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Exercise12 extends Application {

	public void start(Stage primaryStage) {
		
		CategoryAxis xAxis = new CategoryAxis();
		NumberAxis yAxis = new NumberAxis();
		
		BarChart<String, Number> chart = new BarChart<>(xAxis, yAxis);
		
		Series<String, Number> series1 = new Series<>();
		series1.getData().add(new Data<String, Number>("Project", 20));
		series1.getData().add(new Data<String, Number>("Quiz", 10));
		series1.getData().add(new Data<String, Number>("Midterm", 30));
		series1.getData().add(new Data<String, Number>("Final", 40));
		
		series1.setName("Overall grade coefficients");
		
		chart.getData().add(series1);
		xAxis.setTickLabelFont(Font.font(30));
		yAxis.setTickUnit(10);
		yAxis.setTickLabelFont(Font.font(20));
		
		Scene scene = new Scene(chart);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Exercise14_12");
		primaryStage.show();
	}
}
