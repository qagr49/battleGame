package game;

import java.net.URL;
import java.util.ResourceBundle;

import battleEvent.PlayerCharac;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

// AUTO IMPORT CTRL SHIFT O


public class MenuWindow implements Initializable {


	public Button startBattleButton;
	@FXML Label myLabel;
	
	
	public void startBattleClick() throws Exception{
		PlayerCharac.initializeForBattle();
		//BattleWindow bt = new BattleWindow();
		//bt.show();
		WindowsManager.displayBattleWindow();
		WindowsManager.menuStage.close();

	}
	
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("View is now loaded!");
        myLabel.setText(""+ PlayerCharac.gold);
    }
    
    
    public void show(Stage primaryStage) throws Exception{
    	
    	Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 600, 350));
        primaryStage.show();
    }

  
}
