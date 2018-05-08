package player;


import java.util.ArrayList;
import config.Config;
import game.Square;
import pawn.*;


public class Player {

	
	private String name;
	private ArrayList<Pawn> pawnBox;
	private int score;
	private String color;
	
	
	public Player(String name, String color) {
		this.name = name;
		this.color = color;
		
		/*
		 * Giving player's pawn 
		 */
		this.pawnBox = new ArrayList<>();
		
		for(int index = 0; index < 6; index++) {
			pawnBox.add(new Gazelle(color));
		}
		
		for(int index = 0; index < 5; index++) {
			pawnBox.add(new Zebra(color));
		}

		pawnBox.add(new Elephant(color));

		pawnBox.add(new Lion(color));
	
		pawnBox.add(new Crocodile(color));
		pawnBox.add(new Crocodile(color));
		
	}
	
	
	public int pawnBoxSize(){
		return this.pawnBox.size();
	}
	
	
	public void setScore(int score){
		this.score = Config.board.pointCounter(this.color);
	}
	
	
	public int getScore(){
		return score;
	}
	
	
	public String getColor(){
		return this.color;
	}
	
	
	/**
	 * Pawn selection procedure
	 * @return pawn
	 */
	public Pawn choosePawn() {

		Pawn p = selectionPawn();
		this.pawnBox.remove(p);
		Config.split();

		return p;
	}
	
	
	/**
	 * Normalize pawn choice
	 * @return Pawn choose
	 */
	private Pawn selectionPawn() {
		
		int result = 0;
		ArrayList<Pawn> distinctList = new ArrayList<>();
		
		try {
			do {
				distinctList = listPawn();
				System.out.print(this.name + " choose your pawn : (0 to " + String.valueOf(distinctList.size()-1) + ") :\t");
				result = Config.sc.nextInt();
				System.out.println();
			}while(0 > result || result > distinctList.size());
		}
		catch(java.util.InputMismatchException e) {
			System.out.println("Bad entry try again...");
		}
		
		return distinctList.get(result);
	}


	/**
	 * List pawn in pawn box
	 * @return number of different pawn
	 */
	private ArrayList<Pawn> listPawn() {
		ArrayList<Pawn> distinctList = new ArrayList();
		ArrayList<String> tamp = new ArrayList();
		
		for(Pawn p : pawnBox) {
			if(!tamp.contains(p.toString())) {
				distinctList.add(p);
				tamp.add(p.toString());
			}
		}
		
		for(int index = 0; index < distinctList.size(); index++) {
			System.out.println(index + ") " + 
					distinctList.get(index).toString() + " " + 
					count(distinctList.get(index)) + 
					" Pawn");
		}

		System.out.println();
		return distinctList;
	}
	
	
	/**
	 * Count numbers of occurence in pawn box
	 * @param p
	 * @return i
	 */
	private int count(Pawn p) {
		int i = 0;
		for(Pawn p2 : pawnBox) {
			if(p.toString().equals(p2.toString()))
					i++;
		}
		return i;
	}
	

	/**
	 * Returns the pawn (needs to be a Gazelle) to this player's pawnBox
	 * @param p
	 */
	public void returningGazelle(Pawn p){
		if(p.toString()=="Gazelle"){
			pawnBox.add(p);
		}
	}

	
	public String getName() {
		return this.name;
	}


	/**
	 * Moves impala around the board
	 */
	public int moveImpala(int impala){
		System.out.println(this.name + " how much does Impala moves? (between 1 and 3): ");
		int tmp = 0;
		
		do{
			tmp = Config.sc.nextInt();
		}while (tmp<1 && tmp>3);
		
		impala += tmp;
		if(impala > 22){
			impala -= 22;
		}
		
		return impala;
	}
	
	
	/**
	 * The player chooses where to place his pawn first, then we call placePawn() to select a pawn and place it
	 * @param pl
	 */
	public void playPawn(int impala, Player other){
		int tmp;
		System.out.println("impala: " + impala);
		if(impala<6){
			//We ask where to place the pawn on the column
			System.out.println(name + " please select ordinate (0 to 4) : ");
			tmp = Config.sc.nextInt();
			//We place the pawn
			placePawn(impala,tmp, other);
			//We check if this sector is ready to accept visitors
			if(Config.board.newInauguration(impala, tmp)){
				setScore(getScore()+5);
			};
		} else if(impala < 11){
			//We ask where to place the pawn on the line
			System.out.println(name + " please select abscissa (0 to 5) : ");
			tmp = Config.sc.nextInt();
			//We place the pawn
			placePawn(tmp,impala - 6, other);
			//We check if this sector is ready to accept visitors
			if(Config.board.newInauguration(tmp, impala - 6)){
				setScore(getScore()+5);
			};
		} else if(impala < 17){
			//And so on ...
			System.out.println(name + " please select ordinate (0 to 4) : ");
			tmp = Config.sc.nextInt();
			placePawn(-(impala) + 16,tmp, other);
			if(Config.board.newInauguration(-(impala) + 16, tmp)){
				setScore(getScore()+5);
			};
		} else {
			System.out.println(name + " please select abscissa (0 to 5) : ");
			tmp = Config.sc.nextInt();
			placePawn(tmp,-(impala) + 22, other);
			if(Config.board.newInauguration(tmp, -(impala) +22)){
				setScore(getScore()+5);
			};
		}
	}
	
	
	/**
	 * Returns a Gazelle to it's owner pawnBox
	 * @param p
	 */
	public void flee(Player other, Pawn p){
		if(other.getColor() == p.getColor()){
			other.returningGazelle(p);
		} else {
			returningGazelle(p);
		}
	}


	/**
	 * Places a pawn on a square, both selected by the player
	 * @param x
	 * @param y
	 */
	public void placePawn(int x, int y, Player other){
		Config.board.out();
		if(0 > x || x > 5 || 0 > y || y > 4 || Config.board.getPawnAt(x,y) != null){
			System.out.println("You can't place a pawn here");
		} else {
			Pawn p = choosePawn();
			Config.board.adjPown(x, y, p);
			//This is where we take care of the case of a Lion being placed next to a Gazelle
			if(p.toString()=="Lion"){
				ArrayList<Square> voisins = Config.board.voisins(x, y);
				for(Square sq : voisins){
					if(sq.getPawn() != null){
						if(sq.getPawn().toString()=="Gazelle"){
							flee(other, p);
							Config.board.removePawn(sq);
						}
					}
				}
			}
		}
	}
	
	
	/**
	 * Select position of Impala Jones
	 */
	public int placeImpala() {
		int impala = 0;
		try {
			do {
				System.out.print(this.getName() + " where you want to place the Impala Jones ? (0 to 21) :\t");
				impala = Config.sc.nextInt();
				System.out.println();
			}while(0 > impala || impala > 21);
		}
		catch(java.util.InputMismatchException e) {
			System.out.print("Bad entry try again...");
		}
		
		return impala;
	}
	
}