package pawn;

import config.IdPawn;

public class Zebra extends Pawn{

	public Zebra(String couleur) {
		super(IdPawn.Zebra.getValue(), couleur);
	}

	public String toString(){
		return "Zebre";
	}
}
