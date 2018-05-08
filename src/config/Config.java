package config;

import java.util.Scanner;

import game.Board;

public class Config {
	public static final Scanner sc = new Scanner(System.in);
	
	public static void split() {
		System.out.println("\n_____________________________________________________\n\n");
	}
	
	public static Board board = new Board();

}