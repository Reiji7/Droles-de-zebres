/**
 * 
 */
package game;

import java.util.ArrayList;

import pawn.Pawn;

/**
 * @author Adrien
 *
 */
public class Board {


	/**
	 * Board of game
	 */
	private Square[][] board;

	public Board() {
		this.board = new Square[5][6];

		int[] squareNb = {0,2,3,3,3,3,0,2,2,3,4,4,0,0,2,3,3,4,1,0,2,2,2,5,1,1,5,5,5,5};
		
		for(int index1 = 0; index1 < squareNb.length; index1++) {
			for(int index2 = 0; index2 < 5; index2++) {
				for(int index3 = 0; index3 < 6; index3++) {
					board[index2][index3] = new Square(squareNb[index1]);
				}
			}
		}
	}

	public Pawn getPawnAt(int x, int y){
		return board[x][y].getPawn();
	}
	
	/**
	 * Adding pawn 
	 * 
	 * @param x Vertical position
	 * @param y Horizontal position
	 * @param p Pawn added to the board
	 * 
	 * @return result
	 */
	public boolean adjPown(int x, int y, Pawn p) {

		if(x < 0 || x > 6)
			return false;
		if(y < 0 || y > 5)
			return false;
		if(board[x][y].getPawn() != null){
			return false;
		}
		/*
		 * We check out this square's neighbor
		 */
		ArrayList<Square> voisins = voisins(x,y);
		try {
			switch(p.toString()){

			case "Gazelle":
				/*
				 * If one of the neighbor is a lion, this token hides
				 */
				for(int i=0;i<voisins.size();i++){
					if(voisins.get(i).getPawn().toString()=="Lion"){
						p.hides();
					}
				}
				break;

				/* We only take care of the case of a lion being placed next to a zebra in this class
				 * The case where a lion is placed next to a gazelle is being treated in game.Controller.java
				 */
			case "Lion":
				for(int i=0;i<voisins.size();i++){
					if(voisins.get(i).getPawn().toString()=="Zebre"){
						voisins.get(i).getPawn().hides();
					}
				}
				break;

			case "Crocodile":
				ArrayList<Square> listeG = gazellesEchangeables(x,y);

				if(listeG.size()==0){ //If there is no Gazelle, does nothing

				} else
					if(listeG.size()==1){ //If there is only one Gazelle that can be swaped, does swap the two Pawns
						board[x][y].adjPown(p);
						board[x][y].swap(listeG.get(0));
						return true; //We stop the method here, so we don't try to put another Pawn at the end
					} else { //There's is more than one Gazelle that can be swaped, so we ask the player which one to swap with

					}
				break;

			case "Zebre":
				//If a zebra is placed next to a lion, he's immediatly hidden
				for(int i=0;i<voisins.size();i++){
					if(voisins.get(i).getPawn().toString()=="Lion"){
						p.hides();
					}
				}
				break;

			case "Elephant":
				break;
			}

			/*
			 * Once all conditions are verified and all actions executed, we place the pawn on the board
			 * (except in the case of a crocodile swaping with a gazelle)
			 */
			board[x][y].adjPown(p);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	/**
	 * Removes the pawn from the selected square
	 * @param sq
	 */
	public void removePawn(Square sq){
		sq.removePawn();
	}
	
	/**
	 * Returns a square's neighbors 
	 * @param x
	 * @param y
	 * @return
	 */
	public ArrayList<Square> voisins(int x, int y){
		ArrayList<Square> tmp = new ArrayList<Square>();
		switch(x){
		case 0:
			tmp.add(board[x+1][y]);
			break;
		case 6:
			tmp.add(board[x-1][y]);
			break;
		default:
			tmp.add(board[x-1][y]);
			tmp.add(board[x+1][y]);
		}

		switch(y){
		case 0:
			tmp.add(board[x][y+1]);
			break;
		case 5:
			tmp.add(board[x][y-1]);
			break;
		default:
			tmp.add(board[x][y-1]);
			tmp.add(board[x][y+1]);
		}

		return tmp;
	}

	
	/**
	 * We use this method when the player wants to put a crocodile, to know if we can swap it with a Gazelle
	 * @param x
	 * @param y
	 * @return 
	 */
	public ArrayList<Square> gazellesEchangeables(int x, int y){
		ArrayList<Square> voisins = voisins(x,y);
		ArrayList<Square> echangeable = new ArrayList<Square>();
		/*
		 * We look if there is some Gazelles around the sqaure
		 */
		for(int i=0;i<voisins.size();i++){
			if(voisins.get(i).getPawn().toString() == "Gazelle"){
				echangeable.add(voisins.get(i));
			}
		}
		/*
		 * Then, we remove the gazelles that's aren't accross the river
		 */
		for(int i=0;i<echangeable.size();i++){
			if(board[x][y].getSector()==echangeable.get(i).getSector()){
				echangeable.remove(i);
			}
		}
		return echangeable;
	}
}