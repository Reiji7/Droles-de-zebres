package game;

import player.Player;
import config.Config;


public class Controler {

	private Board board;
	private Player Player1, Player2;
	private int impala;
	
	
	public Controler() {
		this.board = new Board();
		
		System.out.print("Entrez le nom du joueur 1 : \t");
		this.Player1 = new Player("Reiji", "Rouge");
		System.out.println();

		
		System.out.print("Entrez le nom du joueur 2 : \t");
		this.Player2 = new Player("Bob", "Bleu");
		System.out.println();
	}
	
	
	public void launch() {
		placeImpala();
		
		
	}
	
	
	/**
	 * Select position of Impala Jones
	 */
	private void placeImpala() {
		try {
			do {
				System.out.print("Joueur 1  ou voulez vous placer l'Impala Jones ? (1 à 24) :\t");
				this.impala = Config.sc.nextInt();
				System.out.println();
			}while(1 > impala || impala > 24);
		}
		catch(java.util.InputMismatchException e) {
			System.out.print("Bad entry try again...");
		}
	}
	
}
/*
this.Player1 = new Player(Config.sc.nextLine(), "Rouge");

this.Player2 = new Player(Config.sc.nextLine(), "Bleu");
*/