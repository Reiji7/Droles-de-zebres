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
						p.seCache();
					}
				}
				break;

			case "Lion":
				for(int i=0;i<voisins.size();i++){
					if(voisins.get(i).getPawn().toString()=="Zebre"){
						voisins.get(i).getPawn().seCache();
					}

					if(voisins.get(i).getPawn().toString()=="Gazelle"){
						voisins.get(i).getPawn().fuite();
					}
				}
				break;

			case "Crocodile":
				ArrayList<Square> listeG = gazellesEchangeables(x,y);

				if(listeG.size()==0){ //S'il n'y a pas de gazelle a echanger, ne fait rien

				} else
					if(listeG.size()==1){ // S'il n'y a qu'une gazelle a echanger, on le fait
						board[x][y].adjPown(p);
						board[x][y].echanger(listeG.get(0));
						return true; //On termine la methode ici, pour ne pas avoir a reposer un pion 
					} else { //Il y a plus d'une gazelle que l'on peut echanger, il faut demander au joueur laquelle

					}
				break;

			case "Zebre":
				for(int i=0;i<voisins.size();i++){
					if(voisins.get(i).getPawn().toString()=="Lion"){
						p.seCache();
					}
				}
				break;

			case "Elephant":
				break;
			}

			/*
			 * Une fois les conditions verifiees et les actions executees, on ajoute le pion au plateau 
			 * (sauf dans le cas ou un crocodile a echange de place avec une gazelle)
			 */
			board[x][y].adjPown(p);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	
	/**
	 * Retourne les voisins d'une case selon ses coordonnees
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
	 * On utilise cette methode quand on veut poser un crocodile, pour savoir si l'on peut l'echanger de place avec une gazelle
	 * @param x
	 * @param y
	 * @return 
	 */
	public ArrayList<Square> gazellesEchangeables(int x, int y){
		ArrayList<Square> voisins = voisins(x,y);
		ArrayList<Square> echangeable = new ArrayList<Square>();
		/*
		 * On regarde s'il y a des gazelles autour de la case cible
		 */
		for(int i=0;i<voisins.size();i++){
			if(voisins.get(i).getPawn().toString() == "Gazelle"){
				echangeable.add(voisins.get(i));
			}
		}
		/*
		 * Puis, on supprime les gazelles qui ne sont pas de l'autre cote de la riviere
		 */
		for(int i=0;i<echangeable.size();i++){
			if(board[x][y].getSector()==echangeable.get(i).getSector()){
				echangeable.remove(i);
			}
		}
		return echangeable;
	}
}