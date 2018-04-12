package pawn;

import config.IdPawn;

public class Lion extends Pawn{

	public Lion(String couleur) {
		super(IdPawn.Lion.getValue(), couleur, "Lion");
	}

	public String toString(){
		return "Lion";
	}
}
