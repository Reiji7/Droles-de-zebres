package config;
/**
 * This enumeration serves as both value and identifier for the pieces
 */
public enum IdPawn {

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
