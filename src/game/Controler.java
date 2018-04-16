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
	 * Places a pawn selected by the player
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
				System.out.print(this.Player1.getName() + " where you want to place the Impala Jones ? (1 to 24) :\t");
				this.impala = Config.sc.nextInt();
				System.out.println();
			}while(1 > impala || impala > 24);
		}
		catch(java.util.InputMismatchException e) {
			System.out.print("Bad entry try again...");
		}
	}

}