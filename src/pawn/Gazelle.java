/**
 * 
 */
package pawn;

import config.IdPawn;

/**
 * @author Adrien
 *
 */
public class Gazelle extends Pawn{

	public Gazelle(String couleur) {
		super(IdPawn.Gazelle.getValue(), couleur, "Gazelle");
	}

	public String toString(){
		return "Gazelle";
	}
}