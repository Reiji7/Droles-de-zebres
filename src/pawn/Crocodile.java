
/**
 * 
 */
package pawn;

import config.IdPawn;

/**
 * @author Adrien
 *
 */
public class Crocodile extends Pawn{

	public Crocodile(String couleur) {
		super(IdPawn.Crocodile.getValue(), couleur);
	}
	
	public String toString(){
		return "Crocodile";
	}
}