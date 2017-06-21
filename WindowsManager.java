package game;

import java.io.IOException;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;

public class WindowsManager {

	public static Stage battleStage;
	public static Parent battleRoot;
	
	public static Stage menuStage;
	public static Parent menuRoot;

public static void displayBattleWindow() {
		
	battleStage = new Stage();
	battleStage.setResizable(true);
	
	battleStage.setTitle("Battle");
		
	battleStage.setOnCloseRequest(e -> {
			e.consume();
			WindowsManager.displayMenuWindow();
			WindowsManager.battleStage.close();
			//System.exit(0);
		});
		
	battleRoot = null;

		try {

			battleRoot = FXMLLoader.load(WindowsManager.class.getResource("BattleWindow.fxml"));

		} catch (IOException e) {

			System.out.println("Could not load the FXML file!!");

			e.printStackTrace();
		}	

		battleStage.setScene(new Scene(battleRoot, 640, 480));

		battleStage.show();
	}

public static void displayMenuWindow() {
	menuStage = new Stage();
	menuStage.setTitle("Menu");
	menuStage.setResizable(true);

	menuRoot = null;
	
	try {
		menuRoot = FXMLLoader.load(WindowsManager.class.getResource("MenuWindow.fxml"));

	} catch (IOException e) {

		System.out.println("Could not load the FXML file!!");

		e.printStackTrace();
	}	

	menuStage.setScene(new Scene(menuRoot, 960, 540));

	menuStage.show();

	
	
	
	
	
	
	
	
	
	
	
}

	
}
