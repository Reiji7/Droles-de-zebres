package game;

import player.Player;
import config.Config;


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