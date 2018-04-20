package game;

import player.Player;

import java.util.ArrayList;

import config.Config;
import pawn.Pawn;


public class Controler {

	private Board board;
	private Player Player1, Player2;
	private int impala;
	private boolean currentPlayer1 = true;


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


	/**
	 * Starts the game
	 */
	public void launch() {
		placeImpala();
		Config.split();

		//Game loop
		while(!endGame()){
			if(currentPlayer1){
				playPawn(Player1);
			} else {
				playPawn(Player2);
			}
			moveImpala();
		}
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
	 * Check if the game is over (when both players run out of pawn to play)
	 * @return
	 */
	public boolean endGame(){
		if(Player1.pawnBoxSize() == 0 && Player2.pawnBoxSize() == 0){
			points();
			return true;
		} else {
			return false;
		}
	}


	/**
	 * The player chooses where to place his pawn first, then we call placePawn() to select a pawn and place it
	 * @param pl
	 */
	public void playPawn(Player pl){
		int tmp;
		System.out.println("impala: " + impala);
		if(impala<6){
			//We ask where to place the pawn on the column
			System.out.println("Please select ordinate (0 to 4) : ");
			tmp = Config.sc.nextInt();
			//We place the pawn
			placePawn(pl,impala,tmp);
			//We check if this sector is ready to accept visitors
			if(board.newInauguration(impala, tmp)){
				pl.setScore(pl.getScore()+5);
			};
		} else if(impala < 11){
			//We ask where to place the pawn on the line
			System.out.println("Please select abscissa (0 to 5) : ");
			tmp = Config.sc.nextInt();
			//We place the pawn
			placePawn(pl,tmp,impala - 6);
			//We check if this sector is ready to accept visitors
			if(board.newInauguration(tmp, impala - 6)){
				pl.setScore(pl.getScore()+5);
			};
		} else if(impala < 17){
			//And so on ...
			System.out.println("Please select ordinate (0 to 4) : ");
			tmp = Config.sc.nextInt();
			placePawn(pl,-(impala) + 16,tmp);
			if(board.newInauguration(-(impala) + 16, tmp)){
				pl.setScore(pl.getScore()+5);
			};
		} else {
			System.out.println("Please select abscissa (0 to 5) : ");
			tmp = Config.sc.nextInt();
			placePawn(pl,tmp,-(impala) + 22);
			if(board.newInauguration(tmp, -(impala) +22)){
				pl.setScore(pl.getScore()+5);
			};
		}

		this.currentPlayer1 = !this.currentPlayer1;
	}


	/**
	 * Places a pawn on a square, both selected by the player
	 * @param pl
	 * @param x
	 * @param y
	 */
	public void placePawn(Player pl, int x, int y){
		this.board.out();
		if(0 > x || x > 5 || 0 > y || y > 4 || board.getPawnAt(x,y) != null){
			System.out.println("You can't place a pawn here");
		} else {
			Pawn p = pl.choosePawn();
			board.adjPown(x, y, p);
			//This is where we take care of the case of a Lion being placed next to a Gazelle
			if(p.toString()=="Lion"){
				ArrayList<Square> voisins = board.voisins(x, y);
				for(Square sq : voisins){
					if(sq.getPawn() != null){
						if(sq.getPawn().toString()=="Gazelle"){
							flee(p);
							board.removePawn(sq);
						}
					}
				}
			}
		}
	}


	/**
	 * Shows the player's points
	 * If the game is over, it also shows who won
	 */
	public void points(){
		int[] points = board.pointCounter();
		Player1.setScore(points[0]);
		Player2.setScore(points[1]);
		System.out.println("Red player has " + points[0] + " points");
		System.out.println("Blue player has " + points[1] + " points");
		if(endGame()){
			if(Player1.getScore() > Player2.getScore()){
				System.out.println("Red player won!");
			} else {
				System.out.println("Blue player won!");
			}
		}
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
				System.out.print(this.Player1.getName() + " where you want to place the Impala Jones ? (0 to 21) :\t");
				this.impala = Config.sc.nextInt();
				System.out.println();
			}while(0 > impala || impala > 21);
		}
		catch(java.util.InputMismatchException e) {
			System.out.print("Bad entry try again...");
		}
	}

}