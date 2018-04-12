package player;

import java.util.ArrayList;
import java.util.Collections;

import pawn.*;

public class Player {

	private String name;
	private ArrayList<Pawn> pawnBox;
	private int score;
	private String couleur;
	
	
	public Player(String name, String couleur) {
		this.name = name;
		this.couleur = couleur;
		
		/*
		 * Giving player's pawn 
		 */
		this.pawnBox = new ArrayList<>();
		
		for(int index = 0; index < 6; index++) {
			pawnBox.add(new Gazelle(couleur));
		}
		
		for(int index = 0; index < 5; index++) {
			pawnBox.add(new Zebra(couleur));
		}

		pawnBox.add(new Elephant(couleur));

		pawnBox.add(new Lion(couleur));
	
		pawnBox.add(new Crocodile(couleur));
		pawnBox.add(new Crocodile(couleur));
	}

	public int choosePawn() {

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
					Collections.frequency(this.pawnBox, distinctList.get(index)) + 
					" Pawn");
		}

		return 0;
	}
}