package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Racer;
import services.Manager;

public class Match {

	public static List<Racer> ranking;
	public static void main(String[] args) {
		
		int numberOfPlayers, numberOfMatchs;

		Scanner input = new Scanner(System.in);
		
		System.out.print("Digite a quantidade corredores: ");
		numberOfPlayers = input.nextInt();
		
		System.out.print("Digite a quantidade partidas: ");
		numberOfMatchs = input.nextInt();

		ranking = new ArrayList<>();
		
		for(int i=0; i<numberOfMatchs; i++) {
			
			try {
				Manager.startRace(numberOfPlayers); // 
			} catch(InterruptedException e) {
				e.printStackTrace();
				break;
			}
			
		}
		
		Manager.showRanking(ranking);
		input.close();
	}
	
		
	
}
