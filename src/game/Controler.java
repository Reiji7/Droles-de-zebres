package game;

import player.Player;
import config.Config;


public class Controler {

	private Player Player1, Player2;
	private int impala;
	private boolean turn = false;


	public Controler() {

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
		this.impala = Player1.placeImpala();
		Config.split();

		//Game loop
		while(!endGame()){
			
			if(turn) {
				Player1.playPawn(impala, Player2);
				this.impala = Player1.moveImpala(impala);
			}
			else {
				Player2.playPawn(impala, Player1);
				this.impala = Player2.moveImpala(impala);
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
		int[] points = new int[2];
		points[0] = Config.board.pointCounter(Player1.getColor());
		points[1] = Config.board.pointCounter(Player2.getColor());
		
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

}