package player;


import java.util.ArrayList;

import config.Config;
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
				System.out.print(this.name + " choose your pawn : (1 to " + String.valueOf(distinctList.size()-1) + ") :\t");
				result = Config.sc.nextInt();
				System.out.println();
			}while(1 > result || result > distinctList.size());
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
		ArrayList<Integer> numb = new ArrayList();
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


}