package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Racer;
import services.Manager;

public class Match {

	public static List <Racer> players = new ArrayList<>();
	public static List <Racer> ranking = new ArrayList<>();

	public static void main(String[] args) {
		
		int numberOfPlayers, numberOfMatchs;
		Scanner input = new Scanner(System.in);
		
		System.out.print("Digite a quantidade corredores: ");
		numberOfPlayers = input.nextInt();
		
		
		System.out.print("Digite a quantidade partidas: ");
		numberOfMatchs = input.nextInt();
		
		for(int i=1; i<=numberOfMatchs; i++) {
			
			try {
				
				Manager.addPlayers(numberOfPlayers);
				System.out.println("run #" + i);
				Manager.startRace();
								
			} catch(InterruptedException e) {
				System.err.println("Error " + i);
				e.printStackTrace();
				break;
			}
			
		}

		Manager.showResult();
		
		input.close();
	}
	
}
