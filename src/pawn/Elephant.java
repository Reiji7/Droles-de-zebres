package pawn;

import config.IdPawn;

public class Elephant extends Pawn{

	public Elephant(String couleur) {
		super(IdPawn.Elephant.getValue(), couleur, "Elephant");
	}

	public String toString(){
		return "Elephant";
	}
}
