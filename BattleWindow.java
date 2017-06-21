package game;

import java.net.URL;
import java.util.ResourceBundle;

import battleEvent.EncounterCharac;
import battleEvent.EncounterGenerator;
import battleEvent.PlayerCharac;
import javafx.animation.KeyFrame;

import javafx.animation.Timeline;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import javafx.stage.Stage;
import javafx.util.Duration;

public class BattleWindow implements Initializable {

	@FXML ScrollPane scrollPane;
	@FXML VBox eventBox;
	@FXML Label currentHP, maximumHP;
	@FXML Button fight;
	int currHP = 10;
	Timeline beat;
	
	
	@Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Battle view is now loaded!");
        
        scrollPane.vvalueProperty().bind(eventBox.heightProperty());
        
        // initial values
        maximumHP.setText("" + PlayerCharac.HP);
        currentHP.setText("" + PlayerCharac.cHP);
        
    }
	
	public void show() throws Exception{
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("BattleWindow.fxml"));
	    primaryStage.setTitle("Hello World");
	    primaryStage.setScene(new Scene(root, 600, 400));
	    primaryStage.show();
	    



	    
	}
	
	
	
	public void fightButtonHandle(){

		// if fight already happened
		if(PlayerCharac.fought) {
			WindowsManager.battleStage.close();
			WindowsManager.displayMenuWindow();
			return;
		}
		

		// else
		PlayerCharac.fought = true;
		fight.setText("Leave...");
	
        eventBox.getChildren().addAll(new Label("Entering the Battlefield..."));

		StringProperty scale = new SimpleStringProperty(""+PlayerCharac.cHP);
        currentHP.textProperty().bind(scale);


        // what happens during the fight is determined here!
        beat = new Timeline(
            new KeyFrame(Duration.millis(600), event -> {
            	EncounterGenerator.generate();
            	// display "you meet..." and change stats in Charac
            	eventBox.getChildren().add(EncounterCharac.text);
            	PlayerCharac.cHP = PlayerCharac.cHP + EncounterCharac.hpModif;
            	PlayerCharac.gold = PlayerCharac.gold + EncounterCharac.goldModif;

      
            	// display the stats change
            	scale.setValue("" + PlayerCharac.cHP);
            	
            	// did the character die?
            	if(PlayerCharac.cHP <=0) {
            		scale.setValue("" + 0);
                	eventBox.getChildren().add(new Label(EncounterGenerator.chooseDefeat()));
            		this.beat.stop();
            	}
            	})
        );
        beat.setAutoReverse(true);
        beat.setCycleCount(Timeline.INDEFINITE);
        beat.play();
    
    		
		
	}
}
