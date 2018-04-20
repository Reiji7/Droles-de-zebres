package game;

import pawn.Pawn;

/**
 * @author Adrien
 *
 */
public class Square {
	
	
	private int sector;
	private Pawn pawn = null;
	
	
	public Pawn getPawn(){
		try {
			return this.pawn;
		}
		catch(NullPointerException e) {
			return null;
		}
	}
	
	
	public int getSector(){
		return this.sector;
	}

	
	public Square(int sector){
		this.sector = sector;
	}
	
	
	public void adjPown(Pawn p) {
		this.pawn = p;
	}
	
	
	/**
	 * Removes the pawn from the square
	 */
	public void removePawn(){
		this.pawn = null;
	}
	
	
	/**
	 * Swaps two square's pawns
	 * @param s
	 */
	public void swap(Square s){
		Pawn tmp = this.pawn;
		this.pawn = s.getPawn();
		s.adjPown(tmp);
	}
	
}