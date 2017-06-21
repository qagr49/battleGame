package battleEvent;

import java.util.Random;

// temporary class, will be replaced by encounter
public class RandomEvent {

	private static Random rand = new Random();
	
	public static String encounter(){
		
		int e = rand.nextInt(3);
		if(e == 0){
			PlayerCharac.cHP = PlayerCharac.cHP-2;
			return "You encounter a tiny rat";
		}
		else if(e == 1){
			PlayerCharac.cHP = PlayerCharac.cHP-7;
			return "You meet mama fermy";
		}
		else if(e == 2){
			PlayerCharac.gold = PlayerCharac.gold + 10;
			return "A tresure chest lies to your feet";
		}
		return "Random Event";
	}
	
	public static String defeat(){
		int e = rand.nextInt(3);
		return youDie[e];
	}
	private static String[] youDie = {"Defeat!", "You died.", "You are dead..."};
	
}
