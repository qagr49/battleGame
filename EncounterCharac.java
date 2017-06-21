package battleEvent;

import java.util.Vector;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

// this class stores the Characteristics to be modified after the Event
public class EncounterCharac  {

	public static String MonsterName;
	public static String adj;
	public static TextFlow text;
	public static double hpModif;
	public static int goldModif;
	public static double adjMultiplicator;
	public static Vector<String> adjType = new Vector<String>();

	// reset all characteristics
	public static void reset(){
		MonsterName="";
		adj="";
		text= new TextFlow(new Text(""));
		hpModif=0;
		goldModif=0;
		adjMultiplicator=1;
		adjType = new Vector<String>();
	}

	// apply multiplicator
	public static void multiplyAdj() {


		hpModif = hpModif * adjMultiplicator;

		goldModif = (int)(goldModif * adjMultiplicator) + 1;
		
		

	}
	


	public static void setText(Text t1){
		text = new TextFlow(t1);
	}
	public static void setText(Text t1, Text t2){
		text = new TextFlow(t1, t2);
	}
	public static void setText(Text t1, Text t2, Text t3){
		text = new TextFlow(t1, t2, t3);
	}


	
}
