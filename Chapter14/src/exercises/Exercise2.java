package exercises;

import java.util.Random;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Exercise2 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
	
		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(5));
		pane.setHgap(5);
		pane.setVgap(5);
		
		char[] cells = generateBoard();
		int j = - 1;
		// put the cells on the grid
		for(int i = 0; i < cells.length; i++) {
			if (i % 3 == 0)
				j++;
			
			ImageView img = new ImageView();
			
			if (cells[i] == 'X') {
				img.setImage(new Image("images/x.jpg"));
			} 
			else if (cells[i] == 'O') {
				img.setImage(new Image("images/o.jpg"));
			}
				
			img.setFitWidth(100);
			img.setFitHeight(100);
			pane.add(img, j, i % 3);
		}
		
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Exercise14_02");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}
	
	public static char[] generateBoard() {
		char[] cells = new char[9];
		
		for(int i = 0; i < cells.length; i++) {
			Random rng = new Random();
			int val = rng.nextInt(3);
			if(val == 1) 
				cells[i] = 'X';
			else if(val == 2) 
				cells[i] = 'O';
		}
		
		return cells;
	}
}
