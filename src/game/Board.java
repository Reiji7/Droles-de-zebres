/**
 * 
 */
package game;

import pawn.Pawn;


/**
 * @author Adrien
 */
public class Board {
	
	/**
	 * Board of game
	 */
	private Square[][] board;
	
	
	/**
	 * Initialization of all the square
	 */
	public Board() {

		int[] squareNb = {0,2,3,3,3,3,0,2,2,3,4,4,0,0,2,3,3,4,1,0,2,2,2,5,1,1,5,5,5,5};
		this.board = new Square[5][6];
		
		for(int index1 = 0; index1 < squareNb.length; index1++) {
			for(int index2 = 0; index2 < 5; index2++) {
				for(int index3 = 0; index3 < 6; index3++) {
					board[index2][index3] = new Square(squareNb[index1]);
				}
			}
		}
		
	}
	

	/**
	 * Adding pawn on board
	 * 
	 * @param x Vertical position
	 * @param y Horizontal position
	 * @param p Pawn added to the board
	 * 
	 * @return result
	 */
	public boolean adjPown(int x, int y, Pawn p) {
		
		// Coordinate normalization
		if(x < 0 || x > 5)
			return false;
		if(y < 0 || y > 6)
			return false;
		
		// adding the pawn
		return board[x][y].adjPown(p);
	}
}