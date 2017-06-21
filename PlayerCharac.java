package battleEvent;



public class PlayerCharac {

	public static String name = "default";
	public static double cHP, HP;
	public static int gold ;
	public static Boolean fought = false;
	

	
	public static void save(){
		
	}
	
	public static void load(){
		HP = 10;
		gold = 0;
	}
	
	
	public static void initializeForBattle(){
		cHP = HP;
		fought = false;
	}
}

