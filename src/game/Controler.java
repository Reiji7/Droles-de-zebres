package game;

import player.Player;
import java.util.ArrayList;
import config.Config;
import pawn.Pawn;


public class Controler {

	private Board board;
	private Player Player1, Player2;
	private int impala;
	private boolean turn = false;
	

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
			
			if(turn) {
				Player1.playPawn(impala, this.board, Player2);
				Player1.moveImpala(impala);
			}
			else {
				Player2.playPawn(impala, this.board, Player1);
				Player2.moveImpala(impala);
			}

			turn = !turn;
			
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