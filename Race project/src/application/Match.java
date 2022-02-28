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
		
		Manager.addPlayers(numberOfPlayers);
		
		System.out.print("Digite a quantidade partidas: ");
		numberOfMatchs = input.nextInt();
		
		for(int i=1; i<=numberOfMatchs; i++) {
			
			try {
				System.out.println("run #" + i);
				Manager.startRace(); // 
				
				if( i == numberOfMatchs ){
					System.out.println("### there is the result ###");
					Manager.showResult();
				} else Manager.remakeRace();
				
			} catch(InterruptedException e) {
				System.err.println("Error " + i);
				e.printStackTrace();
				break;
			}
			
		}
		
		input.close();
	}
	
}
