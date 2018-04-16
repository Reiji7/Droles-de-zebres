package game;

import player.Player;

import java.util.ArrayList;

import config.Config;
import pawn.Pawn;


public class Controler {

	private Board board;
	private Player Player1, Player2;
	private int impala;


	public Controler() {
		this.board = new Board();

		System.out.print("Enter the name of player 1 : \t\n");
		this.Player1 = new Player(Config.sc.nextLine(), "Rouge");
		System.out.println();


		System.out.print("Enter the name of player 2 : \t\n");
		this.Player2 = new Player(Config.sc.nextLine(), "Bleu");
		System.out.println();

		Config.split();
	}


	public void launch() {
		placeImpala();
		Config.split();

		this.board.adjPown(0, 0, this.Player1.choosePawn());
		this.board.adjPown(0, 0, this.Player2.choosePawn());

	}

	/**
	 * Moves impala around the board
	 */
	public void moveImpala(){
		System.out.println("How much does Impala moves? (between 1 and 3): ");
		int tmp = Config.sc.nextInt();
		if(tmp<1 && tmp>3){
			System.out.println("Bad entry");
		}else {
			impala += tmp;
			if(impala > 22){
				impala -= 22;
			}
		}
	}
	
	/**
	 * The player chooses where to place his pawn first, then we call placePawn() to select a pawn and place it
	 * @param pl
	 */
	public void playPawn(Player pl){
		int tmp;
		if(impala<=6){
			System.out.println("Please select ordinate: ");
			tmp = Config.sc.nextInt();
			placePawn(pl,impala,tmp);
		} else if(impala <= 11){
			System.out.println("Please select abscissa: ");
			tmp = Config.sc.nextInt();
			placePawn(pl,tmp,impala - 6);
		} else if(impala <= 17){
			System.out.println("Please select ordinate: ");
			tmp = Config.sc.nextInt();
			placePawn(pl,-(impala) + 18,tmp);
		} else {
			System.out.println("Please select abscissa: ");
			tmp = Config.sc.nextInt();
			placePawn(pl,tmp,-(impala) + 23);
		}
	}
	
	/**
	 * Places a pawn on a square, both selected by the player
	 * @param pl
	 * @param x
	 * @param y
	 */
	public void placePawn(Player pl, int x, int y){
		if(board.getPawnAt(x,y)!=null){
			System.out.println("You can't place a pawn here");
		} else {
			Pawn p = pl.choosePawn();
			board.adjPown(x, y, p);
			//This is where we take care ofthe case of a Lion being placed next to a Gazelle
			if(p.toString()=="Lion"){
				ArrayList<Square> voisins = board.voisins(x, y);
				for(Square sq : voisins){
					if(sq.getPawn().toString()=="Gazelle"){
						flee(p);
						board.removePawn(sq);
					}
				}
			}
		}
	}

	/**
	 * Shows the player's points
	 */
	public void points(){
		int[] points = board.pointCounter();
		System.out.println("Red player has " + points[0] + " points");
		System.out.println("Blue player has " + points[1] + " points");
	}
	
	
	/**
	 * Returns a Gazelle to it's owner pawnBox
	 * @param p
	 */
	public void flee(Pawn p){
		if(Player1.getColor() == p.getColor()){
			Player1.returningGazelle(p);
		} else {
			Player2.returningGazelle(p);
		}
	}

	/**
	 * Select position of Impala Jones
	 */
	private void placeImpala() {
		try {
			do {
				System.out.print(this.Player1.getName() + " where you want to place the Impala Jones ? (1 to 22) :\t");
				this.impala = Config.sc.nextInt();
				System.out.println();
			}while(1 > impala || impala > 22);
		}
		catch(java.util.InputMismatchException e) {
			System.out.print("Bad entry try again...");
		}
	}

}