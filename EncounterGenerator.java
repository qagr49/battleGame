package battleEvent;

import java.util.Random;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class EncounterGenerator {
	public static String text;
	private static Random rand = new Random();
	
	public static void generate(){
		EncounterCharac.reset();
		chooseAdj();
		int choseNb = rand.nextInt(10);
		// Monster, 7/10
		if(choseNb > 3) {
			chooseMonster();
			chooseSentence();
		}
		// Special Event 3/10
		else {
			chooseSpecialEvent();
		}
		EncounterCharac.multiplyAdj();
		
	}
	
	
	
	



	/////// RELATED TO DEFEAT
	public static String chooseDefeat() {
		int choseNb = rand.nextInt(defeat.length);
		return defeat[choseNb];
	}
	private static String[] defeat= {
			"Defeat!", "You died...", "You are dead.",
			"Rest in Peace.", "R.I.P."
	};

	/////// RELATED TO SPECIAL EVENT
	private static void chooseSpecialEvent() {
		int choseNb = rand.nextInt(speE.length);
		SpecialEvent SE = speE[choseNb];
		EncounterCharac.text = new TextFlow(new Text(SE.text));
		EncounterCharac.adjMultiplicator = 1;
		EncounterCharac.hpModif = SE.hpModif;
		EncounterCharac.goldModif = SE.goldModif;
	}
	private static SpecialEvent[] speE= {
			new SpecialEvent("The storm is getting stronger!", 0, -2), new SpecialEvent("The Gods have noticed you", 0, +2), 
			new SpecialEvent("Midas touches you", +5, -3), new SpecialEvent("The battle continues", 0, 0),
			new SpecialEvent("Winter is coming...", 0, -1), new SpecialEvent("This lost arrow nearly hit you!", 0, 0), 
			new SpecialEvent("You run into battle", 0, 0),
	};

	/////// RELATED TO MONSTER
	private static void chooseMonster() {
		int choseNb = rand.nextInt(monster.length);
		Monster mon = monster[choseNb];
		EncounterCharac.MonsterName = EncounterCharac.adj+" "+ mon.name;
		EncounterCharac.hpModif = -mon.monsterDamage;
		if ((EncounterCharac.hpModif + PlayerCharac.cHP) > 0) EncounterCharac.goldModif = mon.monsterGold ;
		
		System.out.println(EncounterCharac.MonsterName);

	}
	
	private static Monster[] monster = {
			new Monster("Rat", 2, 2, 1), new Monster("Bat", 2, 2, 1), new Monster("Mama Ferny", 7, 7, 5), 
			new Monster("Rabit", 1, 1, 0), new Monster("Imp", 4, 4, 2), new Monster("Shrimp", 0.5, 0.5, 0), 
			new Monster("Treasure Chest", 2, 0, 5), new Monster("Snooooooow Maguus", 10, 10, 5), new Monster("Dragon", 20, 20, 15)
	};
	
	/////// RELATED TO SENTENCE
	private static void chooseSentence() {
		// choose sentence
		int choseNb = rand.nextInt(sentence.length);
		Sentence sen = sentence[choseNb];
		
		// remove space at the begining of monster name
		if(EncounterCharac.MonsterName.startsWith(" ")) EncounterCharac.MonsterName = EncounterCharac.MonsterName.substring(1);
		
		// build text
		Text mName = new Text(EncounterCharac.MonsterName);
		mName.setStyle("-fx-font-weight: bold");
		EncounterCharac.setText(new Text(sen.before), mName,  new Text(sen.after));
	}
	private static Sentence[] sentence = {
			new Sentence("You meet ", ". "), new Sentence("Watch out! ", " is coming."), new Sentence("Get ready for the fight with ", ". "),
			new Sentence("", " never forgot you killed its brother... Fight!")
	};
	
	/////// RELATED TO ADJECTIVE
	private static void chooseAdj(){
		// nb of adj 
		int nbOfAdj = 0, choseNb = rand.nextInt(10);
		if(choseNb > 4) nbOfAdj++;
		if(choseNb > 8) nbOfAdj++;
		
		while(nbOfAdj > 0){
			nbOfAdj--;
			Adj adj = getAdj();
			if(!EncounterCharac.adjType.contains(adj.type)) {
				EncounterCharac.adjType.addElement(adj.type);
				EncounterCharac.adj = EncounterCharac.adj + " " +adj.adj;
				EncounterCharac.adjMultiplicator = adj.modifier * EncounterCharac.adjMultiplicator;
			}
		}
	}
	
	private static Adj getAdj(){
		Adj adj = new Adj("");

		// chose adj
		int choseNb = rand.nextInt(2);
		if(choseNb == 0){
			choseNb = rand.nextInt(SizeAdj.length);
			adj = SizeAdj[choseNb];
		}
		else if(choseNb == 1){
			choseNb = rand.nextInt(ColorAdj.length);
			adj = ColorAdj[choseNb];
		}
		return adj;
	}
	
	private static Adj[] SizeAdj = 
		{new Adj("Small", 0.4, "Size"),new Adj("Tiny", 0.5, "Size"), new Adj("Little", 0.6, "Size"), 
				new Adj("Big", 1.2, "Size"), new Adj("Fat", 1, "Size"),new Adj("Superfat", 1.5, "Size"),
				new Adj("Epic", 2, "Size"),new Adj("Legendary", 3, "Size"),};
	private static Adj[] ColorAdj =
		{new Adj("Brown", 1, "Color"),new Adj("Grey", 1, "Color"),new Adj("Red", 1.1, "Color"),
				new Adj("Green", 1, "Color"),new Adj("Pink", 0.7, "Color"),};

}
