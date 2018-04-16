package exercises;

import java.util.GregorianCalendar;
import java.util.Locale;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Exercise29 extends Application {



	public void start(Stage primaryStage) {

		CalendarPane pane = new CalendarPane();
		
		Scene scene = new Scene(pane, 400, 300);
		primaryStage.setTitle("Exercise16_29");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static class CalendarPane extends BorderPane {

		private static Button btnPrior = new Button("Prior");
		private static Button btnNext = new Button("Next");

		private static Label lblMonth = new Label();
		private static GregorianCalendar calendar = new GregorianCalendar();
		
		private static GridPane grid = new GridPane();
		
		public CalendarPane() {
			
			lblMonth.setFont(Font.font(30));
			
			grid.setAlignment(Pos.CENTER);
			grid.setHgap(10);
			grid.setVgap(10);
			printMonth();
			
			HBox topBox = new HBox();
			topBox.setAlignment(Pos.CENTER);
			topBox.getChildren().add(lblMonth);
			
			btnPrior.setOnAction(e -> {
				calendar.add(GregorianCalendar.MONTH, -1);
				printMonth();
			});
			btnNext.setOnAction(e -> {
				calendar.add(GregorianCalendar.MONTH, 1);
				printMonth();
			});
			
			HBox botBox = new HBox(20);
			botBox.setAlignment(Pos.CENTER);
			botBox.getChildren().addAll(btnPrior, btnNext);
			
			setTop(topBox);
			setCenter(grid);
			setBottom(botBox);
			topBox.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
			grid.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
			botBox.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
		}

		public static void printMonth() {

			int gridRow = 0;
			int gridCol = 0;
			
			calendar.set(GregorianCalendar.DAY_OF_MONTH, 1);
			grid.getChildren().clear();
			
			String[] dayNames = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

			int dayNumber = calendar.get(GregorianCalendar.DAY_OF_WEEK);
			int daysInMonth = calendar.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);

			int year = calendar.get(GregorianCalendar.YEAR);

			String monthName = calendar.getDisplayName(GregorianCalendar.MONTH, 
					GregorianCalendar.LONG, Locale.ENGLISH);

			lblMonth.setText(monthName + ", " + year);

			for (int j = 0; j < dayNames.length; j++) {
				grid.add(new Label(dayNames[j]), gridCol, gridRow);
				gridCol++;
			}
		
			gridCol = 0;
			gridRow++;

			// grey days before the first day of the month
			calendar.add(GregorianCalendar.DAY_OF_YEAR, -dayNumber);
			for(int j = 1; j < dayNumber; j++) {
				Label lbl = new Label(calendar.get(GregorianCalendar.DAY_OF_MONTH) + "");
				lbl.setTextFill(Color.GRAY);
				grid.add(lbl, gridCol, gridRow);
				gridCol++;
				calendar.add(GregorianCalendar.DAY_OF_YEAR, 1);
			}
			
			calendar.add(GregorianCalendar.DAY_OF_YEAR, 1);

			// fill the day numbers in a month
			for(int j = 1; j <= daysInMonth; j++) {
				grid.add(new Label(j + ""), gridCol, gridRow);
				gridCol++;
				if ((j + dayNumber - 1)% 7 == 0) {
					gridCol = 0;
					gridRow++;
				}
			}

			//add grey days after the month
			if (gridCol != 0) {
				int greyDays = 7 - gridCol;
				for(int i = 1; i <= greyDays; i++) {
					Label lbl = new Label(i + "");
					lbl.setTextFill(Color.GREY);
					grid.add(lbl, gridCol, gridRow);
					gridCol++;
				}
			}
		}
	}
}
