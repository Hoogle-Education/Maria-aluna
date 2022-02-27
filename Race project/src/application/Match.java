package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Racer;

public class Match {

	public static List <Racer> players = new ArrayList<>();
	public static List <Racer> ranking = new ArrayList<>();
	
	private static void addPlayers(int n) {
		for(int i=1; i<=n; i++) {
			String aux = "Racer #" + i;
			players.add( new Racer(aux) );
		}
	}
	
	private static void startRace() throws InterruptedException {
		for(Racer r: Match.players){
			r.threadRacer.join();	

			if( ! r.threadRacer.isAlive() )r.threadRacer.start();
			else r.threadRacer.interrupt();
			
		} 
	}

	private static void showRanking(){
		ranking.forEach( System.out::println );
	}

	public static void main(String[] args) {
		
		int numberOfPlayers, numberOfMatchs;
		Scanner input = new Scanner(System.in);
		
		System.out.print("Digite a quantidade corredores: ");
		numberOfPlayers = input.nextInt();
		
		Match.addPlayers(numberOfPlayers);

		System.out.print("Digite a quantidade partidas: ");
		numberOfMatchs = input.nextInt();
		
		for(int i=0; i<2; i++) {
			
			try {
				Match.startRace(); // 
			} catch(InterruptedException e) {
				e.printStackTrace();
				break;
			}finally{
			}
			
		}
		
		Match.showRanking();
		input.close();
	}
	
		
	
}
