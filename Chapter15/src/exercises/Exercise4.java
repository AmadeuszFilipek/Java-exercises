package exercises;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Exercise4 extends Application {

	public void start(Stage primaryStage) {
		
		// set the top row 
		HBox top = new HBox(10);
	  top.setPadding(new Insets(20));
		TextField number1 = new TextField();
		number1.setPrefWidth(80);
	
		TextField number2 = new TextField();
		number2.setPrefWidth(80);

		TextField result = new TextField();
		result.setPrefWidth(80);
		result.setEditable(false);
		
		top.getChildren().add(new Label("Number 1:"));
		top.getChildren().add(number1);
		top.getChildren().add(new Label("Number 2:"));
		top.getChildren().add(number2);
		top.getChildren().add(new Label("Result:"));
		top.getChildren().add(result);
			
		// set the row with buttons
		HBox bot = new HBox(10);
		
		Button btnAdd = new Button("Add");
		btnAdd.setOnAction(e -> { 
			try{ result.setText(
				Double.parseDouble(number1.getText()) + Double.parseDouble(number2.getText()) + ""); 
			} catch (NumberFormatException ex) {
				result.setText("NaN");
			}
		});
		
		Button btnSubstract = new Button("Substract");
		btnSubstract.setOnAction(e -> { 
			try { result.setText(
				Double.parseDouble(number1.getText()) - Double.parseDouble(number2.getText()) + "");
			} catch (NumberFormatException ex) {
				result.setText("NaN");
			}
			});
		
		Button btnMultiply = new Button("Multiply");
		btnMultiply.setOnAction(e -> { 
			try { result.setText(
				Double.parseDouble(number1.getText()) * Double.parseDouble(number2.getText()) + "");
			} catch (NumberFormatException ex) {
				result.setText("NaN");
			}
			});

		Button btnDivide = new Button("Divide");
		btnDivide.setOnAction(e -> { 
			try { result.setText(
				Double.parseDouble(number1.getText()) / Double.parseDouble(number2.getText()) + "");
			} catch (NumberFormatException ex) {
				result.setText("NaN");
			} 
			});
		
		
		bot.getChildren().addAll(btnAdd, btnSubstract, btnMultiply, btnDivide);

		//construct final pane
		BorderPane pane = new BorderPane();
		pane.setTop(top);
		pane.setBottom(bot);
		BorderPane.setAlignment(top, Pos.TOP_CENTER);
		bot.setAlignment(Pos.BOTTOM_CENTER);
		
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Exercise15_04");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
