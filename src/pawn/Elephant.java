package pawn;

import config.IdPawn;

public class Elephant extends Pawn{

	public Elephant(String couleur) {
		super(IdPawn.Elephant.getValue(), couleur);
	}

	public String toString(){
		return "Elephant";
	}
}
