package config;
/**
 * This enumeration serves as both value and identifier for the pieces.
 * It's possible because each pawn has a different value.
 */
public enum IdPawn {

	Null(-1),
	Zebra(6),
	Gazelle(2),
	Elephant(5),
	Lion(1),
	Crocodile(0);
	
	
	private int value;
	   

	IdPawn(int value){
		this.value = value;
	}
	

	public int getValue() {
		return this.value;
	}
	
}
